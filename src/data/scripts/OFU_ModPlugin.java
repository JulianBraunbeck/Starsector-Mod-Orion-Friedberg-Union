package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.characters.FullName;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.impl.campaign.ids.Ranks;
import com.fs.starfarer.api.impl.campaign.ids.Skills;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;

public class OFU_ModPlugin extends BaseModPlugin {

    @Override
    public void onNewGameAfterEconomyLoad() {

        MarketAPI special_market = Global.getSector().getEconomy().getMarket("agreus");

        //special_market.addSubmarket(Submarkets.GENERIC_MILITARY);
        //special_market.addSubmarket("generic_military");
        special_market.addSubmarket("ofu_market_special");
    }

}
