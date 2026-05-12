package com.elfmcys.yesstevemodel.neoforge.event;

import com.elfmcys.yesstevemodel.YesSteveModel;
import com.elfmcys.yesstevemodel.client.event.MobEffectEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent.Added;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent.Expired;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent.Remove;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = YesSteveModel.MOD_ID)
public final class MobEffectForgeHook {

    private MobEffectForgeHook() {
    }

    @SubscribeEvent
    public static void onEffectAdded(Added event) {
        MobEffectInstance instance = event.getEffectInstance();
        if (instance != null) {
            MobEffectEvent.onEffectAdded(event.getEntity(), instance.getEffect(), instance.getAmplifier());
        }
    }

    @SubscribeEvent
    public static void onEffectRemoved(Remove event) {
        MobEffectEvent.onEffectRemoved(event.getEntity(), event.getEffect());
    }

    @SubscribeEvent
    public static void onEffectExpired(Expired event) {
        MobEffectInstance instance = event.getEffectInstance();
        if (instance != null) {
            MobEffectEvent.onEffectRemoved(event.getEntity(), instance.getEffect());
        }
    }
}
