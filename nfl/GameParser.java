package com.nfl;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class GameParser {

	public GameStat parse(GameStat gs){
		//GameStat gs = new GameStat();
		//gs.setWeek(wk);
		//gs.setGameid(gid);
		JSONObject jsonObject = new JSONObject();
		try 
		{
			if (!gs.getGameJson().equals("Not Found")){
				jsonObject = (JSONObject) JSONValue.parseWithException(gs.getGameJson().toString());
			}
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}		

		if (jsonObject.isEmpty()){

		}
		else
		{
			JSONObject jsonObjectGameid = (JSONObject) jsonObject.get(gs.getGameid());
			JSONObject jsonObjectHome = (JSONObject) jsonObjectGameid.get("home");
			JSONObject jsonObjectAway = (JSONObject) jsonObjectGameid.get("away");
			JSONObject jsonObjectHomeScore = (JSONObject) jsonObjectHome.get("score");
			JSONObject jsonObjectAwayScore = (JSONObject) jsonObjectAway.get("score");
			if (jsonObjectHome.get("abbr").toString().equals(gs.getATeam())){
				gs.setHScore(jsonObjectAwayScore.get("T").toString());
				gs.setAScore(jsonObjectHomeScore.get("T").toString());
			}
			else
			{
				gs.setAScore(jsonObjectAwayScore.get("T").toString());
				gs.setHScore(jsonObjectHomeScore.get("T").toString());
			}
			//gs.setHTeam(jsonObjectHome.get("abbr").toString());
			//gs.setATeam(jsonObjectAway.get("abbr").toString());
			//gs.setHScore(jsonObjectHomeScore.get("T").toString());
			//gs.setAScore(jsonObjectAwayScore.get("T").toString());
		}
		return gs;
	}
}
