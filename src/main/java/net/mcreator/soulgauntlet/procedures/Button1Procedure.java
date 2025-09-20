package net.mcreator.soulgauntlet.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.soulgauntlet.init.SoulGauntletModMobEffects;
import net.mcreator.soulgauntlet.init.SoulGauntletModAttributes;

import java.util.List;
import java.util.Comparator;

public class Button1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
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
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:chicken")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:cave_spider")) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SCULK_CHARGE_POP, x, y, z, 50, 1, 1, 1, 0.5);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 4));
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:dolphin")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.isInWater()) {
						if (!(entityiterator == entity)) {
							if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
					}
				}
			}
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:iron_golem")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("minecraft:iron_golem")) {
						if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
					}
				}
			}
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:slime")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 4));
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:warden")) {
			if (entity instanceof LivingEntity _livEnt33 && _livEnt33.isBaby()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 10));
			}
			if (entity.isInWaterRainOrBubble()) {
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (entity.isSprinting()) {
				entity.setSprinting(false);
			}
			if (entity instanceof LivingEntity _livEnt39 && _livEnt39.isBlocking()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 0, 2));
			}
			if (entity.isUnderWater()) {
				entity.setAirSupply((int) (entity.getAirSupply() - 1));
			}
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				entity.clearFire();
			}
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:sheep")) {
			if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.getMobType() == MobType.UNDEAD)) {
				if (!(3 - (entity instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
						? _livingEntity49.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
						: 0) <= 0)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(SoulGauntletModMobEffects.HEAVY_EYES.get(), 100,
								(int) (3 - (entity instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
										? _livingEntity50.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
										: 0))));
				}
			}
		}
	}
}
