package com.uraneptus.letmorefishlove.common;

import com.teamabnormals.environmental.common.entity.animal.koi.Koi;
import com.teamabnormals.environmental.common.entity.animal.koi.KoiBreed;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.Pike;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.PikeType;
import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;

import java.util.function.Supplier;

public class CompatRoeBlock extends RoeBlock {

    public CompatRoeBlock(Supplier<EntityType<?>> fish, Properties properties) {
        super(fish, properties);
    }

    @Override
    protected void handleVariantFish(WaterAnimal waterAnimal, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (CompatHandler.isUA) {
            if (waterAnimal instanceof Pike newPike) {
                if (fromBreeding && this.getParentEntity() instanceof Pike parentFish) {
                    newPike.setPikeType(parentFish.getPikeType());
                } else {
                    newPike.setPikeType(PikeType.getRandom(pRandom, pLevel.getBiome(pPos), false));
                }
            }
        }
        if (CompatHandler.isEnvironmental) {
            if (waterAnimal instanceof Koi koi) {
                if (fromBreeding && this.getParentEntity() instanceof Koi parentFish) {
                    koi.setVariant(parentFish.getVariant());
                } else {
                    koi.setVariant(Util.getRandom(KoiBreed.values(), pRandom).getId());
                }
            }

        }

    }
}
