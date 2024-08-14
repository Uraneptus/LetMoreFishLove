package com.uraneptus.letmorefishlove.core.tags;

import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> PERCH = create(CompatHandler.UPGRADE_AUQUATIC, "perch");
    public static final TagKey<Item> LIONFISH = create(CompatHandler.UPGRADE_AUQUATIC, "lionfish");
    public static final TagKey<Item> PIKE = create(CompatHandler.UPGRADE_AUQUATIC, "pike");
    public static final TagKey<Item> BASS = create(CompatHandler.NATURALIST, "bass");
    public static final TagKey<Item> CATFISH = create(CompatHandler.NATURALIST, "catfish");
    public static final TagKey<Item> KOI = create(CompatHandler.ENVIRONMENTAL, "koi");

    public static TagKey<Item> create(String modId, String fishName) {
        return TagKey.create(Registry.ITEM_REGISTRY, LetFishLoveMod.modPrefix("fish_food/" + modId + "/" + fishName));
    }
}
