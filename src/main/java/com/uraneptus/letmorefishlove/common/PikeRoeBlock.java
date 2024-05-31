package com.uraneptus.letmorefishlove.common;

import com.teamabnormals.upgrade_aquatic.common.entity.animal.Pike;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.PikeType;
import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;

import java.util.function.Supplier;

public class PikeRoeBlock extends RoeBlock {

    public PikeRoeBlock(Supplier<EntityType<?>> fish, Properties properties) {
        super(fish, properties);
    }

    @Override
    protected void handleVariantFish(WaterAnimal waterAnimal, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (waterAnimal instanceof Pike newPike) {
            if (fromBreeding && this.getParentEntity() instanceof Pike parentFish) {
                newPike.setPikeType(parentFish.getPikeType());
            } else {
                newPike.setPikeType(PikeType.getRandom(pRandom, pLevel.getBiome(pPos), false));
            }
        }
    }
}
