package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.combat.ShipAPI;

public class OFU_Advancedbay extends BaseHullMod {

    public static float FLUX_RESISTANCE = 75f;
    public static float FIGHTER_SPEED_BONUS = 25f;
    public static float HULL_BONUS = 150f;

    public static float MANEUVER_BONUS = 35f;

    public static float ARMOR_BONUS = 50f;


    public void applyEffectsToFighterSpawnedByShip(ShipAPI fighter, ShipAPI ship, String id) {

        MutableShipStatsAPI stats = fighter.getMutableStats();

        stats.getEmpDamageTakenMult().modifyMult(id, 1f - FLUX_RESISTANCE * 0.01f);

        stats.getMaxSpeed().modifyPercent(id, FIGHTER_SPEED_BONUS);
        stats.getHullBonus().modifyFlat(id, HULL_BONUS);

        stats.getAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
        stats.getDeceleration().modifyPercent(id, MANEUVER_BONUS);
        stats.getTurnAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
        stats.getMaxTurnRate().modifyPercent(id, MANEUVER_BONUS);

        stats.getArmorBonus().modifyFlat(id, ARMOR_BONUS);


    }

    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "" + (int) (FIGHTER_SPEED_BONUS) + "%";
        if (index == 1) return "" + (int) (MANEUVER_BONUS) + "%";
        if (index == 2) return "" + (int) (HULL_BONUS);
        if (index == 3) return "" + (int) (ARMOR_BONUS);
        if (index == 4) return "" + (int) (FLUX_RESISTANCE) + "%";
        return null;
    }


}
