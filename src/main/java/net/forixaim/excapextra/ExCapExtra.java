package net.forixaim.excapextra;

import com.asanginxst.epicfightx.EpicFightExtraMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExCapExtra.MOD_ID)
public class ExCapExtra {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "excapextra";

    public static ResourceLocation identifier(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static ResourceLocation extraIdentifier(String name)
    {
        return ResourceLocation.fromNamespaceAndPath(EpicFightExtraMod.MOD_ID, name);
    }

    public ExCapExtra(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

}
