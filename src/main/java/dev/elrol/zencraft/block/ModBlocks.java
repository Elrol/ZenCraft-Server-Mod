package dev.elrol.zencraft.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;

public class ModBlocks {

    public static final BlockState TIN_ORE = Blocks.STONE_SLAB.defaultBlockState()
            .setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)
            .setValue(BlockStateProperties.WATERLOGGED, true);

    public static final BlockState DEEPSLATE_TIN_ORE = Blocks.DEEPSLATE_BRICK_SLAB.defaultBlockState()
            .setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)
            .setValue(BlockStateProperties.WATERLOGGED, true);

    public static final BlockState URANIUM_ORE = Blocks.COBBLESTONE_SLAB.defaultBlockState()
            .setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)
            .setValue(BlockStateProperties.WATERLOGGED, true);

    public static final BlockState DEEPSLATE_URANIUM_ORE = Blocks.COBBLED_DEEPSLATE_SLAB.defaultBlockState()
            .setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)
            .setValue(BlockStateProperties.WATERLOGGED, true);

    public static final BlockState DEEPSLATE_TITANIUM_ORE = Blocks.POLISHED_DEEPSLATE_SLAB.defaultBlockState()
            .setValue(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)
            .setValue(BlockStateProperties.WATERLOGGED, true);
}
