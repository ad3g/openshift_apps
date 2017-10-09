package com.pv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class InfoDAO {

	public void persistInfo(Info p) throws NamingException {
		
		Info pRetrieved = new Info();
		pRetrieved.setiNum(p.getiNum());
		boolean bFound = loadInfo(pRetrieved);
		
		if (bFound){
			updateInfo(p);
		}
		else
		{
			insertInfo(p);
		}
	}
	private void insertInfo(Info p)  throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.PV_INFO (iNum, iName) VALUES (?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, p.getiNum());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getiName());
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
	private void updateInfo(Info p) throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.PV_INFO set iName = ? where iNum = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, p.getiName());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getiNum());
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

	public boolean loadInfo(Info p) throws NamingException {
		boolean bRtn = false;

		String sql = "select iNum, iName FROM apps.PV_INFO where iNum = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, p.getiNum());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				p.setiNum(rs.getString(1));
				p.setiName(rs.getString(2));
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
	public ArrayList<Info> getAllInfos(String yr) throws NamingException {
//		System.out.println("MLB_Info, getAllInfos");
		
		ArrayList<Info> lInfo = new ArrayList<Info>();

		String sql = "select iNum, iName FROM apps.PV_INFO where iyr = ? order by iNum";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Info p = new Info();
				p.setiNum(rs.getString(1));
				p.setiName(rs.getString(2));
				lInfo.add(p);
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

		return lInfo;
	}
	public String getInfoEdit(Info p) {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadInfo(p);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"3\">Information Message</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";

		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"iName\" value=\"" + p.getiName() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"iYr\" value=\"" + p.getiYr() + "\"></td>";
		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"iNum\" value=\"" + p.getiNum() + "\"></td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"3\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}

}
