package data.scripts.plugins;


import java.util.Random;

import com.fs.starfarer.api.campaign.*;

import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.campaign.submarkets.BaseSubmarketPlugin;
import com.fs.starfarer.api.impl.campaign.submarkets.OpenMarketPlugin;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignUIAPI.CoreUITradeMode;
import com.fs.starfarer.api.campaign.econ.CommodityOnMarketAPI;
import com.fs.starfarer.api.campaign.econ.SubmarketAPI;
import com.fs.starfarer.api.util.Highlights;
import com.fs.starfarer.api.util.Misc;

public class OFU_special_market_plugin extends BaseSubmarketPlugin {


	public void init(SubmarketAPI submarket) {
		super.init(submarket);
	}


	public void updateCargoPrePlayerInteraction() {
		float seconds = Global.getSector().getClock().convertToSeconds(sinceLastCargoUpdate);
		//addAndRemoveStockpiledResources(seconds, false, true, true);
		sinceLastCargoUpdate = 0f;

		if (okToUpdateShipsAndWeapons()) {
			sinceSWUpdate = 0f;

			pruneWeapons(0f);

			FleetDataAPI data = cargo.getMothballedShips();
			for (FleetMemberAPI member : data.getMembersListCopy()) {
					data.removeFleetMember(member);
			}
			
			cargo.clear();


			addShip("ofu_hector_Hull", false, 0f);
			addShip("ofu_agamemnon_Hull", false, 0f);
			addShip("ofu_rhadamanthys_Hull", false, 0f);
			addShip("ofu_rhadamanthys_Hull", false, 0f);
			addShip("ofu_telemachus_Hull", false, 0f);
			addShip("ofu_telemachus_Hull", false, 0f);
			addShip("ofu_asbolus_Hull", false, 0f);
			addShip("ofu_asbolus_Hull", false, 0f);
			addShip("ofu_bellerophon_Hull", false, 0f);
			addShip("ofu_bellerophon_Hull", false, 0f);
			addShip("ofu_frigate_1_Hull", false, 0f);
			addShip("ofu_frigate_1_Hull", false, 0f);
			addShip("ofu_frigate_1_Hull", false, 0f);
			addShip("ofu_fr_missile_Hull", false, 0f);
			addShip("ofu_fr_missile_Hull", false, 0f);
			addShip("ofu_fr_missile_Hull", false, 0f);
			addShip("ofu_diomedes_Hull", false, 0f);
			addShip("ofu_diomedes_Hull", false, 0f);
			addShip("ofu_diomedes_Hull", false, 0f);

			cargo.addFighters("ofu_sinterc_wing", 3);
			cargo.addFighters("ofu_fastbomber_wing", 6);
			cargo.addFighters("ofu_rocketftr_wing", 6);
			cargo.addWeapons("ofu_hesniper", 10);
			cargo.addWeapons("ofu_rocketke_launcher", 10);
			cargo.addWeapons("ofu_rocketke_pod", 10);

			cargo.addHullmods("ofu_bombercommand", 1);
		}

		getCargo().sort();
	}

	protected Object writeReplace() {
		if (okToUpdateShipsAndWeapons()) {
			pruneWeapons(0f);
			pruneShips(1f);
			getCargo().getMothballedShips().clear();
		}
		return this;
	}


	public boolean shouldHaveCommodity(CommodityOnMarketAPI com) {
		return !market.isIllegal(com);
	}

	@Override
	public int getStockpileLimit(CommodityOnMarketAPI com) {

		float limit = OpenMarketPlugin.getBaseStockpileLimit(com);

		Random random = new Random(market.getId().hashCode() + submarket.getSpecId().hashCode() + Global.getSector().getClock().getMonth() * 170000);
		limit *= 0.9f + 0.2f * random.nextFloat();

		float sm = market.getStabilityValue() / 10f;
		limit *= (0.25f + 0.75f * sm);

		if (limit < 0) limit = 0;

		return (int) limit;
	}

	/*public static int getApproximateStockpileLimit(CommodityOnMarketAPI com) {

		float limit = OpenMarketPlugin.getBaseStockpileLimit(com);
		return (int) limit;
	}*/


	@Override
	public PlayerEconomyImpactMode getPlayerEconomyImpactMode() {
		return PlayerEconomyImpactMode.PLAYER_SELL_ONLY;
	}


	@Override
	public String getTooltipAppendix(CoreUIAPI ui) {
		if (ui.getTradeMode() == CoreUITradeMode.SNEAK) {
			return "Requires: proper docking authorization (transponder on)";
		}
		return super.getTooltipAppendix(ui);
	}


	@Override
	public Highlights getTooltipAppendixHighlights(CoreUIAPI ui) {
		if (ui.getTradeMode() == CoreUITradeMode.SNEAK) {
			String appendix = getTooltipAppendix(ui);
			if (appendix == null) return null;

			Highlights h = new Highlights();
			h.setText(appendix);
			h.setColors(Misc.getNegativeHighlightColor());
			return h;
		}
		return super.getTooltipAppendixHighlights(ui);
	}

}



