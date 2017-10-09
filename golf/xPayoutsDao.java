package com.golf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class xPayoutsDao {

//	public void persistInfo(Payouts p) throws NamingException {
//		
//		Payouts pRetrieved = new Payouts();
//		pRetrieved.setpId(p.getpId());
//		boolean bFound = loadPayouts(pRetrieved);
//		
//		if (bFound){
//			updatePayouts(p);
//		}
//		else
//		{
//			insertPayouts(p);
//		}
//	}
//	private void insertPayouts(Payouts p)  throws NamingException {
//
//		PreparedStatement pstmt = null;
//
//		String inssql = "INSERT INTO apps.G_PAYOUTS (pId, pNumberPlayers, pTotalPurse, pFirstPlace, pSecondPlace, pThirdPlace, pCloseToPin) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setInt(1, p.getpId());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(2, p.getpNumberPlayers());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(3, p.getpTotalPurse());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(4, p.getpFirstPlace());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(5, p.getpSecondPlace());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}try {
//			pstmt.setDouble(6, p.getpThirdPlace());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}try {
//			pstmt.setDouble(7, p.getpCloseToPin());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			int iCount = pstmt.executeUpdate();
//
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
//	private void updatePayouts(Payouts p) throws NamingException {
//
//		PreparedStatement pstmt = null;
//
//		String inssql = "UPDATE apps.G_PAYOUTS set pNumberPlayers = ?, pTotalPurse = ?, pFirstPlace = ?, pSecondPlace = ?, pThirdPlace = ?, pCloseToPin = ? where pId = ?";
//
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(1, p.getpNumberPlayers());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(2, p.getpTotalPurse());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(3, p.getpFirstPlace());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setDouble(4, p.getpSecondPlace());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}try {
//			pstmt.setDouble(5, p.getpThirdPlace());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}try {
//			pstmt.setDouble(6, p.getpCloseToPin());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setInt(7, p.getpId());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			int iCount = pstmt.executeUpdate();
//
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
//
//	public boolean loadPayouts(Payouts p) throws NamingException {
//		boolean bRtn = false;
//
//		String sql = "select pId, pNumberPlayers, pTotalPurse, pFirstPlace, pSecondPlace, pThirdPlace, pCloseToPin FROM apps.G_PAYOUTS where pId = ?";
//
//		Statement stmt;
//		PreparedStatement pstmt = null;
//		
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//			pstmt.setInt(1, p.getpId());
//
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				bRtn = true;
//				p.setpId(rs.getInt(1));
//				p.setpNumberPlayers(rs.getInt(2));
//				p.setpTotalPurse(rs.getDouble(3));
//				p.setpFirstPlace(rs.getDouble(4));
//				p.setpSecondPlace(rs.getDouble(5));
//				p.setpThirdPlace(rs.getDouble(6));
//				p.setpCloseToPin(rs.getDouble(7));
//			}
//
//			rs.close();
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
//	
//		return bRtn;
//	}
//	public ArrayList<Payouts> getAllPayouts() throws NamingException {
////		System.out.println("MLB_Info, getAllPayoutss");
//		
//		ArrayList<Payouts> lPayouts = new ArrayList<Payouts>();
//
//		String sql = "select pId, pNumberPlayers, pTotalPurse, pFirstPlace, pSecondPlace, pThirdPlace, pCloseToPin FROM apps.G_PAYOUTS order by pId asc";
//
//		Statement stmt;
//		PreparedStatement pstmt = null;
//		
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//			
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				Payouts p = new Payouts();
//				p.setpId(rs.getInt(1));
//				p.setpNumberPlayers(rs.getInt(2));
//				p.setpTotalPurse(rs.getDouble(3));
//				p.setpFirstPlace(rs.getDouble(4));
//				p.setpSecondPlace(rs.getDouble(5));
//				p.setpThirdPlace(rs.getDouble(6));
//				p.setpCloseToPin(rs.getDouble(7));
//				lPayouts.add(p);
//			}
//
//			rs.close();
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
//
//		return lPayouts;
//	}
//	public String getPayoutsEdit(Payouts p) {
//		
//		String sRtn = "";
//		PreparedStatement pstmt = null;
//		try {
//			boolean bFound = loadPayouts(p);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		
//		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
//		sRtn = sRtn + "<thead>";
//		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
//		sRtn = sRtn + "<th colspan=\"7\">Payouts</th>";
//		sRtn = sRtn + "</tr>";
//		sRtn = sRtn + "</thead>";
//		sRtn = sRtn + "<tbody>";
//		sRtn = sRtn + "<tr>";	
//			
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pName\" value=\"" + p.getpNumberPlayers() + "\"></td>";
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pEmail\" value=\"" + p.getpTotalPurse() + "\"></td>";
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pPhone\" value=\"" + p.getpFirstPlace() + "\"></td>";
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pName\" value=\"" + p.getpSecondPlace() + "\"></td>";
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pEmail\" value=\"" + p.getpThirdPlace() + "\"></td>";
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pPhone\" value=\"" + p.getpCloseToPin() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + p.getpId() + "\"></td>";
//		sRtn = sRtn + "</tr>";
//		sRtn = sRtn + "<tr>";
//		sRtn = sRtn + "<td colspan=\"7\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
//		sRtn = sRtn + "</tr>";
//
//		sRtn = sRtn + "</tbody>";
//		sRtn = sRtn + "</table>";
//			
//		return sRtn;
//	}

}
