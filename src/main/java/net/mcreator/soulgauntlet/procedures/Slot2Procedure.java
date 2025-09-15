package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.soulgauntlet.init.SoulGauntletModItems;

public class Slot2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String Texto = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SoulGauntletModItems.SOULGAUNTLET.get()
				&& !(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Slot2")).equals(""))) {
			Texto = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Slot2");
			Texto = Texto.replace("_", " ");
			return "\u00A7f" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
		}
		return "\u00A7f";
	}
}
