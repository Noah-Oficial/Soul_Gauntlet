package net.mcreator.soulgauntlet.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.soulgauntlet.init.SoulGauntletModBlockEntities;
import net.mcreator.soulgauntlet.block.renderer.SoulAltarTileRenderer;
import net.mcreator.soulgauntlet.SoulGauntletMod;

@Mod.EventBusSubscriber(modid = SoulGauntletMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(SoulGauntletModBlockEntities.SOUL_ALTAR.get(), context -> new SoulAltarTileRenderer());
	}
}
