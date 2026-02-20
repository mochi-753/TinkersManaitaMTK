package com.mochi_753.tconstructmtk;

import com.mochi_753.tconstructmtk.common.registry.TConstructMTKFluids;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKTiers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TConstructMTK.MOD_ID)
public class TConstructMTK {
    public static final String MOD_ID = "tconstructmtk";
    public static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("removal")
    public TConstructMTK() {
        this(FMLJavaModLoadingContext.get());
    }

    public TConstructMTK(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();

        TConstructMTKFluids.register(eventBus);
        TConstructMTKModifiers.register(eventBus);
        new TConstructMTKTiers();
    }
}
