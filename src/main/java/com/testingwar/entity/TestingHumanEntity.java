package com.testingwar.entity;

import java.util.UUID;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public final class TestingHumanEntity extends PathfinderMob {
	private UUID characterId = UUID.randomUUID();
	private String characterName = "Wanderer";

	public TestingHumanEntity(EntityType<? extends TestingHumanEntity> type, Level level) {
		super(type, level);
		this.characterName = "Citizen-" + this.getId();
		this.setCustomName(Component.literal(this.characterName));
		this.setCustomNameVisible(true);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return PathfinderMob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 20.0)
				.add(Attributes.MOVEMENT_SPEED, 0.25)
				.add(Attributes.FOLLOW_RANGE, 24.0);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0f));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putString("TestingWarCharacterId", this.characterId.toString());
		output.putString("TestingWarCharacterName", this.characterName);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		input.getString("TestingWarCharacterId").ifPresent(value -> {
			try { this.characterId = UUID.fromString(value); }
			catch (IllegalArgumentException ignored) { this.characterId = UUID.randomUUID(); }
		});
		input.getString("TestingWarCharacterName").ifPresent(value -> {
			this.characterName = value;
			this.setCustomName(Component.literal(value));
			this.setCustomNameVisible(true);
		});
	}
}
