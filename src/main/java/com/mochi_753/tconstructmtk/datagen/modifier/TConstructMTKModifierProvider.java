package com.mochi_753.tconstructmtk.datagen.modifier;

import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.modules.behavior.ReduceToolDamageModule;
import slimeknights.tconstruct.library.modifiers.modules.display.DurabilityBarColorModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;

@MethodsReturnNonnullByDefault
public class TConstructMTKModifierProvider extends AbstractModifierProvider {
    public TConstructMTKModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {
        buildModifier(TConstructMTKModifiers.MTK_UNBREAKABLE_MODIFIER)
                .addModule(new DurabilityBarColorModule(0xFF0000))
                .addModule(ReduceToolDamageModule.builder().flat(1.0F))
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS);
    }

    @Override
    public String getName() {
        return "Tinkers' ManaitaMTK Modifiers";
    }
}
