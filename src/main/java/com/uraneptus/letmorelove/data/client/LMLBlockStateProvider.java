package com.uraneptus.letmorelove.data.client;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letmorelove.LetMoreLoveMod;

import com.uraneptus.letmorelove.core.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.uraneptus.letmorelove.data.LMLDatagenUtil.*;

public class LMLBlockStateProvider extends BlockStateProvider {

    public LMLBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, LetMoreLoveMod.MOD_ID, exFileHelper);
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
