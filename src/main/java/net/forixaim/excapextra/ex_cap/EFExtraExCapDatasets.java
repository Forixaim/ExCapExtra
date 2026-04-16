package net.forixaim.excapextra.ex_cap;

import com.asanginxst.epicfightx.gameassets.EFXStyles;
import net.forixaim.excapextra.ExCapExtra;
import yesman.epicfight.api.ex_cap.core.data.ExCapData;
import yesman.epicfight.api.ex_cap.core.data.ExCapDataEntry;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import static net.forixaim.excapextra.ex_cap.ExCapExtraMovesets.*;

public class EFExtraExCapDatasets
{
    public static final ExCapDataEntry GREATSWORD = new ExCapDataEntry(ExCapExtra.identifier("greatsword"), ExCapData.builder()
            .addConditional(Conditionals.DUAL_GREATSWORD.id(), Conditionals.GREATSWORD_DAGGER.id())
            .addMoveset(CapabilityItem.Styles.TWO_HAND, greatsword2HMS.id())
            .addMoveset(CapabilityItem.Styles.COMMON, greatsword2HMS.id())
            .addMoveset(EFXStyles.DUAL_GREATSWORD, dualGreatswordMS.id())
            .addMoveset(EFXStyles.GREATSWORD_DAGGER, greatswordDaggerMS.id())
    );

    public static final ExCapDataEntry SCYTHE = new ExCapDataEntry(ExCapExtra.extraIdentifier("scythe"), ExCapData.builder()
            .addConditional(Conditionals.DEFAULT_SCYTHE.id())
            .addMoveset(EFXStyles.SCYTHE, scytheMS.id()));

    public static final ExCapDataEntry TRIDENT = new ExCapDataEntry(ExCapExtra.identifier("trident"), ExCapData.builder()
            .addConditional(Conditionals.DUAL_TRIDENT.id(), Conditionals.SHIELD_OFFHAND.id())
            .addMoveset(ExtraExCapStyles.TRIDENT_SHIELD, tridentShieldMS.id())
            .addMoveset(ExtraExCapStyles.DUAL_TRIDENT, dualTrident.id()));
}
