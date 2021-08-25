package dev.debuggings.examplemod.commands;

import dev.debuggings.examplemod.ExampleMod;
import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class ConfigCommand extends Command {
    public ConfigCommand() {
        super("examplemod");
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(ExampleMod.config.gui());
    }
}
