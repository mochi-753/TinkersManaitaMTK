package com.mochi_753.tconstructmtk.datagen.fluid;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKFluids;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.FlowingFluidObject;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class TConstructMTKFluidTagProvider extends FluidTagsProvider {
    public TConstructMTKFluidTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, ExistingFileHelper pExistingFileHelper) {
        super(pOutput, pProvider, TConstructMTK.MOD_ID, pExistingFileHelper);
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Fluid Tags";
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        fluidTag(TConstructMTKFluids.MOLTEN_MTK);
    }

    private void fluidTag(FlowingFluidObject<?> flowingFluidObject) {
        tag(flowingFluidObject.getLocalTag()).add(flowingFluidObject.getStill(), flowingFluidObject.getFlowing());
        TagKey<Fluid> tagKey = flowingFluidObject.getCommonTag();
        if (tagKey != null) tag(tagKey).addTag(flowingFluidObject.getLocalTag());
    }
}
