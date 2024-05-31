package com.uraneptus.letmorefishlove.data.server.tags;

import codyhuh.unusualfishmod.core.registry.UFEntities;
import com.starfish_studios.naturalist.registry.NaturalistEntityTypes;
import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letfishlove.core.other.LFLEntityTags;
import com.uraneptus.letmorefishlove.core.CompatHandler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class LMLEntityTagsProvider extends EntityTypeTagsProvider {

    public LMLEntityTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, LetFishLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        tag(LFLEntityTags.BREEDABLE_FISH)
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.PERCH.get()))
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.PIKE.get()))
                .addOptional(rlFromEntity(CompatHandler.UPGRADE_AUQUATIC, UAEntityTypes.LIONFISH.get()))
                .addOptional(rlFromEntity(CompatHandler.NATURALIST, NaturalistEntityTypes.BASS.get()))
                .addOptional(rlFromEntity(CompatHandler.NATURALIST, NaturalistEntityTypes.CATFISH.get()))
                .addOptional(rlFromEntity(CompatHandler.UNUSUAL_FISH, UFEntities.BLIZZARDFIN.get()));
    }

    public ResourceLocation rlFromEntity(String modId, EntityType<?> entityType) {
        return new ResourceLocation(modId, ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath());
    }

}
