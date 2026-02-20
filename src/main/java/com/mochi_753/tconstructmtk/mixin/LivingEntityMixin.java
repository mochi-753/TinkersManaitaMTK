package com.mochi_753.tconstructmtk.mixin;

import com.mochi_753.tconstructmtk.common.util.TConstructMTKArmorUtil;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "die", at = @At("HEAD"), cancellable = true)
    private void tconstructmtk$die(DamageSource pDamageSource, CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player && player.getInventory() == null) return;

        if (TConstructMTKArmorUtil.isInvincible(self)) ci.cancel();
    }

    @Inject(method = "getHealth", at = @At("HEAD"), cancellable = true)
    private void tconstructmtk$getHealth(CallbackInfoReturnable<Float> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player && player.getInventory() == null) return;

        if (TConstructMTKArmorUtil.isInvincible(self)) {
            cir.setReturnValue(self.getMaxHealth());
            cir.cancel();
        }
    }

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void tconstructmtk$hurt(DamageSource pSource, float pAmount, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player && player.getInventory() == null) return;

        if (TConstructMTKArmorUtil.isInvincible(self)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(method = "isAlive", at = @At("HEAD"), cancellable = true)
    private void tconstructmtk$isAlive(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player && player.getInventory() == null) return;

        if (TConstructMTKArmorUtil.isInvincible(self)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(method = "isDeadOrDying", at = @At("HEAD"), cancellable = true)
    private void tconstructmtk$isDeadOrDying(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player && player.getInventory() == null) return;

        if (TConstructMTKArmorUtil.isInvincible(self)) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }

    @Inject(method = "setHealth", at = @At("HEAD"), cancellable = true)
    private void tconstructmtk$setHealth(float pHealth, CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self instanceof Player player && player.getInventory() == null) return;

        if (TConstructMTKArmorUtil.isInvincible(self)) ci.cancel();
    }
}
