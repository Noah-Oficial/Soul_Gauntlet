package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class Button1Procedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:cow")) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:pig")) {
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 2));
			if (sourceentity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + 2));
		}
	}
}
