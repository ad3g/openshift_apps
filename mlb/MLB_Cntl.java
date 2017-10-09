package com.mlb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class MLB_Cntl {

	private String url = "";
	private String prm		= "Default";
	private String prmValue	= "";
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPrm() {
		return prm;
	}
	public void setPrm(String prm) {
		this.prm = prm;
	}
	public String getPrmvalue() {
		return prmValue;
	}
	public void setPrmValue(String prmValue) {
		this.prmValue = prmValue;
	}

	public ArrayList<MLB_Cntl> getAllCntl() throws NamingException {
		ArrayList<MLB_Cntl> lCntl = new ArrayList<MLB_Cntl>();
		
		System.out.println("MLB_Cntl, getAllCntl");

		String sql = "select prm, prmvalue FROM apps.mlb_cntl";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MLB_Cntl cntl = new MLB_Cntl();
				
				cntl.setPrm(rs.getString(1));
				cntl.setPrmValue(rs.getString(2));
				System.out.println("getAllCntl within select, prm: " + cntl.getPrm());
				lCntl.add(cntl);
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

		return lCntl;
	}
	public String getSingleCntl(String sPrm) throws NamingException {

		System.out.println("MLB_Cntl, getSingleCntl");

		String sRtn = "";
		String sql = "select prm, prmvalue FROM apps.mlb_cntl where prm = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, sPrm);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				sRtn = rs.getString(2);
				System.out.println("getSingleCntl within select, prmvalue: " + sRtn);
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

		return sRtn;
	}
	public String getWinnerCntl() throws NamingException {

		System.out.println("MLB_Cntl, getWinnerCntl");

		String sRtn = "";
		String sql = "select prm, prmvalue FROM apps.mlb_cntl where prm = 'Winner' order by isrt_ts asc";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				sRtn = rs.getString(2);
				break;
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

		return sRtn;
	}
	public void updateCntl() throws NamingException {

		System.out.println("MLB_Cntl, updateCntl");

		String sql = "update apps.mlb_cntl set prmvalue = ? where prm = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, prmValue);
			pstmt.setString(2, prm);

			int rs = pstmt.executeUpdate();

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
	public void insertCntl() throws NamingException {

		System.out.println("MLB_Cntl, insertCntl");

		String sql = "insert into apps.mlb_cntl (prm, prmvalue) values (?, ?)";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, prm);
			pstmt.setString(2, prmValue);

			int rs = pstmt.executeUpdate();

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
}
