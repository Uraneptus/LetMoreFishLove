package com.uraneptus.letmorelove.common;

import com.uraneptus.letfishlove.common.items.RoeItem;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModRoeItem extends RoeItem {
    public ModRoeItem(Supplier<? extends Block> pBlock) {
        super(pBlock.get());
    }
}
