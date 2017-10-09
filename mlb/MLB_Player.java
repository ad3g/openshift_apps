package com.mlb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class MLB_Player {
	private int player_id			= 0;
	private String player_name		= "";
	private String player_team_name	= "";
	
	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public String getPlayer_team_name() {
		return player_team_name;
	}

	public void setPlayer_team_name(String player_team_name) {
		this.player_team_name = player_team_name;
	}

	public void deletePlayer() throws NamingException {
//		System.out.println("MLB_Player, deletePlayer, plaer_id: " + player_id);

		String sql = "DELETE FROM apps.mlb_player WHERE player_id = ?";

		PreparedStatement pstmt = null;

		Statement stmt;
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, player_id);

			pstmt.executeUpdate();

			pstmt.close();
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

	public void persistPlayer(int iPlayer_id, String sPlayer_Name, String sPlayer_Team_Name) throws NamingException {
//		System.out.println("MLB_Player, persistPlayer, iPlayer_id: " + iPlayer_id + " sPlayer_Name: " + sPlayer_Name + " sPlayer_Team_Name: " + sPlayer_Team_Name);
		
		boolean bFound = loadPlayer();
		
		if (bFound){
			player_id = iPlayer_id;
			player_name = sPlayer_Name;
			player_team_name = sPlayer_Team_Name;
			updatePlayer();
		}
		else
		{
			player_id = iPlayer_id;
			player_name = sPlayer_Name;
			player_team_name = sPlayer_Team_Name;
			insertPlayer();
		}
	}
	private void insertPlayer()  throws NamingException {
//		System.out.println("MLB_Player, insertPlayer, player_id: " + player_id + " player_Name: " + player_name + " player_team_name: " + player_team_name);

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.mlb_player (player_id, player_name, player_team_name) VALUES (?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, player_id);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, player_name);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, player_team_name);
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
	private void updatePlayer() throws NamingException {
		System.out.println("MLB_Player, updatePlayer, player_id: " + player_id + " player_Name: " + player_name + " player_team_name: " + player_team_name);

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.mlb_player set player_name = ?, player_team_name = ? where player_id = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, player_name);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, player_team_name);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(3, player_id);
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

	public boolean loadPlayer() throws NamingException {
		boolean bRtn = false;
//		System.out.println("MLB_Player, loadPlayer, player_id: " + player_id);

		String sql = "select player_id, player_name, player_team_name FROM apps.mlb_player where player_id = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, player_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				//System.out.println("MLB_Player, loadPlayer within select, player_id: " + player_id);
				player_name = rs.getString(2);
				player_team_name = rs.getString(3);
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
	public ArrayList<MLB_Player> getAllPlayers() throws NamingException {
//		System.out.println("MLB_Player, getAllPlayers");
		
		ArrayList<MLB_Player> lPlayer = new ArrayList<MLB_Player>();

		String sql = "select player_id, player_name, player_team_name FROM apps.mlb_player order by player_id";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MLB_Player p = new MLB_Player();
				p.setPlayer_id(rs.getInt(1));
				p.setPlayer_name(rs.getString(2));
				p.setPlayer_team_name(rs.getString(3));
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
}
