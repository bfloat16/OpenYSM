package rip.ysm.compat.swem.neoforge;

import com.elfmcys.yesstevemodel.client.animation.molang.CtrlBinding;
import net.minecraft.world.entity.LivingEntity;

public final class SWEMCompatImpl {

    public static boolean isLoaded() {
        return false;
    }

    public static String getHorseGaitName(LivingEntity livingEntity) {
        return null;
    }

    public static void registerControllerFunctions(CtrlBinding ctrlBinding) {
    }
}
