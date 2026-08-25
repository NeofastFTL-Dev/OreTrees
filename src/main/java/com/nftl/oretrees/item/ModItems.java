package com.nftl.oretrees.item;

import com.nftl.oretrees.item.ModTreeItem;
import com.nftl.oretrees.util.TreeType;
import java.util.EnumMap;
import java.util.Map;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems((String)"oretrees");
    public static final Map<TreeType, DeferredItem<ModTreeItem>> RESINS = new EnumMap<TreeType, DeferredItem<ModTreeItem>>(TreeType.class);
    public static final Map<TreeType, DeferredItem<ModTreeItem>> ACORNS = new EnumMap<TreeType, DeferredItem<ModTreeItem>>(TreeType.class);
    public static final Map<TreeType, DeferredItem<ModTreeItem>> AMBERS = new EnumMap<TreeType, DeferredItem<ModTreeItem>>(TreeType.class);

    static {
        for (TreeType type : TreeType.values()) {
            String name = type.getSerializedName();
            RESINS.put(type, (DeferredItem<ModTreeItem>)ITEMS.register(name + "_resin", () -> new ModTreeItem(type, new Item.Properties())));
            ACORNS.put(type, (DeferredItem<ModTreeItem>)ITEMS.register(name + "_acorn", () -> new ModTreeItem(type, new Item.Properties())));
            AMBERS.put(type, (DeferredItem<ModTreeItem>)ITEMS.register(name + "_amber", () -> new ModTreeItem(type, new Item.Properties())));
        }
    }
}
