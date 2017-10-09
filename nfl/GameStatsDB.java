package com.nfl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class GameStatsDB {

	public static ArrayList<String> getListOfTeams(String yr, String seas, String wk) throws NamingException {
		ArrayList<String> lRtn = new ArrayList<String>();
		//System.out.println("GameStatsDb, getListOfTeams");
		String sql = "select HTeam, ATeam from apps.nfl_gamestats where yr = ? and season = ? and Wk = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
			pstmt.setString(3, wk);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("GameStatsDb, getListOfTeams, within Select");
				lRtn.add(rs.getString(1));
				lRtn.add(rs.getString(2));
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
	public static ArrayList<String> getListOfGameidsByWeek(String yr, String seas, String wk) throws NamingException {
		ArrayList<String> lRtn = new ArrayList<String>();
		//System.out.println("GameStatsDb, getListOfGameidsByWeek, Wk: " + wk);
		String sql = "select gameid	from apps.nfl_gamestats where yr = ? and season = ? and Wk = ? order by gameid";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
			pstmt.setString(3, wk);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("GameStatsDb, getListOfGameidsByWeek, within Select");
				lRtn.add(rs.getString(1));
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
	public static ArrayList<String> getListOfGameidsCurrentPeriod(String yr, String seas) throws NamingException {
		ArrayList<String> lRtn = new ArrayList<String>();
		//System.out.println("GameStatsDb, getListOfGameidsByWeek, Wk: " + wk);
		String sql = "SELECT gameid FROM apps.nfl_gamestats WHERE yr =  ? and season = ? and ((date(substr(Gameid,1,8)) >= CURRENT_DATE - INTERVAL 12 DAY) and (date(substr(Gameid,1,8)) <= CURRENT_DATE + INTERVAL 4 DAY)) order by gameid asc";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
		
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("GameStatsDb, getListOfGameidsByWeek, within Select");
				lRtn.add(rs.getString(1));
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

	public static void deleteGameStats(String gameid) throws NamingException {
		String sql = "DELETE FROM apps.nfl_gamestats WHERE gameid = ?";
		PreparedStatement pstmt = null;
		Statement stmt;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, gameid);

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

	public static void updateGameStats(GameStat gs) throws NamingException {
		String sql = "";
		sql = "update apps.nfl_gamestats set AScore = ?, HScore = ?, GameJson = ? where gameid = ? ";	
	
		PreparedStatement pstmt = null;
		Statement stmt;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, gs.getAScore());
			pstmt.setString(2, gs.getHScore());
			pstmt.setString(3, gs.getGameJson());
			pstmt.setString(4, gs.getGameid());

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
	public static GameStat getGameStatByGameid(String gameid) throws NamingException {
		GameStat gs = new GameStat();
		//System.out.println("GameStatsDb, getGameStatByGameid");
		String sql = "select Gameid, Wk, HTeam, HScore, ATeam, AScore, GameJson from apps.nfl_gamestats where Gameid = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, gameid);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("GameStatsDb, getGameStatByGameid, within Select");
				gs.setGameid(rs.getString("Gameid"));
				gs.setAScore(rs.getString("AScore"));
				gs.setATeam(rs.getString("ATeam"));
				gs.setHScore(rs.getString("HScore"));
				gs.setHTeam(rs.getString("HTeam"));
				gs.setWk(rs.getString("Wk"));
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
		return gs;
	}

//	public static void saveGameStats(GameStat gs) throws NamingException {
////		System.out.println("ScoresJson, persist, urlDate: " + urlDate + " gameNum: " + gameNum);
//		PreparedStatement pstmt = null;
//		String inssql = "INSERT INTO apps.nfl_gamestats (Gameid, Wk, HTeam, HScore, ATeam, AScore, GameJson) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(1, gs.getGameid());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(2, gs.getWk());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(3, gs.getHTeam());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(4, gs.getHScore());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(5, gs.getATeam());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(6, gs.getAScore());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}						
//		try {
//			pstmt.setString(7, gs.getGameJson());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}						
//
//		try {
//			int iCount = pstmt.executeUpdate();
//
//			pstmt.close();
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		} 
//		finally {
//		}		
//	}
}
