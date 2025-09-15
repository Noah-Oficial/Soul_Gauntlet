package net.mcreator.soulgauntlet.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.soulgauntlet.world.inventory.SoulGauntletInterfaceMenu;
import net.mcreator.soulgauntlet.init.SoulGauntletModItems;

import io.netty.buffer.Unpooled;

public class OpenGuiProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		String Texto = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SoulGauntletModItems.SOULGAUNTLET.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SoulGauntletInterface");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SoulGauntletInterfaceMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power")).equals(""))) {
				Texto = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power");
				Texto = Texto.replace("_", " ");
				if ("minecraft:zombie minecraft:skeleton minecraft:creeper minecraft:spider minecraft:enderman minecraft:witch minecraft:slime minecraft:magma_cube minecraft:phantom minecraft:blaze minecraft:ghast minecraft:husk minecraft:stray minecraft:drowned minecraft:pillager minecraft:vindicator minecraft:evoker minecraft:vex minecraft:ravager minecraft:wither_skeleton minecraft:piglin_brute"
						.contains((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power"))) {
					return "\u00A7c" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
				}
				if ("minecraft:wither minecraft:ender_dragon minecraft:warden minecraft:elder_guardian".contains((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power"))) {
					return "\u00A7b" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
				}
				if ("minecraft:iron_golem minecraft:wolf minecraft:polar_bear minecraft:trader_llama minecraft:llama minecraft:piglin minecraft:zombified_piglin"
						.contains((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power"))) {
					return "\u00A7e" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
				}
				if ("minecraft:cow minecraft:chicken minecraft:pig minecraft:sheep minecraft:horse minecraft:donkey minecraft:mule minecraft:cat minecraft:ocelot minecraft:parrot minecraft:rabbit minecraft:mooshroom minecraft:turtle minecraft:cod minecraft:salmon minecraft:tropical_fish minecraft:squid minecraft:glow_squid minecraft:axolotl minecraft:camel"
						.contains((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power"))) {
					return "\u00A7a" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
				}
				if ("minecraft:allay minecraft:bee minecraft:dolphin minecraft:sniffer minecraft:wandering_trader minecraft:villager"
						.contains((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power"))) {
					return "\u00A7d" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
				}
				if ("minecraft:endermite minecraft:silverfish minecraft:giant minecraft:illusioner minecraft:snow_golem minecraft:skeleton_horse"
						.contains((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power"))) {
					return "\u00A78" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
				}
				return "\u00A7f" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
			}
		}
		return "";
	}
}
