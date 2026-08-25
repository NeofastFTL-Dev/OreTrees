package com.nftl.oretrees.registration;

import com.nftl.oretrees.util.TreeType;
import java.util.function.UnaryOperator;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create((ResourceKey)Registries.DATA_COMPONENT_TYPE, (String)"oretrees");
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TreeType>> TREE_TYPE = ModDataComponents.register("tree_type", builder -> builder.persistent(TreeType.CODEC).networkSynchronized(TreeType.STREAM_CODEC));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return DATA_COMPONENTS.register(name, () -> ((DataComponentType.Builder)builder.apply(DataComponentType.builder())).build());
    }
}
