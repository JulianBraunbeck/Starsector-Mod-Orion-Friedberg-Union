package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.combat.ShipAPI;

public class OFU_Advancedbay extends BaseHullMod {

    public static float FIGHTER_SPEED_BONUS = 15f;
    public static float HULL_BONUS = 20f;

    public static float MANEUVER_BONUS = 25f;

    public static float ARMOR_BONUS = 20f;


    public void applyEffectsToFighterSpawnedByShip(ShipAPI fighter, ShipAPI ship, String id) {

        MutableShipStatsAPI stats = fighter.getMutableStats();

        stats.getMaxSpeed().modifyPercent(id, FIGHTER_SPEED_BONUS);
        stats.getHullBonus().modifyPercent(id, HULL_BONUS);

        stats.getAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
        stats.getDeceleration().modifyPercent(id, MANEUVER_BONUS);
        stats.getTurnAcceleration().modifyPercent(id, MANEUVER_BONUS * 2f);
        stats.getMaxTurnRate().modifyPercent(id, MANEUVER_BONUS);

        stats.getArmorBonus().modifyPercent(id, ARMOR_BONUS);


    }

    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "" + (int) (FIGHTER_SPEED_BONUS) + "%";
        if (index == 1) return "" + (int) (MANEUVER_BONUS) + "%";
        if (index == 2) return "" + (int) (HULL_BONUS) + "%";
        if (index == 3) return "" + (int) (ARMOR_BONUS) + "%";
        return null;
    }


}
