package com.uraneptus.letmorefishlove.data.server.tags;

import com.starfish_studios.naturalist.core.registry.NaturalistEntityTypes;
import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letfishlove.core.other.LFLEntityTags;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import com.uraneptus.sullysmod.core.registry.SMEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

public class LMFLEntityTagsProvider extends EntityTypeTagsProvider {

    public LMFLEntityTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> pProvider, ExistingFileHelper fileHelper) {
        super(packOutput, pProvider, LetFishLoveMod.MOD_ID, fileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider pProvider) {
        tag(LFLEntityTags.BREEDABLE_FISH)
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.PERCH.get()))
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.PIKE.get()))
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.LIONFISH.get()))
                .addOptional(rlFromEntity(CompatHandler.NATURALIST, NaturalistEntityTypes.BASS.get()))
                .addOptional(rlFromEntity(CompatHandler.NATURALIST, NaturalistEntityTypes.CATFISH.get()))
                //.addOptional(rlFromEntity(CompatHandler.ENVIRONMENTAL, EnvironmentalEntityTypes.KOI.get()))
                .addOptional(rlFromEntity(CompatHandler.SULLYS_MOD, SMEntityTypes.LANTERNFISH.get()));
    }

    public ResourceLocation rlFromEntity(String modId, EntityType<?> entityType) {
        return new ResourceLocation(modId, ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath());
    }

}
