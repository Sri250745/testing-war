package com.testingwar.client;

import com.testingwar.entity.TestingWarEntities;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.resources.Identifier;

public final class TestingWarClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register(TestingWarEntities.CITIZEN, TestingHumanRenderer::new);
    }

    private static final class TestingHumanRenderer extends HumanoidMobRenderer<
            com.testingwar.entity.TestingHumanEntity,
            AvatarRenderState,
            PlayerModel> {
        private static final Identifier TEXTURE =
                Identifier.fromNamespaceAndPath("testing_war", "textures/entity/citizen.png");

        private TestingHumanRenderer(EntityRendererProvider.Context context) {
            super(context, new PlayerModel(context.bakeLayer(ModelLayers.PLAYER), false), 0.45f);
        }

        @Override
        public AvatarRenderState createRenderState() {
            return new AvatarRenderState();
        }

        @Override
        public Identifier getTextureLocation(AvatarRenderState state) {
            return TEXTURE;
        }
    }
}
