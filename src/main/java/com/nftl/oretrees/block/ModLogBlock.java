package com.nftl.oretrees.block;

import com.nftl.oretrees.registration.ModDataComponents;
import com.nftl.oretrees.util.ModBlockStateProperties;
import com.nftl.oretrees.util.TreeType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;

public class ModLogBlock
extends RotatedPillarBlock {
    public ModLogBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(ModBlockStateProperties.TREE_TYPE, (Comparable)((Object)TreeType.DIRT)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{ModBlockStateProperties.TREE_TYPE});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        TreeType type;
        BlockState state = super.getStateForPlacement(context);
        if (state != null && (type = (TreeType)((Object)context.getItemInHand().get((DataComponentType)ModDataComponents.TREE_TYPE.get()))) != null) {
            return (BlockState)state.setValue(ModBlockStateProperties.TREE_TYPE, (Comparable)((Object)type));
        }
        return state;
    }

    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        ItemStack stack = super.getCloneItemStack(level, pos, state);
        stack.set((DataComponentType)ModDataComponents.TREE_TYPE.get(), (Object)((TreeType)((Object)state.getValue(ModBlockStateProperties.TREE_TYPE))));
        return stack;
    }
}
