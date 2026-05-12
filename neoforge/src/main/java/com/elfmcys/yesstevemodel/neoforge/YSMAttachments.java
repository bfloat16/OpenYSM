package com.elfmcys.yesstevemodel.neoforge;

import com.elfmcys.yesstevemodel.YesSteveModel;
import com.elfmcys.yesstevemodel.capability.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public final class YSMAttachments {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, YesSteveModel.MOD_ID);

    // Server-side, serializable, copy on death
    public static final Supplier<AttachmentType<ModelInfoCapability>> MODEL_INFO =
            ATTACHMENT_TYPES.register("model_info", () -> AttachmentType.builder(ModelInfoCapability::new)
                    .serialize(new IAttachmentSerializer<CompoundTag, ModelInfoCapability>() {
                        @Override
                        public ModelInfoCapability read(IAttachmentHolder holder, CompoundTag tag, HolderLookup.Provider provider) {
                            ModelInfoCapability cap = new ModelInfoCapability();
                            cap.deserializeNBT(tag);
                            return cap;
                        }
                        @Override
                        public CompoundTag write(ModelInfoCapability cap, HolderLookup.Provider provider) {
                            return cap.serializeNBT();
                        }
                    })
                    .copyOnDeath()
                    .build());

    public static final Supplier<AttachmentType<AuthModelsCapability>> AUTH_MODELS =
            ATTACHMENT_TYPES.register("auth_models", () -> AttachmentType.builder(AuthModelsCapability::new)
                    .serialize(new IAttachmentSerializer<ListTag, AuthModelsCapability>() {
                        @Override
                        public AuthModelsCapability read(IAttachmentHolder holder, ListTag tag, HolderLookup.Provider provider) {
                            AuthModelsCapability cap = new AuthModelsCapability();
                            cap.deserializeNBT(tag);
                            return cap;
                        }
                        @Override
                        public ListTag write(AuthModelsCapability cap, HolderLookup.Provider provider) {
                            return cap.serializeNBT();
                        }
                    })
                    .copyOnDeath()
                    .build());

    public static final Supplier<AttachmentType<StarModelsCapability>> STAR_MODELS =
            ATTACHMENT_TYPES.register("star_models", () -> AttachmentType.builder(StarModelsCapability::new)
                    .serialize(new IAttachmentSerializer<ListTag, StarModelsCapability>() {
                        @Override
                        public StarModelsCapability read(IAttachmentHolder holder, ListTag tag, HolderLookup.Provider provider) {
                            StarModelsCapability cap = new StarModelsCapability();
                            cap.deserializeNBT(tag);
                            return cap;
                        }
                        @Override
                        public ListTag write(StarModelsCapability cap, HolderLookup.Provider provider) {
                            return cap.serializeNBT();
                        }
                    })
                    .copyOnDeath()
                    .build());

    public static final Supplier<AttachmentType<ProjectileModelCapability>> PROJECTILE_MODEL =
            ATTACHMENT_TYPES.register("projectile_model", () -> AttachmentType.builder(ProjectileModelCapability::new)
                    .serialize(new IAttachmentSerializer<CompoundTag, ProjectileModelCapability>() {
                        @Override
                        public ProjectileModelCapability read(IAttachmentHolder holder, CompoundTag tag, HolderLookup.Provider provider) {
                            ProjectileModelCapability cap = new ProjectileModelCapability();
                            cap.deserializeNBT(tag);
                            return cap;
                        }
                        @Override
                        public CompoundTag write(ProjectileModelCapability cap, HolderLookup.Provider provider) {
                            return cap.serializeNBT();
                        }
                    })
                    .build());

    public static final Supplier<AttachmentType<VehicleModelCapability>> VEHICLE_MODEL =
            ATTACHMENT_TYPES.register("vehicle_model", () -> AttachmentType.builder(VehicleModelCapability::new)
                    .serialize(new IAttachmentSerializer<CompoundTag, VehicleModelCapability>() {
                        @Override
                        public VehicleModelCapability read(IAttachmentHolder holder, CompoundTag tag, HolderLookup.Provider provider) {
                            VehicleModelCapability cap = new VehicleModelCapability();
                            cap.deserializeNBT(tag);
                            return cap;
                        }
                        @Override
                        public CompoundTag write(VehicleModelCapability cap, HolderLookup.Provider provider) {
                            return cap.serializeNBT();
                        }
                    })
                    .build());

    // Client-side only, NOT serializable
    public static final Supplier<AttachmentType<PlayerCapability>> PLAYER =
            ATTACHMENT_TYPES.register("player_animatable", () -> AttachmentType.<PlayerCapability>builder(
                    holder -> new PlayerCapability((Player) holder)).build());

    public static final Supplier<AttachmentType<ProjectileCapability>> PROJECTILE =
            ATTACHMENT_TYPES.register("projectile_animatable", () -> AttachmentType.<ProjectileCapability>builder(
                    holder -> new ProjectileCapability((Projectile) holder)).build());

    public static final Supplier<AttachmentType<VehicleCapability>> VEHICLE =
            ATTACHMENT_TYPES.register("vehicle_animatable", () -> AttachmentType.<VehicleCapability>builder(
                    holder -> new VehicleCapability((Entity) holder)).build());

    private YSMAttachments() {}
}
