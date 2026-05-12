package rip.ysm.compat.ironsspellbooks.neoforge;

import com.elfmcys.yesstevemodel.client.animation.molang.CtrlBinding;
import com.elfmcys.yesstevemodel.client.entity.LivingAnimatable;
import com.elfmcys.yesstevemodel.geckolib3.core.event.predicate.AnimationEvent;
import com.elfmcys.yesstevemodel.geckolib3.core.enums.PlayState;
import net.minecraft.world.entity.LivingEntity;

public final class SpellbooksCompatImpl {

    public static boolean isLoaded() {
        return false;
    }

    public static void registerBindings(CtrlBinding binding) {
    }

    public static PlayState resolvePlayState(AnimationEvent<LivingAnimatable<?>> event, LivingEntity entity) {
        return null;
    }
}
