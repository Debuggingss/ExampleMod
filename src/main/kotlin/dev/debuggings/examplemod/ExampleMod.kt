package dev.debuggings.examplemod

import dev.debuggings.examplemod.commands.ConfigCommand
import dev.debuggings.examplemod.core.Config
import dev.debuggings.examplemod.events.packet.PacketListener
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = ExampleMod.MOD_ID,
    name = ExampleMod.MOD_NAME,
    version = ExampleMod.VERSION
)
class ExampleMod {

    companion object {
        const val MOD_ID = "examplemod"
        const val MOD_NAME = "ExampleMod"
        const val VERSION = "1.0"
        const val configLocation = "./config/examplemod.toml"
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Config.preload()

        ConfigCommand.register()

        MinecraftForge.EVENT_BUS.register(PacketListener())
    }
}
