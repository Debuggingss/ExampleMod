package dev.debuggings.examplemod.events.packet

import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import net.minecraft.network.Packet
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent

class PacketListener extends ChannelDuplexHandler {
    void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        var get = true

        if (msg instanceof Packet) {
            PacketEvent.Incoming inPacket = new PacketEvent.Incoming(msg as Packet)
            MinecraftForge.EVENT_BUS.post(inPacket)

            if (inPacket?.isCanceled()) {
                get = false
            }
            msg = inPacket?.getPacket()
        }
        if (get) super.channelRead(ctx, msg)
    }

    void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        var send = true

        if (msg instanceof Packet) {
            PacketEvent.Outgoing outPacket = new PacketEvent.Outgoing(msg as Packet)
            MinecraftForge.EVENT_BUS.post(outPacket)

            if (outPacket?.isCanceled()) {
                send = false
            }
            msg = outPacket?.getPacket()
        }
        if (send) super.write(ctx, msg, promise)
    }

    @SubscribeEvent
    void joinEvent(ClientConnectedToServerEvent event) {
        event.manager.channel().pipeline().addBefore(
                "packet_handler",
                "examplemod_packet_listener",
                new PacketListener()
        )
    }
}
