package net.forixaim.excapextra.ex_cap;

import net.forixaim.excapextra.ExCapExtra;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.ex_cap.core.events.*;
import yesman.epicfight.gameasset.ex_cap.Builders;
import yesman.epicfight.gameasset.ex_cap.ExCapDataSets;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import static net.forixaim.excapextra.ex_cap.ExCapExtraMovesets.sword1HMS;
import static net.forixaim.excapextra.ex_cap.ExCapExtraMovesets.sword2HMS;

@Mod.EventBusSubscriber(modid = ExCapExtra.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExCapEventHooks
{
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerBuilder(ExCapBuilderCreationEvent event)
    {
        Builders.GREATSWORD.template().canBePlacedOffhand(true);
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerMovesets(ExCapMovesetRegistryEvent event)
    {
        event.addMoveSet(
                ExCapExtraMovesets.axe1h,
                ExCapExtraMovesets.sword1HMS,
                ExCapExtraMovesets.bowMS,
                ExCapExtraMovesets.crossbowMS,
                ExCapExtraMovesets.sword2HMS,
                ExCapExtraMovesets.longsword1HMS,
                ExCapExtraMovesets.longsword2HMS,
                ExCapExtraMovesets.liechtenauerMS,
                ExCapExtraMovesets.greatsword2HMS,
                ExCapExtraMovesets.dualGreatswordMS,
                ExCapExtraMovesets.greatswordDaggerMS,
                ExCapExtraMovesets.tachi2HMS,
                ExCapExtraMovesets.spear1HMS,
                ExCapExtraMovesets.spear2HMS,
                ExCapExtraMovesets.dagger1HMS,
                ExCapExtraMovesets.dagger2HMS,
                ExCapExtraMovesets.uchigatanaBase,
                ExCapExtraMovesets.uchigatanaSheathed
        );
    }
    @SubscribeEvent
    public static void registerConditionals(ConditionalRegistryEvent event)
    {
        event.addConditional(Conditionals.DUAL_GREATSWORD, Conditionals.GREATSWORD_DAGGER);
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerData(ExCapDataRegistrationEvent event)
    {
        event.addData(
                EFExtraExCapDatasets.GREATSWORD
        );

    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void populateData(ExCapabilityBuilderPopulationEvent event)
    {
        event.registerData(Builders.GREATSWORD.id(), EFExtraExCapDatasets.GREATSWORD.id());
    }
}
