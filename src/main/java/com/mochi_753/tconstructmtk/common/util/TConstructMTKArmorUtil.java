package com.mochi_753.tconstructmtk.common.util;

import net.minecraft.world.entity.LivingEntity;

public class TConstructMTKArmorUtil {
    public static final String INVINCIBLE_TAG = "tconstructmtk_invincible";

    private TConstructMTKArmorUtil() {
    }

    public static boolean isInvincible(LivingEntity livingEntity) {
        if (livingEntity == null || livingEntity.level().isClientSide()) return false;
        return livingEntity.getPersistentData().getBoolean(INVINCIBLE_TAG);
    }
}
