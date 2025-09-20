
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.soulgauntlet.potion.HeavyEyesMobEffect;
import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SoulGauntletMod.MODID);
	public static final RegistryObject<MobEffect> HEAVY_EYES = REGISTRY.register("heavy_eyes", () -> new HeavyEyesMobEffect());
}
