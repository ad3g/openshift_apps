package com.mlb;

import java.util.ArrayList;

public class GameDetail {

	private String hteam = "N/A";
	private String hscore = "0";
	private String herrors = "0";
	private String hhits = "0";
	private ArrayList<String> hscores = null;
	private String vteam = "N/A";
	private String vscore = "0";
	private String vhits = "0";
	private String verrors = "0";
	private ArrayList<String> vscores = null;
	private String winningPitcher = "N/A";
	private String losingPitcher = "N/A";
	private String savingPitcher = "N/A";
	private String status = "N/A";
	private String hprobablePitcher = "N/A";
	private String vprobablePitcher = "N/A";

	public String getHteam() {
		return hteam;
	}
	public void setHteam(String hteam) {
		this.hteam = hteam;
	}
	public String getHscore() {
		return hscore;
	}
	public void setHscore(String hscore) {
		this.hscore = hscore;
	}
	public String getHerrors() {
		return herrors;
	}
	public void setHerrors(String herrors) {
		this.herrors = herrors;
	}
	public String getHhits() {
		return hhits;
	}
	public void setHhits(String hhits) {
		this.hhits = hhits;
	}
	public ArrayList<String> getHscores() {
		return hscores;
	}
	public void setHscores(ArrayList<String> hscores) {
		this.hscores = hscores;
	}
	public String getVteam() {
		return vteam;
	}
	public void setVteam(String vteam) {
		this.vteam = vteam;
	}
	public String getVscore() {
		return vscore;
	}
	public void setVscore(String vscore) {
		this.vscore = vscore;
	}
	public String getVhits() {
		return vhits;
	}
	public void setVhits(String vhits) {
		this.vhits = vhits;
	}
	public String getVerrors() {
		return verrors;
	}
	public void setVerrors(String verrors) {
		this.verrors = verrors;
	}
	public ArrayList<String> getVscores() {
		return vscores;
	}
	public void setVscores(ArrayList<String> vscores) {
		this.vscores = vscores;
	}
	public String getWinningPitcher() {
		return winningPitcher;
	}
	public void setWinningPitcher(String winningPitcher) {
		this.winningPitcher = winningPitcher;
	}
	public String getLosingPitcher() {
		return losingPitcher;
	}
	public void setLosingPitcher(String losingPitcher) {
		this.losingPitcher = losingPitcher;
	}
	public String getSavingPitcher() {
		return savingPitcher;
	}
	public void setSavingPitcher(String savingPitcher) {
		this.savingPitcher = savingPitcher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHprobablePitcher() {
		return hprobablePitcher;
	}
	public void setHprobablePitcher(String hprobablePitcher) {
		this.hprobablePitcher = hprobablePitcher;
	}
	public String getVprobablePitcher() {
		return vprobablePitcher;
	}
	public void setVprobablePitcher(String vprobablePitcher) {
		this.vprobablePitcher = vprobablePitcher;
	}
}
