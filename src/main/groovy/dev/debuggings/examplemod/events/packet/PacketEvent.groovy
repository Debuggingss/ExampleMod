package dev.debuggings.examplemod.events.packet

import net.minecraft.network.Packet
import net.minecraftforge.fml.common.eventhandler.Cancelable
import net.minecraftforge.fml.common.eventhandler.Event

@Cancelable
class PacketEvent extends Event {
    Packet packet

    PacketEvent(Packet packet) {
        this.packet = packet
    }

    Packet getPacket() { packet }

    void setPacket(Packet packet) { this.packet = packet }

    static class Outgoing extends PacketEvent {
        Outgoing(Packet packet) {
            super(packet)
        }
    }

    static class Incoming extends PacketEvent {
        Incoming(Packet packet) {
            super(packet)
        }
    }
}
