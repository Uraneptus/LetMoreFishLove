package com.uraneptus.letmorefishlove.data.client;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;

import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.uraneptus.letmorefishlove.data.LMFLDatagenUtil.*;

public class LMFLBlockStateProvider extends BlockStateProvider {

    public LMFLBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LetMoreFishLoveMod.MOD_ID, exFileHelper);
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
