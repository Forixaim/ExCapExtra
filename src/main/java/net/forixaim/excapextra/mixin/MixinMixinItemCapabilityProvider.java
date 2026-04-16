package net.forixaim.excapextra.mixin;

import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.ex_cap.core.managers.BuilderManager;
import yesman.epicfight.gameasset.ex_cap.Builders;
import yesman.epicfight.world.capabilities.item.ArmorCapability;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.MapCapability;
import yesman.epicfight.world.capabilities.item.WeaponCapabilityPresets;
import yesman.epicfight.world.capabilities.provider.ItemCapabilityProvider;

import java.util.Map;
import java.util.function.Function;

@Mixin(value = ItemCapabilityProvider.class, priority = Integer.MAX_VALUE)
public class MixinMixinItemCapabilityProvider {
    @Shadow
    @Final
    private static Map<Class<? extends Item>, Function<Item, CapabilityItem.Builder>> CAPABILITY_BY_CLASS;

    /**
     * @author Forixaim
     * @reason Reverting Epic Fight overrides to vanilla logic.
     */
    @Overwrite(remap = false)
    public static void registerWeaponTypesByClass() {
        CAPABILITY_BY_CLASS.put(ArmorItem.class, (item) -> ArmorCapability.builder().item(item));
        CAPABILITY_BY_CLASS.put(ShieldItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.SHIELD.id()), item));
        CAPABILITY_BY_CLASS.put(SwordItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.SWORD.id()), item));
        CAPABILITY_BY_CLASS.put(PickaxeItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.PICKAXE.id()), item));
        CAPABILITY_BY_CLASS.put(AxeItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.AXE.id()), item));
        CAPABILITY_BY_CLASS.put(ShovelItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.SHOVEL.id()), item));
        CAPABILITY_BY_CLASS.put(HoeItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.HOE.id()), item));
        CAPABILITY_BY_CLASS.put(BowItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.BOW.id()), item));
        CAPABILITY_BY_CLASS.put(CrossbowItem.class, item -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(Builders.CROSSBOW.id()), item));
        CAPABILITY_BY_CLASS.put(MapItem.class, (item) -> MapCapability.builder());
    }

    /**
     * Safety Lock: Even if another mod attempts to @Inject into the
     * "Tail" of this method after our Overwrite, this high-priority
     * Head injection allows us to monitor or cancel the flow.
     */
    @Inject(method = "registerWeaponTypesByClass", at = @At("HEAD"), cancellable = true, remap = false)
    private static void lockMethod(CallbackInfo ci) {
        // If necessary, ci.cancel() here would prevent any logic below it
        // from executing, but since we are Overwriting, this is mostly
        // for tracking tampering attempts.
        ci.cancel();
    }
}
