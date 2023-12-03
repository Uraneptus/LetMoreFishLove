package com.uraneptus.letmorelove.core;

import com.uraneptus.letmorelove.core.compat.UACompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatHandler {
    public static final String UPGRADE_AUQUATIC = "upgrade_aquatic";

    private static boolean isLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    public static void initRegistries() {
        if (isLoaded(UPGRADE_AUQUATIC)) UACompat.init();
    }

    public static EntityType<?> getEntityType(String modId, String id) {
        return ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(modId, id));
    }
}
