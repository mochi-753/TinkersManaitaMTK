package com.mochi_753.tconstructmtk.common.modiffier;

import com.takoy3466.manaitamtk.util.WeaponUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModifierMTK extends NoLevelsModifier implements BreakSpeedModifierHook, ProjectileHitModifierHook, MeleeHitModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BREAK_SPEED, ModifierHooks.PROJECTILE_HIT, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void onBreakSpeed(IToolStackView iToolStackView, ModifierEntry modifierEntry, PlayerEvent.BreakSpeed breakSpeed, Direction direction, boolean b, float v) {
        breakSpeed.setNewSpeed(Float.MAX_VALUE);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target, boolean notBlocked) {
        if (attacker instanceof Player player && !player.level().isClientSide() && target != null) {
            WeaponUtil.lightningStriker(target, player.level(), player);
            WeaponUtil.die(target);
        }

        return ProjectileHitModifierHook.super.onProjectileHitEntity(modifiers, persistentData, modifier, projectile, hit, attacker, target, notBlocked);
    }

    @Override
    public float beforeMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
        onMeleeHit(context.getAttacker(), context.getTarget(), true);
        return MeleeHitModifierHook.super.beforeMeleeHit(tool, modifier, context, damage, baseKnockback, knockback);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        onMeleeHit(context.getAttacker(), context.getTarget(), false);
    }

    private void onMeleeHit(LivingEntity attacker, Entity entity, boolean lightning) {
        if (entity instanceof PartEntity<?> partEntity) {
            onMeleeHit(attacker, partEntity.getParent(), lightning);
            return;
        }

        if (attacker instanceof Player player && !player.level().isClientSide() && entity instanceof LivingEntity target) {
            if (lightning && target.distanceToSqr(attacker) > 64.0)
                WeaponUtil.lightningStriker(target, player.level(), player);
            WeaponUtil.die(target);
        }
    }

    @Override
    public Component getDisplayName() {
        return ((MutableComponent) super.getDisplayName()).withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public Component getDisplayName(int level) {
        return this.getDisplayName();
    }
}