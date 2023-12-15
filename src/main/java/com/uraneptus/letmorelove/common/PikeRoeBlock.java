package com.uraneptus.letmorelove.common;

import com.teamabnormals.upgrade_aquatic.common.entity.animal.Pike;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.PikeType;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.WaterAnimal;

import java.util.function.Supplier;

public class PikeRoeBlock extends ModRoeBlock {

    public PikeRoeBlock(Supplier<EntityType<?>> fish, Properties properties) {
        super(fish, properties);
    }

    @Override
    protected void spawnFish(ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = pRandom.nextInt(calculateHatchAmount(pLevel).getMinValue(), calculateHatchAmount(pLevel).getMaxValue());

        for(int j = 1; j <= i; ++j) {
            if (createEntity(pLevel) instanceof WaterAnimal waterAnimal) {
                double d0 = (double)pPos.getX() + this.getRandomPositionOffset(pRandom);
                double d1 = (double)pPos.getZ() + this.getRandomPositionOffset(pRandom);
                int k = pRandom.nextInt(1, 361);
                waterAnimal.moveTo(d0, (double)pPos.getY() - 0.5D, d1, (float)k, 0.0F);
                waterAnimal.setPersistenceRequired();
                if (waterAnimal instanceof Pike newPike) {
                    if (fromBreeding && this.getParentEntity() instanceof Pike parentFish) {
                        newPike.setPikeType(parentFish.getPikeType());
                    } else {
                        newPike.setPikeType(PikeType.getRandom(pRandom, pLevel.getBiome(pPos), false));
                    }
                }
                pLevel.addFreshEntity(waterAnimal);
            }
        }
    }
}
