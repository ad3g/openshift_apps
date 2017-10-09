package com.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;

import com.common.MVDBHelper;

public class IdxCntlDB {

	private ArrayList<IdxCntl> getAllIdxCntl(String yr, String seas) throws NamingException {
		ArrayList<IdxCntl> lRtn = new ArrayList<IdxCntl>();
		//System.out.println("IdxCntlDB, getListOfIdxCntl");
		String sql = "Select `aId`, `APP`, `val` from `apps`.`IDX_CNTL`";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("IdxCntlDB, getListOfIdxCntl within select");
				IdxCntl i = new IdxCntl();
				i.setaId(rs.getInt(1));
				i.setApp(rs.getString(2));
				i.setVal(rs.getString(3));
				lRtn.add(i);
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
	public String getIdxCntlByApp(String app) throws NamingException {
		//IdxCntl Rtn = new IdxCntl();
		String sRtn = "N";
		System.out.println("IdxCntlDB, getIdxCntlByApp app: " + app);
		String sql = "Select `aId`, `APP`, `val` from `apps`.`IDX_CNTL` where app = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, app);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("IdxCntlDB, getIdxCntlByApp found app: " + app);
//				IdxCntl i = new IdxCntl();
//				i.setaId(rs.getInt(1));
//				i.setApp(rs.getString(2).toUpperCase());
//				i.setVal(rs.getString(3));
				sRtn = rs.getString(3);
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

//	public static String renderIdxCntl(String yr, String seas) throws NamingException{
//		String sRtn = "";
//				
//		ArrayList<IdxCntl> lW = new ArrayList<IdxCntl>();
//		lW = getListOfIdxCntl(yr, seas);
//
//		sRtn = sRtn + "<div><center><font size=\"18\">IdxCntl</font></center>";
//		sRtn = sRtn + "<table class=\"table table-striped table-bordered text-center \"><thead><tr><th class=\" text-center \">Player Name</th><th class=\" text-center \">Week</th><th class=\" text-center \">Amount</th>";
//		sRtn = sRtn + "</tr></thead><tbody>";
//		
//		for (int i = 0;i < lW.size();i++){
//			//IdxCntl w = new IdxCntl();
//			//w = ;
//			sRtn = sRtn + "<tr>";
//			sRtn = sRtn + "<td align=\"center\" >" + lW.get(i).getPlayer() + "</td>";
//			sRtn = sRtn + "<td align=\"center\" >" + lW.get(i).getWk() + "</td>";
//			sRtn = sRtn + "<td align=\"center\" >$" + lW.get(i).getAmt() + "</td>";
//			sRtn = sRtn + "</tr>";
//		}
//
//		sRtn = sRtn + "</tbody></table></div>";
//		sRtn = sRtn + "<br>";
//		
//		return sRtn;
//
//	}
	public void deleteIdxCntl(String aId) throws NamingException {
		String sql = "DELETE FROM `apps`.`IdxCntl` where aId = ?";
		PreparedStatement pstmt = null;
		Statement stmt;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, aId);

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
//	public static void updateIdxCntl(String yr, String seas, String wk, Double amt) throws NamingException{
//		
//		String sql = "update `apps`.`nfl_IdxCntl` set Amt = ? Where yr = ? and season = ? and wk = ?";
//		PreparedStatement pstmt = null;
//		
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//			pstmt.setDouble(1, amt);
//			pstmt.setString(2, yr);
//			pstmt.setString(3, seas);
//			pstmt.setString(4, wk);
//			
//			int iUpd = pstmt.executeUpdate();
//
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		} 
//	    finally {
//			try {
//				if (pstmt != null) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	public static void insertIdxCntl(String yr, String seas, String wk, String player) throws NamingException{
//		PreparedStatement pstmt = null;
//		String inssql = "INSERT INTO apps.IdxCntl (Yr, Season, Wk, Player, Amt) VALUES (?, ?, ?, ?, ?)";
//
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(1, yr);
//			pstmt.setString(2, seas);
//			pstmt.setString(3, wk);
//			pstmt.setString(4, player);
//			pstmt.setInt(5, 0);
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
