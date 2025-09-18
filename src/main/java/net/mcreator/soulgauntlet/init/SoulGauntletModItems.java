
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.soulgauntlet.item.SoulgemItem;
import net.mcreator.soulgauntlet.item.SoulgauntletItem;
import net.mcreator.soulgauntlet.item.GauntletdamagedItem;
import net.mcreator.soulgauntlet.item.GauntletblueprintItem;
import net.mcreator.soulgauntlet.block.display.SoulAltarDisplayItem;
import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SoulGauntletMod.MODID);
	public static final RegistryObject<Item> SAVIOR_SPAWN_EGG = REGISTRY.register("savior_spawn_egg", () -> new ForgeSpawnEggItem(SoulGauntletModEntities.SAVIOR, -16724788, -1, new Item.Properties()));
	public static final RegistryObject<Item> SOULGAUNTLET = REGISTRY.register("soulgauntlet", () -> new SoulgauntletItem());
	public static final RegistryObject<Item> GAUNTLETDAMAGED = REGISTRY.register("gauntletdamaged", () -> new GauntletdamagedItem());
	public static final RegistryObject<Item> GAUNTLETBLUEPRINT = REGISTRY.register("gauntletblueprint", () -> new GauntletblueprintItem());
	public static final RegistryObject<Item> SOULGEM = REGISTRY.register("soulgem", () -> new SoulgemItem());
	public static final RegistryObject<Item> SOUL_ALTAR = REGISTRY.register(SoulGauntletModBlocks.SOUL_ALTAR.getId().getPath(), () -> new SoulAltarDisplayItem(SoulGauntletModBlocks.SOUL_ALTAR.get(), new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
