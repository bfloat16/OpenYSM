package com.elfmcys.yesstevemodel.neoforge;

import com.elfmcys.yesstevemodel.YesSteveModel;
import com.elfmcys.yesstevemodel.client.compat.acceleratedrendering.AcceleratedRenderingCompat;
import com.elfmcys.yesstevemodel.client.compat.carryon.CarryOnCompat;
import com.elfmcys.yesstevemodel.client.compat.cosmeticarmorreworked.CosmeticArmorCompat;
import com.elfmcys.yesstevemodel.client.compat.curios.CuriosCompat;
import com.elfmcys.yesstevemodel.client.compat.elytraslot.ElytraSlotCompat;
import com.elfmcys.yesstevemodel.client.compat.firstperson.FirstPersonCompat;
import com.elfmcys.yesstevemodel.client.compat.optifine.OptiFineDetector;
import com.elfmcys.yesstevemodel.client.renderer.AnimationDebugOverlay;
import com.elfmcys.yesstevemodel.client.renderer.LoadingStateOverlay;
import com.elfmcys.yesstevemodel.client.renderer.ModelSyncStateOverlay;
import rip.ysm.api.client.HudOverlay;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = YesSteveModel.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class NeoForgeClientSetupHooks {

    private NeoForgeClientSetupHooks() {
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        if (!YesSteveModel.isAvailable()) {
            return;
        }
        event.enqueueWork(() -> {
            CuriosCompat.init();
            FirstPersonCompat.init();
            AcceleratedRenderingCompat.init();
            OptiFineDetector.init();
            CosmeticArmorCompat.init();
            ElytraSlotCompat.init();
            CarryOnCompat.init();
        });
    }

    @SubscribeEvent
    public static void onRegisterGuiLayers(RegisterGuiLayersEvent event) {
        if (!YesSteveModel.isAvailable()) {
            return;
        }
        HudOverlay debugOverlay = AnimationDebugOverlay.createOverlay();
        HudOverlay loadingOverlay = new LoadingStateOverlay();
        HudOverlay syncOverlay = new ModelSyncStateOverlay();
        event.registerAbove(VanillaGuiLayers.DEBUG_OVERLAY, new ResourceLocation(YesSteveModel.MOD_ID, "debug_info"), (gfx, partial) -> {
            var mc = net.minecraft.client.Minecraft.getInstance();
            debugOverlay.render(gfx, mc.font, partial, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
        });
        event.registerAbove(VanillaGuiLayers.DEBUG_OVERLAY, new ResourceLocation(YesSteveModel.MOD_ID, "extra_player"), (gfx, partial) -> {
            var mc = net.minecraft.client.Minecraft.getInstance();
            loadingOverlay.render(gfx, mc.font, partial, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
        });
        event.registerAbove(VanillaGuiLayers.DEBUG_OVERLAY, new ResourceLocation(YesSteveModel.MOD_ID, "loading_state"), (gfx, partial) -> {
            var mc = net.minecraft.client.Minecraft.getInstance();
            syncOverlay.render(gfx, mc.font, partial, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
        });
    }
}
