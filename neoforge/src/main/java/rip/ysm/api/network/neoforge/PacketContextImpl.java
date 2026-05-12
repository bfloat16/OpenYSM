package rip.ysm.api.network.neoforge;

import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.Nullable;
import rip.ysm.api.network.PacketContext;

final class PacketContextImpl implements PacketContext {

    private final IPayloadContext context;

    PacketContextImpl(IPayloadContext context) {
        this.context = context;
    }

    @Override
    public boolean isClientSide() {
        return context.flow().isClientbound();
    }

    @Override
    public boolean isServerSide() {
        return context.flow().isServerbound();
    }

    @Override
    public @Nullable ServerPlayer getSender() {
        if (isServerSide() && context.player() instanceof ServerPlayer sp) {
            return sp;
        }
        return null;
    }

    @Override
    public Connection getConnection() {
        return context.connection();
    }

    @Override
    public void enqueueWork(Runnable runnable) {
        context.enqueueWork(runnable);
    }
}
