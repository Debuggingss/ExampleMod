package dev.debuggings.examplemod;

import dev.debuggings.examplemod.commands.ConfigCommand;
import dev.debuggings.examplemod.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = ExampleMod.MOD_ID,
    name = ExampleMod.MOD_NAME,
    version = ExampleMod.VERSION
)
public class ExampleMod {

    public static final String MOD_ID = "examplemod";
    public static final String MOD_NAME = "ExampleMod";
    public static final String VERSION = "1.0";
    public static final String configLocation = "./config/examplemod.toml";

    public static final Logger logger = LogManager.getLogger();
    public static Config config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        config = new Config();
        config.preload();

        new ConfigCommand().register();
    }
}
