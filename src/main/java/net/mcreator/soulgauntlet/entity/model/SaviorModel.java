package net.mcreator.soulgauntlet.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.soulgauntlet.entity.SaviorEntity;

public class SaviorModel extends GeoModel<SaviorEntity> {
	@Override
	public ResourceLocation getAnimationResource(SaviorEntity entity) {
		return new ResourceLocation("soul_gauntlet", "animations/saviorfinal.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SaviorEntity entity) {
		return new ResourceLocation("soul_gauntlet", "geo/saviorfinal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SaviorEntity entity) {
		return new ResourceLocation("soul_gauntlet", "textures/entities/" + entity.getTexture() + ".png");
	}

}
