
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.soulgauntlet.block.entity.SoulAltarTileEntity;
import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SoulGauntletMod.MODID);
	public static final RegistryObject<BlockEntityType<SoulAltarTileEntity>> SOUL_ALTAR = REGISTRY.register("soul_altar", () -> BlockEntityType.Builder.of(SoulAltarTileEntity::new, SoulGauntletModBlocks.SOUL_ALTAR.get()).build(null));

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
