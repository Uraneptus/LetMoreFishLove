package com.uraneptus.letmorefishlove.core.compat;

import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import com.uraneptus.sullysmod.core.registry.SMEntityTypes;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class SMCompat {
    public static void init() {}

    public static final RegistryObject<Block> LANTERNFISH_ROE_BLOCK = RegistryHelper.createRoeWithItem("lanternfish", SMEntityTypes.LANTERNFISH::get);

}
