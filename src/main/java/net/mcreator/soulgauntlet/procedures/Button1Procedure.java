package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Button1Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:cow")) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
