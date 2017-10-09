package com.nfl;

public class GameStat {

	String Gameid = "N/A";
	String Wk = "N/A";
	String HTeam = "N/A";
	String HScore = "N/A";
	String ATeam = "N/A";
	String AScore = "N/A"; 
	String GameJson = "N/A";
	
	public String getGameid() {
		return Gameid;
	}
	public void setGameid(String gameid) {
		Gameid = gameid;
	}
	public String getWk() {
		return Wk;
	}
	public void setWk(String wk) {
		Wk = wk;
	}
	public String getHTeam() {
		return HTeam;
	}
	public void setHTeam(String hTeam) {
		HTeam = hTeam;
	}
	public String getHScore() {
		return HScore;
	}
	public void setHScore(String hScore) {
		HScore = hScore;
	}
	public String getATeam() {
		return ATeam;
	}
	public void setATeam(String aTeam) {
		ATeam = aTeam;
	}
	public String getAScore() {
		return AScore;
	}
	public void setAScore(String aScore) {
		AScore = aScore;
	}
	public String getGameJson() {
		return GameJson;
	}
	public void setGameJson(String gameJson) {
		GameJson = gameJson;
	}
}
