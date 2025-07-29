package data.missions.ofu_lions_roar;

import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.impl.campaign.ids.BattleObjectives;
import com.fs.starfarer.api.impl.campaign.ids.Personalities;
import com.fs.starfarer.api.mission.FleetSide;
import com.fs.starfarer.api.mission.MissionDefinitionAPI;
import com.fs.starfarer.api.mission.MissionDefinitionPlugin;

public class MissionDefinition implements MissionDefinitionPlugin {

    public void defineMission(MissionDefinitionAPI api) {

        // Set up the fleets so we can add ships and fighter wings to them.
        // In this scenario, the fleets are attacking each other, but
        // in other scenarios, a fleet may be defending or trying to escape
        api.initFleet(FleetSide.PLAYER, "OFS", FleetGoal.ATTACK, false);
        api.initFleet(FleetSide.ENEMY, "LGS", FleetGoal.ATTACK, true);

//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.COORDINATED_MANEUVERS, 3);
//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.ELECTRONIC_WARFARE, 3);

        // Set a small blurb for each fleet that shows up on the mission detail and
        // mission results screens to identify each side.
        api.setFleetTagline(FleetSide.PLAYER, "1st Union Vanguard Squadron");
        api.setFleetTagline(FleetSide.ENEMY, "2nd Lion's Guard Armada");

        // These show up as items in the bulleted list under
        // "Tactical Objectives" on the mission detail screen
        api.addBriefingItem("Defeate the Diktat forces");
        api.addBriefingItem("the 'OFS Sirius' must survive");

        boolean testMode = false;
        // Set up the player's fleet.  Variant names come from the
        // files in data/variants and data/variants/fighters
        //api.addToFleet(FleetSide.PLAYER, "station_small_Standard", FleetMemberType.SHIP, "Test Station", false);
        if (!testMode) {
            api.addToFleet(FleetSide.PLAYER, "ofu_hector_standard", FleetMemberType.SHIP, "OFS Sirius", true);
            api.addToFleet(FleetSide.PLAYER, "ofu_agamemnon_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_agamemnon_standard", FleetMemberType.SHIP,false);
            api.addToFleet(FleetSide.PLAYER, "ofu_telemachus_strike", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_bellerophon_support", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_bellerophon_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_support_1", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_support_1", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_sithon_standard", FleetMemberType.SHIP,  false);
            api.addToFleet(FleetSide.PLAYER, "ofu_diomedes_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_argeus_assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_argeus_assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_argeus_assault", FleetMemberType.SHIP, false);

            api.defeatOnShipLoss("OFS Sirius");

            // Set up the enemy fleet.
            api.addToFleet(FleetSide.ENEMY, "executor_Elite", FleetMemberType.SHIP, "LGS Lion's Pride", false);
            api.addToFleet(FleetSide.ENEMY, "executor_Elite", FleetMemberType.SHIP, "LGS Allegiant Ultimus", false);
            api.addToFleet(FleetSide.ENEMY, "eagle_LG_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "eagle_LG_Support", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "eagle_LG_Support", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "falcon_LG_CS", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "hammerhead_LG_Elite", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "hammerhead_LG_Balanced", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "hammerhead_LG_Balanced", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "sunder_LG_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "sunder_LG_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "brawler_LG_Elite", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "brawler_LG_Elite", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "brawler_LG_Elite", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "centurion_LG_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "centurion_LG_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "centurion_LG_Assault", FleetMemberType.SHIP, false);


        }

        // Set up the map.
        float width = 24000f;
        float height = 18000f;

        float minX = -width/2;
        float minY = -height/2;

        for (int i = 0; i < 48; i++) {
            float x = (float) Math.random() * width - width/2;
            float y = (float) Math.random() * height - height/2;
            float radius = 300f + (float) Math.random() * 700f;
            api.addNebula(x, y, radius);
        }

        api.addObjective(minX + width * 0.5f, minY + height * 0.5f, "comm_relay");
        api.addObjective(minX + width * 0.5f, minY + height * 0.8f, "nav_buoy");
        api.addObjective(minX + width * 0.5f, minY + height * 0.2f, "nav_buoy");
        api.addObjective(minX + width * 0.3f, minY + height * 0.65f, "sensor_array");
        api.addObjective(minX + width * 0.7f, minY + height * 0.35f, "sensor_array");


        api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);


        // Add an asteroid field
        // api.addAsteroidField(minX, minY + height / 2, 0, 16000f,
        //        20f, 70f, 125);


    }

}