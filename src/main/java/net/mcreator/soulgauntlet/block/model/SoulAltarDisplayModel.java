package net.mcreator.soulgauntlet.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.soulgauntlet.block.display.SoulAltarDisplayItem;

public class SoulAltarDisplayModel extends GeoModel<SoulAltarDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SoulAltarDisplayItem animatable) {
		return new ResourceLocation("soul_gauntlet", "animations/soulaltar.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulAltarDisplayItem animatable) {
		return new ResourceLocation("soul_gauntlet", "geo/soulaltar.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulAltarDisplayItem entity) {
		return new ResourceLocation("soul_gauntlet", "textures/block/soulaltartexture.png");
	}
}
