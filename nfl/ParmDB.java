package com.nfl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class ParmDB {

	public static String getWeekByDate(String Dt) throws NamingException {
		String sRtn = "Not Found";
		System.out.println("ParmDb, getWeekByDate, Date: " + Dt);
		String sql = "Select parm_id from `apps`.`nfl_parms` where parm_type = 'Week' and str_to_date(parm_value, '%m/%d/%Y') <= str_to_date(?, '%Y/%m/%d') and str_to_date(parm_value2, '%m/%d/%Y') >= str_to_date(?, '%Y/%m/%d');";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, Dt);
			pstmt.setString(2, Dt);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("getWeekByDate within select, value found: " + rs.getString(1));
				sRtn = rs.getString(1);
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
	public static String getPlayerNameByNumber(String playernum) throws NamingException {
		String sRtn = "Not Found";
		//System.out.println("ParmDb, getPlayerNameByNumber, number: " + playernum);
		String sql = "Select parm_value from `apps`.`nfl_parms` where parm_type = 'Player' and parm_id = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, playernum);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("getPlayerNameByNumber within select, value found: " + rs.getString(1));
				sRtn = rs.getString(1);
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
	public static int getParmAsInteger(String typ) throws NamingException {
		int iRtn = 0;
		System.out.println("ParmDb, getParmAsInteger, typ: "+ typ);
		String sql = "Select parm_value from `apps`.`nfl_parms` where parm_type = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, typ);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("getParmAsInteger within select, value found: " + rs.getString(1));
				iRtn = Integer.parseInt(rs.getString(1));
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
		return iRtn;
	}
	public static String getParmAsString(String typ) throws NamingException {
		String sRtn = "";
		//System.out.println("ParmDb, getParmAsString");
		String sql = "Select parm_value from `apps`.`nfl_parms` where parm_type = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, typ);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("getParmAsString within select, value found: " + rs.getString(1));
				sRtn = rs.getString(1);
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
	public static void updateParmLastUpdateDate(String dt) throws NamingException {
		String sRtn = "";
		System.out.println("ParmDb, updateParmLastUpdateDate");
		String sql = "update `apps`.`nfl_parms` set parm_value = ? where parm_type = 'Last_Update' ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, dt);
			
			int iRtn = pstmt.executeUpdate();
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

	public static ArrayList<String> getListOf(String parmtype) throws NamingException {
		ArrayList<String> lRtn = new ArrayList<String>();
		//System.out.println("ParmDB, getListOf");
		String sql = "select parm_value from apps.nfl_parms where parm_type = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, parmtype);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("ParmDB, getListOf within select");
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
	
}
