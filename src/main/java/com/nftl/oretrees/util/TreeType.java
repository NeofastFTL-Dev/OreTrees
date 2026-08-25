package com.nftl.oretrees.util;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;

public enum TreeType implements StringRepresentable
{
    DIRT("dirt", -8825539),
    PETRIFIED("petrified", -8355712),
    SAND("sand", -1910115),
    GRAVEL("gravel", -7632761),
    CLAY("clay", -6182991),
    COAL("coal", -13684945),
    IRON("iron", -2576493),
    GOLD("gold", -201141),
    REDSTONE("redstone", -65536),
    LAPIS("lapis", -15711065),
    DIAMOND("diamond", -13374570),
    EMERALD("emerald", -15213214),
    QUARTZ("quartz", -1712427),
    COPPER("copper", -1606570),
    TIN("tin", -1710619),
    ALUMINUM("aluminum", -2697514),
    LEAD("lead", -10655360),
    SILVER("silver", -3021592),
    NICKEL("nickel", -2039600),
    PLATINUM("platinum", -6691073),
    URANIUM("uranium", -12336384),
    OSMIUM("osmium", -13221556),
    ZINC("zinc", -9470864);

    public static final Codec<TreeType> CODEC;
    public static final StreamCodec<ByteBuf, TreeType> STREAM_CODEC;
    private final String name;
    private final int color;

    private TreeType(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public String getSerializedName() {
        return this.name;
    }

    static {
        CODEC = StringRepresentable.fromEnum(TreeType::values);
        STREAM_CODEC = ByteBufCodecs.VAR_INT.map(id -> TreeType.values()[id], Enum::ordinal);
    }
}
