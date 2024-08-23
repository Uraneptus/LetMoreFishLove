package com.uraneptus.letmorefishlove.core;

import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letfishlove.core.registry.LFLBlocks;
import com.uraneptus.letfishlove.core.registry.LFLItems;
import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = LetMoreFishLoveMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LMFLClientEvents {

    @SubscribeEvent
    public static void buildTabContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> tabKey = event.getTabKey();
        if (!ModList.get().isLoaded("letfishlove")) return;
        for (Block block : RegistryHelper.BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
            if (tabKey == CreativeModeTabs.NATURAL_BLOCKS) {
                event.getEntries().putAfter(LFLItems.COD_ROE.get().getDefaultInstance(), block.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }

    }

}
