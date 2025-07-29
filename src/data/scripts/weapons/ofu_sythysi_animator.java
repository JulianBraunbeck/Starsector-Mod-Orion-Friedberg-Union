package data.scripts.weapons;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.util.IntervalUtil;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.loading.ProjectileWeaponSpecAPI;


public class ofu_sythysi_animator implements EveryFrameWeaponEffectPlugin {

    float animStartTime = 0f,
            animEndTime = 0f;
    float totalFrames = 0,
            totalFireTime = 0,
            startPercent = 0,
            endPercent = 0;

    boolean doOnce = true;

    public void advance(float amount, CombatEngineAPI engine, WeaponAPI weapon) {

            if (doOnce) {
                totalFireTime = ((ProjectileWeaponSpecAPI) weapon.getSpec()).getRefireDelay();
                totalFrames = weapon.getAnimation().getNumFrames();
                animEndTime = totalFrames / weapon.getAnimation().getFrameRate() + animStartTime;
                weapon.getAnimation().setFrameRate(0);
                startPercent = animStartTime / totalFireTime;
                endPercent = animEndTime / totalFireTime;
                doOnce = false;
            }

        //Saves handy variables used later
        boolean fired = weapon.getCooldownRemaining() > 0;
        float chargeLevel = weapon.getChargeLevel();

        float shotFaction = 0.0f;
        if (!fired) {
            shotFaction = ((((ProjectileWeaponSpecAPI) weapon.getSpec()).getChargeTime() * chargeLevel) / totalFireTime);
        } else {
            shotFaction = ((((ProjectileWeaponSpecAPI) weapon.getSpec()).getChargeTime() + ((totalFireTime - ((ProjectileWeaponSpecAPI) weapon.getSpec()).getChargeTime()) * (1 - chargeLevel))) / totalFireTime);
        }
        float animFraction = (shotFaction - startPercent) / endPercent;
        int frame = (int) Math.max(0, Math.min((animFraction * totalFrames), (totalFrames - 1)));
        Global.getLogger(ofu_sythysi_animator.class).info((frame + 1) + "/" + totalFrames);
        weapon.getAnimation().setFrame(frame);


    }
}
