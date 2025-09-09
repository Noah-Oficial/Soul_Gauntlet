
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoulGauntletModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> STEAL_CHANCE = GameRules.register("stealChance", GameRules.Category.MISC, GameRules.IntegerValue.create(5));
}
