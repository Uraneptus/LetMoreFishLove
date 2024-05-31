package com.uraneptus.letmorefishlove.data.client;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;

import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.uraneptus.letmorefishlove.data.LMLDatagenUtil.*;

public class LMLBlockStateProvider extends BlockStateProvider {

    public LMLBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, LetMoreFishLoveMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        RegistryHelper.BLOCKS.getEntries().forEach(block -> {
            if (block.get() instanceof RoeBlock) {
                roeBlock(block.get());
            }
        });
    }

    private void roeBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            ModelFile modelFile = models().withExistingParent(name(block), vanillaBlockLocation(FROGSPAWN_PARENT))
                    .texture("particle", modBlockLocation(name(block))).texture("texture", modBlockLocation(name(block))).renderType("translucent");
            return ConfiguredModel.builder().modelFile(modelFile).build();
        });
    }


}
