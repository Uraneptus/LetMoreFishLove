package com.uraneptus.letmorefishlove.data.server.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;

public class LMFLLootTableProvider extends LootTableProvider {
    public LMFLLootTableProvider(PackOutput pOutput) {
        super(pOutput, Collections.emptySet(), List.of(
                new SubProviderEntry(LMFLBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }
}
