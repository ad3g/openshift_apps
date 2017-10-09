package com.sb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.naming.NamingException;
import com.common.MVDBHelper;

public class Game {

	public String gameid = "";
	public String NFCTeam = "Seatle Seahawks";
	public String AFCTeam = "New England Patriots";
	public String NFCNumbers1 = "";
	public String AFCNumbers1 = "";
	public String NFCNumbers2 = "";
	public String AFCNumbers2 = "";
	public String PlayerNumbers = "";
	public String NFCAbbr = "";
	public String AFCAbbr = "";
	
	public void assignNumbers() throws NamingException {
		
		System.out.println("Game, assignNumbers");
		List<String> sNFCNumbers1 = GetList(10);
		SuffleList(sNFCNumbers1);
		NFCNumbers1 = sNFCNumbers1.toString().replace("[","").replace("]","");
		System.out.println("assignNumbers, NFCNumbers1: " + NFCNumbers1);

		List<String> sNFCNumbers2 = GetList(10);
		SuffleList(sNFCNumbers2);
		NFCNumbers2 = sNFCNumbers2.toString().replace("[","").replace("]","");
		System.out.println("assignNumbers, NFCNumbers2: " + NFCNumbers2);

		List<String> sAFCNumbers1 = GetList(10);
		SuffleList(sAFCNumbers1);
		AFCNumbers1 = sAFCNumbers1.toString().replace("[","").replace("]","");
		System.out.println("assignNumbers, AFCNumbers1: " + AFCNumbers1);
		
		List<String> sAFCNumbers2 = GetList(10);
		SuffleList(sAFCNumbers2);
		AFCNumbers2 = sAFCNumbers2.toString().replace("[","").replace("]","");
		System.out.println("assignNumbers, AFCNumbers2: " + AFCNumbers2);
		
		List<String> sPlayerNumbers = GetList(100);
		SuffleList(sPlayerNumbers);
		PlayerNumbers = sPlayerNumbers.toString().replace("[","").replace("]","");
		System.out.println("assignNumbers, PlayerNumbers: " + PlayerNumbers);

		updateGame();
		System.out.println("Game, After updateGame, assignNumbers");
		
	}
	private void updateGame() throws NamingException {
		System.out.println("Game, updateGame");

		String sql = "UPDATE apps.SB_GAME SET NFCNUMBERS1 = ?, AFCNUMBERS1 = ?, NFCNUMBERS2 = ?, AFCNUMBERS2 = ?, PLAYERNUMBERS = ?";
		System.out.println("Game, updateGame, sql: " + sql);
//		MVDBHelper dbh = new MVDBHelper();
//		Connection conn = null;
//		conn = dbh.getLocalConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, NFCNumbers1);
			pstmt.setString(2, AFCNumbers1);
			pstmt.setString(3, NFCNumbers2);
			pstmt.setString(4, AFCNumbers2);
			pstmt.setString(5, PlayerNumbers);
			
			pstmt.executeUpdate();

			pstmt.close();
			//conn.close();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		finally 
		{
//			try {
//				if (conn != null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				e.printStackTrace();
//			}
		}	
	}	

	private static List GetList(int sz) {
        
        List l = new ArrayList<String>();
        for (int i = 0; i < sz;i++){
               l.add(i);
        }
        return l; 
	}
	private static List SuffleList(List lToShuffle) {
        
        Collections.shuffle(lToShuffle);
        return lToShuffle;
	}

	public void getGame() throws NamingException {
		System.out.println("Game, getGame");

		String sql = "SELECT NFCTEAM, AFCTEAM, NFCNUMBERS1, AFCNUMBERS1, NFCNUMBERS2, AFCNUMBERS2, PLAYERNUMBERS, GAMEID, NFCABBR, AFCABBR FROM apps.SB_GAME";
		System.out.println("Game, getGame, sql: " + sql);
		
//		MVDBHelper dbh = new MVDBHelper();
//		Connection conn = null;
//		conn = dbh.getLocalConnection();
		PreparedStatement pstmt = null;

		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				setNFCTeam(rs.getString(1));
				setAFCTeam(rs.getString(2));
				setNFCNumbers1(rs.getString(3));
				setAFCNumbers1(rs.getString(4));
				setNFCNumbers2(rs.getString(5));
				setAFCNumbers2(rs.getString(6));
				setPlayerNumbers(rs.getString(7));
				setGameid(rs.getString(8));
				setNFCAbbr(rs.getString(9));
				setAFCAbbr(rs.getString(10));
			}

			pstmt.close();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		finally 
		{
//			try {
//				if (conn != null)
//					conn.close();
//			} 
//			catch (Exception e) {
//				e.printStackTrace();
//			}
		}	
		System.out.println("Game, getGame, done, NFCTEAM: " + NFCTeam + " AFCTEAM:" + AFCTeam);
	}	

	public String getNFCTeam() {
		return NFCTeam;
	}
	public void setNFCTeam(String nFCTeam) {
		NFCTeam = nFCTeam;
	}
	public String getAFCTeam() {
		return AFCTeam;
	}
	public void setAFCTeam(String aFCTeam) {
		AFCTeam = aFCTeam;
	}
	public String getNFCNumbers1() {
		return NFCNumbers1;
	}
	public void setNFCNumbers1(String nFCNumbers1) {
		NFCNumbers1 = nFCNumbers1;
	}
	public String getAFCNumbers1() {
		return AFCNumbers1;
	}
	public void setAFCNumbers1(String aFCNumbers1) {
		AFCNumbers1 = aFCNumbers1;
	}
	public String getNFCNumbers2() {
		return NFCNumbers2;
	}
	public void setNFCNumbers2(String nFCNumbers2) {
		NFCNumbers2 = nFCNumbers2;
	}
	public String getAFCNumbers2() {
		return AFCNumbers2;
	}
	public void setAFCNumbers2(String aFCNumbers2) {
		AFCNumbers2 = aFCNumbers2;
	}
	public String getPlayerNumbers() {
		return PlayerNumbers;
	}
	public void setPlayerNumbers(String playerNumbers) {
		PlayerNumbers = playerNumbers;
	}
	public String getGameid() {
		return gameid;
	}
	public void setGameid(String gameid) {
		this.gameid = gameid;
	}
	public String getNFCAbbr() {
		return NFCAbbr;
	}
	public void setNFCAbbr(String nFCAbbr) {
		NFCAbbr = nFCAbbr;
	}
	public String getAFCAbbr() {
		return AFCAbbr;
	}
	public void setAFCAbbr(String aFCAbbr) {
		AFCAbbr = aFCAbbr;
	}
	public boolean numbersLoaded() {
		boolean bRtn = true;
		
		if (PlayerNumbers==null || PlayerNumbers.equals("")){
			bRtn = false;
		}
		else
		{
			bRtn = true;
		}
		return bRtn;
	}	
}
