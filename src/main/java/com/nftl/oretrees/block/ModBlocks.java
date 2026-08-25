package com.nftl.oretrees.block;

import com.nftl.oretrees.block.ModLeavesBlock;
import com.nftl.oretrees.block.ModLogBlock;
import com.nftl.oretrees.block.ModSaplingBlock;
import com.nftl.oretrees.item.ModItems;
import com.nftl.oretrees.item.ModTreeBlockItem;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks((String)"oretrees");
    public static final DeferredBlock<ModLogBlock> LOG = ModBlocks.registerBlockWithTreeItem("log", () -> new ModLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<ModLeavesBlock> LEAVES = ModBlocks.registerBlockWithTreeItem("leaves", () -> new ModLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<ModSaplingBlock> SAPLING = ModBlocks.registerBlockWithTreeItem("sapling", () -> new ModSaplingBlock(TreeGrower.OAK, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    private static <T extends Block> DeferredBlock<T> registerBlockWithTreeItem(String name, Supplier<T> block) {
        DeferredBlock toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new ModTreeBlockItem((Block)toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem((Block)toReturn.get(), new Item.Properties()));
        return toReturn;
    }
}
