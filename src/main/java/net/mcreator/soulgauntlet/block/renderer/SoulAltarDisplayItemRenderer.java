package net.mcreator.soulgauntlet.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.soulgauntlet.block.model.SoulAltarDisplayModel;
import net.mcreator.soulgauntlet.block.display.SoulAltarDisplayItem;

public class SoulAltarDisplayItemRenderer extends GeoItemRenderer<SoulAltarDisplayItem> {
	public SoulAltarDisplayItemRenderer() {
		super(new SoulAltarDisplayModel());
	}

	@Override
	public RenderType getRenderType(SoulAltarDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
