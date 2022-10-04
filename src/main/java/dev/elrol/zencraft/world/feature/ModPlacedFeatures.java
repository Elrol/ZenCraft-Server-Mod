package dev.elrol.zencraft.world.feature;

import dev.elrol.zencraft.ZenCraft;
import dev.elrol.zencraft.dimension.ModDimensions;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    private static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ZenCraft.MODID);

    private static final DimensionBiomeFilter resourceFilter = new DimensionBiomeFilter(id -> id.equals(ModDimensions.RESOURCE_LEVEL));

    public static RegistryObject<PlacedFeature> TIN_ORE_PLACED;
    public static RegistryObject<PlacedFeature> URANIUM_ORE_PLACED;
    public static RegistryObject<PlacedFeature> TITANIUM_ORE_PLACED;

    private static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier height) {
        return List.of(modifier, InSquarePlacement.spread(), height, resourceFilter);
    }

    private static List<PlacementModifier> commonOrePlacement(int veins, PlacementModifier height) {
        return orePlacement(CountPlacement.of(veins), height);
    }

    //   1 / chance
    private static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier height) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), height);
    }

    public static void register(IEventBus bus) {
        TIN_ORE_PLACED = registerPlacedFeature(
                "tin_ore_placed",
                ModConfiguredFeatures.TIN_ORE.getHolder().get(),
                commonOrePlacement(8,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-16),
                                VerticalAnchor.absolute(32))));

        URANIUM_ORE_PLACED = registerPlacedFeature(
                "uranium_ore_placed",
                ModConfiguredFeatures.URANIUM_ORE.getHolder().get(),
                commonOrePlacement(6,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-48),
                                VerticalAnchor.absolute(16))));

        TITANIUM_ORE_PLACED = registerPlacedFeature(
                "titanium_ore_placed",
                ModConfiguredFeatures.TITANIUM_ORE.getHolder().get(),
                rareOrePlacement(4,
                        HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-60),
                                VerticalAnchor.absolute(-28))));

        PLACED_FEATURES.register(bus);
    }

    private static RegistryObject<PlacedFeature> registerPlacedFeature(String registryName, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return PLACED_FEATURES.register(registryName,()-> new PlacedFeature(feature, modifiers));
    }

}
