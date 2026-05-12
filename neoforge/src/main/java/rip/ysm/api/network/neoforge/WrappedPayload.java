package rip.ysm.api.network.neoforge;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public class WrappedPayload implements CustomPacketPayload {
    private final Type<WrappedPayload> type;
    private final Object inner;

    public WrappedPayload(Type<WrappedPayload> type, Object inner) {
        this.type = type;
        this.inner = inner;
    }

    public Object inner() { return inner; }

    @Override
    public Type<WrappedPayload> type() { return type; }
}
