
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.soulgauntlet.network.SelectPowerMessage;
import net.mcreator.soulgauntlet.SoulGauntletMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SoulGauntletModKeyMappings {
	public static final KeyMapping SELECT_POWER = new KeyMapping("key.soul_gauntlet.select_power", GLFW.GLFW_KEY_R, "key.categories.soul_gauntlet") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SoulGauntletMod.PACKET_HANDLER.sendToServer(new SelectPowerMessage(0, 0));
				SelectPowerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SELECT_POWER);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SELECT_POWER.consumeClick();
			}
		}
	}
}
