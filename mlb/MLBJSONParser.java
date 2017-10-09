package com.mlb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.mlb.ScoresJson;

public class MLBJSONParser {

	private String urlDate = null;
	private String m_URL = "http://gd2.mlb.com/components/game/mlb/";
	private String temp_URL = "";
	private final String defaultJson = "{ \"subject\": \"master_scoreboard_mlb_CCYY_MM_DD\", \"copyright\" : \"Copyright 2014 MLB Advanced Media, L.P.  Use of any content on this page acknowledges agreement to the terms posted here http://gdx.mlb.com/components/copyright.txt\", \"data\" : {\"games\":{\"next_day_date\":\"CCYY-MM-DD\",\"modified_date\":\"CCYY-MM-DDTHH:MM:SSZ\",\"month\":\"MM\",\"year\":\"CCYY\",\"day\":\"DD\"}}}";
	private JSONObject jsonObject = new JSONObject();
	private JSONObject jsonObjectData = new JSONObject();
	private JSONObject jsonObjectGames = new JSONObject();
	private JSONObject jsonObjectGame = new JSONObject();
	private JSONObject jsonObjectGameObject = new JSONObject();
	private JSONArray  jsonArrayGame = new JSONArray();
	private JSONObject jsonObjectGameDetails = new JSONObject();
	private JSONObject jsonObjectGameDetailsStatus = new JSONObject();
	private JSONObject jsonObjectGameDetailsGameNbr = new JSONObject();
	private JSONObject jsonObjectGameDetailsLinescore = new JSONObject();
	private JSONObject jsonObjectGameDetailsLinescoreRuns = new JSONObject();
	private JSONObject jsonObjectGameDetailsLinescoreHits = new JSONObject();
	private JSONObject jsonObjectGameDetailsLinescoreErrors = new JSONObject();
	private JSONObject jsonObjectGameDetailsLinescorexxx = new JSONObject();
	private JSONObject jo = new JSONObject();
	private ScoresJson sj = new ScoresJson();
	
	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public void LoadDB(String newUrlDate) throws NamingException {
		urlDate = newUrlDate;
		setUrlString();

		getMLB_JSONObject();
		deleteScoresForDate();
		parseGameForScores();
	}

	private void deleteScoresForDate() throws NamingException{
		sj.setUrlDate(urlDate);
		sj.deleteScores();		
	}
	
	private void parseGameForScores() throws NamingException {

		/*
		 * Scenarios:
		 * No data found for date (ie. 2013-02-30)		- set default 
		 * Determine if game is Array or Object
		 * Determine if game completed successfully or not (ie. Final or Completed Early)
		 * 		if final or completed early 	- parse values 
		 * 		if not final or completed early - set default
		 */

		//		System.out.println("subject: " + jsonObject.get("subject").toString());
		//		System.out.println("copyright: " + jsonObject.get("copyright").toString());
		//		System.out.println("data: " + jsonObject.get("data").toString());
		if (jsonObject.get("subject").equals("master_scoreboard_mlb_CCYY_MM_DD")){
			//			System.out.println("File not found, default skip processing");
			setScoreJsonDefault();
		}
		else
		{
			jsonObjectData = (JSONObject) jsonObject.get("data");
			jsonObjectGames = (JSONObject) jsonObjectData.get("games");

			/*
			 * Check if game is an array or an object (it'll be an object if there is only a single game on that day)
			 */
			if (jsonObjectGames.get("game") instanceof JSONArray) {
				jsonArrayGame = (JSONArray) jsonObjectGames.get("game");

				for (int i = 0; i < jsonArrayGame.size();i++){
					jsonObjectGameDetails = (JSONObject) jsonArrayGame.get(i);
					jsonObjectGameDetailsStatus = (JSONObject) jsonObjectGameDetails.get("status");
					sj.setGameStatus(jsonObjectGameDetailsStatus.get("status").toString());
					sj.setGameNum(i);
					setScoreJson(isGameFinal());
				}
			}
			else
			{
				jsonObjectGameDetails = (JSONObject) jsonObjectGames.get("game");
				if (jsonObjectGameDetails==null){ 
					sj.setGameStatus("N/A");
					sj.setGameNum(0);
					//setScoreJson(isGameFinal());
					setScoreJsonDefault();
				}	
				else
				{
					jsonObjectGameDetailsStatus = (JSONObject) jsonObjectGameDetails.get("status");
					sj.setGameStatus(jsonObjectGameDetailsStatus.get("status").toString());
					sj.setGameNum(0);
					setScoreJson(isGameFinal());
				}
			}
		}
	}
	
