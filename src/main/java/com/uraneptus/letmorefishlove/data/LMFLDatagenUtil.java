package com.uraneptus.letmorefishlove.data;

import com.uraneptus.letfishlove.data.LFLDatagenUtil;
import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import net.minecraft.resources.ResourceLocation;

public class LMFLDatagenUtil extends LFLDatagenUtil {

    public static ResourceLocation modBlockLocation(String path) {
        return LetMoreFishLoveMod.modPrefix("block/" + path);
    }
}
