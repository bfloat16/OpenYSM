package com.elfmcys.yesstevemodel.capability.neoforge;

import com.elfmcys.yesstevemodel.capability.VehicleModelCapability;
import com.elfmcys.yesstevemodel.neoforge.YSMAttachments;
import net.minecraft.world.entity.Entity;

import java.util.Optional;

public final class VehicleModelCapabilityImpl {

    private VehicleModelCapabilityImpl() {}

    public static Optional<VehicleModelCapability> get(Entity entity) {
        return Optional.of(entity.getData(YSMAttachments.VEHICLE_MODEL));
    }
}
