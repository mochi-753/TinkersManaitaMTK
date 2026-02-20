package com.mochi_753.tconstructmtk.common.material;

import com.mochi_753.tconstructmtk.TConstructMTK;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

import java.util.Objects;

public class TConstructMTKMaterialIds {
    public static final MaterialId MTK = Objects.requireNonNull(MaterialId.tryBuild(TConstructMTK.MOD_ID, "mtk"));

    private TConstructMTKMaterialIds() {
    }
}
