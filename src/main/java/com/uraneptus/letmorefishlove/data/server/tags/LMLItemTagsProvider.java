package com.uraneptus.letmorefishlove.data.server.tags;

import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import com.uraneptus.letmorefishlove.core.tags.ModItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class LMLItemTagsProvider extends ItemTagsProvider {

    public LMLItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, LetMoreFishLoveMod.MOD_ID, existingFileHelper);
    }

    protected void addTags() {
        tag(ModItemTags.PERCH).add(Items.WHEAT_SEEDS);
        tag(ModItemTags.LIONFISH).add(Items.TROPICAL_FISH);
        tag(ModItemTags.PIKE).add(Items.SALMON);
        tag(ModItemTags.BASS).add(Items.DRIED_KELP);
        tag(ModItemTags.CATFISH).add(Items.DRIED_KELP);
        tag(ModItemTags.LANTERNFISH).add(Items.GLOW_BERRIES);
        tag(ModItemTags.KOI).addOptional(new ResourceLocation(CompatHandler.ENVIRONMENTAL, "cherries"));
    }

    public ResourceLocation rlFromBlock(String modId, Block block) {
        return new ResourceLocation(modId, ForgeRegistries.BLOCKS.getKey(block).getPath());
    }
}
