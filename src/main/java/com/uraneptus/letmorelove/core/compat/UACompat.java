package com.uraneptus.letmorelove.core.compat;

import com.teamabnormals.upgrade_aquatic.common.entity.animal.Perch;
import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letmorelove.core.CompatHandler;
import com.uraneptus.letmorelove.core.RegistryHelper;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.function.Supplier;

public class UACompat {

    public static void init() {

    }

    public static UniformInt setUAHatchAmount(EntityType<?> checkedEntity) {
        if (checkedEntity == UAEntityTypes.PERCH.get()) {
            return UniformInt.of(2, 4);
        }
        return UniformInt.of(0, 1);
    }


    public static final RegistryObject<Block> PERCH_ROE_BLOCK = RegistryHelper.createRoeWithItem("perch", UAEntityTypes.PERCH::get);


}
