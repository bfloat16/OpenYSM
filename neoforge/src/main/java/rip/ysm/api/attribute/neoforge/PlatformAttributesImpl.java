package rip.ysm.api.attribute.neoforge;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.jetbrains.annotations.Nullable;

public final class PlatformAttributesImpl {

    private PlatformAttributesImpl() {
    }

    @Nullable
    public static Holder<Attribute> blockReach() {
        return Attributes.BLOCK_INTERACTION_RANGE;
    }

    @Nullable
    public static Holder<Attribute> entityReach() {
        return Attributes.ENTITY_INTERACTION_RANGE;
    }

    @Nullable
    public static Holder<Attribute> swimSpeed() {
        return NeoForgeMod.SWIM_SPEED;
    }

    @Nullable
    public static Holder<Attribute> entityGravity() {
        return Attributes.GRAVITY;
    }

    @Nullable
    public static Holder<Attribute> stepHeightAddition() {
        return Attributes.STEP_HEIGHT;
    }

    @Nullable
    public static Holder<Attribute> nametagDistance() {
        return NeoForgeMod.NAMETAG_DISTANCE;
    }
}
