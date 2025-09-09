package net.mcreator.soulgauntlet.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.soulgauntlet.item.GauntletdamagedItem;

public class GauntletdamagedItemModel extends GeoModel<GauntletdamagedItem> {
	@Override
	public ResourceLocation getAnimationResource(GauntletdamagedItem animatable) {
		return new ResourceLocation("soul_gauntlet", "animations/bank.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GauntletdamagedItem animatable) {
		return new ResourceLocation("soul_gauntlet", "geo/bank.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GauntletdamagedItem animatable) {
		return new ResourceLocation("soul_gauntlet", "textures/item/damagedtexture.png");
	}
}
