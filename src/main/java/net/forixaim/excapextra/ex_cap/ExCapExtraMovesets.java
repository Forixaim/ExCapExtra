package net.forixaim.excapextra.ex_cap;

import com.asanginxst.epicfightx.gameassets.EpicFightSkillsX;
import com.asanginxst.epicfightx.gameassets.ExtraSkills;
import com.asanginxst.epicfightx.gameassets.animations.AnimationsX;
import com.asanginxst.epicfightx.gameassets.animations.ExtraAnimations;
import net.forixaim.excapextra.ExCapExtra;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.Enchantments;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.core.data.MoveSet;
import yesman.epicfight.api.ex_cap.core.data.MoveSetEntry;
import yesman.epicfight.main.EpicFightMod;
import yesman.epicfight.skill.guard.GuardSkill;

public class ExCapExtraMovesets
{
    public static MoveSetEntry sword1HMS = new MoveSetEntry(
            EpicFightMod.identifier("sword_1h"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.SWORD_GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, AnimationsX.SWORD_GUARD_HIT)
                    .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, AnimationsX.SWORD_GUARD_ACTIVE_HIT1,
                            AnimationsX.SWORD_GUARD_ACTIVE_HIT2, AnimationsX.SWORD_GUARD_ACTIVE_HIT3)
                    .addComboAttacks(
                            AnimationsX.SWORD_AUTO1, AnimationsX.SWORD_AUTO2, AnimationsX.SWORD_AUTO3,
                            ExtraAnimations.SWORD_AUTO4, ExtraAnimations.SWORD_AUTO5,
                            AnimationsX.SWORD_DASH, AnimationsX.SWORD_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.SWEEPING_EDGE)
    );

    public static MoveSetEntry bowMS = new MoveSetEntry(
            EpicFightMod.identifier("bow"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_BOW)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_BOW)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_BOW)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_BOW)
                    .setMotionPredicate((entityPatch, interactionHand) ->
                            entityPatch.getOriginal().isUsingItem() &&
                                    entityPatch.getOriginal().getUseItem().getUseAnimation() == UseAnim.BOW
                                    ? LivingMotions.AIM : null)
                    .addLivingMotionModifier(LivingMotions.AIM, AnimationsX.BIPED_BOW_AIM)
                    .addLivingMotionModifier(LivingMotions.SHOT, AnimationsX.BIPED_BOW_SHOT)
    );

    public static MoveSetEntry crossbowMS = new MoveSetEntry(
            EpicFightMod.identifier("crossbow"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_CROSSBOW,
                            LivingMotions.IDLE, LivingMotions.KNEEL, LivingMotions.SNEAK,
                            LivingMotions.SWIM, LivingMotions.FLOAT, LivingMotions.FALL)
                    .setMotionPredicate((entityPatch, interactionHand) ->
                            entityPatch.getEntityState().canUseItem() &&
                                    entityPatch.getOriginal().getMainHandItem().getItem() instanceof ProjectileWeaponItem &&
                                    CrossbowItem.isCharged(entityPatch.getOriginal().getMainHandItem())
                                    ? LivingMotions.AIM : null)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_CROSSBOW)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_CROSSBOW)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_CROSSBOW)
                    .addLivingMotionModifier(LivingMotions.RELOAD, AnimationsX.BIPED_CROSSBOW_RELOAD)
                    .addLivingMotionModifier(LivingMotions.AIM, AnimationsX.BIPED_CROSSBOW_AIM)
                    .addLivingMotionModifier(LivingMotions.SHOT, AnimationsX.BIPED_CROSSBOW_SHOT)
    );

    public static MoveSetEntry axe1h = new MoveSetEntry(
            EpicFightMod.identifier("axe_1h"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.SWORD_GUARD)
                    .addGuardAnimations(GuardSkill.BlockType.GUARD, AnimationsX.SWORD_GUARD_HIT)
                    .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, AnimationsX.SWORD_GUARD_ACTIVE_HIT1,
                            AnimationsX.SWORD_GUARD_ACTIVE_HIT2, AnimationsX.SWORD_GUARD_ACTIVE_HIT3)
                    .addComboAttacks(
                            AnimationsX.AXE_AUTO1, AnimationsX.AXE_AUTO2,
                            ExtraAnimations.AXE_AUTO3, ExtraAnimations.AXE_AUTO4, ExtraAnimations.AXE_AUTO5,
                            AnimationsX.SWORD_DASH, AnimationsX.SWORD_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.GUILLOTINE_AXE)
    );

    public static MoveSetEntry tridentMS = new MoveSetEntry(
            EpicFightMod.identifier("trident"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_POLEARM)
                    .setMotionPredicate((entityPatch, interactionHand) ->
                            entityPatch.getOriginal().isUsingItem() && entityPatch.getOriginal().getUseItem().getUseAnimation() == UseAnim.SPEAR ? LivingMotions.AIM : null)
                    .addComboAttacks(
                            ExtraAnimations.SPEAR_ONEHAND_AUTO1, ExtraAnimations.SPEAR_ONEHAND_AUTO2,
                            AnimationsX.SPEAR_DASH, AnimationsX.SPEAR_ONEHAND_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) ->
                    {
                        if (itemStack.getEnchantmentLevel(Enchantments.RIPTIDE) > 0) {
                            return EpicFightSkillsX.TSUNAMI;
                        } else if (itemStack.getEnchantmentLevel(Enchantments.CHANNELING) > 0) {
                            return EpicFightSkillsX.WRATHFUL_LIGHTING;
                        } else if (itemStack.getEnchantmentLevel(Enchantments.LOYALTY) > 0) {
                            return EpicFightSkillsX.EVERLASTING_ALLEGIANCE;
                        } else {
                            return EpicFightSkillsX.GRASPING_SPIRE;
                        }
                    })
    );

    public static MoveSetEntry scytheMS = new MoveSetEntry(
            ExCapExtra.extraIdentifier("scythe"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_SPEAR,
                            LivingMotions.KNEEL, LivingMotions.SNEAK, LivingMotions.SWIM,
                            LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.CHASE, AnimationsX.BIPED_WALK_SPEAR)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.SPEAR_GUARD)
                    .addComboAttacks(
                            ExtraAnimations.SCYTHE_TWOHAND_AUTO1, ExtraAnimations.SCYTHE_TWOHAND_AUTO2,
                            ExtraAnimations.SCYTHE_TWOHAND_AUTO3, ExtraAnimations.SCYTHE_TWOHAND_AUTO4,
                            ExtraAnimations.SCYTHE_TWOHAND_AUTO5, ExtraAnimations.SCYTHE_TWOHAND_DASH,
                            ExtraAnimations.SCYTHE_TWOHAND_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> ExtraSkills.SCYTHE_SKILL)
    );

    public static MoveSetEntry fistMS = new MoveSetEntry(
            EpicFightMod.identifier("fist"),
            MoveSet.builder()
                    .addComboAttacks(
                            AnimationsX.FIST_AUTO1, AnimationsX.FIST_AUTO2, AnimationsX.FIST_AUTO3,
                            ExtraAnimations.FIST_AUTO4, ExtraAnimations.FIST_AUTO5,
                            AnimationsX.FIST_DASH, AnimationsX.FIST_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.RELENTLESS_COMBO)
    );

    public static MoveSetEntry greatswordDaggerMS = new MoveSetEntry(
            ExCapExtra.identifier("greatsword_dagger"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_SPEAR,
                            LivingMotions.KNEEL, LivingMotions.SNEAK, LivingMotions.SWIM,
                            LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_WIELD_HEAVY_LIGHT)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_WIELD_HEAVY_LIGHT)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.CHASE, AnimationsX.BIPED_WALK_SPEAR)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.GREATSWORD_GUARD)
                    .addComboAttacks(
                            ExtraAnimations.GREATSWORD_DAGGER_WIELD_AUTO1, ExtraAnimations.GREATSWORD_DAGGER_WIELD_AUTO2,
                            ExtraAnimations.GREATSWORD_DAGGER_WIELD_AUTO3, ExtraAnimations.GREATSWORD_DAGGER_WIELD_AUTO4,
                            ExtraAnimations.GREATSWORD_DAGGER_WIELD_AUTO5, AnimationsX.GREATSWORD_DASH,
                            AnimationsX.GREATSWORD_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> ExtraSkills.GREATSWORD_DAGGER_SKILL)
    );

    public static MoveSetEntry dualGreatswordMS = new MoveSetEntry(
            ExCapExtra.identifier("dual_greatsword"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_SPEAR,
                            LivingMotions.KNEEL, LivingMotions.SNEAK, LivingMotions.SWIM,
                            LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_DUAL_HEAVY)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.CHASE, AnimationsX.BIPED_WALK_SPEAR)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.GREATSWORD_GUARD)
                    .addComboAttacks(
                            ExtraAnimations.GREATSWORD_DUAL_AUTO1, ExtraAnimations.GREATSWORD_DUAL_AUTO2,
                            ExtraAnimations.GREATSWORD_DUAL_AUTO3, ExtraAnimations.GREATSWORD_DUAL_AUTO4,
                            ExtraAnimations.GREATSWORD_DUAL_AUTO5, AnimationsX.SWORD_DUAL_DASH,
                            AnimationsX.SWORD_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.DANCING_EDGE)
    );

    public static MoveSetEntry sword2HMS = new MoveSetEntry(
            EpicFightMod.identifier("sword_dual"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_DUAL_WEAPON,
                            LivingMotions.WALK, LivingMotions.KNEEL, LivingMotions.CHASE,
                            LivingMotions.SNEAK, LivingMotions.SWIM, LivingMotions.FLOAT, LivingMotions.FALL)
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_DUAL_LIGHT)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_DUAL_LIGHT)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_DUAL_LIGHT)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.SWORD_DUAL_GUARD)
                    .addComboAttacks(
                            AnimationsX.SWORD_DUAL_AUTO1, AnimationsX.SWORD_DUAL_AUTO2, AnimationsX.SWORD_DUAL_AUTO3,
                            ExtraAnimations.SWORD_DUAL_AUTO4, ExtraAnimations.SWORD_DUAL_AUTO5,
                            AnimationsX.SWORD_DUAL_DASH, AnimationsX.SWORD_DUAL_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.DANCING_EDGE)
    );

    public static MoveSetEntry longsword1HMS = new MoveSetEntry(
            EpicFightMod.identifier("longsword_1h"),
            MoveSet.builder()
                    .parent(EpicFightMod.identifier("longsword_2h"))
                    .addComboAttacks(
                            AnimationsX.LONGSWORD_AUTO1, AnimationsX.LONGSWORD_AUTO2, AnimationsX.LONGSWORD_AUTO3,
                            ExtraAnimations.LONGSWORD_AUTO4, ExtraAnimations.LONGSWORD_AUTO5,
                            AnimationsX.LONGSWORD_DASH, AnimationsX.LONGSWORD_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.SHARP_STAB)
    );

    public static MoveSetEntry longsword2HMS = new MoveSetEntry(
            EpicFightMod.identifier("longsword_2h"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(ExtraAnimations.BIPED_HOLD_ONEHAND_MEDIUM,
                            LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL, LivingMotions.SWIM)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.CHASE, AnimationsX.BIPED_WALK_LONGSWORD)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.LONGSWORD_GUARD)
                    .addComboAttacks(
                            AnimationsX.LONGSWORD_AUTO1, AnimationsX.LONGSWORD_AUTO2, AnimationsX.LONGSWORD_AUTO3,
                            ExtraAnimations.LONGSWORD_AUTO4, ExtraAnimations.LONGSWORD_AUTO5,
                            ExtraAnimations.LONGSWORD_TWOHAND_DASH, ExtraAnimations.LONGSWORD_TWOHAND_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.LIECHTENAUER)
    );

    public static MoveSetEntry liechtenauerMS = new MoveSetEntry(
            EpicFightMod.identifier("liechtenauer"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_LIECHTENAUER,
                            LivingMotions.IDLE, LivingMotions.RUN, LivingMotions.SNEAK, LivingMotions.KNEEL, LivingMotions.SWIM)
                    .addLivingMotionsRecursive(AnimationsX.BIPED_WALK_LIECHTENAUER,
                            LivingMotions.WALK, LivingMotions.CHASE)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_LIECHTENAUER)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.LONGSWORD_GUARD)
                    .addComboAttacks(
                            AnimationsX.LONGSWORD_LIECHTENAUER_AUTO1, AnimationsX.LONGSWORD_LIECHTENAUER_AUTO2,
                            AnimationsX.LONGSWORD_LIECHTENAUER_AUTO3, ExtraAnimations.LONGSWORD_LIECHTENAUER_AUTO4,
                            ExtraAnimations.LONGSWORD_LIECHTENAUER_AUTO5, ExtraAnimations.LONGSWORD_LIECHTENAUER_AUTO6,
                            ExtraAnimations.LONGSWORD_TWOHAND_DASH, ExtraAnimations.LONGSWORD_TWOHAND_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.LIECHTENAUER)
    );

    public static MoveSetEntry greatsword2HMS = new MoveSetEntry(
            EpicFightMod.identifier("greatsword_2h"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_SPEAR,
                            LivingMotions.KNEEL, LivingMotions.SNEAK, LivingMotions.SWIM,
                            LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_TWOHAND_HEAVY)
                    .addLivingMotionModifier(LivingMotions.CHASE, AnimationsX.BIPED_WALK_SPEAR)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.GREATSWORD_GUARD)
                    .addComboAttacks(
                            AnimationsX.GREATSWORD_AUTO1, AnimationsX.GREATSWORD_AUTO2,
                            ExtraAnimations.GREATSWORD_AUTO3, ExtraAnimations.GREATSWORD_AUTO4,
                            ExtraAnimations.GREATSWORD_AUTO5, AnimationsX.GREATSWORD_DASH,
                            AnimationsX.GREATSWORD_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.STEEL_WHIRLWIND)
    );

    public static MoveSetEntry tachi2HMS = new MoveSetEntry(
            EpicFightMod.identifier("tachi_2h"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(ExtraAnimations.BIPED_HOLD_ONEHAND_MEDIUM,
                            LivingMotions.IDLE, LivingMotions.KNEEL, LivingMotions.SNEAK,
                            LivingMotions.SWIM, LivingMotions.FLOAT, LivingMotions.FALL)
                    .addLivingMotionsRecursive(ExtraAnimations.BIPED_RUN_ONEHAND_MEDIUM,
                            LivingMotions.CHASE, LivingMotions.RUN)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.LONGSWORD_GUARD)
                    .addComboAttacks(
                            AnimationsX.TACHI_AUTO1, AnimationsX.TACHI_AUTO2, AnimationsX.TACHI_AUTO3,
                            ExtraAnimations.TACHI_AUTO4, ExtraAnimations.TACHI_AUTO5,
                            AnimationsX.TACHI_DASH, ExtraAnimations.TACHI_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.RUSHING_TEMPO)
    );

    public static MoveSetEntry spear1HMS = new MoveSetEntry(
            EpicFightMod.identifier("spear_1h"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(ExtraAnimations.BIPED_HOLD_ONEHAND_POLEARM,
                            LivingMotions.IDLE)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_POLEARM)
                    .addComboAttacks(
                            ExtraAnimations.SPEAR_ONEHAND_AUTO1, ExtraAnimations.SPEAR_ONEHAND_AUTO2,
                            AnimationsX.SPEAR_DASH, AnimationsX.SPEAR_ONEHAND_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.HEARTPIERCER)
    );

    public static MoveSetEntry spear2HMS = new MoveSetEntry(
            EpicFightMod.identifier("spear_2h"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(ExtraAnimations.BIPED_HOLD_ONEHAND_POLEARM,
                            LivingMotions.IDLE)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_POLEARM)
                    .addLivingMotionModifier(LivingMotions.CHASE, AnimationsX.BIPED_WALK_SPEAR)
                    .addLivingMotionModifier(LivingMotions.SWIM, AnimationsX.BIPED_HOLD_SPEAR)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.SPEAR_GUARD)
                    .addComboAttacks(
                            AnimationsX.SPEAR_TWOHAND_AUTO1, AnimationsX.SPEAR_TWOHAND_AUTO2,
                            ExtraAnimations.SPEAR_TWOHAND_AUTO3, ExtraAnimations.SPEAR_TWOHAND_AUTO4,
                            ExtraAnimations.SPEAR_TWOHAND_AUTO5, ExtraAnimations.SPEAR_TWOHAND_DASH,
                            AnimationsX.SPEAR_TWOHAND_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.GRASPING_SPIRE)
    );

    public static MoveSetEntry dagger1HMS = new MoveSetEntry(
            EpicFightMod.identifier("dagger_1h"),
            MoveSet.builder()
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_LIGHT)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_LIGHT)
                    .addComboAttacks(
                            AnimationsX.DAGGER_AUTO1, AnimationsX.DAGGER_AUTO2, AnimationsX.DAGGER_AUTO3,
                            ExtraAnimations.DAGGER_AUTO4, ExtraAnimations.DAGGER_AUTO5,
                            AnimationsX.DAGGER_DASH, AnimationsX.DAGGER_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.EVISCERATE)
    );

    public static MoveSetEntry dagger2HMS = new MoveSetEntry(
            EpicFightMod.identifier("dagger_2h"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_DUAL_WEAPON,
                            LivingMotions.KNEEL, LivingMotions.WALK, LivingMotions.CHASE,
                            LivingMotions.SNEAK, LivingMotions.SWIM, LivingMotions.FLOAT, LivingMotions.FALL)
                    .addLivingMotionModifier(LivingMotions.IDLE, ExtraAnimations.BIPED_HOLD_DUAL_LIGHT)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_DUAL_LIGHT)
                    .addLivingMotionModifier(LivingMotions.RUN, ExtraAnimations.BIPED_RUN_DUAL_LIGHT)
                    .addComboAttacks(
                            AnimationsX.DAGGER_DUAL_AUTO1, AnimationsX.DAGGER_DUAL_AUTO2,
                            AnimationsX.DAGGER_DUAL_AUTO3, AnimationsX.DAGGER_DUAL_AUTO4,
                            ExtraAnimations.DAGGER_DUAL_AUTO5, AnimationsX.DAGGER_DUAL_DASH,
                            AnimationsX.DAGGER_DUAL_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.BLADE_RUSH)
    );

    public static MoveSetEntry uchigatanaBase = new MoveSetEntry(
            EpicFightMod.identifier("uchigatana_base"),
            MoveSet.builder()
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_UCHIGATANA,
                            LivingMotions.IDLE, LivingMotions.KNEEL, LivingMotions.SWIM,
                            LivingMotions.FLOAT, LivingMotions.FALL)
                    .addLivingMotionsRecursive(AnimationsX.BIPED_WALK_UCHIGATANA,
                            LivingMotions.CHASE, LivingMotions.SNEAK)
                    .addLivingMotionModifier(LivingMotions.WALK, ExtraAnimations.BIPED_WALK_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_ONEHAND_MEDIUM)
                    .addLivingMotionModifier(LivingMotions.RUN, AnimationsX.BIPED_RUN_UCHIGATANA)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.UCHIGATANA_GUARD)
                    .addComboAttacks(
                            AnimationsX.UCHIGATANA_AUTO1, AnimationsX.UCHIGATANA_AUTO2,
                            AnimationsX.UCHIGATANA_AUTO3, ExtraAnimations.UCHIGATANA_AUTO4,
                            ExtraAnimations.UCHIGATANA_AUTO5, AnimationsX.UCHIGATANA_DASH,
                            AnimationsX.UCHIGATANA_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.BATTOJUTSU)
                    .setPassiveSkill(EpicFightSkillsX.BATTOJUTSU_PASSIVE)
    );

    public static MoveSetEntry uchigatanaSheathed = new MoveSetEntry(
            EpicFightMod.identifier("uchigatana_sheathed"),
            MoveSet.builder()
                    .parent(EpicFightMod.identifier("uchigatana_base"))
                    .addLivingMotionsRecursive(AnimationsX.BIPED_HOLD_UCHIGATANA_SHEATHING,
                            LivingMotions.IDLE, LivingMotions.KNEEL, LivingMotions.CHASE,
                            LivingMotions.SNEAK, LivingMotions.SWIM, LivingMotions.FLOAT, LivingMotions.FALL)
                    .addLivingMotionModifier(LivingMotions.WALK, AnimationsX.BIPED_WALK_UCHIGATANA_SHEATHING)
                    .addLivingMotionModifier(LivingMotions.RUN, AnimationsX.BIPED_RUN_UCHIGATANA_SHEATHING)
                    .addLivingMotionModifier(LivingMotions.JUMP, ExtraAnimations.BIPED_JUMP_UCHIGATANA_SHEATH)
                    .addLivingMotionModifier(LivingMotions.BLOCK, AnimationsX.UCHIGATANA_GUARD)
                    .addComboAttacks(
                            AnimationsX.UCHIGATANA_SHEATHING_AUTO, AnimationsX.UCHIGATANA_SHEATHING_DASH,
                            AnimationsX.UCHIGATANA_SHEATH_AIR_SLASH
                    )
                    .addInnateSkill((itemStack, playerPatch) -> EpicFightSkillsX.BATTOJUTSU)
    );
}
