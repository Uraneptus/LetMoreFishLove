package com.uraneptus.letmorelove.core.tags;

import com.uraneptus.letfishlove.LetFishLoveMod;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> PERCH = TagKey.create(Registry.ITEM_REGISTRY, LetFishLoveMod.modPrefix("fish_food/perch"));
    public static final TagKey<Item> LIONFISH = TagKey.create(Registry.ITEM_REGISTRY, LetFishLoveMod.modPrefix("fish_food/lionfish"));
    public static final TagKey<Item> PIKE = TagKey.create(Registry.ITEM_REGISTRY, LetFishLoveMod.modPrefix("fish_food/pike"));

}
