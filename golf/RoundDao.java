package com.golf;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class RoundDao {

	public void persistRound(Round r) throws NamingException {
		System.out.println("RoundDao, persistRound");
		
		Round rRetrieved = new Round();
		rRetrieved.setrId(r.getrId());
		boolean bFound = loadRound(rRetrieved);
		
		if (bFound){
			updateRound(r);
		}
		else
		{
			insertRound(r);
		}
	}
	public void insertRound(Round r)  throws NamingException {
		System.out.println("RoundDao, insertRound");
		
		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.G_ROUND (rDate, rType, rRainOut) VALUES (?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDate(1, r.getrDate());
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
			pstmt.setString(3, r.getrRainOut());
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
	public void updateRound(Round r) throws NamingException {
		System.out.println("RoundDao, updateRound");
		
		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.G_ROUND set rDate = ?, rType = ?, rRainOut = ? where rId = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDate(1, r.getrDate());
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
			pstmt.setString(3, r.getrRainOut());
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

	public boolean loadRound(Round r) throws NamingException {
		System.out.println("RoundDao, loadRound");
		boolean bRtn = false;

		String sql = "select rId, rDate, rType, rRainOut FROM apps.G_ROUND where rId = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, r.getrId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				r.setrId(rs.getInt(1));
				r.setrDate(rs.getDate(2));
				r.setrType(rs.getString(3));
				r.setrRainOut(rs.getString(4));
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
	public boolean loadRoundByDate(Round r) throws NamingException {
		System.out.println("RoundDao, loadRoundByDate");
		boolean bRtn = false;

		String sql = "select rId, rDate, rType, rRainOut FROM apps.G_ROUND where rDate = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setDate(1, r.getrDate());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				r.setrId(rs.getInt(1));
				r.setrDate(rs.getDate(2));
				r.setrType(rs.getString(3));
				r.setrRainOut(rs.getString(4));
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
	public boolean roundsExistForYear() throws NamingException {
		boolean bRtn = false;

		String sql = "select rId, rDate, rType, rRainOut FROM apps.G_ROUND where year(rDate) = year(current_date)";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
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

	public ArrayList<Round> getAllRounds() throws NamingException {
		System.out.println("RoundDao, getAllRounds");
		
		ArrayList<Round> lRound = new ArrayList<Round>();

		String sql = "select rId, rDate, rType, rRainOut FROM apps.G_ROUND order by rId asc";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Round r = new Round();
				r.setrId(rs.getInt(1));
				r.setrDate(rs.getDate(2));
				r.setrType(rs.getString(3));
				r.setrRainOut(rs.getString(4));
				lRound.add(r);
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

		return lRound;
	}
	public ArrayList<Round> getAllRoundsGTDate(Date dt) throws NamingException {
		System.out.println("RoundDao, getAllRoundsGTDate Date: " + dt);
		
		ArrayList<Round> lRound = new ArrayList<Round>();

		String sql = "select rId, rDate, rType, rRainOut FROM apps.G_ROUND where rDate >= ? order by rId asc";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setDate(1, dt);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Round r = new Round();
				r.setrId(rs.getInt(1));
				r.setrDate(rs.getDate(2));
				r.setrType(rs.getString(3));
				r.setrRainOut(rs.getString(4));
				lRound.add(r);
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

		return lRound;
	}

	public String formatScoreType(Round r){
		String sRtn = "";
		
		sRtn = sRtn + "<label for=\"scoreType\">Round Type (Individual or Scramble)</label>";
		sRtn = sRtn + "<td class=\"myWidth\"><select id=\"scoreType\" class=\"form-control myRoundWidth\" >";
		if (r.getrType().equals("Individual"))
		{
			sRtn = sRtn + "<option value=\"Individual\" selected=\"selected\">Individual</option>";
			sRtn = sRtn + "<option value=\"Scramble\">Scramble</option>";
		}
		else
		{
			sRtn = sRtn + "<option value=\"Individual\">Individual</option>";
			sRtn = sRtn + "<option value=\"Scramble\" selected=\"selected\">Scramble</option>";
		}
		sRtn = sRtn + "</select></td>";
		return sRtn;
	}
	public String formatRainOut(Round r){
		String sRtn = "";
		sRtn = sRtn + "<label for=\"rainOut\">Rain Out (Yes or No)</label>";
		sRtn = sRtn + "<td class=\"myWidth\"><select id=\"rainOut\" class=\"form-control myRoundWidth \" >";
		if (r.getrRainOut().equals("Y"))
		{
			sRtn = sRtn + "<option value=\"Yes\" selected=\"selected\">Yes</option>";
			sRtn = sRtn + "<option value=\"No\">No</option>";
		}
		else
		{
			sRtn = sRtn + "<option value=\"Yes\">Yes</option>";
			sRtn = sRtn + "<option value=\"No\" selected=\"selected\">No</option>";
		}
		sRtn = sRtn + "</select></td>";
		return sRtn;
	}
	public String getRoundEdit(Round r) {
		System.out.println("RoundDao, getRoundEdit");		
		String sRtn = "";
		PreparedStatement pstmt = null;
		boolean bFound = false;
		try {
			bFound = loadRound(r);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String sDate = "";
		if (bFound){
			sDate = sdf.format(r.getrDate());
		}
		else
		{
			sDate = sdf.format(new java.util.Date()); 
		}
		sRtn = sRtn + "<div class=\"form-group\">";
		sRtn = sRtn + "<div class='input-group date myRoundWidth' id='datetimepicker1'><input type='text' id=\"mydate\" class=\"form-control\" /><span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-calendar\"></span></span></div></div>";
		sRtn = sRtn + "<script type=\"text/javascript\">$(function () {$('#datetimepicker1').datetimepicker({format: 'MM/DD/YYYY',";
		sRtn = sRtn + " defaultDate: '" + sDate + "'});});</script>";
		sRtn = sRtn + "<div class=\"dropdown\">";
		sRtn = sRtn + formatScoreType(r);
		sRtn = sRtn + "<br>";
		sRtn = sRtn + formatRainOut(r);
		sRtn = sRtn + "<br>";
		sRtn = sRtn + "<div class=\"form-group\">";
		sRtn = sRtn + "<div class=\"col-sm-offset-1 col-sm-10\">";
		sRtn = sRtn + "<button type=\"button\" id=\"subbtn\" class=\"btn btn-primary col-sm-3 \">";
		sRtn = sRtn + "Save";
		sRtn = sRtn + "</button>";
		sRtn = sRtn + "<button type=\"button\" id=\"canbtn\" class=\"btn btn-default col-sm-3 \">";
		sRtn = sRtn + "Cancel";
		sRtn = sRtn + "</button>";
		sRtn = sRtn + "<button type=\"button\" id=\"mainbtn\" class=\"btn btn-default col-sm-3 \">";
		sRtn = sRtn + "Main Page";
		sRtn = sRtn + "</button>";
		sRtn = sRtn + "<div class=\"col-sm-2\">";
		sRtn = sRtn + "<input type=\"hidden\" class=\"form-control\" id=\"inputId\" value=\"" + r.getrId() + "\"/>";
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "</div>";	
		sRtn = sRtn + "</div>";
		sRtn = sRtn + "</form>";
		return sRtn;
	}

}
