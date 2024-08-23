package com.uraneptus.letmorefishlove.data.client;

import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class LMFLItemModelProvider extends ItemModelProvider {

    public LMFLItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LetMoreFishLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        RegistryHelper.ITEMS.getEntries().forEach(this::basicItem);
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }
}
