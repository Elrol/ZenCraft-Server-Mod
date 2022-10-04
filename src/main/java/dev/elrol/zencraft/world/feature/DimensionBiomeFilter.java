package dev.elrol.zencraft.world.feature;

import dev.elrol.zencraft.ZenCraft;
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
        ZenCraft.LOGGER.info("DBF: Created DimensionBiomeFilter");
    }

    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        if (this.levelTest.test(context.getLevel().getLevel().dimension())) {
            PlacedFeature placedfeature = context.topFeature().orElseThrow(() -> new IllegalStateException("Tried to biome check an unregistered feature"));
            Holder<Biome> biome = context.getLevel().getBiome(pos);
            boolean flag = biome.value().getGenerationSettings().hasFeature(placedfeature);
            ZenCraft.LOGGER.info("DBF: Should Place: " + flag);
            return flag;
        } else {
            ZenCraft.LOGGER.info("DBF: Shouldn't Be Placed");
            return false;
        }
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return PlacementModifierType.BIOME_FILTER;
    }
}
