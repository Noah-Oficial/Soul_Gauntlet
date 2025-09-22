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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
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
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,
						(int) ((1 - (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
								? _livingEntity11.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
								: 0))
								* (sourceentity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
										? _livingEntity12.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
										: 0))));
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
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100,
						(int) ((4 - (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
								? _livingEntity18.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
								: 0))
								* (sourceentity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
										? _livingEntity19.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
										: 0))));
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
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100,
						(int) ((4 - (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
								? _livingEntity34.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
								: 0))
								* (sourceentity instanceof LivingEntity _livingEntity35 && _livingEntity35.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
										? _livingEntity35.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
										: 0))));
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:warden")) {
			if (entity instanceof LivingEntity _livEnt39 && _livEnt39.isBaby()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60,
							(int) ((10 - (entity instanceof LivingEntity _livingEntity40 && _livingEntity40.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
									? _livingEntity40.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
									: 0))
									* (sourceentity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
											? _livingEntity41.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
											: 0))));
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
			if (entity instanceof LivingEntity _livEnt47 && _livEnt47.isBlocking()) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 0,
							(int) ((2 - (entity instanceof LivingEntity _livingEntity48 && _livingEntity48.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
									? _livingEntity48.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
									: 0))
									* (sourceentity instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
											? _livingEntity49.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
											: 0))));
			}
			if (entity.isUnderWater()) {
				entity.setAirSupply((int) (entity.getAirSupply() - (1 - (sourceentity instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
						? _livingEntity53.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
						: 0))));
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
			if (!(entity instanceof LivingEntity _livEnt59 && _livEnt59.getMobType() == MobType.UNDEAD)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(SoulGauntletModMobEffects.HEAVY_EYES.get(), 100,
							(int) ((3 - (entity instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
									? _livingEntity60.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
									: 0))
									* (sourceentity instanceof LivingEntity _livingEntity61 && _livingEntity61.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
											? _livingEntity61.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
											: 0))));
			}
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:enderman")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100,
						(int) ((1 - (entity instanceof LivingEntity _livingEntity65 && _livingEntity65.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
								? _livingEntity65.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
								: 0))
								* (sourceentity instanceof LivingEntity _livingEntity66 && _livingEntity66.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
										? _livingEntity66.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
										: 0))));
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:rabbit")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 100,
						(int) ((1 - (entity instanceof LivingEntity _livingEntity70 && _livingEntity70.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
								? _livingEntity70.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
								: 0))
								* (sourceentity instanceof LivingEntity _livingEntity71 && _livingEntity71.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
										? _livingEntity71.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
										: 0))));
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:bee")) {
			if ((entity.getPersistentData().getString("Allergy")).equals("bee")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 500,
							(int) ((10 - (entity instanceof LivingEntity _livingEntity76 && _livingEntity76.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
									? _livingEntity76.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
									: 0))
									* (sourceentity instanceof LivingEntity _livingEntity77 && _livingEntity77.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
											? _livingEntity77.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
											: 0))));
				sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("soul_gauntlet:dismemberment")))), 9999);
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100,
							(int) ((1 - (entity instanceof LivingEntity _livingEntity81 && _livingEntity81.getAttributes().hasAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get())
									? _livingEntity81.getAttribute(SoulGauntletModAttributes.SOULRESISTANCE.get()).getBaseValue()
									: 0))
									* (sourceentity instanceof LivingEntity _livingEntity82 && _livingEntity82.getAttributes().hasAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get())
											? _livingEntity82.getAttribute(SoulGauntletModAttributes.EVOLUTION_OF_SOULS.get()).getBaseValue()
											: 0))));
				sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("soul_gauntlet:dismemberment")))), 9999);
			}
		}
		if ((itemstack.getOrCreateTag().getString("Power")).equals("minecraft:turtle")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
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
	}
}
