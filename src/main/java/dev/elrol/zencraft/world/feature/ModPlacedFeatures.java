package dev.elrol.zencraft.world.feature;

import dev.elrol.zencraft.ZenCraft;
import dev.elrol.zencraft.dimension.ModDimensions;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {


    private static final DimensionBiomeFilter resourceFilter = new DimensionBiomeFilter(id -> id.equals(ModDimensions.RESOURCE_LEVEL));

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ZenCraft.MODID);

    public static final RegistryObject<PlacedFeature> TIN_ORE_PLACED = PLACED_FEATURES.register("tin_ore_placed",
            ()-> new PlacedFeature(
                    ModConfiguredFeatures.TIN_ORE.getHolder().get(),
                    commonOrePlacement(8,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.absolute(-16),
                                    VerticalAnchor.absolute(32)))));

    public static final RegistryObject<PlacedFeature> URANIUM_ORE_PLACED = PLACED_FEATURES.register("uranium_ore_placed",
            ()-> new PlacedFeature(
                    ModConfiguredFeatures.URANIUM_ORE.getHolder().get(),
                    commonOrePlacement(6,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.absolute(-48),
                                    VerticalAnchor.absolute(16)))));

    public static final RegistryObject<PlacedFeature> TITANIUM_ORE_PLACED = PLACED_FEATURES.register("titanium_ore_placed",
            ()-> new PlacedFeature(
                    ModConfiguredFeatures.TITANIUM_ORE.getHolder().get(),
                    rareOrePlacement(4,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.absolute(-60),
                                    VerticalAnchor.absolute(-28)))));


    private static List<PlacementModifier> orePlacement(PlacementModifier mod, PlacementModifier modifier) {
        return List.of(mod, InSquarePlacement.spread(), modifier, resourceFilter);
    }

    private static List<PlacementModifier> commonOrePlacement(int veins, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(veins), modifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int amount, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(amount),modifier);
    }

    public static void register(IEventBus bus) {
        PLACED_FEATURES.register(bus);
    }

}
