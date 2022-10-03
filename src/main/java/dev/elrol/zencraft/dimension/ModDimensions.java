package dev.elrol.zencraft.dimension;

import dev.elrol.zencraft.ZenCraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {

    // Levels
    public static final ResourceKey<Level> RESOURCE_LEVEL = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            new ResourceLocation(ZenCraft.MODID, "resource"));

    public static final ResourceKey<Level> OVERWORLD_LEVEL = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            new ResourceLocation(ZenCraft.MODID, "overworld"));

    public static final ResourceKey<Level> CREATIVE_LEVEL = ResourceKey.create(
            Registry.DIMENSION_REGISTRY,
            new ResourceLocation(ZenCraft.MODID, "creative"));

    // Dimension Types
    private static final ResourceKey<DimensionType> RESOURCE_TYPE = ResourceKey.create(
            Registry.DIMENSION_TYPE_REGISTRY,
            RESOURCE_LEVEL.location());

    private static final ResourceKey<DimensionType> OVERWORLD_TYPE = ResourceKey.create(
            Registry.DIMENSION_TYPE_REGISTRY,
            OVERWORLD_LEVEL.location());

    private static final ResourceKey<DimensionType> CREATIVE_TYPE = ResourceKey.create(
            Registry.DIMENSION_TYPE_REGISTRY,
            CREATIVE_LEVEL.location());

    public static void register() {
        System.out.println("Registering ZenCraft Dimensions:");
        System.out.println("Resource:" + RESOURCE_LEVEL.location());
        System.out.println("Overworld:" + OVERWORLD_LEVEL.location());
        System.out.println("Creative:" + CREATIVE_LEVEL.location());
    }
}
