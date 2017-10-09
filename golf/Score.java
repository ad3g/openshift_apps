package com.golf;

public class Score {

	private int sId = 0;
	private int rId = 0;
	private int pId = 0;
	private int sPtsNeeded = 0;
	private int sPtsEarned = 0;
	private String sPaid = "N";
	private int sPtsDiff = 0;
	private int sPtsNextWk = 0;
	private String sClosestTo = "N";
	private double winAmt = 0;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getsPtsNeeded() {
		return sPtsNeeded;
	}
	public void setsPtsNeeded(int sPtsNeeded) {
		this.sPtsNeeded = sPtsNeeded;
	}
	public int getsPtsEarned() {
		return sPtsEarned;
	}
	public void setsPtsEarned(int sPtsEarned) {
		this.sPtsEarned = sPtsEarned;
	}
	public String getsPaid() {
		return sPaid;
	}
	public void setsPaid(String sPaid) {
		this.sPaid = sPaid;
	}
	public int getsPtsDiff() {
		return sPtsDiff;
	}
	public void setsPtsDiff(int sPtsDiff) {
		this.sPtsDiff = sPtsDiff;
	}
	public int getsPtsNextWk() {
		return sPtsNextWk;
	}
	public void setsPtsNextWk(int sPtsNextWk) {
		this.sPtsNextWk = sPtsNextWk;
	}
	public String getsClosestTo() {
		return sClosestTo;
	}
	public void setsClosestTo(String sClosestTo) {
		this.sClosestTo = sClosestTo;
	}
	public double getWinAmt() {
		return winAmt;
	}
	public void setWinAmt(double winAmt) {
		this.winAmt = winAmt;
	}
}
