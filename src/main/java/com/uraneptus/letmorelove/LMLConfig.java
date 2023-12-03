package com.uraneptus.letmorelove;

import net.minecraftforge.common.ForgeConfigSpec;

public class LMLConfig {
    public static final ForgeConfigSpec COMMON;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON = COMMON_BUILDER.build();
    }
}
