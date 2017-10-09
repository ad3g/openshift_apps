package com.golf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class GroupsDao {

	public void persistInfo(Groups p) throws NamingException {
		
		Groups pRetrieved = new Groups();
		pRetrieved.setpId(p.getpId());
		boolean bFound = loadGroups(pRetrieved);
		
		if (bFound){
			updateGroups(p);
		}
		else
		{
			insertGroups(p);
		}
	}
	private void insertGroups(Groups g)  throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.G_Groups (gId, sId, gsId, pId) VALUES (?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, g.getgId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(2, g.getsId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(3, g.getGsId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(4, g.getpId());
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
	private void updateGroups(Groups g) throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.G_Groups set gsId = ?, pId = ? where gId = ? and sId = ??";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(1, g.getGsId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(2, g.getpId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(3, g.getgId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(4, g.getsId());
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

	public boolean loadGroups(Groups g) throws NamingException {
		boolean bRtn = false;

		String sql = "select gId, sId, gsId, pId FROM apps.G_Groups where gId = ? and sId = ? order by gsId";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, g.getgId());
			pstmt.setInt(2, g.getsId());
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				g.setgId(rs.getInt(1));
				g.setsId(rs.getInt(2));
				g.setGsId(rs.getInt(3));
				g.setpId(rs.getInt(4));
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
	public ArrayList<Groups> getAllGroups() throws NamingException {
//		System.out.println("MLB_Info, getAllGroupss");
		
		ArrayList<Groups> lGroups = new ArrayList<Groups>();

		String sql = "select gId, sId, gsId, pId FROM apps.G_Groups where gId = ? and sId = ? order by sId, gsId";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Groups g = new Groups();
				g.setgId(rs.getInt(1));
				g.setsId(rs.getInt(2));
				g.setGsId(rs.getInt(3));
				g.setpId(rs.getInt(4));
				lGroups.add(g);
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

		return lGroups;
	}
	public String getGroupsEdit(Groups g) {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadGroups(g);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<caption>Groups for week mm/dd/yyyy</caption>";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"7\">Group</th>";
		sRtn = sRtn + "<th colspan=\"7\">Players</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";	
			
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"gGroup\" value=\"" + g.getGsId() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"gNames\" value=\"" + g.getpId() + "\"></td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"7\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}

}
