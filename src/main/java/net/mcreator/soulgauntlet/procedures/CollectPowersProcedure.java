package net.mcreator.soulgauntlet.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.soulgauntlet.init.SoulGauntletModGameRules;

public class CollectPowersProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0) {
			if (Mth.nextInt(RandomSource.create(), 1, 100) < (world.getLevelData().getGameRules().getInt(SoulGauntletModGameRules.STEAL_CHANCE))) {
				if ((itemstack.getOrCreateTag().getString("Slot1")).equals("")) {
					itemstack.getOrCreateTag().putString("Slot1", ("" + ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()));
				} else if ((itemstack.getOrCreateTag().getString("Slot2")).equals("")) {
					itemstack.getOrCreateTag().putString("Slot2", ("" + ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()));
				} else if ((itemstack.getOrCreateTag().getString("Slot3")).equals("")) {
					itemstack.getOrCreateTag().putString("Slot3", ("" + ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()));
				}
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("CollectPowers.Success").getString())), true);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("CollectPowers.Weaknesses").getString())), true);
			}
		}
		if (!(itemstack.getOrCreateTag().getString("Power")).equals("")) {
			Button1Procedure.execute(world, x, y, z, entity, sourceentity, itemstack);
		}
	}
}
