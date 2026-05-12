package com.elfmcys.yesstevemodel.capability.neoforge;

import com.elfmcys.yesstevemodel.capability.ProjectileModelCapability;
import com.elfmcys.yesstevemodel.neoforge.YSMAttachments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;

import java.util.Optional;

public final class ProjectileModelCapabilityImpl {

    private ProjectileModelCapabilityImpl() {}

    public static Optional<ProjectileModelCapability> get(Entity entity) {
        if (entity instanceof Projectile) {
            return Optional.of(entity.getData(YSMAttachments.PROJECTILE_MODEL));
        }
        return Optional.empty();
    }

    public static Optional<ProjectileModelCapability> get(Projectile projectile) {
        return Optional.of(projectile.getData(YSMAttachments.PROJECTILE_MODEL));
    }
}
