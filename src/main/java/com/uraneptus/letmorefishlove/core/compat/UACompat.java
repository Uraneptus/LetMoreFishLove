package com.uraneptus.letmorefishlove.core.compat;

import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class UACompat {

    public static void init() {}

    public static final RegistryObject<Block> PERCH_ROE_BLOCK = RegistryHelper.createRoeWithItem("perch", UAEntityTypes.PERCH::get);
    public static final RegistryObject<Block> LIONFISH_ROE_BLOCK = RegistryHelper.createRoeWithItem("lionfish", UAEntityTypes.LIONFISH::get);
    public static final RegistryObject<Block> PIKE_ROE_BLOCK = RegistryHelper.createCompatRoeWithItem("pike", UAEntityTypes.PIKE::get);


}
