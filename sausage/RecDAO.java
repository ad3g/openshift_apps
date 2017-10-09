package com.sausage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class RecDAO {

	public void deleteRec(Rec r) throws NamingException {
		System.out.println("Rec, deleteRec, rId: " + r.getrId());

		String sql = "DELETE FROM apps.sa_rec WHERE rId = ?";

		PreparedStatement pstmt = null;

		Statement stmt;
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, r.getrId());

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
	public void persistRec(Rec r) throws NamingException {
		System.out.println("Rec, persistRec, rId: " + r.getrId());
		
		Rec pRetrieved = new Rec();
		pRetrieved.setrId(r.getrId());
		boolean bFound = loadRec(pRetrieved);
		
		if (bFound){
			updateRec(r);
		}
		else
		{
			insertRec(r);
		}
	}
	private void insertRec(Rec r)  throws NamingException {
		System.out.println("Rec, insertRec, rId: " + r.getrId());

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.sa_rec (rid, rName, rRec, rCost) VALUES (?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, r.getrId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, r.getrName());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, r.getrRec());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(4, r.getrCost());
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
	private void updateRec(Rec r) throws NamingException {
		System.out.println("Rec, updateRec, rId: " + r.getrId());
		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.sa_rec set rName = ?, rRec = ?, rCost where rid = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, r.getrName());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, r.getrRec());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, r.getrCost());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(4, r.getrId());
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
	public boolean loadRec(Rec r) throws NamingException {
		boolean bRtn = false;
		System.out.println("Rec, loadRec, rId: " + r.getrId());

		String sql = "select rid, rName, rRec, rCost FROM apps.sa_rec where rid = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, r.getrId());
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;

				r.setrId(rs.getInt(1));
				r.setrName(rs.getString(2));
				r.setrRec(rs.getString(3));
				r.setrCost(rs.getString(4));
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
	public ArrayList<Rec> getAllRec() throws NamingException {
		System.out.println("Rec, getAllRec");
		
		ArrayList<Rec> lRec = new ArrayList<Rec>();

		String sql = "select rid, rName, rRec, rCost FROM apps.sa_rec order by rId";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Rec r = new Rec();
				r.setrId(rs.getInt(1));
				r.setrName(rs.getString(2));
				r.setrRec(rs.getString(3));
				r.setrCost(rs.getString(4));
				lRec.add(r);
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

		return lRec;
	}
	public String getRecEdit(Rec r) {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadRec(r);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"3\">Recieved</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";

		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"rName\" value=\"" + r.getrName() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"rRec\" value=\"" + r.getrRec() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pCost\" value=\"" + r.getrCost() + "\"></td>";
		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"rId\" value=\"" + r.getrId() + "\"></td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"3\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}

}
