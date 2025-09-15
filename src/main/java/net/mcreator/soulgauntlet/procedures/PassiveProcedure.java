package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PassiveProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		ItemStack Manopla = ItemStack.EMPTY;
		if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Power")).equals(""))) {
			Manopla = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			if ((Manopla.getOrCreateTag().getString("Power")).equals("minecraft:cow")) {/*Adicionar Passiva*/
			}
		}
		return true;
	}
}
