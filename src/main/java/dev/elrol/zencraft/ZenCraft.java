package dev.elrol.zencraft;

import dev.elrol.zencraft.dimension.ModDimensions;
import dev.elrol.zencraft.world.feature.ModConfiguredFeatures;
import dev.elrol.zencraft.world.feature.ModPlacedFeatures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ZenCraft.MODID)
public class ZenCraft {

    public static final String MODID = "zencraft";

    private static final Logger LOGGER = LogManager.getLogger();

    public ZenCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModDimensions.register();
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
