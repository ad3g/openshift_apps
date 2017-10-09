package com.mm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.common.MVDBHelper;

public class WinnerDAO {

	public String loadMatches (){
		
		String sRtn = "Matches Loaded";
		Bracket b = new Bracket();
		
		Winner w = new Winner();
		w.setGameid("Match00");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("0", "0")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);
		
		w.setGameid("Match11");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("1", "1")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match22");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("2", "2")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match33");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("3", "3")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match44");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("4", "4")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match55");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("5", "5")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match66");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("6", "6")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match77");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("7", "7")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match88");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("8", "8")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);

		w.setGameid("Match99");
		w.setPlayer(b.getPlayerName(b.getPlayerNumbers("9", "9")));
		w.setStdate("loaddate");
		w.setUrl("loadurl");
		w.setAmt(Double.parseDouble("50"));
		w.setPeriod("final");
		insertWinner(w);
		
		return sRtn;
	}

	public String formatWinnerTable(){
		String sRtn = "";
		
		sRtn = sRtn + "<table>";
		sRtn = sRtn + "<th>Player</th>";
		sRtn = sRtn + "<th>Amount</th>";

		ArrayList<Winner> lWin = new ArrayList<Winner>();
		lWin = getWinners();
		Bracket b = new Bracket();
		for (int i = 0;i < lWin.size();i++){
			sRtn = sRtn + "<tr>";
			sRtn = sRtn + "<td>" + lWin.get(i).getPlayer() + "</td>";
			sRtn = sRtn + "<td>" + lWin.get(i).getAmt() + "</td>";
			sRtn = sRtn + "</tr>";
		}
		sRtn = sRtn + "</table>";
		
		return sRtn;
	}
	public boolean gameExists(String gameid, String period) {
		
		PreparedStatement pstmt = null;
	
		boolean bRtn = false;

		String sql = "SELECT PLAYER FROM apps.mm_winner where gameid = ? and period = ?";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, gameid);
			pstmt.setString(2, period);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Winner w = new Winner();
				bRtn = true;
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
		return bRtn;
	}

	public ArrayList<Winner> getWinners() {
		
		PreparedStatement pstmt = null;
	
		ArrayList<Winner> sRtn = new ArrayList<Winner>();

		String sql = "SELECT PLAYER, SUM(AMT) AS AMT_SUM FROM apps.mm_winner GROUP BY PLAYER ORDER BY AMT_SUM DESC, PLAYER ASC";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Winner w = new Winner();
				w.setPlayer(rs.getString(1));
				w.setAmt(rs.getDouble(2));
				sRtn.add(w);
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
	public void insertWinner(Winner w){
		
		if (!gameExists(w.getGameid(), w.getPeriod())){
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO apps.mm_winner (GAMEID, STDATE, URL, PLAYER, AMT, PERIOD) VALUES (?, ?, ?, ?, ?, ?) ";
			
			try {
				pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
				pstmt.setString(1, w.getGameid());
				pstmt.setString(2, w.getStdate());
				pstmt.setString(3, w.getUrl());
				pstmt.setString(4, w.getPlayer());
				pstmt.setDouble(5, w.getAmt());
				pstmt.setString(6, w.getPeriod());
				
				pstmt.execute();
	
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
		}
	}

	public String deleteAll(){
		
		String sRtn = "Records Deleted";
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM apps.mm_winner";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			int iCnt = pstmt.executeUpdate(sql);

		} catch (Exception e) {
			sRtn = e.getMessage();
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
