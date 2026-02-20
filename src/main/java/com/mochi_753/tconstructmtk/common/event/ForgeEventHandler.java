package com.mochi_753.tconstructmtk.common.event;

import com.mochi_753.tconstructmtk.TConstructMTK;
import com.mochi_753.tconstructmtk.common.registry.TConstructMTKModifiers;
import com.mochi_753.tconstructmtk.common.util.TConstructMTKArmorUtil;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import javax.annotation.ParametersAreNonnullByDefault;

@Mod.EventBusSubscriber(modid = TConstructMTK.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
@ParametersAreNonnullByDefault
public class ForgeEventHandler {
    private ForgeEventHandler() {
    }

    private static void cancel(final LivingEvent event) {
        if (TConstructMTKArmorUtil.isInvincible(event.getEntity())) event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onLivingAttack(final LivingAttackEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingDeath(final LivingDeathEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingDamage(final LivingDamageEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingHurt(final LivingHurtEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingKnockBack(final LivingKnockBackEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onLivingDrops(final LivingDropsEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onExperienceDrop(final LivingExperienceDropEvent event) {
        cancel(event);
    }

    @SubscribeEvent
    public static void onPlayerTick(final TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (event.phase == TickEvent.Phase.END && event.side.isServer() && TConstructMTKArmorUtil.isInvincible(player)) {
            player.setHealth(player.getMaxHealth());
            player.getFoodData().setFoodLevel(20);
            player.getFoodData().setSaturation(20.0F);

            for (MobEffectInstance effectInstance : player.getActiveEffects()) {
                if (effectInstance.getEffect().getCategory().equals(MobEffectCategory.HARMFUL)) {
                    player.removeEffect(effectInstance.getEffect());
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingEquipmentChange(final LivingEquipmentChangeEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if (livingEntity != null && !livingEntity.level().isClientSide())
            livingEntity.getPersistentData().putBoolean(TConstructMTKArmorUtil.INVINCIBLE_TAG, isInvincible(event));
    }

    private static boolean isInvincible(final LivingEquipmentChangeEvent event) {
        // 負荷軽減用 (おそらく必要ないのでコメントアウト)
        // ToolStack to = ToolStack.copyFrom(event.getTo());
        // if (to.getModifierLevel(TConstructMTKModifiers.MTK_MODIFIER.get()) > 0) return true;

        for (ItemStack itemStack : event.getEntity().getArmorSlots()) {
            ToolStack toolStack = ToolStack.copyFrom(itemStack);
            if (toolStack.getModifierLevel(TConstructMTKModifiers.MTK_MODIFIER.get()) > 0) return true;
        }

        return false;
    }
}
