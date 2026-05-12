package rip.ysm.api.config.neoforge;

import net.minecraftforge.common.ForgeConfigSpec;
import net.neoforged.fml.config.ModConfig;
import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;

public final class ConfigRegistrationImpl {

    private ConfigRegistrationImpl() {
    }

    public static void register(String modId, String type, ForgeConfigSpec spec) {
        ForgeConfigRegistry.INSTANCE.register(modId, ModConfig.Type.valueOf(type), spec);
    }
}
