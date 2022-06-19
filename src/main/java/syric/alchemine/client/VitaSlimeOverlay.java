package syric.alchemine.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;

public class VitaSlimeOverlay implements IIngameOverlay {
    protected static final ResourceLocation VITA_SLIME_LOCATION = new ResourceLocation("alchemine:textures/misc/vita_slime_outline.png");
    protected static final Float opacity = 0.9F;

//    public final IIngameOverlay VITA_ELEMENT = OverlayRegistry.registerOverlayBottom("vita_slime_overlay", (gui, poseStack, partialTick, screenWidth, screenHeight) -> {
//        gui.setupOverlayRenderState(true, false);
//        VitaSlimeOverlay.render(gui, poseStack, partialTick, screenWidth, screenHeight);
//    });

    public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, opacity);
        RenderSystem.setShaderTexture(0, VITA_SLIME_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(0.0D, (double) height, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double) width, (double) height, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double) width, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }

}