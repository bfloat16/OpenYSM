package rip.ysm.api.network.neoforge;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import rip.ysm.api.network.PacketContext;
import rip.ysm.api.network.PacketDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public final class YSMChannelImpl {

    private static ResourceLocation channelId;
    private static String version;
    private static final List<DeferredRegistration<?>> registrations = new ArrayList<>();

    private YSMChannelImpl() {}

    public static void init(ResourceLocation channelId, String version) {
        if (YSMChannelImpl.channelId != null) return;
        YSMChannelImpl.channelId = channelId;
        YSMChannelImpl.version = version;
    }

    public static <T> void register(int discriminator, Class<T> type,
                                    BiConsumer<T, FriendlyByteBuf> encoder,
                                    Function<FriendlyByteBuf, T> decoder,
                                    BiConsumer<T, PacketContext> handler,
                                    PacketDirection direction) {
        ResourceLocation id = new ResourceLocation(
                channelId.getNamespace(), channelId.getPath() + "/" + discriminator);
        CustomPacketPayload.Type<WrappedPayload> payloadType = new CustomPacketPayload.Type<>(id);
        registrations.add(new DeferredRegistration<>(payloadType, type, encoder, decoder, handler, direction));
    }

    private static boolean registered = false;

    @SuppressWarnings("unchecked")
    public static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {
        if (registered) return;
        registered = true;
        PayloadRegistrar registrar = event.registrar(version).optional();
        for (DeferredRegistration<?> reg : registrations) {
            doRegister(registrar, (DeferredRegistration<Object>) reg);
        }
    }

    private static <T> void doRegister(PayloadRegistrar registrar, DeferredRegistration<T> reg) {
        StreamCodec<RegistryFriendlyByteBuf, WrappedPayload> codec = StreamCodec.of(
                (buf, payload) -> reg.encoder.accept(reg.clazz.cast(payload.inner()), buf),
                buf -> new WrappedPayload(reg.type, reg.decoder.apply(buf))
        );

        switch (reg.direction) {
            case PLAY_TO_CLIENT -> registrar.playToClient(reg.type, codec,
                    (payload, ctx) -> reg.handler.accept(reg.clazz.cast(payload.inner()), new PacketContextImpl(ctx)));
            case PLAY_TO_SERVER -> registrar.playToServer(reg.type, codec,
                    (payload, ctx) -> reg.handler.accept(reg.clazz.cast(payload.inner()), new PacketContextImpl(ctx)));
        }
    }

    public static void sendToServer(Object packet) {
        PacketDistributor.sendToServer(wrap(packet));
    }

    public static void sendToClientPlayer(Object packet, ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, wrap(packet));
    }

    public static void sendToAll(Object packet) {
        PacketDistributor.sendToAllPlayers(wrap(packet));
    }

    public static void sendToTrackingEntity(Object packet, Entity entity) {
        PacketDistributor.sendToPlayersTrackingEntity(entity, wrap(packet));
    }

    public static void sendToTrackingEntityAndSelf(Object packet, Player player) {
        PacketDistributor.sendToPlayersTrackingEntityAndSelf(player, wrap(packet));
    }

    public static Packet<?> toClientboundPacket(Object packet) {
        return new ClientboundCustomPayloadPacket(wrap(packet));
    }

    public static Packet<?> toServerboundPacket(Object packet) {
        return new ServerboundCustomPayloadPacket(wrap(packet));
    }

    private static WrappedPayload wrap(Object packet) {
        for (DeferredRegistration<?> reg : registrations) {
            if (reg.clazz.isInstance(packet)) {
                return new WrappedPayload(reg.type, packet);
            }
        }
        throw new IllegalArgumentException("Unregistered packet: " + packet.getClass().getName());
    }

    private record DeferredRegistration<T>(
            CustomPacketPayload.Type<WrappedPayload> type,
            Class<T> clazz,
            BiConsumer<T, FriendlyByteBuf> encoder,
            Function<FriendlyByteBuf, T> decoder,
            BiConsumer<T, PacketContext> handler,
            PacketDirection direction
    ) {}
}
