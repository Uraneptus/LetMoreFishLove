package com.uraneptus.letmorelove.core;

import com.uraneptus.letfishlove.common.items.RoeItem;
import com.uraneptus.letfishlove.core.other.LFLProperties;
import com.uraneptus.letmorelove.LetMoreLoveMod;
import com.uraneptus.letmorelove.common.ModRoeBlock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = LetMoreLoveMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHelper {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LetMoreLoveMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LetMoreLoveMod.MOD_ID);

    public static RegistryObject<Block> createRoeWithItem(String fishName, Supplier<EntityType<?>> entityType) {
        RegistryObject<Block> block = BLOCKS.register(fishName + "_roe_block", () -> new ModRoeBlock(entityType, LFLProperties.roeBlockProperties()));
        ITEMS.register(fishName + "_roe", () -> new RoeItem(block));

        return block;
    }

    public static RegistryObject<Block> createCustomRoeWithItem(EntityType<?> entityType, Supplier<Block> roeBlock) {
        String name = ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath();
        RegistryObject<Block> block = BLOCKS.register(name + "_roe_block", roeBlock);
        ITEMS.register(name + "_roe", () -> new RoeItem(block));

        return block;
    }
}
