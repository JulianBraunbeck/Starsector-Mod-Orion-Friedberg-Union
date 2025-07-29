package data.missions.ofu_arrow_hail;

import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.impl.campaign.ids.BattleObjectives;
import com.fs.starfarer.api.impl.campaign.ids.StarTypes;
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
        api.initFleet(FleetSide.ENEMY, "PLS", FleetGoal.ATTACK, true);

//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.COORDINATED_MANEUVERS, 3);
//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.ELECTRONIC_WARFARE, 3);

        // Set a small blurb for each fleet that shows up on the mission detail and
        // mission results screens to identify each side.
        api.setFleetTagline(FleetSide.PLAYER, "3rd Carrier group with escorts");
        api.setFleetTagline(FleetSide.ENEMY, "Persean League cruiser squadron with mercenary allies");

        // These show up as items in the bulleted list under
        // "Tactical Objectives" on the mission detail screen
        api.addBriefingItem("Defeate the League forces");
        api.addBriefingItem("the 'OFS Lamia' and the 'OFS Cephalus' must survive");

        boolean testMode = false;
        // Set up the player's fleet.  Variant names come from the
        // files in data/variants and data/variants/fighters
        //api.addToFleet(FleetSide.PLAYER, "station_small_Standard", FleetMemberType.SHIP, "Test Station", false);
        if (!testMode) {
            api.addToFleet(FleetSide.PLAYER, "ofu_telemachus_standard", FleetMemberType.SHIP, "OFS Hagen", true);
            api.addToFleet(FleetSide.PLAYER, "ofu_telemachus_strike", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_rhadamanthys_strike", FleetMemberType.SHIP, "OFS Lamia", false).getCaptain().setPersonality(Personalities.CAUTIOUS);;
            api.addToFleet(FleetSide.PLAYER, "ofu_rhadamanthys_strike", FleetMemberType.SHIP, "OFS Cephalus", false).getCaptain().setPersonality(Personalities.CAUTIOUS);;
            api.addToFleet(FleetSide.PLAYER, "drover_Support", FleetMemberType.SHIP, "OFS Novenu", false);
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_support_2", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_support_2", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_sithon_standard", FleetMemberType.SHIP,  false);
            api.addToFleet(FleetSide.PLAYER, "ofu_sithon_strike", FleetMemberType.SHIP,  false);
            api.addToFleet(FleetSide.PLAYER, "lasher_Assault", FleetMemberType.SHIP,  false);
            api.addToFleet(FleetSide.PLAYER, "ofu_diomedes_standard", FleetMemberType.SHIP, false);

            api.defeatOnShipLoss("OFS Lamia");
            api.defeatOnShipLoss("OFS Cephalus");

            // Set up the enemy fleet.
            api.addToFleet(FleetSide.ENEMY, "champion_Elite", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "eagle_Support", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "eagle_Balanced", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "gryphon_DEM", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "eradicator_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "hammerhead_DEM", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "hammerhead_DEM", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "medusa_Starting", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "sunder_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "vigilance_Standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "vigilance_Standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "brawler_Elite", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "wolf_Assault", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "wolf_Strike", FleetMemberType.SHIP, false);


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

        float minX = -width/2;
        float minY = -height/2;

        if (testMode) {
            width += 4000;
            height += 8000;
        }

        for (int i = 0; i < 12; i++) {
            float x = (float) Math.random() * width - width/2;
            float y = (float) Math.random() * height - height/2;
            float radius = 100f + (float) Math.random() * 1000f;
            api.addNebula(x, y, radius);
        }

        api.addObjective(minX + width * 0.8f, minY + height * 0.4f, "sensor_array");
        api.addObjective(minX + width * 0.8f, minY + height * 0.6f, "nav_buoy");
        api.addObjective(minX + width * 0.3f, minY + height * 0.3f, "nav_buoy");
        api.addObjective(minX + width * 0.3f, minY + height * 0.7f, "sensor_array");
        api.addObjective(minX + width * 0.2f, minY + height * 0.5f, "comm_relay");


        api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);


        // Add an asteroid field
        api.addAsteroidField(minX, minY + height / 2, 0, 16000f,
                20f, 70f, 125);


    }

}