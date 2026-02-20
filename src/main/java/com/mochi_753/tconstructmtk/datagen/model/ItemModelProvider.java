package com.mochi_753.tconstructmtk.datagen.model;

import com.google.gson.JsonObject;
import com.mochi_753.tconstructmtk.TConstructMTK;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import slimeknights.mantle.data.GenericDataProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ItemModelProvider extends GenericDataProvider {
    public ItemModelProvider(PackOutput output) {
        super(output, PackOutput.Target.RESOURCE_PACK, "models/item");
    }

    @SuppressWarnings("deprecation")
    private static JsonObject makeJson(BucketItem bucket) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", "forge:item/bucket_drip");
        json.addProperty("loader", "tconstruct:fluid_container");
        json.addProperty("flip_gas", bucket.getFluid().getFluidType().isLighterThanAir());
        json.addProperty("fluid", BuiltInRegistries.FLUID.getKey(bucket.getFluid()).toString());
        return json;
    }

    @SuppressWarnings({"deprecation", "removal"})
    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        BucketItem bucketItem = (BucketItem) BuiltInRegistries.ITEM.get(new ResourceLocation(TConstructMTK.MOD_ID, "molten_mtk_bucket"));
        return saveJson(cachedOutput, BuiltInRegistries.ITEM.getKey(bucketItem), makeJson(bucketItem));
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Item models";
    }
}
