package syric.alchemine;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import syric.alchemine.brewing.ingredients.AlchemicalIngredients;
import syric.alchemine.client.FogEffects;
import syric.alchemine.outputs.general.alchemicaleffects.AlchemicalEffects;
import syric.alchemine.setup.BlockRendering;
import syric.alchemine.setup.AlchemineOverlays;
import syric.alchemine.setup.BootStrap;
import syric.alchemine.setup.registry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Alchemine.MODID)
public class Alchemine
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "alchemine";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public Alchemine() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        forgeEventBus.addListener(this::handleFog);
        forgeEventBus.addListener(this::handleFogColor);

        registry.register();


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

        AlchemicalIngredients.fillMap();
        AlchemicalEffects.fillList();
        BootStrap.bootStrap();

        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    private void handleFog(final EntityViewRenderEvent.RenderFogEvent event) {
        FogEffects.renderFog(event);
    }
    private void handleFogColor(final EntityViewRenderEvent.FogColors event) {
        FogEffects.fogColor(event);
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            BlockRendering.registerBlockRenderTypes();
            AlchemineOverlays.register();


        }
    }
}
