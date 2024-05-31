package com.uraneptus.letmorefishlove;

import com.mojang.logging.LogUtils;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import com.uraneptus.letmorefishlove.core.RegistryHelper;
import com.uraneptus.letmorefishlove.data.client.LMLBlockStateProvider;
import com.uraneptus.letmorefishlove.data.client.LMLItemModelProvider;
import com.uraneptus.letmorefishlove.data.client.LMLLangProvider;
import com.uraneptus.letmorefishlove.data.server.LMLLootTableProvider;
import com.uraneptus.letmorefishlove.data.server.tags.LMLBlockTagsProvider;
import com.uraneptus.letmorefishlove.data.server.tags.LMLEntityTagsProvider;
import com.uraneptus.letmorefishlove.data.server.tags.LMLItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

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

        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LMLConfig.COMMON);

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
        ExistingFileHelper fileHelper = event.getExistingFileHelper();


        generator.addProvider(includeClient, new LMLBlockStateProvider(generator, fileHelper));
        generator.addProvider(includeClient, new LMLItemModelProvider(generator, fileHelper));
        generator.addProvider(includeClient, new LMLLangProvider(generator));

        LMLBlockTagsProvider blockTagsProvider = new LMLBlockTagsProvider(generator, fileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new LMLItemTagsProvider(generator, blockTagsProvider, fileHelper));
        generator.addProvider(includeServer, new LMLEntityTagsProvider(generator, fileHelper));
        generator.addProvider(includeServer, new LMLLootTableProvider(generator));
    }

}
