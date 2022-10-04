package dev.elrol.zencraft;

import dev.elrol.zencraft.dimension.ModDimensions;
import dev.elrol.zencraft.enchantment.ModEnchantments;
import dev.elrol.zencraft.events.ModEventHandler;
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

    public static final Logger LOGGER = LogManager.getLogger();

    public ZenCraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModDimensions.register();
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);
        ModEnchantments.register(eventBus);

        eventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ModEventHandler());
    }

    private void setup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
