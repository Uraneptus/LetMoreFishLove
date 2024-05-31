package com.uraneptus.letmorefishlove.core;

import com.uraneptus.letfishlove.common.blocks.RoeBlock;
import com.uraneptus.letfishlove.common.items.RoeItem;
import com.uraneptus.letfishlove.core.other.LFLProperties;
import com.uraneptus.letmorefishlove.LetMoreFishLoveMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = LetMoreFishLoveMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHelper {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LetMoreFishLoveMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LetMoreFishLoveMod.MOD_ID);

    public static RegistryObject<Block> createRoeWithItem(String fishName, Supplier<EntityType<?>> entityType) {
        RegistryObject<Block> block = BLOCKS.register(fishName + "_roe_block", () -> new RoeBlock(entityType, LFLProperties.roeBlockProperties()));
        ITEMS.register(fishName + "_roe", () -> new RoeItem(block));

        return block;
    }

    public static RegistryObject<Block> createCustomRoeWithItem(String fishName, Supplier<Block> roeBlock) {
        RegistryObject<Block> block = BLOCKS.register(fishName + "_roe_block", roeBlock);
        ITEMS.register(fishName + "_roe", () -> new RoeItem(block));

        return block;
    }
}
