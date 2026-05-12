package com.elfmcys.yesstevemodel.neoforge.event;

import com.elfmcys.yesstevemodel.YesSteveModel;
import com.elfmcys.yesstevemodel.client.event.RenderFirstPlayerBackground;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = YesSteveModel.MOD_ID, value = Dist.CLIENT)
public final class RenderFirstPlayerForgeHook {

    private RenderFirstPlayerForgeHook() {
    }

    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        if (event.getStage() == RenderLevelStageEvent.Stage.AFTER_CUTOUT_BLOCKS) {
            RenderFirstPlayerBackground.resetFrame();
        }
    }

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        RenderFirstPlayerBackground.onRenderHand(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getPartialTick());
    }
}
