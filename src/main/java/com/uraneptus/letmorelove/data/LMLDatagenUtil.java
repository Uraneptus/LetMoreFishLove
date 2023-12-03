package com.uraneptus.letmorelove.data;

import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letfishlove.data.LFLDatagenUtil;
import com.uraneptus.letmorelove.LetMoreLoveMod;
import net.minecraft.resources.ResourceLocation;

public class LMLDatagenUtil extends LFLDatagenUtil {

    public static ResourceLocation modBlockLocation(String path) {
        return LetMoreLoveMod.modPrefix("block/" + path);
    }
}
