package rip.ysm.api.config.fabric;

import fuzs.forgeconfigapiport.fabric.api.forge.v4.ForgeConfigRegistry;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public final class ConfigRegistrationImpl {

    private ConfigRegistrationImpl() {
    }

    public static void register(String modId, String type, ForgeConfigSpec spec) {
        ForgeConfigRegistry.INSTANCE.register(modId, ModConfig.Type.valueOf(type), spec);
    }
}
