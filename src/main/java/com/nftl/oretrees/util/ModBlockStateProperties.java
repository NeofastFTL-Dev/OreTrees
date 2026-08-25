package com.nftl.oretrees.util;

import com.nftl.oretrees.util.TreeType;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ModBlockStateProperties {
    public static final EnumProperty<TreeType> TREE_TYPE = EnumProperty.create((String)"tree_type", TreeType.class);
}
