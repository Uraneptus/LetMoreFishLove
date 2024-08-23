package com.uraneptus.letmorefishlove.data.client;

import com.google.common.collect.Lists;
import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class LMFLLangProvider extends LanguageProvider {
    public LMFLLangProvider(PackOutput output) {
        super(output, LetMoreFishLoveMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        RegistryHelper.ITEMS.getEntries().forEach(this::forItem);
    }

    public void forItem(Supplier<? extends Item> item) {
        addItem(item, createTranslation(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.get())).getPath()));
    }

    public static String createTranslation(String path) {
        var translation = "";
        List<String> translationParts = Lists.newArrayList();
        var splitList = path.split("_");
        for (String split : splitList) {
            var capitalized = firstToUpperCase(split);
            translationParts.add(capitalized);
        }
        translation = String.join(" ", translationParts);
        return translation;
    }

    public static String firstToUpperCase(String string) {
        var firstLetter = string.charAt(0);
        return string.replaceFirst(String.valueOf(firstLetter), String.valueOf(firstLetter).toUpperCase());
    }
}
