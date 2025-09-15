package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;

public class PassiveProcedure {
	public static void execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:cow")) {/*Adicionar Passiva*/
		}
	}
}
