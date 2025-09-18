
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.soulgauntlet.block.SoulAltarBlock;
import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SoulGauntletMod.MODID);
	public static final RegistryObject<Block> SOUL_ALTAR = REGISTRY.register("soul_altar", () -> new SoulAltarBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
