
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SoulGauntletMod.MODID);
	public static final RegistryObject<SoundEvent> TREMBLESFX = REGISTRY.register("tremblesfx", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("soul_gauntlet", "tremblesfx")));
}
