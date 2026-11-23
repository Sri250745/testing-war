package com.testingwar.entity;

import com.testingwar.TestingWarMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.core.Registry;

public final class TestingWarEntities {
	private static final ResourceKey<EntityType<?>> CITIZEN_KEY = ResourceKey.create(Registries.ENTITY_TYPE, TestingWarMod.id("citizen"));
	public static final EntityType<TestingHumanEntity> CITIZEN = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			CITIZEN_KEY,
			EntityType.Builder.<TestingHumanEntity>of(TestingHumanEntity::new, MobCategory.CREATURE)
					.sized(0.6f, 1.8f)
					.build(CITIZEN_KEY)
	);

	private TestingWarEntities() {}

	public static void initialize() {
		FabricDefaultAttributeRegistry.register(CITIZEN, TestingHumanEntity.createAttributes());
	}
}