	public GameDetail parseGameDetail(int gameid){
		
		GameDetail gd = new GameDetail();
		ArrayList<String> Hinning = new ArrayList<String>();
		ArrayList<String> Vinning = new ArrayList<String>();
		
		jsonObjectData = (JSONObject) jsonObject.get("data");
		jsonObjectGames = (JSONObject) jsonObjectData.get("games");

		/*
		 * Check if game is an array or an object (it'll be an object if there is only a single game on that day)
		 */
		if (jsonObjectGames.get("game") instanceof JSONArray) {
			jsonArrayGame = (JSONArray) jsonObjectGames.get("game");
			jsonObjectGameDetails = (JSONObject) jsonArrayGame.get(gameid);
		}
		else
		{
			jsonObjectGameDetails = (JSONObject) jsonObjectGames.get("game");
		}
		
		if (jsonObjectGameDetails.containsKey("status")){
			jo = (JSONObject) jsonObjectGameDetails.get("status");
			gd.setStatus(jo.get("status").toString());
			System.out.println("1jo - gd - status: " + gd.getStatus());
		}
		else
		{
			gd.setStatus("N/A");
		}
		System.out.println("2jo - gd - status: " + gd.getStatus());
		
		if (jsonObjectGameDetails.containsKey("home_team_name")){
			gd.setHteam(jsonObjectGameDetails.get("home_team_name").toString());
		}
		else
		{
			gd.setHteam("N/A");
		}
		if (jsonObjectGameDetails.containsKey("away_team_name")){
			gd.setVteam(jsonObjectGameDetails.get("away_team_name").toString());
		}
		else
		{
			gd.setVteam("N/A");
		}

		/*
		 * Preview or Cancelled game setup
		 */
		if (gd.getStatus().equals("Preview") || gd.getStatus().equals("Cancelled") || gd.getStatus().equals("N/A")){
//			if (jsonObjectGameDetails.containsKey("home_probable_pitcher")){
//				jo = (JSONObject) jsonObjectGameDetails.get("home_probable_pitcher");
//				gd.setHprobablePitcher(jo.get("home_probable_pitcher").toString());
//			}
//			else
//			{
				gd.setHprobablePitcher("N/A");
//			}
//			if (jsonObjectGameDetails.containsKey("away_probable_pitcher")){
//				jo = (JSONObject) jsonObjectGameDetails.get("away_probable_pitcher");
//				gd.setVprobablePitcher(jo.get("away_probable_pitcher").toString());
//			}
//			else
//			{
				gd.setVprobablePitcher("N/A");
//			}
			gd.setHscore("0");
			gd.setVscore("0");
			gd.setHhits("0");
			gd.setVhits("0");
			gd.setHerrors("0");
			gd.setVerrors("0");
			gd.setWinningPitcher("N/A");
			gd.setLosingPitcher("N/A");
			gd.setSavingPitcher("N/A");
			for (int i = 0; i < 10;i++){
				Hinning.add("0");
				Vinning.add("0");
			}
			gd.setHscores(Hinning);
			gd.setVscores(Vinning);
			return gd;
		}
		/*
		 * In Progress game setup
		 */
		if (gd.getStatus().equals("In Progress")){
			jsonObjectGameDetailsLinescore = (JSONObject) jsonObjectGameDetails.get("linescore");
			if (jsonObjectGameDetailsLinescore.containsKey("inning")){
				jsonObjectGameDetailsLinescoreRuns = (JSONObject) jsonObjectGameDetailsLinescore.get("r");
				jsonObjectGameDetailsLinescoreErrors = (JSONObject) jsonObjectGameDetailsLinescore.get("e");
				jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectGameDetailsLinescore.get("h");
				gd.setHscore(jsonObjectGameDetailsLinescoreRuns.get("home").toString());
				gd.setVscore(jsonObjectGameDetailsLinescoreRuns.get("away").toString());
				gd.setHhits(jsonObjectGameDetailsLinescoreHits.get("home").toString());
				gd.setVhits(jsonObjectGameDetailsLinescoreHits.get("away").toString());
				gd.setHerrors(jsonObjectGameDetailsLinescoreErrors.get("home").toString());
				gd.setVerrors(jsonObjectGameDetailsLinescoreErrors.get("away").toString());
				
				if (jsonObjectGameDetailsLinescore.containsKey("inning")){
					jsonObjectGameDetailsLinescoreRuns = (JSONObject) jsonObjectGameDetailsLinescore.get("r");
					jsonObjectGameDetailsLinescoreErrors = (JSONObject) jsonObjectGameDetailsLinescore.get("e");
					jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectGameDetailsLinescore.get("h");
					gd.setHscore(jsonObjectGameDetailsLinescoreRuns.get("home").toString());
					gd.setVscore(jsonObjectGameDetailsLinescoreRuns.get("away").toString());
					gd.setHhits(jsonObjectGameDetailsLinescoreHits.get("home").toString());
					gd.setVhits(jsonObjectGameDetailsLinescoreHits.get("away").toString());
					gd.setHerrors(jsonObjectGameDetailsLinescoreErrors.get("home").toString());
					gd.setVerrors(jsonObjectGameDetailsLinescoreErrors.get("away").toString());
					JSONArray jsonObjectInningArray = new JSONArray();
					jsonObjectInningArray = (JSONArray) jsonObjectGameDetailsLinescore.get("inning");
					for (int i = 0; i < jsonObjectInningArray.size();i++){
						jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectInningArray.get(i);
						if (jsonObjectGameDetailsLinescoreHits.containsKey("home")){
							Hinning.add(jsonObjectGameDetailsLinescoreHits.get("home").toString());
							//System.out.println("idx: " + i + "inning home: " + jsonObjectGameDetailsLinescoreHits.get("home").toString());
						}
						gd.setHscores(Hinning);
						if (jsonObjectGameDetailsLinescoreHits.containsKey("away")){
							Vinning.add(jsonObjectGameDetailsLinescoreHits.get("away").toString());
							//System.out.println("idx: " + i + "inning away: " + jsonObjectGameDetailsLinescoreHits.get("away").toString());
						}
						gd.setVscores(Vinning);
					}
				}
				else
				{
					gd.setHscore("0");
					gd.setVscore("0");
					gd.setHhits("0");
					gd.setVhits("0");
					gd.setHerrors("0");
					gd.setVerrors("0");
					gd.setWinningPitcher("N/A");
					gd.setLosingPitcher("N/A");
					gd.setSavingPitcher("N/A");
					for (int i = 0; i < 10;i++){
						Hinning.add("0");
						Vinning.add("0");
					}
					gd.setHscores(Hinning);
					gd.setVscores(Vinning);
				}
			}
			else
			{
				gd.setHscore("0");
				gd.setVscore("0");
				gd.setHhits("0");
				gd.setVhits("0");
				gd.setHerrors("0");
				gd.setVerrors("0");
				gd.setWinningPitcher("N/A");
				gd.setLosingPitcher("N/A");
				gd.setSavingPitcher("N/A");
				for (int i = 0; i < 10;i++){
					Hinning.add("0");
					Vinning.add("0");
				}
				gd.setHscores(Hinning);
				gd.setVscores(Vinning);
			}
			gd.setWinningPitcher("N/A");
			gd.setLosingPitcher("N/A");
			gd.setSavingPitcher("N/A");
			gd.setHprobablePitcher("N/A");
			gd.setVprobablePitcher("N/A");
			return gd;
		}
		/*
		 * Final game setup
		 */
		if (gd.getStatus().equals("Final") || gd.getStatus().equals("Completed Early") || gd.getStatus().equals("Game Over")){
			jsonObjectGameDetailsLinescore = (JSONObject) jsonObjectGameDetails.get("linescore");
			if (jsonObjectGameDetails.containsKey("winning_pitcher")){
				jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectGameDetails.get("winning_pitcher");
				gd.setWinningPitcher(jsonObjectGameDetailsLinescoreHits.get("last").toString());
			}
			else
			{
				gd.setWinningPitcher("N/A");
			}

			if (jsonObjectGameDetails.containsKey("losing_pitcher")){
				jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectGameDetails.get("losing_pitcher");
				gd.setLosingPitcher(jsonObjectGameDetailsLinescoreHits.get("last").toString());
			}
			else
			{
				gd.setLosingPitcher("N/A");
			}

			if (jsonObjectGameDetails.containsKey("save_pitcher")){
				jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectGameDetails.get("save_pitcher");
				gd.setSavingPitcher(jsonObjectGameDetailsLinescoreHits.get("last").toString());
			}
			else
			{
				gd.setSavingPitcher("N/A");
			}

			if (jsonObjectGameDetailsLinescore.containsKey("inning")){
				jsonObjectGameDetailsLinescoreRuns = (JSONObject) jsonObjectGameDetailsLinescore.get("r");
				jsonObjectGameDetailsLinescoreErrors = (JSONObject) jsonObjectGameDetailsLinescore.get("e");
				jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectGameDetailsLinescore.get("h");
				gd.setHscore(jsonObjectGameDetailsLinescoreRuns.get("home").toString());
				gd.setVscore(jsonObjectGameDetailsLinescoreRuns.get("away").toString());
				gd.setHhits(jsonObjectGameDetailsLinescoreHits.get("home").toString());
				gd.setVhits(jsonObjectGameDetailsLinescoreHits.get("away").toString());
				gd.setHerrors(jsonObjectGameDetailsLinescoreErrors.get("home").toString());
				gd.setVerrors(jsonObjectGameDetailsLinescoreErrors.get("away").toString());
				JSONArray jsonObjectInningArray = new JSONArray();
				jsonObjectInningArray = (JSONArray) jsonObjectGameDetailsLinescore.get("inning");
				for (int i = 0; i < jsonObjectInningArray.size();i++){
					jsonObjectGameDetailsLinescoreHits = (JSONObject) jsonObjectInningArray.get(i);
					if (jsonObjectGameDetailsLinescoreHits.containsKey("home")){
						Hinning.add(jsonObjectGameDetailsLinescoreHits.get("home").toString());
						//System.out.println("idx: " + i + "inning home: " + jsonObjectGameDetailsLinescoreHits.get("home").toString());
					}
					gd.setHscores(Hinning);
					if (jsonObjectGameDetailsLinescoreHits.containsKey("away")){
						Vinning.add(jsonObjectGameDetailsLinescoreHits.get("away").toString());
						//System.out.println("idx: " + i + "inning away: " + jsonObjectGameDetailsLinescoreHits.get("away").toString());
					}
					gd.setVscores(Vinning);
				}
			}
			else
			{
				gd.setHscore("0");
				gd.setVscore("0");
				gd.setHhits("0");
				gd.setVhits("0");
				gd.setHerrors("0");
				gd.setVerrors("0");
				gd.setWinningPitcher("N/A");
				gd.setLosingPitcher("N/A");
				gd.setSavingPitcher("N/A");
				for (int i = 0; i < 10;i++){
					Hinning.add("0");
					Vinning.add("0");
				}
				gd.setHscores(Hinning);
				gd.setVscores(Vinning);
			}
			
			return gd;
		}		

		return gd;
	}
	private ScoresJson setScoreJsonDefault()  throws NamingException {

		sj.setUrlDate(urlDate);
		sj.setUrlString(temp_URL);
		sj.setGameNum(0);
		sj.setGameType("N/A");
		sj.setScoreJson(jsonObject.toJSONString());
		sj.sethTeam("N/A");		
		sj.sethScore(0);
		sj.setvTeam("N/A");
		sj.setvScore(0);
		sj.setGameStatus("N/A");
		sj.persist();
		
		return sj;
		
	}
	private boolean isGameFinal() {
		boolean bRtn = true;
		
		if (sj.getGameStatus().equals("Final") || sj.getGameStatus().equals("Completed Early")){
			bRtn = true;
		}
		else
		{
			bRtn = false;
		}
		
		return bRtn;
	}

