package com.uraneptus.letmorelove.common;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letmorelove.core.CompatHandler;
import com.uraneptus.letmorelove.core.compat.UACompat;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModRoeBlock extends RoeBlock {
    public ModRoeBlock(Supplier<EntityType<?>> fish, Properties properties) {
        super(fish, properties);
    }

    @Override
    protected UniformInt calculateHatchAmount(ServerLevel pLevel) {
        if (CompatHandler.isLoaded(CompatHandler.UPGRADE_AUQUATIC)) {
            return UACompat.setUAHatchAmount(this.createEntity(pLevel).getType());
        }
        return super.calculateHatchAmount(pLevel);
    }
}
