
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.soulgauntlet.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.soulgauntlet.entity.WardenEntity;
import net.mcreator.soulgauntlet.entity.SaviorEntity;
import net.mcreator.soulgauntlet.entity.EggEntity;
import net.mcreator.soulgauntlet.SoulGauntletMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoulGauntletModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SoulGauntletMod.MODID);
	public static final RegistryObject<EntityType<SaviorEntity>> SAVIOR = register("savior",
			EntityType.Builder.<SaviorEntity>of(SaviorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SaviorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EggEntity>> EGG = register("egg",
			EntityType.Builder.<EggEntity>of(EggEntity::new, MobCategory.MISC).setCustomClientFactory(EggEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WardenEntity>> WARDEN = register("warden",
			EntityType.Builder.<WardenEntity>of(WardenEntity::new, MobCategory.MISC).setCustomClientFactory(WardenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SaviorEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SAVIOR.get(), SaviorEntity.createAttributes().build());
	}
}
