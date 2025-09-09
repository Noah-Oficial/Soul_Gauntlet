package net.mcreator.soulgauntlet.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.soulgauntlet.init.SoulGauntletModItems;
import net.mcreator.soulgauntlet.entity.SaviorEntity;
import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SaviorButton2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">").contains("\u00A7c")) {
			if (entity instanceof SaviorEntity animatable)
				animatable.setTexture("_savior4");
			if (entity instanceof SaviorEntity) {
				((SaviorEntity) entity).setAnimation("Tremble");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			SoulGauntletMod.queueServerWork(20, () -> {
				if (entity instanceof SaviorEntity animatable)
					animatable.setTexture("_savior3");
				if (entity instanceof SaviorEntity) {
					((SaviorEntity) entity).setAnimation("IdleTransform");
				}
			});
		}
		if ((entity instanceof SaviorEntity _datEntL7 && _datEntL7.getEntityData().get(SaviorEntity.DATA_Talks)) == false && (entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 0) {
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (entity instanceof SaviorEntity) {
				((SaviorEntity) entity).setAnimation("Transform1");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			SoulGauntletMod.queueServerWork(25, () -> {
				if (entity instanceof SaviorEntity animatable)
					animatable.setTexture("_savior2");
				SoulGauntletMod.queueServerWork(8, () -> {
					if (entity instanceof SaviorEntity) {
						((SaviorEntity) entity).setAnimation("Transform3");
					}
					if (entity instanceof SaviorEntity animatable)
						animatable.setTexture("_savior3");
					SoulGauntletMod.queueServerWork(20, () -> {
						if (entity instanceof SaviorEntity) {
							((SaviorEntity) entity).setAnimation("IdleTransform");
						}
						SoulGauntletMod.queueServerWork(40, () -> {
							if (entity instanceof SaviorEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 1);
							if (entity instanceof SaviorEntity _datEntSetL)
								_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
						});
					});
				});
			});
		}
		if ((entity instanceof SaviorEntity _datEntL22 && _datEntL22.getEntityData().get(SaviorEntity.DATA_Talks)) == false && (entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 1) {
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014"),
						false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")), false);
			if (entity instanceof SaviorEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SaviorEntity.DATA_Message, (int) ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + 1));
			SoulGauntletMod.queueServerWork((int) ((MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")).length() + 50), () -> {
				if ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) < 11) {
					if (entity instanceof SaviorEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
					SaviorButton2Procedure.execute(world, x, y, z, entity, sourceentity, itemstack);
				} else {
					SoulGauntletMod.queueServerWork(40, () -> {
						if (entity instanceof SaviorEntity animatable)
							animatable.setTexture("saviortexture1");
						if (entity instanceof SaviorEntity) {
							((SaviorEntity) entity).setAnimation("Transform4");
						}
						SoulGauntletMod.queueServerWork(20, () -> {
							if (entity instanceof SaviorEntity) {
								((SaviorEntity) entity).setAnimation("Idle");
							}
							if (sourceentity instanceof ServerPlayer _serverPlayer)
								_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("soul_gauntlet:gauntlet_damaged_craft")});
							if (sourceentity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(SoulGauntletModItems.GAUNTLETBLUEPRINT.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entity instanceof SaviorEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 2);
							if (entity instanceof SaviorEntity _datEntSetL)
								_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
						});
					});
				}
			});
		}
		if ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 2
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SoulGauntletModItems.GAUNTLETDAMAGED.get())) : false)
				&& (entity instanceof SaviorEntity _datEntL45 && _datEntL45.getEntityData().get(SaviorEntity.DATA_Talks)) == false) {
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (entity instanceof SaviorEntity) {
				((SaviorEntity) entity).setAnimation("Transform1");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			SoulGauntletMod.queueServerWork(25, () -> {
				if (entity instanceof SaviorEntity animatable)
					animatable.setTexture("_savior2");
				SoulGauntletMod.queueServerWork(8, () -> {
					if (entity instanceof SaviorEntity) {
						((SaviorEntity) entity).setAnimation("Transform3");
					}
					if (entity instanceof SaviorEntity animatable)
						animatable.setTexture("_savior3");
					SoulGauntletMod.queueServerWork(20, () -> {
						if (entity instanceof SaviorEntity) {
							((SaviorEntity) entity).setAnimation("IdleTransform");
						}
						if (entity instanceof SaviorEntity _datEntSetL)
							_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
						if (entity instanceof SaviorEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 3);
					});
				});
			});
		}
		if ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 3
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SoulGauntletModItems.GAUNTLETDAMAGED.get())) : false)
				&& (entity instanceof SaviorEntity _datEntL60 && _datEntL60.getEntityData().get(SaviorEntity.DATA_Talks)) == false) {
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014"),
						false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")), false);
			if (entity instanceof SaviorEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SaviorEntity.DATA_Message, (int) ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + 1));
			SoulGauntletMod.queueServerWork((int) ((MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")).length() + 50), () -> {
				if (Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) < 17) {
					if (entity instanceof SaviorEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
					SaviorButton2Procedure.execute(world, x, y, z, entity, sourceentity, itemstack);
				} else {
					if (entity instanceof SaviorEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 4);
					if (entity instanceof SaviorEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
				}
			});
		}
		if ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 4
				&& ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SoulGauntletModItems.GAUNTLETDAMAGED.get() || itemstack.getOrCreateTag().getBoolean("Sacrif\u00EDcios") == true)
				&& (entity instanceof SaviorEntity _datEntL78 && _datEntL78.getEntityData().get(SaviorEntity.DATA_Talks)) == false) {
			if (itemstack.getOrCreateTag().getBoolean("Sacrif\u00EDcios") == false) {
				itemstack.getOrCreateTag().putBoolean("Sacrif\u00EDcios", true);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, 50, 3, 3, 3, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.allay.ambient_without_item")), SoundSource.NEUTRAL, 4, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.allay.ambient_without_item")), SoundSource.NEUTRAL, 4, 1, false);
					}
				}
			}
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014"),
						false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")), false);
			if (entity instanceof SaviorEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SaviorEntity.DATA_Message, (int) ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + 1));
			SoulGauntletMod.queueServerWork((int) ((MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")).length() + 50), () -> {
				if (Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) < 21) {
					if (entity instanceof SaviorEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
					SaviorButton2Procedure.execute(world, x, y, z, entity, sourceentity, itemstack);
				} else {
					SoulGauntletMod.queueServerWork(60, () -> {
						if (entity instanceof SaviorEntity animatable)
							animatable.setTexture("saviortexture1");
						if (entity instanceof SaviorEntity) {
							((SaviorEntity) entity).setAnimation("Transform4");
						}
						SoulGauntletMod.queueServerWork(20, () -> {
							if (entity instanceof SaviorEntity) {
								((SaviorEntity) entity).setAnimation("Idle");
							}
							if (entity instanceof SaviorEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 5);
							if (entity instanceof SaviorEntity _datEntSetL)
								_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
						});
					});
				}
			});
		}
		if ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 5
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SoulGauntletModItems.SOULGEM.get())) : false)
				&& (entity instanceof SaviorEntity _datEntL104 && _datEntL104.getEntityData().get(SaviorEntity.DATA_Talks)) == false) {
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (entity instanceof SaviorEntity) {
				((SaviorEntity) entity).setAnimation("Transform1");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("soul_gauntlet:tremblesfx")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			SoulGauntletMod.queueServerWork(25, () -> {
				if (entity instanceof SaviorEntity animatable)
					animatable.setTexture("_savior2");
				SoulGauntletMod.queueServerWork(8, () -> {
					if (entity instanceof SaviorEntity) {
						((SaviorEntity) entity).setAnimation("Transform3");
					}
					if (entity instanceof SaviorEntity animatable)
						animatable.setTexture("_savior3");
					SoulGauntletMod.queueServerWork(20, () -> {
						if (entity instanceof SaviorEntity) {
							((SaviorEntity) entity).setAnimation("IdleTransform");
						}
						if (entity instanceof SaviorEntity _datEntSetL)
							_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
						if (entity instanceof SaviorEntity _datEntSetI)
							_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 6);
					});
				});
			});
		}
		if ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Stage) : 0) == 6
				&& (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(SoulGauntletModItems.SOULGEM.get())) : false)
				&& (entity instanceof SaviorEntity _datEntL119 && _datEntL119.getEntityData().get(SaviorEntity.DATA_Talks)) == false) {
			if (entity instanceof SaviorEntity _datEntSetL)
				_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, true);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014"),
						false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")), false);
			if (entity instanceof SaviorEntity _datEntSetI)
				_datEntSetI.getEntityData().set(SaviorEntity.DATA_Message, (int) ((entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + 1));
			SoulGauntletMod.queueServerWork((int) ((MessageFilterProcedure.execute("<Part=" + Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) + ">")).length() + 40), () -> {
				if (Math.round(entity instanceof SaviorEntity _datEntI ? _datEntI.getEntityData().get(SaviorEntity.DATA_Message) : 0) < 30) {
					if (entity instanceof SaviorEntity _datEntSetL)
						_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
					SaviorButton2Procedure.execute(world, x, y, z, entity, sourceentity, itemstack);
				} else {
					if (sourceentity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("soul_gauntlet:soul_gauntlet_craft")});
					SoulGauntletMod.queueServerWork(100, () -> {
						if (entity instanceof SaviorEntity animatable)
							animatable.setTexture("saviortexture1");
						if (entity instanceof SaviorEntity) {
							((SaviorEntity) entity).setAnimation("Transform4");
						}
						SoulGauntletMod.queueServerWork(20, () -> {
							if (entity instanceof SaviorEntity) {
								((SaviorEntity) entity).setAnimation("Idle");
							}
							if (entity instanceof SaviorEntity _datEntSetI)
								_datEntSetI.getEntityData().set(SaviorEntity.DATA_Stage, 7);
							if (entity instanceof SaviorEntity _datEntSetL)
								_datEntSetL.getEntityData().set(SaviorEntity.DATA_Talks, false);
						});
					});
				}
			});
		}
	}
}
