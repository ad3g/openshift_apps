package com.golf;

public class Winner {

	private int wId = 0;
	private int rId = 0;
	private int pId = 0;
	private double wAmt = 0;
	private String wType = "1st";
	
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
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
	public double getwAmt() {
		return wAmt;
	}
	public void setwAmt(double wAmt) {
		this.wAmt = wAmt;
	}
	public String getwType() {
		return wType;
	}
	public void setwType(String wType) {
		this.wType = wType;
	}
}
