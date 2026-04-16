package net.forixaim.excapextra.ex_cap;

import com.asanginxst.epicfightx.gameassets.animations.ExtraAnimations;
import net.forixaim.excapextra.ExCapExtra;
import yesman.epicfight.api.ex_cap.core.data.BuilderEntry;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class ExCapExtraBuilders {
    public static BuilderEntry SCYTHE = new BuilderEntry(ExCapExtra.extraIdentifier("scythe"), WeaponCapability.builder()
            .category(CapabilityItem.WeaponCategories.SPEAR)
            .collider(ExtraAnimations.SCYTHE_COLLIDER)
            .swingSound(EpicFightSounds.WHOOSH_BIG.get())
            .canBePlacedOffhand(true)
            .reach(0.05F)
            .addTag(ExCapExtra.extraIdentifier("scythe"))
            .setTierValues(0, 2, 1, 3)
    );
}
