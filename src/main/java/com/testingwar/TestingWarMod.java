package com.testingwar;

import com.testingwar.entity.TestingWarEntities;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TestingWarMod implements ModInitializer {
	public static final String MOD_ID = "testing_war";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TestingWarEntities.initialize();
		LOGGER.info("Testing War initialized. Summon a test character with /summon testing_war:citizen.");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
