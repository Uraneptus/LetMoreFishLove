package com.uraneptus.letmorefishlove.core;

import com.uraneptus.letmorefishlove.core.compat.NACompat;
import com.uraneptus.letmorefishlove.core.compat.UACompat;
import com.uraneptus.letmorefishlove.core.compat.UFCompat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatHandler {
    public static final String UPGRADE_AUQUATIC = "upgrade_aquatic";
    public static final String UNUSUAL_FISH = "unusualfishmod";
    public static final String NATURALIST = "naturalist";

    public static boolean isLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    public static void initRegistries() {
        if (isLoaded(UPGRADE_AUQUATIC)) UACompat.init();
        if (isLoaded(UNUSUAL_FISH)) UFCompat.init();
        if (isLoaded(NATURALIST)) NACompat.init();
    }

    public static EntityType<?> getEntityType(String modId, String id) {
        return ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(modId, id));
    }
}
