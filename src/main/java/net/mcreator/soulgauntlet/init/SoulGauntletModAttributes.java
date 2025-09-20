
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;

import net.mcreator.soulgauntlet.SoulGauntletMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoulGauntletModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, SoulGauntletMod.MODID);
	public static final RegistryObject<Attribute> SOULRESISTANCE = REGISTRY.register("soulresistance", () -> new RangedAttribute("attribute.soul_gauntlet.soulresistance", 0, 0, 1000).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, SOULRESISTANCE.get()));
	}

	@Mod.EventBusSubscriber
	public static class PlayerAttributesSync {
		@SubscribeEvent
		public static void playerClone(PlayerEvent.Clone event) {
			Player oldPlayer = event.getOriginal();
			Player newPlayer = event.getEntity();
			newPlayer.getAttribute(SOULRESISTANCE.get()).setBaseValue(oldPlayer.getAttribute(SOULRESISTANCE.get()).getBaseValue());
		}
	}
}
