package com.uraneptus.letmorefishlove.core.compat;

import com.starfish_studios.naturalist.registry.NaturalistEntityTypes;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class NACompat {
    public static void init(){}

    public static final RegistryObject<Block> BASS_ROE_BLOCK = RegistryHelper.createRoeWithItem("bass", NaturalistEntityTypes.BASS::get);
    public static final RegistryObject<Block> CATFISH_ROE_BLOCK = RegistryHelper.createRoeWithItem("catfish", NaturalistEntityTypes.CATFISH::get);

}
