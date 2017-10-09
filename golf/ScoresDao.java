package com.golf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.common.MVDBHelper;
import java.util.UUID;

public class ScoresDao {
	private char ltr = 'A' ;
	
//	public ArrayList<Score> listScores(int iNumToBuild){
//		ArrayList<Score> lScore = new ArrayList<Score>();
//		
//		for (int i=0;i<iNumToBuild;i++){
//			lScore.add(buildScore(i));
//		}
//
//		return lScore;
//	}
//	private Score buildScore(int id){
//		Score p = new Score();
//		//p.setpName(UUID.randomUUID().toString());
//		p.setpName(String.valueOf(ltr)); 
//		p.setpId(id);
//		
//		ltr++;
//		
//		return p;
//	}
	public void persistScore(Score s) throws NamingException {
		
		Score sRetrieved = new Score();
		sRetrieved.setsId(s.getsId());
		boolean bFound = loadScore(sRetrieved);
		
		if (bFound){
			updateScore(s);
		}
		else
		{
			insertScore(s);
		}
	}
	private void insertScore(Score s)  throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "INSERT INTO apps.G_SCORES (sId, rId, pId, pts_Needed, pts_Earned, paid, pts_Diff, pts_Next, closestTo, winAmt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, s.getsId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(2, s.getrId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(3, s.getpId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(4, s.getsPtsNeeded());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(5, s.getsPtsEarned());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(6, s.getsPaid());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(7, s.getsPtsDiff());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(8, s.getsPtsNextWk());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}		
		try {
			pstmt.setString(9, s.getsClosestTo());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}		
		try {
			pstmt.setDouble(10, s.getWinAmt());
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
	private void updateScore(Score s) throws NamingException {

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.G_SCORES set rId = ?, pId = ?, pts_Needed = ?, pts_Earned = ?, paid = ?, pts_Diff = ?, pts_Next = ?, closestTo = ?, winAmt = ? where sId = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(1, s.getrId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(2, s.getpId());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(3, s.getsPtsNeeded());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(4, s.getsPtsEarned());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(5, s.getsPaid());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(6, s.getsPtsDiff());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(7, s.getsPtsNextWk());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(8, s.getsClosestTo());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setDouble(9, s.getWinAmt());
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setInt(10, s.getsId());
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

	public boolean loadScore(Score s) throws NamingException {
		boolean bRtn = false;

		String sql = "select sId, rId, pId, pts_Needed, pts_Earned, paid, pts_Diff, pts_Next, closestTo, winAmt FROM apps.G_SCORES where sId = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, s.getsId());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				s.setsId(rs.getInt(1));
				s.setrId(rs.getInt(2));
				s.setpId(rs.getInt(3));
				s.setsPtsNeeded(rs.getInt(4));
				s.setsPtsEarned(rs.getInt(5));
				s.setsPaid(rs.getString(6));
				s.setsPtsDiff(rs.getInt(7));
				s.setsPtsNextWk(rs.getInt(8));
				s.setsClosestTo(rs.getString(9));
				s.setWinAmt(rs.getDouble(10));
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
	public ArrayList<Score> getAllScoresByRound(int inRid) throws NamingException {
//		System.out.println("MLB_Info, getAllScores");
		
		ArrayList<Score> lScore = new ArrayList<Score>();

		String sql = "select sId, rId, pId, pts_Needed, pts_Earned, paid, pts_Diff, pts_Next, closestTo, winAmt FROM apps.G_SCORES where rId = ? order by sId asc, rId asc, pId asc";
		
		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, inRid);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Score s = new Score();
				s.setsId(rs.getInt(1));
				s.setrId(rs.getInt(2));
				s.setpId(rs.getInt(3));
				s.setsPtsNeeded(rs.getInt(4));
				s.setsPtsEarned(rs.getInt(5));
				s.setsPaid(rs.getString(6));
				s.setsPtsDiff(rs.getInt(7));
				s.setsPtsNextWk(rs.getInt(8));
				s.setsClosestTo(rs.getString(9));
				s.setWinAmt(rs.getDouble(10));
				lScore.add(s);
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

		return lScore;
	}
	public ArrayList<Score> getAllScoresByRoundAndPaid(int inRid) throws NamingException {
//		System.out.println("MLB_Info, getAllScores");
		
		ArrayList<Score> lScore = new ArrayList<Score>();

		String sql = "select sId, rId, pId, pts_Needed, pts_Earned, paid, pts_Diff, pts_Next, closestTo, winAmt FROM apps.G_SCORES where rId = ? and paid = 'Y' order by sId asc, rId asc, pId asc";
		
		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, inRid);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Score s = new Score();
				s.setsId(rs.getInt(1));
				s.setrId(rs.getInt(2));
				s.setpId(rs.getInt(3));
				s.setsPtsNeeded(rs.getInt(4));
				s.setsPtsEarned(rs.getInt(5));
				s.setsPaid(rs.getString(6));
				s.setsPtsDiff(rs.getInt(7));
				s.setsPtsNextWk(rs.getInt(8));
				s.setsClosestTo(rs.getString(9));
				s.setWinAmt(rs.getDouble(10));
				lScore.add(s);
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

		return lScore;
	}

	public ArrayList<Score> getAllScores() throws NamingException {
//		System.out.println("MLB_Info, getAllScores");
		
		ArrayList<Score> lScore = new ArrayList<Score>();

		String sql = "select sId, rId, pId, pts_Needed, pts_Earned, paid, pts_Diff, pts_Next, closestTo, winAmt FROM apps.G_SCORES order by sId asc, rId asc, pId asc";
		
		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Score s = new Score();
				s.setsId(rs.getInt(1));
				s.setrId(rs.getInt(2));
				s.setpId(rs.getInt(3));
				s.setsPtsNeeded(rs.getInt(4));
				s.setsPtsEarned(rs.getInt(5));
				s.setsPaid(rs.getString(6));
				s.setsPtsDiff(rs.getInt(7));
				s.setsPtsNextWk(rs.getInt(8));
				s.setsClosestTo(rs.getString(9));
				s.setWinAmt(rs.getDouble(10));
				lScore.add(s);
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

		return lScore;
	}
	public Score getMostRecentScoreByPid(int inPid) throws NamingException {
		System.out.println("ScoreDao, getMostRecentScoreByPid, pId: " + inPid);
		
		Score s = new Score();

		String sql = "select sId, rId, pId, pts_Needed, pts_Earned, paid, pts_Diff, pts_Next, closestTo, winAmt FROM apps.G_SCORES where pId = ? and rId = (select max(rid) FROM apps.G_SCORES where pId = ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setInt(1, inPid);
			pstmt.setInt(2, inPid);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("ScoreDao, getMostRecentScoreByPid, pId: " + inPid + " rId: " + rs.getInt(2));
				s.setsId(rs.getInt(1));
				s.setrId(rs.getInt(2));
				s.setpId(rs.getInt(3));
				s.setsPtsNeeded(rs.getInt(4));
				s.setsPtsEarned(rs.getInt(5));
				s.setsPaid(rs.getString(6));
				s.setsPtsDiff(rs.getInt(7));
				s.setsPtsNextWk(rs.getInt(8));
				s.setsClosestTo(rs.getString(9));
				s.setWinAmt(rs.getDouble(10));
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

		return s;
	}

//	public String getScoreEdit(Score s) {
//		
//		String sRtn = "";
//		PreparedStatement pstmt = null;
//		try {
//			boolean bFound = loadScore(s);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		
////		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
////		sRtn = sRtn + "<thead>";
////		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
////		sRtn = sRtn + "<th>Score Id</th>";
////		sRtn = sRtn + "<th>Round Id</th>";
////		sRtn = sRtn + "<th>Player Id</th>";
////		sRtn = sRtn + "<th>Pts Needed</th>";
////		sRtn = sRtn + "<th>Pts Earned</th>";
////		sRtn = sRtn + "<th>Paid Y/N</th>";
////		sRtn = sRtn + "<th>Pts Different</th>";
////		sRtn = sRtn + "<th>Pts Next Week</th>";
////		sRtn = sRtn + "</tr>";
////		sRtn = sRtn + "</thead>";
////		sRtn = sRtn + "<tbody>";
//		sRtn = sRtn + "<tr>";	
//			
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pName\" value=\"" + s.getsId() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pEmail\" value=\"" + s.getrId() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pPhone\" value=\"" + s.getpId() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + s.getsPtsNeeded() + "\"></td>";
//		sRtn = sRtn + "<td><input type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + s.getsPtsEarned() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + s.getsPaid() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + s.getsPtsDiff() + "\"></td>";
//		sRtn = sRtn + "<td><input readonly type=\"text\" class=\"form-control nameWidth\" id=\"pId\" value=\"" + s.getsPtsNextWk() + "\"></td>";
//		sRtn = sRtn + "</tr>";
//		sRtn = sRtn + "<tr>";
////		sRtn = sRtn + "<td colspan=\"8\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td>";
//		sRtn = sRtn + "</tr>";
//
////		sRtn = sRtn + "</tbody>";
////		sRtn = sRtn + "</table>";
//			
//		return sRtn;
//	}
	public String getScoreTableByRound(int inRid) {
		
		String sRtn = "";
		ArrayList<Score> lScore = new ArrayList<Score>();

		PlayerDao pDao = new PlayerDao();
		Player p = new Player();
		try {
			lScore = getAllScoresByRound(inRid);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sRtn = sRtn + "<table class=\"table table-striped compact\" id=\"datatableScores\" cellspacing=\"0\" border=\"0\">";
		sRtn = sRtn + "<thead>";
		sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
		sRtn = sRtn + "<th class=\"myTh\">Player</th>";
		sRtn = sRtn + "<th class=\"myTh\">Points Needed</th>";
		sRtn = sRtn + "<th class=\"myTh\">Points Earned</th>";
		sRtn = sRtn + "<th class=\"myTh\">Points Different</th>";
		sRtn = sRtn + "<th class=\"myTh\">Points Next Week</th>";
//		sRtn = sRtn + "<th class=\"myTh\">Paid Y/N</th>";
		sRtn = sRtn + "<th class=\"myTh\">Mark Paid</th>";
		sRtn = sRtn + "<th class=\"myTh\">Closest To Pin</th>";
//		sRtn = sRtn + "<th class=\"myHiddenWidth\">Score Id</th>";
//		sRtn = sRtn + "<th class=\"myHiddenWidth\">Round Id</th>";
//		sRtn = sRtn + "<th class=\"myHiddenWidth\">Player Id</th>";
		sRtn = sRtn + "<th class=\"myTh\">Win Amount</th>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</thead>";
		sRtn = sRtn + "<tbody>";
		for (int i=0;i<lScore.size();i++){
			sRtn = sRtn + "<tr>";
			p.setpId(lScore.get(i).getpId());
			try {
				pDao.loadPlayer(p);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sRtn = sRtn + "<td class=\"myNameWidth\"><input readonly type=\"text\" class=\"form-control myNameWidth\" id=\"pName--" + lScore.get(i).getsId() + "\" value=\"" + p.getpName() + "\"></td>";
			//sRtn = sRtn + "<td class=\"myWidth\"><input readonly type=\"text\" class=\"form-control myWidth\" id=\"ptsNeeded--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getsPtsNeeded() + "\"></td>";
			//sRtn = sRtn + "<td class=\"myWidth\"><input type=\"text\" class=\"form-control nameWidth\" id=\"ptsEarned\" onchange=\"alert(this.value)\" value=\"" + lScore.get(i).getsPtsEarned() + "\"></td>";
			sRtn = sRtn + formatNeeded(lScore.get(i));
			sRtn = sRtn + formatEarned(lScore.get(i));
			sRtn = sRtn + "<td class=\"myWidth\"><input readonly type=\"text\" class=\"form-control myWidth\" id=\"sPtsDiff--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getsPtsDiff() + "\"></td>";
			sRtn = sRtn + "<td class=\"myWidth\"><input readonly type=\"text\" class=\"form-control myWidth\" id=\"sPtsNextWk--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getsPtsNextWk() + "\"></td>";
//			sRtn = sRtn + "<td class=\"myWidth\"><input readonly type=\"text\" class=\"form-control myPaidWidth\" id=\"sPaid--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getsPaid() + "\"></td>";
			System.out.println("paid: " + lScore.get(i).getsPaid());
			if (lScore.get(i).getsPaid().equals("N"))
			{
				sRtn = sRtn + "<td class=\"myWidth\"><input type=\"button\" value=\"Paid\" onclick=\"btnMarkPaid(" + lScore.get(i).getsId() + ", 'Y\'" + ")\"></td>";;
			}
			else
			{
				sRtn = sRtn + "<td class=\"myWidth\"><input type=\"button\" value=\"Unpaid\" onclick=\"btnMarkPaid(" + lScore.get(i).getsId() + ", 'N\'" + ")\"></td>";;
			}
			System.out.println("closest: " + lScore.get(i).getsClosestTo());
			if (lScore.get(i).getsClosestTo().equals("N"))
			{
				sRtn = sRtn + "<td class=\"myWidth\"><input type=\"button\" value=\"Closest To Pin\" onclick=\"btnMarkClosestTo(" + lScore.get(i).getsId() + ", 'Y\'" + ")\"></td>";;
			}
			else
			{
				sRtn = sRtn + "<td class=\"myWidth\"><input type=\"button\" value=\"Un-Closest To Pin\" onclick=\"btnMarkClosestTo(" + lScore.get(i).getsId() + ", 'N\'" + ")\"></td>";;
			}
//			sRtn = sRtn + "<td class=\"myHiddenWidth\"><input type=\"hidden\" class=\"form-control myWidth\" id=\"sId--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getsId() + "\"></td>";
//			sRtn = sRtn + "<td class=\"myHiddenWidth\"><input type=\"hidden\" class=\"form-control myWidth\" id=\"rId--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getrId() + "\"></td>";
//			sRtn = sRtn + "<td class=\"myHiddenWidth\"><input type=\"hidden\" class=\"form-control myWidth\" id=\"pId--" + lScore.get(i).getsId() + "\" value=\"" + lScore.get(i).getpId() + "\"></td>";
			sRtn = sRtn + formatWinningAmount(lScore.get(i));
			sRtn = sRtn + "</tr>";
		}
		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}
	public int calculateDifference(Score s){
		int iDiff = 0;
		
		iDiff = s.getsPtsEarned() - s.getsPtsNeeded();
		
		return iDiff;
	}
	public int calculateNextWeek(Score s){
		int iNext = 0;
		int iNet = 0;
		
		if (s.getsPtsNeeded() == 0){
			iNext = 0;
		}
		else
		{
			iNet = s.getsPtsDiff() / 2;
		} 
		if (iNet < -2){
			iNet = -2;
		}
		if (iNet > 0){
			iNext = s.getsPtsNeeded() + Math.abs(iNet);
		}
		else
		{
			iNext = s.getsPtsNeeded() - Math.abs(iNet);
		}
		if (iNext < 5){
			iNext = 5;
		}
		return iNext;
	}

	public String formatEarned(Score s){
		String sRtn = "";
		
		//sRtn = sRtn + "<td class=\"myWidth\"><select class=\"form-control nameWidth\"><option value=\"0\">0</option><option value=\"2\" selected=\"selected\">2</option><option value=\"3\">3</option></select></td>";
		//sRtn = sRtn + "<td class=\"myWidth\"><select class=\"form-control ptsEarnedWidth\" onchange=\"alert(this.value)\">";
		sRtn = sRtn + "<td class=\"myWidth\"><select id=\"ptsEarned--" + s.getsId() + "\" class=\"form-control ptsEarnedWidth\" onchange=\"myFunction(" + s.getsId() + ", " + s.getsPtsEarned() + ")\">";
		for (int i = 0; i < 25;i++){
			if (Integer.valueOf(s.getsPtsEarned()) == null)
			{
				sRtn = sRtn + "<option value=\"" + i + "\">" + i + "</option>";
			}
			else
			{
				if (i == s.getsPtsEarned())
				{
					sRtn = sRtn + "<option value=\"" + i + "\" selected=\"selected\">" + i + "</option>";
				}
				else
				{
					sRtn = sRtn + "<option value=\"" + i + "\">" + i + "</option>";
				}
			}
		}
		sRtn = sRtn + "</select></td>";
		return sRtn;
	}
	public String formatNeeded(Score s){
		String sRtn = "";
		
		sRtn = sRtn + "<td class=\"myWidth\"><select id=\"ptsNeeded--" + s.getsId() + "\" class=\"form-control ptsNeededWidth\" onchange=\"myFunction(" + s.getsId() + ", " + s.getsPtsNeeded() + ")\">";
		for (int i = 0; i < 25;i++){
			if (Integer.valueOf(s.getsPtsNeeded()) == null)
			{
				sRtn = sRtn + "<option value=\"" + i + "\">" + i + "</option>";
			}
			else
			{
				if (i == s.getsPtsNeeded())
				{
					sRtn = sRtn + "<option value=\"" + i + "\" selected=\"selected\">" + i + "</option>";
				}
				else
				{
					sRtn = sRtn + "<option value=\"" + i + "\">" + i + "</option>";
				}
			}
		}
		sRtn = sRtn + "</select></td>";
		return sRtn;
	}
	public String formatWinningAmount(Score s){
		String sRtn = "";
		
		sRtn = sRtn + "<td class=\"myWidth\"><select id=\"winAmt--" + s.getsId() + "\" class=\"form-control winAmtWidth\" onchange=\"myWinAmount(" + s.getsId() + ", " + s.getWinAmt() + ")\">";
		for (int i = 0; i < 50;i++){
			if (Double.valueOf(s.getWinAmt()) == null)
			{
				sRtn = sRtn + "<option value=\"" + i + "\" selected=\"selected\">" + i + "</option>";
				break;
			}
			else
			{
				if (i == s.getWinAmt())
				{
					sRtn = sRtn + "<option value=\"" + i + "\" selected=\"selected\">" + i + "</option>";
					break;
				}
				else
				{
					sRtn = sRtn + "<option value=\"" + i + "\">" + i + "</option>";
				}
			}
		}
		sRtn = sRtn + "</select></td>";
		return sRtn;
	}

}
