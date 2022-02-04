package dev.debuggings.examplemod.core

import dev.debuggings.examplemod.ExampleMod
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType

class Config extends Vigilant {
    Config() {
        super(new File(ExampleMod.configLocation))

        addDependency("swagText", "toggleSwag")

        initialize()
    }

    @Property(
            type = PropertyType.SWITCH,
            name = "Toggle Swag Mod",
            description = "Example Switch",
            category = "General"
    )
    var toggleSwag = false

    @Property(
            type = PropertyType.TEXT,
            name = "Swag Text",
            description = "Example Text",
            category = "General"
    )
    var swagText = ":sunglasses:"
}
