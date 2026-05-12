package com.elfmcys.yesstevemodel.capability.neoforge;

import com.elfmcys.yesstevemodel.capability.VehicleCapability;
import com.elfmcys.yesstevemodel.neoforge.YSMAttachments;
import net.minecraft.world.entity.Entity;

import java.util.Optional;

public final class VehicleCapabilityImpl {

    private VehicleCapabilityImpl() {}

    public static Optional<VehicleCapability> get(Entity entity) {
        return Optional.of(entity.getData(YSMAttachments.VEHICLE));
    }
}
