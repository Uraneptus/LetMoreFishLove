package com.uraneptus.letmorelove.common;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public class ModRoeBlock extends RoeBlock {
    private final Supplier<? extends EntityType<?>> entity;

    public ModRoeBlock(Supplier<? extends EntityType<?>> fish, Properties properties) {
        super(fish.get(), properties);
        entity = fish;
    }
}
