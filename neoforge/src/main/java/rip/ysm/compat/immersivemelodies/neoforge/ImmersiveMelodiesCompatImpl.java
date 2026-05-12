package rip.ysm.compat.immersivemelodies.neoforge;

import com.elfmcys.yesstevemodel.client.animation.molang.CtrlBinding;
import rip.ysm.compat.immersivemelodies.ImmersiveMelodiesCompat.ImmersiveMelodiesData;
import net.minecraft.world.entity.LivingEntity;

public final class ImmersiveMelodiesCompatImpl {

    public static boolean isLoaded() {
        return false;
    }

    public static void updateMelodyProgress(LivingEntity livingEntity, ImmersiveMelodiesData imData) {
    }

    public static void registerBindings(CtrlBinding binding) {
    }
}
