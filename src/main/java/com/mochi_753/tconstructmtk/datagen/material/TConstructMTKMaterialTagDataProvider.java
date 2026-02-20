package com.mochi_753.tconstructmtk.datagen.material;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.material.TConstructMTKMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.data.tags.MaterialTagProvider;

@SuppressWarnings("removal")
public class TConstructMTKMaterialTagDataProvider extends MaterialTagProvider {
    public TConstructMTKMaterialTagDataProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(TinkerTags.Materials.EXCLUDE_FROM_LOOT).addOptional(new ResourceLocation(TConstructMTK.MOD_ID, TConstructMTKMaterialIds.MTK.getPath()));
    }
}
