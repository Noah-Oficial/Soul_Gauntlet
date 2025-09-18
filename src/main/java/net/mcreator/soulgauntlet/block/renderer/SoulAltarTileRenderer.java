package net.mcreator.soulgauntlet.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.soulgauntlet.block.model.SoulAltarBlockModel;
import net.mcreator.soulgauntlet.block.entity.SoulAltarTileEntity;

public class SoulAltarTileRenderer extends GeoBlockRenderer<SoulAltarTileEntity> {
	public SoulAltarTileRenderer() {
		super(new SoulAltarBlockModel());
	}

	@Override
	public RenderType getRenderType(SoulAltarTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
