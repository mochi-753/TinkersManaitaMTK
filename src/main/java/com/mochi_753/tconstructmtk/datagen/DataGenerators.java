package com.mochi_753.tconstructmtk.datagen;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.datagen.fluid.TConstructMTKFluidTagProvider;
import com.mochi_753.tconstructmtk.datagen.fluid.TConstructMTKFluidTextureProvider;
import com.mochi_753.tconstructmtk.datagen.lang.TConstructMTKLanguageProvider;
import com.mochi_753.tconstructmtk.datagen.material.TConstructMTKMaterialDataProvider;
import com.mochi_753.tconstructmtk.datagen.material.TConstructMTKMaterialStatsDataProvider;
import com.mochi_753.tconstructmtk.datagen.material.TConstructMTKMaterialTagDataProvider;
import com.mochi_753.tconstructmtk.datagen.material.TConstructMTKMaterialTraitsProvider;
import com.mochi_753.tconstructmtk.datagen.model.ItemModelProvider;
import com.mochi_753.tconstructmtk.datagen.modifier.TConstructMTKModifierProvider;
import com.mochi_753.tconstructmtk.datagen.recipe.TConstructMTKRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TConstructMTKFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new TConstructMTKFluidTextureProvider(packOutput));

        generator.addProvider(event.includeServer(), new TConstructMTKLanguageProvider(packOutput, "en_us"));
        generator.addProvider(event.includeServer(), new TConstructMTKLanguageProvider(packOutput, "ja_jp"));

        TConstructMTKMaterialDataProvider materialDataProvider = new TConstructMTKMaterialDataProvider(packOutput);
        generator.addProvider(event.includeServer(), materialDataProvider);
        generator.addProvider(event.includeServer(), new TConstructMTKMaterialTraitsProvider(packOutput, materialDataProvider));
        generator.addProvider(event.includeServer(), new TConstructMTKMaterialStatsDataProvider(packOutput, materialDataProvider));
        generator.addProvider(event.includeServer(), new TConstructMTKMaterialTagDataProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new ItemModelProvider(packOutput));

        generator.addProvider(event.includeServer(), new TConstructMTKModifierProvider(packOutput));

        generator.addProvider(event.includeServer(), new TConstructMTKRecipeProvider(packOutput));
    }
}
