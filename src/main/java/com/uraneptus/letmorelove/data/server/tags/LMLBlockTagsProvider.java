package com.uraneptus.letmorelove.data.server.tags;

import com.uraneptus.letmorelove.LetMoreLoveMod;
import com.uraneptus.letmorelove.core.RegistryHelper;
import com.uraneptus.letmorelove.core.compat.UACompat;
import com.uraneptus.letmorelove.core.tags.ModBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class LMLBlockTagsProvider extends BlockTagsProvider {

    public LMLBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, LetMoreLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        RegistryHelper.BLOCKS.getEntries().forEach(block -> tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block.get()));

        tag(ModBlockTags.PERCH).add(UACompat.PERCH_ROE_BLOCK.get());


        /*
        RoeBlock.getAllBlocks().forEach(block -> tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block));

        tag(LFLBlockTags.COD).add(LMLBlocks.COD_ROE_BLOCK.get());
        tag(LFLBlockTags.SALMON).add(LMLBlocks.SALMON_ROE_BLOCK.get());
        tag(LFLBlockTags.PUFFERFISH).add(LMLBlocks.PUFFERFISH_ROE_BLOCK.get());
        tag(LFLBlockTags.TROPICAL_FISH).add(LMLBlocks.TROPICAL_FISH_ROE_BLOCK.get());

         */

    }
}
