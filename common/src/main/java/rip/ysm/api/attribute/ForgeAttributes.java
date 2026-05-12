package rip.ysm.api.attribute;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.jetbrains.annotations.Nullable;

public final class ForgeAttributes {

    private ForgeAttributes() {
    }

    @ExpectPlatform
    @Nullable
    public static Holder<Attribute> blockReach() {
        throw new AssertionError();
    }

    @ExpectPlatform
    @Nullable
    public static Holder<Attribute> entityReach() {
        throw new AssertionError();
    }

    @ExpectPlatform
    @Nullable
    public static Holder<Attribute> swimSpeed() {
        throw new AssertionError();
    }

    @ExpectPlatform
    @Nullable
    public static Holder<Attribute> entityGravity() {
        throw new AssertionError();
    }

    @ExpectPlatform
    @Nullable
    public static Holder<Attribute> stepHeightAddition() {
        throw new AssertionError();
    }

    @ExpectPlatform
    @Nullable
    public static Holder<Attribute> nametagDistance() {
        throw new AssertionError();
    }

    public static double getValue(LivingEntity entity, @Nullable Holder<Attribute> attribute, double defaultValue) {
        if (attribute == null) {
            return defaultValue;
        }
        return entity.getAttributeValue(attribute);
    }
}
