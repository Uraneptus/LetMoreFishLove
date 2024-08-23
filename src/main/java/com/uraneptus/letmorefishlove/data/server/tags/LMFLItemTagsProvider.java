package com.uraneptus.letmorefishlove.data.server.tags;

import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import com.uraneptus.letmorefishlove.core.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LMFLItemTagsProvider extends ItemTagsProvider {

    public LMFLItemTagsProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> pProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, pProvider, blockProvider, LetMoreFishLoveMod.MOD_ID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModItemTags.PERCH).add(Items.WHEAT_SEEDS);
        tag(ModItemTags.LIONFISH).add(Items.TROPICAL_FISH);
        tag(ModItemTags.PIKE).add(Items.SALMON);
        tag(ModItemTags.BASS).add(Items.DRIED_KELP);
        tag(ModItemTags.CATFISH).add(Items.DRIED_KELP);
        tag(ModItemTags.LANTERNFISH).add(Items.GLOW_BERRIES);
        //tag(ModItemTags.KOI).addOptional(new ResourceLocation(CompatHandler.ENVIRONMENTAL, "cherries"));
    }

    public ResourceLocation rlFromBlock(String modId, Block block) {
        return new ResourceLocation(modId, ForgeRegistries.BLOCKS.getKey(block).getPath());
    }
}
