package dev.debuggings.examplemod.config;

import dev.debuggings.examplemod.ExampleMod;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {

    @Property(
        type = PropertyType.SWITCH,
        name = "Toggle Swag Mod",
        description = "Example Switch",
        category = "General"
    )
    public boolean toggleSwag = false;

    @Property(
        type = PropertyType.TEXT,
        name = "Swag Text",
        description = "Example Text",
        category = "General"
    )
    public String swagText = ":sunglasses:";

    public Config() {
        super(new File(ExampleMod.configLocation));

        addDependency("swagText", "toggleSwag");

        initialize();
    }
}
