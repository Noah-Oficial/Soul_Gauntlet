package net.mcreator.soulgauntlet.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.soulgauntlet.block.entity.SoulAltarTileEntity;

public class SoulAltarBlockModel extends GeoModel<SoulAltarTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SoulAltarTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("soul_gauntlet", "animations/soulaltar.animation.json");
		return new ResourceLocation("soul_gauntlet", "animations/soulaltar.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulAltarTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("soul_gauntlet", "geo/soulaltar.geo.json");
		return new ResourceLocation("soul_gauntlet", "geo/soulaltar.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulAltarTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("soul_gauntlet", "textures/block/soulaltartexture.png");
		return new ResourceLocation("soul_gauntlet", "textures/block/soulaltartexture.png");
	}
}
