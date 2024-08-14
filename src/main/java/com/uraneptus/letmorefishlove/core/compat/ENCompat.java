package com.uraneptus.letmorefishlove.core.compat;

import com.teamabnormals.environmental.core.registry.EnvironmentalEntityTypes;
import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ENCompat {
    public static void init() {}

    public static final RegistryObject<Block> KOI_ROE_BLOCK = RegistryHelper.createCompatRoeWithItem("koi", EnvironmentalEntityTypes.KOI::get);

}
