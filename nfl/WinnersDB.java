package com.nfl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class WinnersDB {

	private static ArrayList<Winners> getListOfWinners(String yr, String seas) throws NamingException {
		ArrayList<Winners> lRtn = new ArrayList<Winners>();
		//System.out.println("WinnersDB, getListOfWinners");
		String sql = "SELECT `Player`, `Wk`, `Amt` FROM `apps`.`nfl_winners` where yr = '" + yr + "' and season = '" + seas + "' order by wk * 1, player";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("WinnersDB, getListOfWinners within select");
				Winners w = new Winners();
				w.setPlayer(rs.getString("Player"));
				w.setSeas(seas);
				w.setYr(yr);
				w.setWk(rs.getString("Wk"));
				w.setAmt(rs.getString("Amt"));
				lRtn.add(w);
			}

			rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
	    finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lRtn;
	}

	public static String renderWinners(String yr, String seas) throws NamingException{
		String sRtn = "";
				
		ArrayList<Winners> lW = new ArrayList<Winners>();
		lW = getListOfWinners(yr, seas);

		sRtn = sRtn + "<div><center><font size=\"18\">Winners</font></center>";
		sRtn = sRtn + "<table class=\"table table-striped table-bordered text-center \"><thead><tr><th class=\" text-center \">Player Name</th><th class=\" text-center \">Week</th><th class=\" text-center \">Amount</th>";
		sRtn = sRtn + "</tr></thead><tbody>";
		
		for (int i = 0;i < lW.size();i++){
			//Winners w = new Winners();
			//w = ;
			sRtn = sRtn + "<tr>";
			sRtn = sRtn + "<td align=\"center\" >" + lW.get(i).getPlayer() + "</td>";
			sRtn = sRtn + "<td align=\"center\" >" + lW.get(i).getWk() + "</td>";
			sRtn = sRtn + "<td align=\"center\" >$" + lW.get(i).getAmt() + "</td>";
			sRtn = sRtn + "</tr>";
		}

		sRtn = sRtn + "</tbody></table></div>";
		sRtn = sRtn + "<br>";
		
		return sRtn;

	}
	public static void deleteWinners(String yr, String seas) throws NamingException {
		String sql = "DELETE FROM `apps`.`nfl_winners` where yr = ? and season = ?";
		PreparedStatement pstmt = null;
		Statement stmt;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);

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
	public static void updateWinnersAmt(String yr, String seas, String wk, Double amt) throws NamingException{
		
		String sql = "update `apps`.`nfl_winners` set Amt = ? Where yr = ? and season = ? and wk = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setDouble(1, amt);
			pstmt.setString(2, yr);
			pstmt.setString(3, seas);
			pstmt.setString(4, wk);
			
			int iUpd = pstmt.executeUpdate();

		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
	    finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertWinners(String yr, String seas, String wk, String player) throws NamingException{
		PreparedStatement pstmt = null;
		String inssql = "INSERT INTO apps.nfl_winners (Yr, Season, Wk, Player, Amt) VALUES (?, ?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
			pstmt.setString(3, wk);
			pstmt.setString(4, player);
			pstmt.setInt(5, 0);
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
