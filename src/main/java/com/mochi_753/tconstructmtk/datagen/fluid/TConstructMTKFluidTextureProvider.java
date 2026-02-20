package com.mochi_753.tconstructmtk.datagen.fluid;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKFluids;
import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("removal")
public class TConstructMTKFluidTextureProvider extends AbstractFluidTextureProvider {
    public TConstructMTKFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, TConstructMTK.MOD_ID);
    }

    @Override
    public void addTextures() {
        texture(TConstructMTKFluids.MOLTEN_MTK).root(new ResourceLocation(TConstructMTK.MOD_ID, "fluid/molten/mtk_"))
                .still().flowing().camera().calculateFogColor(true).fog(FogShape.SPHERE, 0.25F, 2);
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Fluid Textures";
    }
}
