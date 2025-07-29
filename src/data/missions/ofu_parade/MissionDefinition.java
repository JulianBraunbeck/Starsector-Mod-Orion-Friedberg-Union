package data.missions.ofu_parade;

import com.fs.starfarer.api.fleet.FleetGoal;
import com.fs.starfarer.api.fleet.FleetMemberType;
import com.fs.starfarer.api.impl.campaign.ids.BattleObjectives;
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


        //try to make the enemy fleet never retreat
        api.getContext().aiRetreatAllowed = false;
        api.getContext().fightToTheLast = true;

//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.COORDINATED_MANEUVERS, 3);
//		api.getDefaultCommander(FleetSide.PLAYER).getStats().setSkillLevel(Skills.ELECTRONIC_WARFARE, 3);

        // Set a small blurb for each fleet that shows up on the mission detail and
        // mission results screens to identify each side.
        api.setFleetTagline(FleetSide.PLAYER, "Assembled Parade Squadron");
        api.setFleetTagline(FleetSide.ENEMY, "Scrap Flotilla");

        // These show up as items in the bulleted list under
        // "Tactical Objectives" on the mission detail screen
        api.addBriefingItem("Display the Firepower of the Union fleet");

        boolean testMode = false;
        // Set up the player's fleet.  Variant names come from the
        // files in data/variants and data/variants/fighters
        //api.addToFleet(FleetSide.PLAYER, "station_small_Standard", FleetMemberType.SHIP, "Test Station", false);
        if (!testMode) {
            api.addToFleet(FleetSide.PLAYER, "ofu_hector_standard", FleetMemberType.SHIP, true);
            api.addToFleet(FleetSide.PLAYER, "ofu_agamemnon_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_rhadamanthys_strike", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_telemachus_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_asbolus_support_1", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_bellerophon_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_diomedes_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_sithon_standard", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.PLAYER, "ofu_argeus_assault", FleetMemberType.SHIP, false);

            // Set up the enemy fleet.
            api.addToFleet(FleetSide.ENEMY, "venture_scrap", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "venture_scrap", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "venture_scrap", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "venture_scrap", FleetMemberType.SHIP, false);
            api.addToFleet(FleetSide.ENEMY, "venture_scrap", FleetMemberType.SHIP, false);


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
        float width = 16000f;
        float height = 12000f;

        if (testMode) {
            width += 4000;
            height += 8000;
        }

        api.initMap((float)-width/2f, (float)width/2f, (float)-height/2f, (float)height/2f);

        float minX = -width/2;
        float minY = -height/2;


    }

}