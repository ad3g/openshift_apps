package com.mm;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class Bracket {

	public String buildNumberBracket() throws IOException, NamingException {
		String sRtn = "";
		sRtn = sRtn + "<table>";
		sRtn = sRtn + "<th>Player</th>";
		sRtn = sRtn + "<th>Winning #</th>";
		sRtn = sRtn + "<th>Losing #</th>";
		for (int i = 0;i < 10;i++){
			for (int j = 0;j < 10;j++){
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td>" + getPlayerName(getPlayerNumbers(String.valueOf(i), String.valueOf(j))) + "</td>";
				sRtn = sRtn + "<td>" + i + "</td>";
				sRtn = sRtn + "<td>" + j + "</td>";
				sRtn = sRtn + "</tr>";
			}
		}
		sRtn = sRtn + "</table>";
		
		
		return sRtn;
	}
	
	public String getPlayerNumbers(String wn, String ls) {
		
		PreparedStatement pstmt = null;
	
		String sRtn = "";

		String sql = "SELECT Player FROM apps.mm_player_numbers WHERE Winning = ? and Losing = ?";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, wn);
			pstmt.setString(2, ls);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sRtn = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sRtn;
	}
	
	public String buildBracket() throws IOException, NamingException {
		String sRtn = "";

		//Write Game Sections
		ArrayList<String> lWinning = new ArrayList<String>(Arrays.asList(getNumbers("Team_Numbers","Winning").split(",")));
		ArrayList<String> lLosing = new ArrayList<String>(Arrays.asList(getNumbers("Team_Numbers","Losing").split(",")));
		ArrayList<String> lPlayersNumbers = new ArrayList<String>(Arrays.asList(getNumbers("Player_Numbers","1").split(",")));

		sRtn = sRtn + "<table border=\"1\">";
		sRtn = sRtn + "<th class=\"rotate myWidthSmall myFont\" rowspan=\"13\">Losing Team Numbers</th>";
		sRtn = sRtn + "<th class=\"myWidth2 myFont\" colspan=\"13\">Winning Team Numbers</th>";
		sRtn = sRtn + "<tr class=\"myWidth2\">";
		sRtn = sRtn + "<td class=\"myWidth\"></td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(0) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(1) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(2) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(3) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(4) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(5) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(6) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(7) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(8) + "</td>";
		sRtn = sRtn + "<td class=\"myWidth\">" + lWinning.get(9) + "</td>";
		sRtn = sRtn + "</tr>";
		
		int pn = 0;
		for (int k = 0;k < lWinning.size();k++){
			sRtn = sRtn + "<tr class=\"myWidth myFont\">";
			sRtn = sRtn + "<td class=\"myWidth\">" + lLosing.get(k) + "</td>";
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "<td class=\"myWidth\">" + getPlayerName(lPlayersNumbers.get(pn)) + "</td>"; pn++;
			sRtn = sRtn + "</tr>";
		}
		sRtn = sRtn + "</table>";

		return sRtn;
	}
	public String getNumbers(String type, String id) {
		
		PreparedStatement pstmt = null;
		
		String Numbers = "";

		String sql = "SELECT PARM_VALUE FROM apps.mm_parms WHERE parm_type = ? and parm_id = ?";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Numbers = rs.getString(1).replace("[", "").replace("]", "").replace(" ", "");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Numbers;
	}
	public String getPlayerName(String id) {
		
		PreparedStatement pstmt = null;
	
		String sRtn = "";

		String sql = "SELECT PARM_VALUE FROM apps.mm_parms WHERE parm_type = 'Player' and parm_id = ?";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sRtn = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sRtn;
	}

}
