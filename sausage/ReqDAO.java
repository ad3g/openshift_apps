package com.sausage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class ReqDAO {

	public void deleteReq(Req r) throws NamingException {
		System.out.println("Req, deleteReq, rId: " + r.getrId());

		String sql = "DELETE FROM apps.sa_req WHERE rId = ?";

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
	public void persistReq(Req r) throws NamingException {
		System.out.println("Req, persistReq, rId: " + r.getrId());
		
		Req pRetrieved = new Req();
		pRetrieved.setrId(r.getrId());
		boolean bFound = loadReq(pRetrieved);
		
		if (bFound){
			updateReq(r);
		}
		else
		{
			insertReq(r);
		}
	}
	private void insertReq(Req r)  throws NamingException {
		System.out.println("Req, insertReq, rId: " + r.getrId());

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.sa_Req (rid, rName, rType, rReq) VALUES (?, ?, ?, ?)";

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
			pstmt.setString(3, r.getrType());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(4, r.getrReq());
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
	private void updateReq(Req r) throws NamingException {
		System.out.println("Req, updateReq, rId: " + r.getrId());
		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.sa_Req set rName = ?, rType = ?, rReq where rid = ?";

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
			pstmt.setString(2, r.getrType());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, r.getrReq());
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
	public boolean loadReq(Req r) throws NamingException {
		boolean bRtn = false;
		System.out.println("Req, loadReq, rId: " + r.getrId());

		String sql = "select rid, rName, rType, rReq FROM apps.sa_Req where rid = ?";

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
				r.setrType(rs.getString(3));
				r.setrReq(rs.getString(4));
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
	public ArrayList<Req> getAllReq() throws NamingException {
		System.out.println("Req, getAllReq");
		
		ArrayList<Req> lReq = new ArrayList<Req>();

		String sql = "select rid, rName, rType, rReq FROM apps.sa_Req order by rId";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Req r = new Req();
				r.setrId(rs.getInt(1));
				r.setrName(rs.getString(2));
				r.setrType(rs.getString(3));
				r.setrReq(rs.getString(4));
				lReq.add(r);
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

		return lReq;
	}
	public String getReqEdit(Req r) {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadReq(r);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"3\">Requested</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";

		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"rName\" value=\"" + r.getrName() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pType\" value=\"" + r.getrType() + "\"></td>";
		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pReq\" value=\"" + r.getrReq() + "\"></td>";
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
