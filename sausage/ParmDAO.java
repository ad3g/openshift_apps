package com.sausage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class ParmDAO {

	public void deleteParm(Parm p) throws NamingException {
		System.out.println("Parm, deleteParm, pId: " + p.getpId());

		String sql = "DELETE FROM apps.SA_PARM WHERE pId = ?";

		PreparedStatement pstmt = null;

		Statement stmt;
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, p.getpId());

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
	public void persistParm(Parm p) throws NamingException {
		System.out.println("Parm, persistParm, pId: " + p.getpId() + " pKey: " + p.getpKey() + " pValue: " + p.getpValue());
		
		Parm pRetrieved = new Parm();
		pRetrieved.setpId(p.getpId());
		boolean bFound = loadParm(pRetrieved);
		
		if (bFound){
			updateParm(p);
		}
		else
		{
			insertParm(p);
		}
	}
	private void insertParm(Parm p)  throws NamingException {
		System.out.println("Parm, insertParm, pId: " + p.getpId() + " pKey: " + p.getpKey() + " pValue: " + p.getpValue());

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.SA_PARM (pid, pkey, pvalue) VALUES (?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, p.getpId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getpKey());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(3, p.getpValue());
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
	private void updateParm(Parm p) throws NamingException {
		System.out.println("Parm, updateParm, pId: " + p.getpId() + " pKey: " + p.getpKey() + " pValue: " + p.getpValue());
		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.SA_PARM set pKey = ?, pValue = ? where pid = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, p.getpKey());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(2, p.getpValue());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(3, p.getpId());
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
	public boolean loadParm(Parm p) throws NamingException {
		boolean bRtn = false;
		System.out.println("Parm, loadParm, pId: " + p.getpId());

		String sql = "select pId, pKey, pValue FROM apps.SA_PARM where pid = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, p.getpId());
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;

				p.setpId(rs.getInt(1));
				p.setpKey(rs.getString(2));
				p.setpValue(rs.getString(3));
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
	public ArrayList<Parm> getAllParms() throws NamingException {
//		System.out.println("MLB_Player, getAllPlayers");
		
		ArrayList<Parm> lParm = new ArrayList<Parm>();

		String sql = "select pid, pKey, pValue FROM apps.SA_PARM order by pid";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Parm p = new Parm();
				p.setpId(rs.getInt(1));
				p.setpKey(rs.getString(2));
				p.setpValue(rs.getString(3));
				lParm.add(p);
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

		return lParm;
	}
	public String getParmList() {
		
		String sRtn = "";
		
		ArrayList<Parm> lParm = new ArrayList<Parm>();
		try {
			lParm = getAllParms();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table table-striped compact\" id=\"datatableScores\" cellspacing=\"0\" border=\"0\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th class=\"myTh\">Edit</th>";
		sRtn = sRtn + "<th class=\"myTh\">Option</th>";
		sRtn = sRtn + "<th class=\"myTh\">Value</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		for (int i=0;i<lParm.size();i++){
			sRtn = sRtn + "<tr>";
			sRtn = sRtn + "<td class=\"myNameWidth\"><input readonly type=\"text\" class=\"form-control myNameWidth\" id=\"pKey" + lParm.get(i).getpKey() + "\" value=\"" + lParm.get(i).getpKey() + "\"></td>";
			sRtn = sRtn + "<td class=\"myNameWidth\"><input readonly type=\"text\" class=\"form-control myNameWidth\" id=\"pKey" + lParm.get(i).getpKey() + "\" value=\"" + lParm.get(i).getpKey() + "\"></td>";
			sRtn = sRtn + "<td class=\"myNameWidth\"><input readonly type=\"text\" class=\"form-control myNameWidth\" id=\"pValue" + lParm.get(i).getpValue() + "\" value=\"" + lParm.get(i).getpValue() + "\"></td>";
			sRtn = sRtn + "</tr>";
		}
		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";

		return sRtn;
	}
	public String getParmEdit(Parm p) {
		
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadParm(p);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th colspan=\"3\">System Values</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		//sRtn = sRtn + "<tr>";

		sRtn = sRtn + "<tr><td><input type=\"text\" class=\"form-control nameWidth\" id=\"pKey\" value=\"" + p.getpKey() + "\"></td></tr>";
		sRtn = sRtn + "<tr><td><input type=\"text\" class=\"form-control nameWidth\" id=\"pValue\" value=\"" + p.getpValue() + "\"></td></tr>";
		sRtn = sRtn + "<tr><td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + p.getpId() + "\"></td></tr>";
		//sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"3\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}
}
