package com.elfmcys.yesstevemodel.capability.neoforge;

import com.elfmcys.yesstevemodel.capability.PlayerCapability;
import com.elfmcys.yesstevemodel.neoforge.YSMAttachments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public final class PlayerCapabilityImpl {

    private PlayerCapabilityImpl() {}

    public static Optional<PlayerCapability> get(Player player) {
        return Optional.of(player.getData(YSMAttachments.PLAYER));
    }

    public static Optional<PlayerCapability> get(Entity entity) {
        if (entity instanceof Player player) {
            return Optional.of(player.getData(YSMAttachments.PLAYER));
        }
        return Optional.empty();
    }
}
