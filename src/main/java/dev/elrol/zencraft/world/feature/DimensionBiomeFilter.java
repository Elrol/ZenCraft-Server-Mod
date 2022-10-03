package dev.elrol.zencraft.world.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class DimensionBiomeFilter extends PlacementFilter {

    private final Predicate<ResourceKey<Level>> levelTest;

    public DimensionBiomeFilter(Predicate<ResourceKey<Level>> levelTest) {
        this.levelTest = levelTest;
    }

    @Override
    protected boolean shouldPlace(PlacementContext context, @NotNull RandomSource rand, @NotNull BlockPos pos) {
        if(levelTest.test(context.getLevel().getLevel().dimension())) {
            PlacedFeature feature = context.topFeature().orElseThrow(()-> new IllegalStateException("Tried to biome check an unregistered feature"));
            Holder<Biome> biome = context.getLevel().getBiome(pos);
            return biome.value().getGenerationSettings().hasFeature(feature);
        } else {
            return false;
        }
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return PlacementModifierType.BIOME_FILTER;
    }

}
