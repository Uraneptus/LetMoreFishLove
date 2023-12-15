package com.uraneptus.letmorelove.core.compat;

import com.teamabnormals.upgrade_aquatic.common.entity.animal.Perch;
import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letfishlove.core.other.LFLProperties;
import com.uraneptus.letmorelove.common.ModRoeBlock;
import com.uraneptus.letmorelove.common.PikeRoeBlock;
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
        if (checkedEntity == UAEntityTypes.LIONFISH.get()) {
            return UniformInt.of(1, 2);
        }
        if (checkedEntity == UAEntityTypes.PIKE.get()) {
            return UniformInt.of(2, 4);
        }
        return UniformInt.of(0, 1);
    }


    public static final RegistryObject<Block> PERCH_ROE_BLOCK = RegistryHelper.createRoeWithItem("perch", UAEntityTypes.PERCH::get);
    public static final RegistryObject<Block> LIONFISH_ROE_BLOCK = RegistryHelper.createRoeWithItem("lionfish", UAEntityTypes.LIONFISH::get);
    public static final RegistryObject<Block> PIKE_ROE_BLOCK = RegistryHelper.createCustomRoeWithItem("pike", UAEntityTypes.PIKE::get, () -> new PikeRoeBlock(UAEntityTypes.PIKE::get, LFLProperties.roeBlockProperties()));


}
