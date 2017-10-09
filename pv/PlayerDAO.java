package com.pv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class PlayerDAO {

//	public void deletePlayer(Player p) throws NamingException {
////		System.out.println("MLB_Player, deletePlayer, plaer_id: " + player_id);
//
//		String sql = "DELETE FROM apps.pv_player WHERE pid = ?";
//
//		PreparedStatement pstmt = null;
//
//		Statement stmt;
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//			pstmt.setString(1, p.getpNum());
//
//			pstmt.executeUpdate();
//
//			pstmt.close();
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}	
//		finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}	
	public void persistPlayer(Player p) throws NamingException {
//		System.out.println("MLB_Player, persistPlayer, iPlayer_id: " + iPlayer_id + " sPlayer_Name: " + sPlayer_Name + " sPlayer_Team_Name: " + sPlayer_Team_Name);
		
		Player pRetrieved = new Player();
		pRetrieved.setpNum(p.getpNum());
		boolean bFound = loadPlayer(pRetrieved);
		
		if (bFound){
			updatePlayer(p);
		}
		else
		{
			insertPlayer(p);
		}
	}
	private void insertPlayer(Player p)  throws NamingException {
//		System.out.println("MLB_Player, insertPlayer, player_id: " + player_id + " player_Name: " + player_name + " player_team_name: " + player_team_name);

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.PV_PLAYER (pid, pname, pyr) VALUES (?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, p.getpNum());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getpName());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, p.getpYr());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			int iCount = pstmt.executeUpdate();

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
	private void updatePlayer(Player p) throws NamingException {
//		System.out.println("MLB_Player, updatePlayer, player_id: " + player_id + " player_Name: " + player_name + " player_team_name: " + player_team_name);

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.PV_PLAYER set pname = ? where pid = ? and pyr = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, p.getpName());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getpNum());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, p.getpYr());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			int iCount = pstmt.executeUpdate();

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
	public String getPlayerName(String nbr) throws NamingException {
		
		Player p = new Player();
		p.setpNum(nbr);
		
		loadPlayer(p);
		//System.out.println("getPlayerName: " + nbr + " name: " + p.getpName());
		return p.getpName();
	}
	public boolean loadPlayer(Player p) throws NamingException {
		boolean bRtn = false;
//		System.out.println("MLB_Player, loadPlayer, player_id: " + player_id);

		String sql = "select pid, pname FROM apps.PV_PLAYER where pid = ? and pyr = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, p.getpNum());
			pstmt.setString(2, p.getpYr());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				//System.out.println("MLB_Player, loadPlayer within select, player_id: " + player_id);
				p.setpNum(rs.getString(1));
				p.setpName(rs.getString(2));
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
	
		return bRtn;
	}
	public ArrayList<Player> getAllPlayers(String yr) throws NamingException {
//		System.out.println("MLB_Player, getAllPlayers");
		
		ArrayList<Player> lPlayer = new ArrayList<Player>();

		String sql = "select pid, pname, pyr FROM apps.PV_PLAYER where pyr = ? order by pid";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Player p = new Player();
				p.setpNum(rs.getString(1));
				p.setpName(rs.getString(2));
				p.setpYr(rs.getString(3));
				lPlayer.add(p);
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

		return lPlayer;
	}
	public String getPlayerEdit(Player p) {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadPlayer(p);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"3\">Player Name</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";

		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pName\" value=\"" + p.getpName() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pYr\" value=\"" + p.getpYr() + "\"></td>";
		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pNum\" value=\"" + p.getpNum() + "\"></td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"3\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}

}
