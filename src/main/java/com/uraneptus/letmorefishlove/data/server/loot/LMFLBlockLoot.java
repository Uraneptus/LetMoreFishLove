package com.uraneptus.letmorefishlove.data.server.loot;

import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class LMFLBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    protected LMFLBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegistryHelper.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void generate() {
        RegistryHelper.BLOCKS.getEntries().forEach(block -> dropSelf(block.get()));
    }
}
