
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.soulgauntlet.world.inventory.SoulGauntletInterfaceMenu;
import net.mcreator.soulgauntlet.SoulGauntletMod;

public class SoulGauntletModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SoulGauntletMod.MODID);
	public static final RegistryObject<MenuType<SoulGauntletInterfaceMenu>> SOUL_GAUNTLET_INTERFACE = REGISTRY.register("soul_gauntlet_interface", () -> IForgeMenuType.create(SoulGauntletInterfaceMenu::new));
}
