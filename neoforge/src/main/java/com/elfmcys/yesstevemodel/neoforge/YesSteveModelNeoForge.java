package com.elfmcys.yesstevemodel.neoforge;

import com.elfmcys.yesstevemodel.YesSteveModel;
import com.elfmcys.yesstevemodel.network.NetworkHandler;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import rip.ysm.api.network.neoforge.YSMChannelImpl;

@Mod(YesSteveModel.MOD_ID)
public final class YesSteveModelNeoForge {

    public YesSteveModelNeoForge(IEventBus modBus) {
        YSMAttachments.ATTACHMENT_TYPES.register(modBus);
        // NetworkHandler.init() must run BEFORE RegisterPayloadHandlersEvent
        NetworkHandler.init();
        modBus.addListener(YesSteveModelNeoForge::onRegisterPayloads);
        YesSteveModel.init();
    }

    private static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {
        YSMChannelImpl.onRegisterPayloads(event);
    }
}
