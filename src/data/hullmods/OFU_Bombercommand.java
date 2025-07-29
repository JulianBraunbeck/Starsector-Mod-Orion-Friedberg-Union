package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.combat.ShipAPI;

public class OFU_Bombercommand extends BaseHullMod {

    public static float MISSILE_SPEED_BONUS = 25f;
    public static float MISSILE_RANGE_MULT = 0.8f;
    public static float MISSILE_ACCEL_BONUS = 150f;
    public static float MISSILE_RATE_BONUS = 50f;
    public static float MISSILE_TURN_ACCEL_BONUS = 150f;

    public static float GUIDANCE_IMPROVEMENT = 1f;
    public static float ECCM_CHANCE = 0.5f;

    public static float REPLACEMENT_RATE_PERCENT = 25;

    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {

        boolean sMod = isSMod(stats);
        float rateMalus = REPLACEMENT_RATE_PERCENT;
        float timeMult = 1f / ((100f - rateMalus) / 100f);
        if (sMod) {
            stats.getFighterRefitTimeMult().modifyMult(id, timeMult);
        }
    }

    public void applyEffectsToFighterSpawnedByShip(ShipAPI fighter, ShipAPI ship, String id) {

        MutableShipStatsAPI stats = fighter.getMutableStats();

        stats.getMissileGuidance().modifyFlat(id, GUIDANCE_IMPROVEMENT);
        stats.getEccmChance().modifyFlat(id, ECCM_CHANCE);

        stats.getMissileMaxSpeedBonus().modifyPercent(id, MISSILE_SPEED_BONUS);
        stats.getMissileWeaponRangeBonus().modifyMult(id, MISSILE_RANGE_MULT);
        stats.getMissileAccelerationBonus().modifyPercent(id, MISSILE_ACCEL_BONUS);
        stats.getMissileMaxTurnRateBonus().modifyPercent(id, MISSILE_RATE_BONUS);
        stats.getMissileTurnAccelerationBonus().modifyPercent(id, MISSILE_TURN_ACCEL_BONUS);
    }


    @Override
    public boolean isApplicableToShip(ShipAPI ship) {
        return (ship.getHullSize() == HullSize.CAPITAL_SHIP || ship.getHullSize() == HullSize.CRUISER || ship.getHullSize() == HullSize.DESTROYER);
    };

    public String getUnapplicableReason(ShipAPI ship) {
        if (ship != null && ship.getHullSize() != HullSize.CAPITAL_SHIP && ship.getHullSize() != HullSize.CRUISER || ship.getHullSize() == HullSize.DESTROYER) {
            return "Cannot be installed on frigates";
        }
        return null;
    };

    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "" + (int) (ECCM_CHANCE * 100f) + "%";
        if (index == 1) return "" + (int) (MISSILE_SPEED_BONUS) + "%";
        if (index == 2) return "" + (int) (MISSILE_RATE_BONUS) + "%";
        return null;
    }

    @Override
    public String getSModDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "" + (int) REPLACEMENT_RATE_PERCENT + "%";
        return null;
    }


    @Override
    public boolean isSModEffectAPenalty() {
        return true;
    };

}
