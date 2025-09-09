
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SoulGauntletMod.MODID);
	public static final RegistryObject<CreativeModeTab> SOUL_GAUNTLET_ITENS = REGISTRY.register("soul_gauntlet_itens",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.soul_gauntlet.soul_gauntlet_itens")).icon(() -> new ItemStack(SoulGauntletModItems.SOULGAUNTLET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SoulGauntletModItems.SOULGAUNTLET.get());
				tabData.accept(SoulGauntletModItems.GAUNTLETDAMAGED.get());
			}).build());
}
