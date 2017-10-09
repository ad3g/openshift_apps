package com.golf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class WinnerDao {

	public void persistInfo(Winner w) throws NamingException {
		
		Winner wRetrieved = new Winner();
		wRetrieved.setwId(w.getwId());
		boolean bFound = loadWinner(wRetrieved);
		
		if (bFound){
			updateWinner(w);
		}
		else
		{
			insertWinner(w);
		}
	}
	private void insertWinner(Winner w)  throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.G_WINNERS (rId, pId, wAmt, wType) VALUES (?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, w.getrId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(2, w.getpId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(3, w.getwAmt());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(4, w.getwType());
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
	private void updateWinner(Winner w) throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.G_WINNERS set rId = ?, pId = ?, wAmt = ?, wType = ? where wId = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, w.getrId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(2, w.getpId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(3, w.getwAmt());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(4, w.getwType());
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
	public void deleteWinner(Winner w) throws NamingException {

		boolean bFound = false;
		bFound = loadWinner(w);
		if (bFound) {
			PreparedStatement pstmt = null;
	
			String delsql = "DELETE apps.G_WINNERS where rId = ?";
	
			try {
				pstmt = MVDBHelper.getLocalConnection().prepareStatement(delsql);
				pstmt.setInt(1, w.getrId());
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
	}

	public boolean loadWinner(Winner w) throws NamingException {
		boolean bRtn = false;

		String sql = "select wId, rId, pId, wAmt, wType FROM apps.G_WINNERS where wId = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, w.getwId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				w.setwId(rs.getInt(1));
				w.setrId(rs.getInt(2));
				w.setpId(rs.getInt(3));
				w.setwAmt(rs.getDouble(4));
				w.setwType(rs.getString(5));
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
	public ArrayList<Winner> getAllWinner() throws NamingException {
//		System.out.println("MLB_Info, getAllWinners");
		
		ArrayList<Winner> lWinner = new ArrayList<Winner>();

		String sql = "select wId, rId, pId, wAmt, wType FROM apps.G_WINNERS order by wId asc";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Winner w = new Winner();
				w.setwId(rs.getInt(1));
				w.setrId(rs.getInt(2));
				w.setpId(rs.getInt(3));
				w.setwAmt(rs.getDouble(4));
				w.setwType(rs.getString(5));

//				p.setpId(rs.getInt(1));
//				p.setpNumberPlayers(rs.getInt(2));
//				p.setpTotalPurse(rs.getDouble(3));
//				p.setpFirstPlace(rs.getDouble(4));
//				p.setpSecondPlace(rs.getDouble(5));
//				p.setpThirdPlace(rs.getDouble(6));
//				p.setpCloseToPin(rs.getDouble(7));
				lWinner.add(w);
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

		return lWinner;
	}
	public String getWinnerEdit() {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadWinner();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"7\">Winner</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";	
			
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"wId\" value=\"" + w.getwId() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"rId\" value=\"" + w.getrId() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + w.getpId() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"wAmt\" value=\"" + w.getwAmt() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"wType\" value=\"" + w.getwType() + "\"></td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"7\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}
}

