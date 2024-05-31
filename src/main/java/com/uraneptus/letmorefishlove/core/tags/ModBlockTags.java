package com.uraneptus.letmorefishlove.core.tags;

import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> PERCH = create(CompatHandler.UPGRADE_AUQUATIC, "perch");
    public static final TagKey<Block> LIONFISH = create(CompatHandler.UPGRADE_AUQUATIC, "lionfish");
    public static final TagKey<Block> PIKE = create(CompatHandler.UPGRADE_AUQUATIC, "pike");
    public static final TagKey<Block> BASS = create(CompatHandler.NATURALIST, "bass");
    public static final TagKey<Block> CATFISH = create(CompatHandler.NATURALIST, "catfish");
    public static final TagKey<Block> BLIZZARD_FIN = create(CompatHandler.UNUSUAL_FISH, "blizzard_fin");

    public static TagKey<Block> create(String modId, String fishName) {
        return TagKey.create(Registry.BLOCK_REGISTRY, LetFishLoveMod.modPrefix("fish_roe/" + modId + "/" + fishName));
    }
}
