package com.golf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;
public class PlayerDao {
	private char ltr = 'A' ;
	
	public ArrayList<Player> listPlayers(int iNumToBuild){
		ArrayList<Player> lPlayer = new ArrayList<Player>();
		
		for (int i=0;i<iNumToBuild;i++){
			lPlayer.add(buildPlayer(i));
		}

		return lPlayer;
	}
	private Player buildPlayer(int id){
		Player p = new Player();
		//p.setpName(UUID.randomUUID().toString());
		p.setpName(String.valueOf(ltr)); 
		p.setpId(id);
		
		ltr++;
		
		return p;
	}
	public void persistPlayer(Player p) throws NamingException {
		
		Player pRetrieved = new Player();
		pRetrieved.setpId(p.getpId());
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

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.G_PLAYER (pName, pEmail, pPhone) VALUES (?, ?, ?)";
		//String inssql = "INSERT INTO apps.G_PLAYER (pId, pName, pEmail, pPhone) VALUES (?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
//		try {
//			pstmt.setInt(1, p.getpId());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		try {
			pstmt.setString(1, p.getpName());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getpEmail());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, p.getpPhone());
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

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.G_PLAYER set pName = ?, pEmail = ?, pPhone = ? where pId = ?";

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
			pstmt.setString(2, p.getpEmail());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, p.getpPhone());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(4, p.getpId());
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

	public boolean loadPlayer(Player p) throws NamingException {
		boolean bRtn = false;

		String sql = "select pId, pName, pEmail, pPhone FROM apps.G_PLAYER where pId = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, p.getpId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpEmail(rs.getString(3));
				p.setpPhone(rs.getString(4));
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
	public ArrayList<Player> getAllPlayers() throws NamingException {
		System.out.println("PlayerDao, getAllPlayers");	
		ArrayList<Player> lPlayer = new ArrayList<Player>();

		String sql = "select pId, pName, pEmail, pPhone FROM apps.G_PLAYER order by pId asc";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Player p = new Player();
				p.setpId(rs.getInt(1));
				p.setpName(rs.getString(2));
				p.setpEmail(rs.getString(3));
				p.setpPhone(rs.getString(4));
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
		//System.out.println("PlayerDao, getAllPlayers exit, size: " + lPlayer.size());	
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
		sRtn = sRtn + "<form class=\"form-horizontal\" role=\"form\">";
		sRtn = sRtn + "<div class=\"form-group\">";
		sRtn = sRtn + "<label for=\"input\" class=\"col-sm-1 control-label\">";
		sRtn = sRtn + "Name";
		sRtn = sRtn + "</label>";
		sRtn = sRtn + "<div class=\"col-sm-2\">";
		sRtn = sRtn + "<input type=\"text\" class=\"form-control\" id=\"inputName\" value=\"" + p.getpName() + "\"/>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "<div class=\"form-group\">";
		sRtn = sRtn + "	<label for=\"inputEmail\" class=\"col-sm-1 control-label\">";
		sRtn = sRtn + "Email";
		sRtn = sRtn + "</label>";
		sRtn = sRtn + "<div class=\"col-sm-2\">";
		sRtn = sRtn + "<input type=\"email\" class=\"form-control\" id=\"inputEmail\" value=\"" + p.getpEmail() + "\"/>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "<div class=\"form-group\">";
		sRtn = sRtn + "<label for=\"inputPhone\" class=\"col-sm-1 control-label\">";
		sRtn = sRtn + "Phone";
		sRtn = sRtn + "</label>";
		sRtn = sRtn + "<div class=\"col-sm-2\">";
		sRtn = sRtn + "<input type=\"text\" class=\"form-control\" id=\"inputPhone\" value=\"" + p.getpPhone() + "\"/>";
		sRtn = sRtn + "	</div>";
		sRtn = sRtn + "<div class=\"col-sm-2\">";
		sRtn = sRtn + "<input type=\"hidden\" class=\"form-control\" id=\"inputId\" value=\"" + p.getpId() + "\"/>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "<div class=\"form-group\">";
		sRtn = sRtn + "<div class=\"col-sm-offset-1 col-sm-10\">";
		sRtn = sRtn + "<button type=\"button\" id=\"subbtn\" class=\"btn btn-primary col-sm-1 \">";
		sRtn = sRtn + "Save";
		sRtn = sRtn + "</button>";
		sRtn = sRtn + "<button type=\"button\" id=\"canbtn\" class=\"btn btn-default col-sm-1 \">";
		sRtn = sRtn + "Cancel";
		sRtn = sRtn + "</button>";
		sRtn = sRtn + "<button type=\"button\" id=\"mainbtn\" class=\"btn btn-default col-sm-1 \">";
		sRtn = sRtn + "Main Page";
		sRtn = sRtn + "</button>";
		sRtn = sRtn + "</div>";	
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "<br>";
		sRtn = sRtn + "<br>";
		sRtn = sRtn + "</form>";
					
		return sRtn;
	}

}
