package com.mochi_753.tconstructmtk.common.registry;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.modiffier.ModifierMTK;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.DynamicModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TConstructMTKModifiers {
    private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TConstructMTK.MOD_ID);
    public static final StaticModifier<NoLevelsModifier> MTK_MODIFIER = MODIFIERS.register("mtk", ModifierMTK::new);
    public static final DynamicModifier MTK_UNBREAKABLE_MODIFIER = MODIFIERS.registerDynamic("mtk_unbreakable");

    private TConstructMTKModifiers() {
    }

    public static void register(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}
