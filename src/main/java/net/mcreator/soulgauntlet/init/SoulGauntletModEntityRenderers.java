
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.soulgauntlet.client.renderer.SaviorRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SoulGauntletModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SoulGauntletModEntities.SAVIOR.get(), SaviorRenderer::new);
		event.registerEntityRenderer(SoulGauntletModEntities.EGG.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(SoulGauntletModEntities.WARDEN.get(), ThrownItemRenderer::new);
	}
}
