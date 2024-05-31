package com.uraneptus.letmorefishlove.core.compat;

import codyhuh.unusualfishmod.core.registry.UFEntities;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class UFCompat {
    public static void init() {}

    public static final RegistryObject<Block> BLIZZARD_FIN_ROE_BLOCK = RegistryHelper.createRoeWithItem("blizzard_fin", UFEntities.BLIZZARDFIN::get);
}
