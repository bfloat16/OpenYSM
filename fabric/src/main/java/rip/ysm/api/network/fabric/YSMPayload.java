package rip.ysm.api.network.fabric;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record YSMPayload(FriendlyByteBuf data) implements CustomPacketPayload {

    public static CustomPacketPayload.Type<YSMPayload> TYPE;

    public static void register(ResourceLocation id) {
        TYPE = new CustomPacketPayload.Type<>(id);
        StreamCodec<FriendlyByteBuf, YSMPayload> codec = StreamCodec.of(
                (buf, payload) -> buf.writeBytes(payload.data().copy()),
                buf -> new YSMPayload(new FriendlyByteBuf(buf.readBytes(buf.readableBytes())))
        );
        PayloadTypeRegistry.playC2S().register(TYPE, codec);
        PayloadTypeRegistry.playS2C().register(TYPE, codec);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
