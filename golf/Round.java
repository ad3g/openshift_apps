package com.golf;

import java.sql.Date;

public class Round {

	private int rId = 0;
	private Date rDate;
	private String rType = "Individual";
	private String rRainOut = "N";
	
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public String getrRainOut() {
		return rRainOut;
	}
	public void setrRainOut(String rRainOut) {
		this.rRainOut = rRainOut;
	}
	
}
