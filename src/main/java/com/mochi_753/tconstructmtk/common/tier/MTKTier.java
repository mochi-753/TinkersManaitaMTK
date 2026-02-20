package com.mochi_753.tconstructmtk.common.tier;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class MTKTier implements Tier {
    private static final MTKTier INSTANCE = new MTKTier();

    private MTKTier() {
    }

    public static MTKTier getInstance() {
        return INSTANCE;
    }

    @Override
    public int getUses() {
        return Integer.MAX_VALUE;
    }

    @Override
    public float getSpeed() {
        return Float.MAX_VALUE;
    }

    @Override
    public float getAttackDamageBonus() {
        return Float.MAX_VALUE;
    }

    @Override
    public int getLevel() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getEnchantmentValue() {
        return Integer.MAX_VALUE;
    }

    @SuppressWarnings({"NullableProblems", "DataFlowIssue"})
    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
