package com.sb;

import java.util.ArrayList;

public class Away {

	String abbr = "";
	String to = "";
	String players = "";
	Score score = new Score();
	ArrayList<Stats> lStats = new ArrayList<Stats>();
	
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public ArrayList<Stats> getlStats() {
		return lStats;
	}
	public void setlStats(ArrayList<Stats> lStats) {
		this.lStats = lStats;
	}
}
