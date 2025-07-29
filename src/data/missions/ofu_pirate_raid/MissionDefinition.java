package data.missions.ofu_pirate_raid;

import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.impl.campaign.ids.BattleObjectives;
import com.fs.starfarer.api.impl.campaign.ids.StarTypes;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;

public class MissionDefinition implements MissionDefinitionPlugin {

    public void defineMission(MissionDefinitionAPI api) {

        // Set up the fleets so we can add ships and fighter wings to them.
        // In this scenario, the fleets are attacking each other, but
        // in other scenarios, a fleet may be defending or trying to escape
        api.initFleet(FleetSide.PLAYER, "OFS", FleetGoal.ATTACK, false);
        api.initFleet(FleetSide.ENEMY, "", FleetGoal.ATTACK, true);

//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.COORDINATED_MANEUVERS, 3);
//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.ELECTRONIC_WARFARE, 3);

        // Set a small blurb for each fleet that shows up on the mission detail and
        // mission results screens to identify each side.
        api.setFleetTagline(FleetSide.PLAYER, "7th Patrol squadron, flying patrol 18-c");
        api.setFleetTagline(FleetSide.ENEMY, "Pirate raiders in the pursuit of plunder");

        // These show up as items in the bulleted list under
        // "Tactical Objectives" on the mission detail screen
        api.addBriefingItem("Rout the Pirate raiding fleet");
        api.addBriefingItem("Destroy the 'Pillager'");

        boolean testMode = false;
        // Set up the player's fleet.  Variant names come from the
        // files in data/variants and data/variants/fighters
        //api.addToFleet(FleetSide.PLAYER, "station_small_Standard", FleetMemberType.SHIP, "Test Station", false);
        if (!testMode) {
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_assault", FleetMemberType.SHIP, "OFS Eber II", true);
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_support_1", FleetMemberType.SHIP, "OFS Mercurial", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_bellerophon_standard", FleetMemberType.SHIP, "OFS Voidclipper", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_bellerophon_standard", FleetMemberType.SHIP, "OFS Attis", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_diomedes_standard", FleetMemberType.SHIP, "OFS Amber", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_sithon_standard", FleetMemberType.SHIP, "OFS Ultraviolet", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_sithon_strike", FleetMemberType.SHIP, "OFS Irrwurz", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_argeus_assault", FleetMemberType.SHIP, "OFS Kobold", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_argeus_assault", FleetMemberType.SHIP, "OFS Geryon", false);

            // Set up the enemy fleet.
            api.addToFleet(FleetSide.ENEMY, "venture_p_Pirate", FleetMemberType.SHIP, "Pillager", false);
            api.addToFleet(FleetSide.ENEMY, "eradicator_pirates_Attack", FleetMemberType.SHIP, "Hungry Raven", false);
            api.addToFleet(FleetSide.ENEMY, "enforcer_Assault", FleetMemberType.SHIP, "Space Pig", false);
            api.addToFleet(FleetSide.ENEMY, "mule_d_pirates_Standard", FleetMemberType.SHIP, "Long Shot", false);
            api.addToFleet(FleetSide.ENEMY, "mule_d_pirates_Smuggler", FleetMemberType.SHIP, "Stick Your Tariff", false);
            api.addToFleet(FleetSide.ENEMY, "shrike_p_Attack", FleetMemberType.SHIP, "Legbiter", false);
            api.addToFleet(FleetSide.ENEMY, "condor_Strike", FleetMemberType.SHIP, "Slinger", false);
            api.addToFleet(FleetSide.ENEMY, "kite_pirates_Raider", FleetMemberType.SHIP, "Don't Shoot Now", false);
            api.addToFleet(FleetSide.ENEMY, "kite_Standard", FleetMemberType.SHIP, "Buzzfly", false);
            api.addToFleet(FleetSide.ENEMY, "kite_Standard", FleetMemberType.SHIP, "Artio", false);
            api.addToFleet(FleetSide.ENEMY, "hound_Standard", FleetMemberType.SHIP, "Burned Old Spacer", false);
            api.addToFleet(FleetSide.ENEMY, "lasher_Assault", FleetMemberType.SHIP, "Tengu", false);


        }

        if (testMode) {
//			FleetMemberAPI member = api.addToFleet(FleetSide.PLAYER, "omen_PD", FleetMemberType.SHIP, "Milk Run", true);
//			member.getCaptain().getStats().setSkillLevel(Skills.IMPACT_MITIGATION, 2);
//			member.getCaptain().getStats().setSkillLevel(Skills.SHIELD_MODULATION, 2);
//			member.getCaptain().getStats().setSkillLevel(Skills.HELMSMANSHIP, 2);

            api.addToFleet(FleetSide.PLAYER, "falcon_Attack", FleetMemberType.SHIP, "Stranger II", true);
            //		PersonAPI person = new AICoreOfficerPluginImpl().createPerson(Commodities.ALPHA_CORE, null, null);
            //		member.setCaptain(person);

            api.addToFleet(FleetSide.ENEMY, "lasher_CS", FleetMemberType.SHIP, "Cherenkov Bloom", false);
            api.addToFleet(FleetSide.ENEMY, "lasher_CS", FleetMemberType.SHIP, null, false);
            api.addToFleet(FleetSide.ENEMY, "lasher_CS", FleetMemberType.SHIP, null, false);

            api.addObjective(0, 4000, BattleObjectives.SENSOR_JAMMER);
            api.addObjective(4000, 0, BattleObjectives.COMM_RELAY);
            api.addObjective(-3000, -2000, BattleObjectives.NAV_BUOY);
        }

        // Set up the map.
        float width = 24000f;
        float height = 18000f;

        if (testMode) {
            width += 4000;
            height += 8000;
        }

        api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);

        float minX = -width/2;
        float minY = -height/2;

        // Add an asteroid field
        api.addAsteroidField(minX, minY + height / 2, 0, 16000f,
                20f, 70f, 75);

        api.addNebula(minX + width * 0.6f - 2000, minY + height * 0.35f, 1000);
        api.addNebula(minX + width * 0.65f - 2000, minY + height * 0.4f, 1200);
        api.addNebula(minX + width * 0.7f - 2000, minY + height * 0.5f, 1750);
        api.addNebula(minX + width * 0.8f - 2000, minY + height * 0.6f, 1000);

        api.addNebula(minX + width * 0.3f - 2000, minY + height * 0.4f, 1000);
        api.addNebula(minX + width * 0.35f - 2000, minY + height * 0.4f, 800);

        api.addNebula(minX + width * 0.5f - 2000, minY + height * 0.7f, 1000);
        api.addNebula(minX + width * 0.55f - 2000, minY + height * 0.7f, 600);

        api.addNebula(minX + width * 0.4f - 2000, minY + height * 0.8f, 1200);
        api.addNebula(minX + width * 0.3f - 2000, minY + height * 0.85f, 1200);


        api.addObjective(minX + width * 0.15f + 3000, minY + height * 0.3f + 1000, "nav_buoy");
        api.addObjective(minX + width * 0.8f - 2000, minY + height * 0.7f - 1000, "comm_relay");

    }

}