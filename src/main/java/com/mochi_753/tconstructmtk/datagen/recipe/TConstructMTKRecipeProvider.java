package com.mochi_753.tconstructmtk.datagen.recipe;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.material.TConstructMTKMaterialIds;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKFluids;
import com.takoy3466.manaitamtk.init.ItemsInit;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidType;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("removal")
public class TConstructMTKRecipeProvider extends RecipeProvider implements IMaterialRecipeHelper {
    public TConstructMTKRecipeProvider(PackOutput generator) {
        super(generator);
    }

    @Override
    public String getModId() {
        return TConstructMTK.MOD_ID;
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        addMeltingRecipes(consumer);
    }

    private void addMeltingRecipes(Consumer<FinishedRecipe> consumer) {
        MeltingRecipeBuilder.melting(Ingredient.of(ItemsInit.ITEM_MTK.get()), TConstructMTKFluids.MOLTEN_MTK.get(), FluidType.BUCKET_VOLUME, 0.01F)
                .save(consumer, new ResourceLocation(TConstructMTK.MOD_ID, "smeltery/melting/mtk"));

        materialRecipe(consumer, TConstructMTKMaterialIds.MTK, Ingredient.of(ItemsInit.ITEM_MTK.get()), 1, 1, "tools/materials/mtk");
        materialMeltingCasting(consumer, TConstructMTKMaterialIds.MTK, TConstructMTKFluids.MOLTEN_MTK, "tools/materials/");
    }
}
