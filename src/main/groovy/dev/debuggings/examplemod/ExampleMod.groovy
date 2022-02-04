package dev.debuggings.examplemod

import dev.debuggings.examplemod.commands.ConfigCommand
import dev.debuggings.examplemod.core.Config
import dev.debuggings.examplemod.events.packet.PacketListener
import net.minecraft.client.Minecraft
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
        modid = MOD_ID,
        name = MOD_NAME,
        version = VERSION
)
class ExampleMod {
    public static final var MOD_ID = "examplemod"
    public static final var MOD_NAME = "Example Mod"
    public static final var VERSION = "1.0"
    public static final var configLocation = "./config/examplemod.toml"

    final var mc = Minecraft.getMinecraft()
    public static Config config = null

    @Mod.EventHandler
    void init(FMLInitializationEvent event) {
        config = new Config()
        config.preload()

        new ConfigCommand().register()

        MinecraftForge.EVENT_BUS.register(new PacketListener())
    }
}