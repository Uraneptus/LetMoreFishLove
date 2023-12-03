package com.uraneptus.letmorelove.core.compat;

import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letmorelove.core.CompatHandler;
import com.uraneptus.letmorelove.core.RegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.html.parser.Entity;

public class UACompat {


    public static void init() {

    }

    public static RegistryObject<Block> PERCH_ROE_BLOCK = RegistryHelper.createRoeWithItem("perch", UAEntityTypes.PERCH);


}
