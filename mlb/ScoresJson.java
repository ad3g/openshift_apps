package com.mlb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class ScoresJson {

	private String urlDate		= "";
	private String urlString	= "";
	private int gameNum  		= 0;
	private String gameType  	= "";
	private String scoreJson  	= "";
	private String hTeam		= "";
	private int hScore			= 0;
	private String vTeam		= "";
	private int vScore			= 0;
	private String gameStatus	= "";
	
	public String getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}
	public String gethTeam() {
		return hTeam;
	}
	public void sethTeam(String hTeam) {
		this.hTeam = hTeam;
	}
	public String getvTeam() {
		return vTeam;
	}
	public void setvTeam(String vTeam) {
		this.vTeam = vTeam;
	}
	public int gethScore() {
		return hScore;
	}
	public void sethScore(int hScore) {
		this.hScore = hScore;
	}
	public int getvScore() {
		return vScore;
	}
	public void setvScore(int vScore) {
		this.vScore = vScore;
	}
	public String getUrlDate() {
		return urlDate;
	}
	public void setUrlDate(String urlDate) {
		this.urlDate = urlDate;
	}
	public String getUrlString() {
		return urlString;
	}
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
	public int getGameNum() {
		return gameNum;
	}
	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getScoreJson() {
		return scoreJson;
	}
	public void setScoreJson(String scoreJson) {
		this.scoreJson = scoreJson;
	}
	public void deleteScores() throws NamingException {
//		System.out.println("ScoresJson, deleteScores, urlDate: " + urlDate);

		String sql = "DELETE FROM apps.mlb_scores WHERE urlDate = ?";

		PreparedStatement pstmt = null;

		Statement stmt;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, urlDate);

			pstmt.executeUpdate();

			pstmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		finally 
		{
		}	
	}	

	public void persist() throws NamingException {
//		System.out.println("ScoresJson, persist, urlDate: " + urlDate + " gameNum: " + gameNum);

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.mlb_scores (urlDate, urlString, gameNum, gameType, scorejson, hTeam, hScore, vTeam, vScore, gameStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, urlDate);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, urlString);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(3, gameNum);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(4, gameType);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(5, scoreJson);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(6, hTeam);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(7, hScore);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(8, vTeam);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(9, vScore);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(10, gameStatus);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		
		try {
			int iCount = pstmt.executeUpdate();

			pstmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
		}		
	}
}
