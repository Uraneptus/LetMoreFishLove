package com.uraneptus.letmorelove.data.server.tags;

import com.uraneptus.letfishlove.core.other.LFLItemTags;
import com.uraneptus.letmorelove.LetMoreLoveMod;
import com.uraneptus.letmorelove.core.tags.ModItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class LMLItemTagsProvider extends ItemTagsProvider {

    public LMLItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, LetMoreLoveMod.MOD_ID, existingFileHelper);
    }

    protected void addTags() {
        tag(ModItemTags.PERCH).add(Items.COAL);
        tag(ModItemTags.LIONFISH).add(Items.DANDELION);
        tag(ModItemTags.PIKE).add(Items.PINK_DYE);
    }
}
