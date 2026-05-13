package rip.ysm.api.config;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.neoforged.neoforge.common.ModConfigSpec;

public final class ConfigRegistration {

    private ConfigRegistration() {
    }

    @ExpectPlatform
    public static void register(String modId, String type, ModConfigSpec spec) {
        throw new AssertionError();
    }
}
