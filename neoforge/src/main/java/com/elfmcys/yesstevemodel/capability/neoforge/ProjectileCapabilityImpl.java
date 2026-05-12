package com.elfmcys.yesstevemodel.capability.neoforge;

import com.elfmcys.yesstevemodel.capability.ProjectileCapability;
import com.elfmcys.yesstevemodel.neoforge.YSMAttachments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;

import java.util.Optional;

public final class ProjectileCapabilityImpl {

    private ProjectileCapabilityImpl() {}

    public static Optional<ProjectileCapability> get(Entity entity) {
        if (entity instanceof Projectile) {
            return Optional.of(entity.getData(YSMAttachments.PROJECTILE));
        }
        return Optional.empty();
    }

    public static Optional<ProjectileCapability> get(Projectile projectile) {
        return Optional.of(projectile.getData(YSMAttachments.PROJECTILE));
    }
}
