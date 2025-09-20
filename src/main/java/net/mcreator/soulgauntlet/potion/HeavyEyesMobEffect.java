
package net.mcreator.soulgauntlet.potion;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import java.util.List;
import java.util.ArrayList;

public class HeavyEyesMobEffect extends MobEffect {
	public HeavyEyesMobEffect() {
		super(MobEffectCategory.HARMFUL, -13395457);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "51b077ce-fc73-333e-99fa-a5dfc65c2346", -0.02, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_SPEED, "a9259c09-cfd2-3500-b13e-5892e83b37db", -0.02, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.JUMP_STRENGTH, "3dd670a2-b38d-32e9-bf59-b6d9638c8a31", -0.02, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.NAMETAG_DISTANCE.get(), "af487942-8930-3a53-93b6-6a0f345a761d", -0.02, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "b585d3aa-ed5b-3c06-b856-94fd901040b9", -0.02, AttributeModifier.Operation.ADDITION);
		this.addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "ee36b093-b6bc-3b49-b03d-616303e114ef", -0.02, AttributeModifier.Operation.ADDITION);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
		cures.add(new ItemStack(Items.TOTEM_OF_UNDYING));
		cures.add(new ItemStack(Items.HONEY_BOTTLE));
		return cures;
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
