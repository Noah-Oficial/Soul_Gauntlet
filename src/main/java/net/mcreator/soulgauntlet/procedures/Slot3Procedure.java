package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.soulgauntlet.init.SoulGauntletModItems;

public class Slot3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String Data = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SoulGauntletModItems.SOULGAUNTLET.get()
				&& !(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Slot3")).equals(""))) {
			Data = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("Slot3");
			return "\u00A7f" + ((Data.replace("minecraft:", "")).substring(0, 1)).toUpperCase() + (Data.replace("minecraft:", "")).substring(1, (Data.replace("minecraft:", "")).length());
		}
		return "\u00A7f";
	}
}
