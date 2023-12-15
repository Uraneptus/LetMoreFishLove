package com.uraneptus.letmorelove.data.server.tags;

import com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes;
import com.uraneptus.letfishlove.LetFishLoveMod;
import com.uraneptus.letfishlove.core.other.LFLEntityTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class LMLEntityTagsProvider extends EntityTypeTagsProvider {

    public LMLEntityTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, LetFishLoveMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void addTags() {
        //TODO make mod dependent
        tag(LFLEntityTags.BREEDABLE_FISH).add(UAEntityTypes.PERCH.get());
        tag(LFLEntityTags.BREEDABLE_FISH).add(UAEntityTypes.LIONFISH.get());
        tag(LFLEntityTags.BREEDABLE_FISH).add(UAEntityTypes.PIKE.get());
    }
}
