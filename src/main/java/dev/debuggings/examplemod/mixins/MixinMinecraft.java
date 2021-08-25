package dev.debuggings.examplemod.mixins;

import dev.debuggings.examplemod.ExampleMod;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = { "startGame" }, at = @At("RETURN"))
    private void startGame(CallbackInfo ci) {
        ExampleMod.logger.info("Successfully injected into startGame.");
    }
}
