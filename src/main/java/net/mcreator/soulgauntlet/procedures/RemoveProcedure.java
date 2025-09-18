package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.soulgauntlet.SoulGauntletMod;

public class RemoveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < 10; index0++) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 1, 0, 0, 0, 0.5);
		}
		SoulGauntletMod.queueServerWork(4, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
