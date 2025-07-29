package data.scripts.weapons;

import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.listeners.ApplyDamageResultAPI;
import org.lwjgl.util.vector.Vector2f;

public class ofu_fragmg_onhit implements OnHitEffectPlugin {
    public static float DAMAGE = 75;

    @Override
    public void onHit(DamagingProjectileAPI projectile, CombatEntityAPI target, Vector2f point, boolean shieldHit, ApplyDamageResultAPI damageResult, CombatEngineAPI engine) {
        // Only do something special when we hit a ship


        if (!(target instanceof ShipAPI)) return;

        var ship = (ShipAPI) target;
        if (ship.isFighter()) {
            float mult = 1f;
            engine.applyDamage(target, point, DAMAGE * mult, DamageType.ENERGY, 0f, false, false, projectile.getSource());
        };

    }

}
