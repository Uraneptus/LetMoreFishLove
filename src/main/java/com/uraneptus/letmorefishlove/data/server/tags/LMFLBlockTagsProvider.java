package com.uraneptus.letmorefishlove.data.server.tags;

import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import com.uraneptus.letmorefishlove.core.compat.ENCompat;
import com.uraneptus.letmorefishlove.core.compat.NACompat;
import com.uraneptus.letmorefishlove.core.compat.SMCompat;
import com.uraneptus.letmorefishlove.core.compat.UACompat;
import com.uraneptus.letmorefishlove.core.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LMFLBlockTagsProvider extends BlockTagsProvider {

    public LMFLBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LetMoreFishLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider pProvider) {
        RegistryHelper.BLOCKS.getEntries().forEach(block -> tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block.get()));

        tag(ModBlockTags.PERCH).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, UACompat.PERCH_ROE_BLOCK.get()));
        tag(ModBlockTags.LIONFISH).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, UACompat.LIONFISH_ROE_BLOCK.get()));
        tag(ModBlockTags.PIKE).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, UACompat.PIKE_ROE_BLOCK.get()));
        tag(ModBlockTags.BASS).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, NACompat.BASS_ROE_BLOCK.get()));
        tag(ModBlockTags.CATFISH).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, NACompat.CATFISH_ROE_BLOCK.get()));
        //tag(ModBlockTags.KOI).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, ENCompat.KOI_ROE_BLOCK.get()));
        tag(ModBlockTags.LANTERNFISH).addOptional(rlFromBlock(LetMoreFishLoveMod.MOD_ID, SMCompat.LANTERNFISH_ROE_BLOCK.get()));
    }

    public ResourceLocation rlFromBlock(String modId, Block block) {
        return new ResourceLocation(modId, ForgeRegistries.BLOCKS.getKey(block).getPath());
    }
}
