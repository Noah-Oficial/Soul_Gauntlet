
package net.mcreator.soulgauntlet.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.soulgauntlet.world.inventory.SoulGauntletRemovePowersMenu;
import net.mcreator.soulgauntlet.procedures.Slot3RemoveProcedure;
import net.mcreator.soulgauntlet.procedures.Slot2RemoveProcedure;
import net.mcreator.soulgauntlet.procedures.Slot1RemoveProcedure;
import net.mcreator.soulgauntlet.SoulGauntletMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoulGauntletRemovePowersButtonMessage {
	private final int buttonID, x, y, z;

	public SoulGauntletRemovePowersButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SoulGauntletRemovePowersButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SoulGauntletRemovePowersButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SoulGauntletRemovePowersButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SoulGauntletRemovePowersMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Slot1RemoveProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			Slot2RemoveProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			Slot3RemoveProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SoulGauntletMod.addNetworkMessage(SoulGauntletRemovePowersButtonMessage.class, SoulGauntletRemovePowersButtonMessage::buffer, SoulGauntletRemovePowersButtonMessage::new, SoulGauntletRemovePowersButtonMessage::handler);
	}
}
