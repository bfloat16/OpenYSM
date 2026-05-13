package rip.ysm.api.config.fabric;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class ConfigRegistrationImpl {

    private ConfigRegistrationImpl() {
    }

    public static void register(String modId, String type, ModConfigSpec spec) {
        NeoForgeConfigRegistry.INSTANCE.register(modId, ModConfig.Type.valueOf(type), spec);
    }
}
