package com.uraneptus.letmorelove.data.client;

import com.uraneptus.letmorelove.LetMoreLoveMod;
import com.uraneptus.letmorelove.core.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class LMLItemModelProvider extends ItemModelProvider {

    public LMLItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LetMoreLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        RegistryHelper.ITEMS.getEntries().forEach(this::basicItem);
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }
}
