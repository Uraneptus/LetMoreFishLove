package com.uraneptus.letmorelove.data.server.tags;

import com.uraneptus.letmorelove.LetMoreLoveMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class LMLBlockTagsProvider extends BlockTagsProvider {

    public LMLBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, LetMoreLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        /*
        RoeBlock.getAllBlocks().forEach(block -> tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block));

        tag(LFLBlockTags.COD).add(LMLBlocks.COD_ROE_BLOCK.get());
        tag(LFLBlockTags.SALMON).add(LMLBlocks.SALMON_ROE_BLOCK.get());
        tag(LFLBlockTags.PUFFERFISH).add(LMLBlocks.PUFFERFISH_ROE_BLOCK.get());
        tag(LFLBlockTags.TROPICAL_FISH).add(LMLBlocks.TROPICAL_FISH_ROE_BLOCK.get());

         */

    }
}
