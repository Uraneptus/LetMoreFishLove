package com.uraneptus.letmorefishlove.core;

import com.uraneptus.letmorefishlove.core.compat.ENCompat;
import com.uraneptus.letmorefishlove.core.compat.NACompat;
import com.uraneptus.letmorefishlove.core.compat.SMCompat;
import com.uraneptus.letmorefishlove.core.compat.UACompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatHandler {
    public static final String UPGRADE_AUQUATIC = "upgrade_aquatic";
    public static final boolean isUA = isLoaded(UPGRADE_AUQUATIC);
    public static final String NATURALIST = "naturalist";
    public static final boolean isNaturalist = isLoaded(NATURALIST);
    public static final String ENVIRONMENTAL = "environmental";
    public static final boolean isEnvironmental = isLoaded(ENVIRONMENTAL);
    public static final String SULLYS_MOD = "sullysmod";
    public static final boolean isSM = isLoaded(SULLYS_MOD);


    public static boolean isLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    public static void initRegistries() {
        if (isUA) UACompat.init();
        if (isNaturalist) NACompat.init();
        //if (isEnvironmental) ENCompat.init();
        if (isSM) SMCompat.init();
    }

    public static EntityType<?> getEntityType(String modId, String id) {
        return ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(modId, id));
    }
}
