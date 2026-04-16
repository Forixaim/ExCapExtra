package net.forixaim.excapextra.mixin;

import com.asanginxst.epicfightx.capabilities.item.WeaponCapabilityPresetsX;
import com.mojang.logging.LogUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;

@Mixin(WeaponCapabilityPresetsX.class)
public class MixinWeaponCapabilityPresetX {
    @Inject(method = "efx$register", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;)V", shift = At.Shift.AFTER), remap = false, cancellable = true)
    private static void nope(WeaponCapabilityPresetRegistryEvent event, CallbackInfo ci)
    {
        LogUtils.getLogger().info("Nope. To keep parity with ExCap this method will be canceled");
        ci.cancel();
    }
}
