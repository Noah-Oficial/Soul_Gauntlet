package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.soulgauntlet.SoulGauntletMod;

public class Button1Procedure {
	public static void execute(ItemStack itemstack) {
		SoulGauntletMod.LOGGER.info(itemstack.getOrCreateTag().getString("Power"));
	}
}
