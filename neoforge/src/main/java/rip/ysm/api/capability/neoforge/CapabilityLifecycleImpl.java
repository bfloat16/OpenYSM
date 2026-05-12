package rip.ysm.api.capability.neoforge;

import net.minecraft.world.entity.Entity;

public final class CapabilityLifecycleImpl {

    private CapabilityLifecycleImpl() {
    }

    public static void revive(Entity entity) {
        // No-op: Capability system removed in NeoForge 1.20.6
    }

    public static void invalidate(Entity entity) {
        // No-op: Capability system removed in NeoForge 1.20.6
    }
}
