package net.mcreator.soulgauntlet.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.soulgauntlet.item.SoulgauntletItem;

public class SoulgauntletItemModel extends GeoModel<SoulgauntletItem> {
	@Override
	public ResourceLocation getAnimationResource(SoulgauntletItem animatable) {
		return new ResourceLocation("soul_gauntlet", "animations/gauntlet.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SoulgauntletItem animatable) {
		return new ResourceLocation("soul_gauntlet", "geo/gauntlet.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulgauntletItem animatable) {
		return new ResourceLocation("soul_gauntlet", "textures/item/gauntlet_texture.png");
	}
}
