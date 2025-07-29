package data.shipsystems.scripts;

import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.impl.combat.BaseShipSystemScript;

public class OFU_KineticConverterStats extends BaseShipSystemScript {

	//public static final float ROF_BONUS = 1f;
	//public static final float FLUX_REDUCTION = 50f;
	public static final float DAMAGE_BONUS_PERCENT = 20f;
	public static final float PROJECTILE_SPEED_INCREASE_PERCENT = 50f;
	public static final float SPEED_DECREASE_PERCENT = -33f;

	
	public void apply(MutableShipStatsAPI stats, String id, State state, float effectLevel) {
		
		float dmgPercent = DAMAGE_BONUS_PERCENT * effectLevel;
		float speedPercent = SPEED_DECREASE_PERCENT * effectLevel;
		stats.getBallisticWeaponDamageMult().modifyPercent(id, dmgPercent);
		stats.getEnergyWeaponDamageMult().modifyPercent(id, dmgPercent);
		stats.getBallisticProjectileSpeedMult().modifyMult(id, 1f + (PROJECTILE_SPEED_INCREASE_PERCENT * 0.01f));
		stats.getEnergyProjectileSpeedMult().modifyMult(id, 1f + (PROJECTILE_SPEED_INCREASE_PERCENT * 0.01f));
		stats.getMaxSpeed().modifyPercent(id, speedPercent);

	}
	public void unapply(MutableShipStatsAPI stats, String id) {
		stats.getBallisticWeaponDamageMult().unmodify(id);
		stats.getEnergyWeaponDamageMult().unmodify(id);
		stats.getBallisticProjectileSpeedMult().unmodify(id);
		stats.getEnergyProjectileSpeedMult().unmodify(id);
		stats.getMaxSpeed().unmodify(id);
	}
	
	public StatusData getStatusData(int index, State state, float effectLevel) {
		float dmgPercent = DAMAGE_BONUS_PERCENT * effectLevel;
		float bonusPercent = (int) (dmgPercent);
		float negPercent = SPEED_DECREASE_PERCENT * effectLevel;
		if (index == 0) {
			return new StatusData("non-missile weapon damage +" + (int) bonusPercent + "%", false);
		}
		if (index == 1) {
			return new StatusData("non-missile projectile speed +" + (int) PROJECTILE_SPEED_INCREASE_PERCENT + "%", false);
		}
		if (index == 2) {
			return new StatusData("Ship speed " + (int) negPercent + "%", false);
		}
		return null;
	}
}
