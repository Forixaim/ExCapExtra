package net.forixaim.excapextra.ex_cap;

import com.asanginxst.epicfightx.gameassets.EFXStyles;
import net.forixaim.excapextra.ExCapExtra;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.ex_cap.core.data.ConditionalEntry;
import yesman.epicfight.api.ex_cap.core.provider.ProviderConditional;
import yesman.epicfight.api.ex_cap.core.provider.ProviderConditionalType;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class Conditionals
{
    public static ConditionalEntry GREATSWORD_DAGGER = new ConditionalEntry(
            ExCapExtra.identifier("gs_dagger"), ProviderConditional.builder()
            .setType(ProviderConditionalType.WEAPON_CATEGORY)
            .setWieldStyle(EFXStyles.GREATSWORD_DAGGER)
            .setHand(InteractionHand.OFF_HAND)
            .setCategory(CapabilityItem.WeaponCategories.DAGGER)
            .isVisibleOffHand(true)
    );

    public static ConditionalEntry DUAL_GREATSWORD = new ConditionalEntry(
            ExCapExtra.identifier("dual_gs"), ProviderConditional.builder()
            .setType(ProviderConditionalType.WEAPON_CATEGORY)
            .setWieldStyle(EFXStyles.DUAL_GREATSWORD)
            .setHand(InteractionHand.OFF_HAND)
            .setCategory(CapabilityItem.WeaponCategories.GREATSWORD)
            .isVisibleOffHand(true)
    );
}
