package com.uraneptus.letmorefishlove;

import com.mojang.logging.LogUtils;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import com.uraneptus.letmorefishlove.data.client.LMFLBlockStateProvider;
import com.uraneptus.letmorefishlove.data.client.LMFLItemModelProvider;
import com.uraneptus.letmorefishlove.data.client.LMFLLangProvider;
import com.uraneptus.letmorefishlove.data.server.loot.LMFLLootTableProvider;
import com.uraneptus.letmorefishlove.data.server.tags.LMFLBlockTagsProvider;
import com.uraneptus.letmorefishlove.data.server.tags.LMFLEntityTagsProvider;
import com.uraneptus.letmorefishlove.data.server.tags.LMFLItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod(LetMoreFishLoveMod.MOD_ID)
@Mod.EventBusSubscriber(modid = LetMoreFishLoveMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LetMoreFishLoveMod {
    public static final String MOD_ID = "letmorefishlove";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(LetMoreFishLoveMod.MOD_ID, path);
    }

    public LetMoreFishLoveMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::gatherData);

        RegistryHelper.BLOCKS.register(bus);
        RegistryHelper.ITEMS.register(bus);
        CompatHandler.initRegistries();

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new LMFLBlockStateProvider(output, fileHelper));
        generator.addProvider(includeClient, new LMFLItemModelProvider(output, fileHelper));
        generator.addProvider(includeClient, new LMFLLangProvider(output));

        LMFLBlockTagsProvider blockTagsProvider = new LMFLBlockTagsProvider(output, lookupProvider, fileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new LMFLItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new LMFLEntityTagsProvider(output, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new LMFLLootTableProvider(output));
    }

}
