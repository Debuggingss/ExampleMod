package dev.debuggings.examplemod.commands

import dev.debuggings.examplemod.core.Config
import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler

object ConfigCommand : Command("examplemod") {

    @DefaultHandler
    fun handle() {
        EssentialAPI.getGuiUtil().openScreen(Config.gui())
    }
}
