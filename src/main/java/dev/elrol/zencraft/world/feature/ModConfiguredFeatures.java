package dev.elrol.zencraft.world.feature;

import com.google.common.base.Suppliers;
import dev.elrol.zencraft.ZenCraft;
import dev.elrol.zencraft.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ZenCraft.MODID);

    //Ore Configurations
    private static final Supplier<List<OreConfiguration.TargetBlockState>> TIN_ORES = Suppliers.memoize(()-> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE)));

    private static final Supplier<List<OreConfiguration.TargetBlockState>> URANIUM_ORES = Suppliers.memoize(()-> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.URANIUM_ORE),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_URANIUM_ORE)));

    private static final Supplier<List<OreConfiguration.TargetBlockState>> TITANIUM_ORES = Suppliers.memoize(()-> List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TITANIUM_ORE)));

    //Registry Objects
    public static final RegistryObject<ConfiguredFeature<?,?>> TIN_ORE = CONFIGURED_FEATURES.register("tin_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TIN_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?,?>> URANIUM_ORE = CONFIGURED_FEATURES.register("uranium_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(URANIUM_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?,?>> TITANIUM_ORE = CONFIGURED_FEATURES.register("titanium_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TITANIUM_ORES.get(), 6)));

    public static void register(IEventBus bus) {
        CONFIGURED_FEATURES.register(bus);
    }
}
