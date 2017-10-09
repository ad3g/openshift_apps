package com.nfl;

public class UpdInfo {

	String lastUpdateTm = "";
	String nextUpdateTm = "";
	boolean updData = false;
	
	public String getLastUpdateTm() {
		return lastUpdateTm;
	}
	public void setLastUpdateTm(String lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}
	public String getNextUpdateTm() {
		return nextUpdateTm;
	}
	public void setNextUpdateTm(String nextUpdateTm) {
		this.nextUpdateTm = nextUpdateTm;
	}
	public boolean isUpdData() {
		return updData;
	}
	public void setUpdData(boolean updData) {
		this.updData = updData;
	}
	

}
