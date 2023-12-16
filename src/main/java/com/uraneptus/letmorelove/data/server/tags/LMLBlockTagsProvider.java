package com.uraneptus.letmorelove.data.server.tags;

import com.uraneptus.letmorelove.LetMoreLoveMod;
import com.uraneptus.letmorelove.core.CompatHandler;
import com.uraneptus.letmorelove.core.RegistryHelper;
import com.uraneptus.letmorelove.core.compat.UACompat;
import com.uraneptus.letmorelove.core.tags.ModBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class LMLBlockTagsProvider extends BlockTagsProvider {

    public LMLBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, LetMoreLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        RegistryHelper.BLOCKS.getEntries().forEach(block -> tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block.get()));

        tag(ModBlockTags.PERCH).addOptional(rlFromBlock(CompatHandler.UPGRADE_AUQUATIC, UACompat.PERCH_ROE_BLOCK.get()));
        tag(ModBlockTags.LIONFISH).addOptional(rlFromBlock(CompatHandler.UPGRADE_AUQUATIC, UACompat.LIONFISH_ROE_BLOCK.get()));
        tag(ModBlockTags.PIKE).addOptional(rlFromBlock(CompatHandler.UPGRADE_AUQUATIC, UACompat.PIKE_ROE_BLOCK.get()));
    }

    public ResourceLocation rlFromBlock(String modId, Block block) {
        return new ResourceLocation(modId, ForgeRegistries.BLOCKS.getKey(block).getPath());
    }
}
