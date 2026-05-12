package rip.ysm.api.config;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ConfigRegistration {

    private ConfigRegistration() {
    }

    @ExpectPlatform
    public static void register(String modId, String type, ForgeConfigSpec spec) {
        throw new AssertionError();
    }
}
