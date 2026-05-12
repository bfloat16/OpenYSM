package com.elfmcys.yesstevemodel.neoforge.event;

import com.elfmcys.yesstevemodel.YesSteveModel;
import com.elfmcys.yesstevemodel.client.event.ShieldBlockCooldownEvent;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.ShieldBlockEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = YesSteveModel.MOD_ID)
public final class ShieldBlockCooldownForgeHook {

    private ShieldBlockCooldownForgeHook() {
    }

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        ShieldBlockCooldownEvent.onShieldBlock(event.getEntity());
    }

    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity living) {
            ShieldBlockCooldownEvent.onLivingTick(living);
        }
    }
}