	private void setScoreJson(boolean bComplete)  throws NamingException {

		sj.setUrlDate(urlDate);
		sj.setUrlString(temp_URL);
		sj.setGameType(jsonObjectGameDetails.get("game_type").toString());
		sj.setScoreJson(jsonObject.toJSONString());
		sj.sethTeam(jsonObjectGameDetails.get("home_team_name").toString());
		sj.setvTeam(jsonObjectGameDetails.get("away_team_name").toString());
		if (bComplete){
			jsonObjectGameDetailsLinescore = (JSONObject) jsonObjectGameDetails.get("linescore");
			jsonObjectGameDetailsLinescoreRuns = (JSONObject) jsonObjectGameDetailsLinescore.get("r");
			sj.sethScore(Integer.parseInt(jsonObjectGameDetailsLinescoreRuns.get("home").toString()));
			sj.setvScore(Integer.parseInt(jsonObjectGameDetailsLinescoreRuns.get("away").toString()));
		}
		else
		{
			sj.sethScore(0);
			sj.setvScore(0);
		}
		sj.persist();
		
	}
	private void setUrlString(){

		temp_URL = m_URL + "year_" + urlDate.substring(0,4) + "/month_" + urlDate.substring(5,7) + "/day_" + urlDate.substring(8,10) + "/master_scoreboard.json";

	}
	private void getMLB_JSONObject() {

		jsonObject = null;

		String genreJson = null;
		try 
		{
			genreJson = IOUtils.toString(new URL(temp_URL));
		}
		catch (FileNotFoundException e) 
		{
			genreJson = defaultJson;
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			jsonObject = (JSONObject) JSONValue.parseWithException(genreJson);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}		
	}
}