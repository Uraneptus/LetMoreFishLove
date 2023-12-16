package com.uraneptus.letmorelove.data.server.tags;

import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letfishlove.core.other.LFLEntityTags;
import com.uraneptus.letmorelove.core.CompatHandler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class LMLEntityTagsProvider extends EntityTypeTagsProvider {

    public LMLEntityTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, LetFishLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        tag(LFLEntityTags.BREEDABLE_FISH)
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.PERCH.get()))
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.PIKE.get()))
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.LIONFISH.get()));
    }

    public ResourceLocation rlFromEntity(String modId, EntityType<?> entityType) {
        return new ResourceLocation(modId, ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath());
    }

}
