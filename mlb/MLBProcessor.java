package com.mlb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.naming.NamingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.common.MVDBHelper;

public class MLBProcessor {
	static String sInputFileName = "";
	static String line;
	static final String CR = "\r\n";
	static final String defaultDateStart = "2015-01-01";
	public static void main(String[] args) throws IOException {
		
//		if (Logger.DefineLogFile()) {
//			Logger.log("MLB13RunPoolProcessor Starting","Info");

//			AssignPlayers();
//			LoadSingleDayOfYear("2013-01-01");
//			LoadAllDaysOfYear("2013");
//			LoadAllBetweenDateRange("2014-01-01", "2014-01-05");
//		} 
//		Logger.log(" ","Info");
//		Logger.log(" ","Info");
//		Logger.log("MLB13RunPool Complete","Info");
	}
	public final static String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	public static void AssignPlayers() throws NamingException{
	
		MLB_Player p = new MLB_Player();
		MLB_Teams t = new MLB_Teams();
		ArrayList<MLB_Player> lPlayers = new ArrayList<MLB_Player>();
		lPlayers = p.getAllPlayers();

//		for (int i = 0;i < lPlayers.size();i++){
//			System.out.println("First Pass - Player_id: " + lPlayers.get(i).getPlayer_id() + " Player_Name: " + lPlayers.get(i).getPlayer_name() + " Team_Name: " + lPlayers.get(i).getPlayer_team_name());
//		}
		
		List<Integer> NoOfPlayers = GetList(t.getlTeams().size());
		SuffleList(NoOfPlayers);
		
		for (int i = 0;i < lPlayers.size();i++){
			lPlayers.get(i).setPlayer_team_name(t.getlTeams().get(NoOfPlayers.get(i)));
//			System.out.println("Second Pass - Player_id: " + lPlayers.get(i).getPlayer_id() + " Player_Name: " + lPlayers.get(i).getPlayer_name() + " Team_Name: " + lPlayers.get(i).getPlayer_team_name());
		}

		for (int i = 0;i < lPlayers.size();i++){
			p.persistPlayer(lPlayers.get(i).getPlayer_id(), lPlayers.get(i).getPlayer_name(), lPlayers.get(i).getPlayer_team_name());
		}

		
//		for (int i = 0;i < lPlayers.size();i++){
//			System.out.println("After Update - Player_id: " + lPlayers.get(i).getPlayer_id() + " Player_Name: " + lPlayers.get(i).getPlayer_name() + " Team_Name: " + lPlayers.get(i).getPlayer_team_name());
//		}
		
		
	}
	private static List GetList(int sz) {
        
        List l = new ArrayList<Integer>();
        for (int i = 0; i < sz;i++){
               l.add(i);
        }
        return l; 
	}
	private static List SuffleList(List lToShuffle) {
        
        Collections.shuffle(lToShuffle);
        return lToShuffle;
	}
	public static void LoadSingleDayOfYear(String sDate) throws NamingException{
		
		MLBJSONParser jp = new MLBJSONParser();
		jp.LoadDB(sDate);
//		jp.LoadDB("2013-02-30");
//		jp.LoadDB("2013-02-26");
//		jp.LoadDB("2013-02-28");
//		jp.LoadDB("2013-03-31");
//		jp.LoadDB("2013-03-01");
		
	}
	
	public static void LoadAllBetweenDateRange(String urlDateStart, String urlDateEnd) throws NamingException{
		/*
		 * 1.  Check if start and end dates are populated
		 * 2.  If end date is already recorded end (return)
		 * 3.  Otherwise, Load all dates between the start and end date
		 * 4.  Update end date with current date
		 */
		System.out.println("LoadAllBetweenDateRanges, received values, start date: " + urlDateStart + " end date: " + urlDateEnd);
		MLB_Cntl mc = new MLB_Cntl();
		String sEND_DT = "";

		if (urlDateStart.equals("")){
			try {
				sEND_DT = mc.getSingleCntl("END_DT");
			} 
			catch (NamingException e2) {
				e2.printStackTrace();
			}
			urlDateStart = sEND_DT;
		}
		if (urlDateEnd.equals("")){
			urlDateEnd = getCurrentDate();
		}
		
//		if (urlDateStart.equals(urlDateEnd)){
//			System.out.println("LoadAllBetweenDateRanges, Start and End Dates are equal, nothing to retrieve");
//			return;
//		}
//		else
//		{
			System.out.println("LoadAllBetweenDateRanges, start date: " + urlDateStart + " end date: " + urlDateEnd);
//		}

		MLBJSONParser jp = new MLBJSONParser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Calendar start = Calendar.getInstance();
		try {
			start.setTime(sdf.parse(urlDateStart));
		} 
		catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		Calendar end = Calendar.getInstance();
		try {
			end.setTime(sdf.parse(urlDateEnd));
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}

//		while( !start.after(end)){
//		    Date targetDay = start.getTime();
//            System.out.println("LoadAllBetweenDateRange, Loading single Date: " + sdf.format(targetDay));
//
//		    start.add(Calendar.DATE, 1);
//		}
		for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            System.out.println("LoadAllBetweenDateRange, Loading single Date: " + sdf.format(date));
            jp.LoadDB(sdf.format(date));      
		}		
	
		mc.setPrm("END_DT");
		mc.setPrmValue(urlDateEnd);
		try {
			mc.updateCntl();
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
		return;
	}
	private static void LoadAllDaysOfYear(String sYear) throws NamingException{
		MLBJSONParser jp = new MLBJSONParser();
		
		String year = "2013";
		String month = null;
        String day = null;
        for(int i = 1; i < 13; i++) {
        	if(i < 10) {
        		month = "0" + i;	
        	}
        	else
        	{
        		month = "" + i;
        	}
        	
            for(int j = 1; j < 32; j++) {
                if(j < 10) {
                    day = "0" + j;
                } else {
                    day = String.valueOf(j);
                }
                System.out.println(year + "-" + month + "-" + day);
                jp.LoadDB(year + "-" + month + "-" + day);      
            }
        }
		
	}
	public static String TodaysGames() throws NamingException {
		
		String sRtn = "";
		PreparedStatement pstmt = null;

		String sql = "SELECT hscore, hteam, vscore, vteam, scorejson, urlDate, gamenum FROM apps.mlb_scores where DATE(urlDate) = DATE(NOW())";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GameDetail gd = new GameDetail();
				MLBJSONParser jp = new MLBJSONParser();
				JSONObject jo = new JSONObject((JSONObject) JSONValue.parse(rs.getString(5)));
				jp.setJsonObject(jo);
				gd = jp.parseGameDetail(Integer.parseInt(rs.getString(7)));
				sRtn = sRtn + "<div class=\"xyz\">";
				sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
				sRtn = sRtn + "<thead>";
				sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
				sRtn = sRtn + "<th align=\"left\" style=\"white-space:nowrap;\">" + rs.getString(6).substring(5) + "     Final</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th></th><th>R</th><th>H</th><th>E</th>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "</thead>";
				sRtn = sRtn + "<tbody>";
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td align=\"left\" style=\"white-space:nowrap;\"><img src=\"../res/mlb_teams/" + rs.getString(2) + ".png\" height=\"25px\" width=\"25px\">" + rs.getString(2) + "</td>";
				for (int i = 0; i < gd.getHscores().size();i++){
					if (i > gd.getHscores().size() - 1){
						sRtn = sRtn + "<td></td>";
					}
					else
					{
						sRtn = sRtn + "<td>" + gd.getHscores().get(i) + "</td>";
					}
				}
				sRtn = sRtn + "<td></td>";
				sRtn = sRtn + "<td>" + rs.getString(1) + "</td>";
				sRtn = sRtn + "<td>" + gd.getHhits() + "</td>";
				sRtn = sRtn + "<td>" + gd.getHerrors() + "</td>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td align=\"left\" style=\"white-space:nowrap;\"><img src=\"../res/mlb_teams/" + rs.getString(4) + ".png\" height=\"25px\" width=\"25px\">" + rs.getString(4) + "</td>";
				for (int i = 0; i < gd.getVscores().size();i++){
					if (i > gd.getVscores().size() - 1){
						sRtn = sRtn + "<td></td>";
					}
					else
					{
						sRtn = sRtn + "<td>" + gd.getVscores().get(i) + "</td>";
					}
				}
				sRtn = sRtn + "<td></td>";
				sRtn = sRtn + "<td>" + rs.getString(3) + "</td>";
				sRtn = sRtn + "<td>" + gd.getVhits() + "</td>";
				sRtn = sRtn + "<td>" + gd.getVerrors() + "</td>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td colspan=\"14\">W: " + gd.getWinningPitcher() + " L: " + gd.getLosingPitcher() + " S: " + gd.getSavingPitcher() + "</td>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "</tbody>";
				sRtn = sRtn + "</table>";
				sRtn = sRtn + "</div>";
		}

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
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
	public static String getGame(String sTeam) throws NamingException {
		
		String sRtn = "";
		PreparedStatement pstmt = null;

		String sql = "SELECT hscore, hteam, vscore, vteam, scorejson, urlDate, gamenum FROM apps.mlb_scores where (hTeam = ? or vTeam = ?) and urlDate > '2015-03-01' order by urldate desc";
		//String sql = "SELECT hscore, hteam, vscore, vteam, scorejson, urlDate, gamenum FROM apps.mlb_scores where urlDate = '2015-03-03' and (hTeam = 'Tigers' or vTeam = 'Tigers')";
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, sTeam);
			pstmt.setString(2, sTeam);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GameDetail gd = new GameDetail();
				MLBJSONParser jp = new MLBJSONParser();
				JSONObject jo = new JSONObject((JSONObject) JSONValue.parse(rs.getString(5)));
				jp.setJsonObject(jo);
				gd = jp.parseGameDetail(Integer.parseInt(rs.getString(7)));
				sRtn = sRtn + "<div class=\"xyz\">";
				sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
				sRtn = sRtn + "<thead>";
				sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
				sRtn = sRtn + "<th align=\"left\" style=\"white-space:nowrap;\">" + rs.getString(6).substring(5) + " - " + gd.getStatus() + "</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th></th><th>R</th><th>H</th><th>E</th>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "</thead>";
				sRtn = sRtn + "<tbody>";
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td align=\"left\" style=\"white-space:nowrap;\"><img src=\"../res/mlb_teams/" + rs.getString(2) + ".png\" height=\"25px\" width=\"25px\">" + rs.getString(2) + "</td>";
				for (int i = 0; i < 9;i++){
					if (i > gd.getHscores().size() - 1){
						sRtn = sRtn + "<td></td>";
					}
					else
					{
						sRtn = sRtn + "<td>" + gd.getHscores().get(i) + "</td>";
					}
				}
				sRtn = sRtn + "<td></td>";
				sRtn = sRtn + "<td>" + rs.getString(1) + "</td>";
				sRtn = sRtn + "<td>" + gd.getHhits() + "</td>";
				sRtn = sRtn + "<td>" + gd.getHerrors() + "</td>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td align=\"left\" style=\"white-space:nowrap;\"><img src=\"../res/mlb_teams/" + rs.getString(4) + ".png\" height=\"25px\" width=\"25px\">" + rs.getString(4) + "</td>";
				for (int i = 0; i < 9;i++){
					if (i > gd.getVscores().size() - 1){
						sRtn = sRtn + "<td></td>";
					}
					else
					{
						sRtn = sRtn + "<td>" + gd.getVscores().get(i) + "</td>";
					}
				}
				sRtn = sRtn + "<td></td>";
				sRtn = sRtn + "<td>" + rs.getString(3) + "</td>";
				sRtn = sRtn + "<td>" + gd.getVhits() + "</td>";
				sRtn = sRtn + "<td>" + gd.getVerrors() + "</td>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td colspan=\"14\">W: " + gd.getWinningPitcher() + " L: " + gd.getLosingPitcher() + " S: " + gd.getSavingPitcher() + "</td>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "</tbody>";
				sRtn = sRtn + "</table>";
				sRtn = sRtn + "</div>";
			}

			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
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

	public static String checkForWinner(){
		String sRtn = ""; 
		String wBracket = "";
		
		MLB_Cntl c = new MLB_Cntl();
		try {
			wBracket = c.getWinnerCntl();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		sRtn = "<a href=\"../mlb/HistoricalBrackets.jsp" + "\"class=\"Team\"<B>To View Historical Brackets, click here</b></a>";
		
//		ArrayList<MLB_Bracket> lb = new ArrayList<MLB_Bracket>();
//		MLB_Bracket b = new MLB_Bracket();
//		b.setBracket_id(wBracket);
//		try {
//			lb = b.loadbrackets();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		
//		sRtn = sRtn + "<table border=\"1\"><thead><tr><th>Player</th><th>Team</th><th>Matches</th></tr></thead><tbody>";
//		for (int i = 0;i < lb.size();i++){
//			sRtn = sRtn + "<tr><td>" + lb.get(i).getP_name() + "</td><td>" + lb.get(i).getP_team() + "</td><td>" + lb.get(i).getMatches() + "</td></tr>";
//		}
//		sRtn = sRtn + "</tbody></table>";
		
		return sRtn;
	}
	public static String saveBracket(String urlDateStart, String urlDateEnd) throws NamingException{

		String sRtn = "";
		if (urlDateStart.equals("")){
			urlDateStart = defaultDateStart;
		}
		if (urlDateEnd.equals("")){
			urlDateEnd = getCurrentDate();
		}		

		String sql = "select player_name, player_team_name, zero_cnt, one_cnt, two_cnt, three_cnt, four_cnt, five_cnt, six_cnt, seven_cnt, " +
			"	eight_cnt, nine_cnt, ten_cnt, eleven_cnt, twelve_cnt, thirteen_cnt, other_cnt," +
			"	sum(x0+x1+x2+x3+x4+x5+x6+x7+x8+x9+x10+x11+x12+x13) as match_cnt, " +
			"   sum(zero_cnt+one_cnt+two_cnt+three_cnt+four_cnt+five_cnt+six_cnt+seven_cnt+eight_cnt+nine_cnt+ten_cnt+eleven_cnt+twelve_cnt+thirteen_cnt+other_cnt) as gp_cnt " +
			" from " +
			"( " +
			"	select player_name, player_team_name, zero_cnt, one_cnt, two_cnt, three_cnt, four_cnt, five_cnt, six_cnt, seven_cnt, " +
			"		eight_cnt, nine_cnt, ten_cnt, eleven_cnt, twelve_cnt, thirteen_cnt, other_cnt," +
			"		(case when zero_cnt > 0 then 1 else 0 end) as x0, " +
			"		(case when one_cnt > 0 then 1 else 0 end) as x1, " +
			"		(case when two_cnt > 0 then 1 else 0 end) as x2, " +
			"		(case when three_cnt > 0 then 1 else 0 end)as x3, " +
			"		(case when four_cnt > 0 then 1 else 0 end) as x4, " +
			"		(case when five_cnt > 0 then 1 else 0 end) as x5, " +
			"		(case when six_cnt > 0 then 1 else 0 end) as x6, " +
			"		(case when seven_cnt > 0 then 1 else 0 end) as x7, " +
			"		(case when eight_cnt > 0 then 1 else 0 end) as x8, " +
			"		(case when nine_cnt > 0 then 1 else 0 end) as x9, " +
			"		(case when ten_cnt > 0 then 1 else 0 end) as x10, " +
			"		(case when eleven_cnt > 0 then 1 else 0 end) as x11, " +
			"		(case when twelve_cnt > 0 then 1 else 0 end) as x12, " +
			"		(case when thirteen_cnt > 0 then 1 else 0 end) as x13, " +
			"		(case when other_cnt > 0 then 1 else 0 end) as xother " +
			"	from " +
			"	( " +
			"		select player_name, player_team_name, sum(zero_cnt) as zero_cnt, sum(one_cnt) as one_cnt, sum(two_cnt) as two_cnt, sum(three_cnt) as three_cnt, " + 
			"				   sum(four_cnt) as four_cnt, sum(five_cnt) as five_cnt, sum(six_cnt) as six_cnt, sum(seven_cnt) as seven_cnt, sum(eight_cnt) as eight_cnt, " +
			"				   sum(nine_cnt) as nine_cnt, sum(ten_cnt) as ten_cnt, sum(eleven_cnt) as eleven_cnt, sum(twelve_cnt) as twelve_cnt, " +
			"				   sum(thirteen_cnt) as thirteen_cnt, sum(other_cnt) as other_cnt " +
			"		from (	 " +
			"			SELECT player_name, player_team_name " + 
			"					,(case when (hTeam = player_team_name and hScore = 0) or (vTeam = player_team_name and vScore = 0) then 1 else 0 end ) as zero_cnt " + 
			"					,(case when (hTeam = player_team_name and hScore = 1) or (vTeam = player_team_name and vScore = 1) then 1 else 0 end ) as one_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 2) or (vTeam = player_team_name and vScore = 2) then 1 else 0 end ) as two_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 3) or (vTeam = player_team_name and vScore = 3) then 1 else 0 end ) as three_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 4) or (vTeam = player_team_name and vScore = 4) then 1 else 0 end ) as four_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 5) or (vTeam = player_team_name and vScore = 5) then 1 else 0 end ) as five_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 6) or (vTeam = player_team_name and vScore = 6) then 1 else 0 end ) as six_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 7) or (vTeam = player_team_name and vScore = 7) then 1 else 0 end ) as seven_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 8) or (vTeam = player_team_name and vScore = 8) then 1 else 0 end ) as eight_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 9) or (vTeam = player_team_name and vScore = 9) then 1 else 0 end ) as nine_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 10) or (vTeam = player_team_name and vScore = 10) then 1 else 0 end ) as ten_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 11) or (vTeam = player_team_name and vScore = 11) then 1 else 0 end ) as eleven_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 12) or (vTeam = player_team_name and vScore = 12) then 1 else 0 end ) as twelve_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore = 13) or (vTeam = player_team_name and vScore = 13) then 1 else 0 end ) as thirteen_cnt  " +
			"					,(case when (hTeam = player_team_name and hScore > 13) or (vTeam = player_team_name and vScore > 13) then 1 else 0 end ) as other_cnt  " +
			"			FROM apps.mlb_scores , apps.mlb_player " +
			"			where (hTeam = player_team_name or vTeam = player_team_name ) " +
			"			and gameType = (Select prmvalue from apps.mlb_cntl where prm = 'SEASON') " +
			"			and (gameStatus = 'Final' or gameStatus = 'Completed Early') " +
			" 			and urlDate > '" + urlDateStart + "'" +
			" 			and urlDate <= '" + urlDateEnd +  "'" +
			"		) a " +
			" 	group by player_name " +	
			" 	) b " +
			" 	group by player_name " +
			") c " +
			" group by player_name order by match_cnt desc, thirteen_cnt desc, twelve_cnt desc, eleven_cnt desc, ten_cnt desc, nine_cnt desc, eight_cnt desc, seven_cnt desc, six_cnt desc, five_cnt desc, four_cnt desc, three_cnt desc, two_cnt desc, one_cnt desc, zero_cnt desc";

		PreparedStatement pstmt = null;
		String newBracketId = UUID.randomUUID().toString();
		sRtn = newBracketId;
		boolean bWinner = false;
		int iCount = 0;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if (rs.getInt(18) > 8){
					if (!bWinner){
						bWinner = true;
						MLB_Cntl c = new MLB_Cntl();
						c.setPrm("Winner");
						c.setPrmValue(newBracketId);
						c.insertCntl();
					}
				}
				iCount++;
				MLB_Bracket b = new MLB_Bracket();
				b.setBracket_id(newBracketId);
				b.setBracket_seq(iCount);
				b.setP_name(rs.getString(1));
				b.setP_team(rs.getString(2));
				b.setR0(rs.getInt(3));
				b.setR1(rs.getInt(4));
				b.setR2(rs.getInt(5));
				b.setR3(rs.getInt(6));
				b.setR4(rs.getInt(7));
				b.setR5(rs.getInt(8));
				b.setR6(rs.getInt(9));
				b.setR7(rs.getInt(10));
				b.setR8(rs.getInt(11));
				b.setR9(rs.getInt(12));
				b.setR10(rs.getInt(13));
				b.setR11(rs.getInt(14));
				b.setR12(rs.getInt(15));
				b.setR13(rs.getInt(16));
				b.setOther(rs.getInt(17));
				b.setMatches(rs.getInt(18));
				b.setGp(rs.getInt(19));
				b.insertbracket();
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
	public static String printStandings(String bracketid) throws NamingException{
		String sRtn = "";
		
		sRtn = sRtn + "<table class=\"table\"><th>Player</th><th>Team</th><th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th><th>11</th><th>12</th><th>13</th><th class=\"thOther\">Other</th><th>Matches</th><th class=\"thGP\">Games Played</th>";
		ArrayList<MLB_Bracket> lb = new ArrayList<MLB_Bracket>();
		MLB_Bracket MasterBracket = new MLB_Bracket();
		MasterBracket.setBracket_id(bracketid);
		lb = MasterBracket.loadbrackets();
		
		for (int i = 0;i < lb.size();i++){
			MLB_Bracket b = new MLB_Bracket();
			b = lb.get(i);
			sRtn = sRtn + "<tr>";
			sRtn = sRtn + formatCell(b.getP_name());
			sRtn = sRtn + "<td><a href=\"../mlb/Team.jsp?Team=" + b.getP_team() + "\"class=\"Team\"</a>" + "<img src=\"../res/mlb_teams/" + b.getP_team() + ".png\" width=\"16\" height=\"16\"/>" + b.getP_team() + "</td>";
			sRtn = sRtn + formatCell(String.valueOf(b.getR0()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR1()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR2()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR3()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR4()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR5()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR6()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR7()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR8()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR9()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR10()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR11()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR12()));
			sRtn = sRtn + formatCell(String.valueOf(b.getR13()));
			sRtn = sRtn + "<td class=\"tdOther\">" + String.valueOf(b.getOther()) + "</td>";
			sRtn = sRtn + formatCell(String.valueOf(b.getMatches()));
			sRtn = sRtn + "<td class=\"tdGP\">" + String.valueOf(b.getGp()) + "</td>";
			sRtn = sRtn + "</tr>";
		}

		sRtn = sRtn + "</table>";
			
		return sRtn;

	}
	public static String printHistoricalList() throws NamingException{
		String sRtn = "";
		String sSaveDt = "";
		sRtn = sRtn + "<ul>";
		ArrayList<MLB_Bracket> lb = new ArrayList<MLB_Bracket>();
		MLB_Bracket MasterBracket = new MLB_Bracket();
		lb = MasterBracket.loadHistoryList();
		
		for (int i = 0;i < lb.size();i++){
			if (lb.get(i).getDt().equals(sSaveDt)){}else
			{
				sRtn = sRtn + "<a href=\"../mlb/SingleHistoricalBracket.jsp?bid=" + lb.get(i).getBracket_id() + "&dt=" + lb.get(i).getDt() + "\">" + lb.get(i).getDt() + "</a><BR>";
				sSaveDt = lb.get(i).getDt();
			}
		}
		sRtn = sRtn + "</ul>";
		return sRtn;

	}

//	public static String printStandings(String urlDateStart, String urlDateEnd) throws NamingException{
//
//		if (urlDateStart.equals("")){
//			urlDateStart = defaultDateStart;
//		}
//		if (urlDateEnd.equals("")){
//			urlDateEnd = getCurrentDate();
//		}		
//		String sRtn = "";
//
//		String sql = "select player_name, player_team_name, zero_cnt, one_cnt, two_cnt, three_cnt, four_cnt, five_cnt, six_cnt, seven_cnt, " +
//			"	eight_cnt, nine_cnt, ten_cnt, eleven_cnt, twelve_cnt, thirteen_cnt, other_cnt," +
//			"	sum(x0+x1+x2+x3+x4+x5+x6+x7+x8+x9+x10+x11+x12+x13) as match_cnt, " +
//			"   sum(zero_cnt+one_cnt+two_cnt+three_cnt+four_cnt+five_cnt+six_cnt+seven_cnt+eight_cnt+nine_cnt+ten_cnt+eleven_cnt+twelve_cnt+thirteen_cnt+other_cnt) as gp_cnt " +
//			" from " +
//			"( " +
//			"	select player_name, player_team_name, zero_cnt, one_cnt, two_cnt, three_cnt, four_cnt, five_cnt, six_cnt, seven_cnt, " +
//			"		eight_cnt, nine_cnt, ten_cnt, eleven_cnt, twelve_cnt, thirteen_cnt, other_cnt," +
//			"		(case when zero_cnt > 0 then 1 else 0 end) as x0, " +
//			"		(case when one_cnt > 0 then 1 else 0 end) as x1, " +
//			"		(case when two_cnt > 0 then 1 else 0 end) as x2, " +
//			"		(case when three_cnt > 0 then 1 else 0 end)as x3, " +
//			"		(case when four_cnt > 0 then 1 else 0 end) as x4, " +
//			"		(case when five_cnt > 0 then 1 else 0 end) as x5, " +
//			"		(case when six_cnt > 0 then 1 else 0 end) as x6, " +
//			"		(case when seven_cnt > 0 then 1 else 0 end) as x7, " +
//			"		(case when eight_cnt > 0 then 1 else 0 end) as x8, " +
//			"		(case when nine_cnt > 0 then 1 else 0 end) as x9, " +
//			"		(case when ten_cnt > 0 then 1 else 0 end) as x10, " +
//			"		(case when eleven_cnt > 0 then 1 else 0 end) as x11, " +
//			"		(case when twelve_cnt > 0 then 1 else 0 end) as x12, " +
//			"		(case when thirteen_cnt > 0 then 1 else 0 end) as x13, " +
//			"		(case when other_cnt > 0 then 1 else 0 end) as xother " +
//			"	from " +
//			"	( " +
//			"		select player_name, player_team_name, sum(zero_cnt) as zero_cnt, sum(one_cnt) as one_cnt, sum(two_cnt) as two_cnt, sum(three_cnt) as three_cnt, " + 
//			"				   sum(four_cnt) as four_cnt, sum(five_cnt) as five_cnt, sum(six_cnt) as six_cnt, sum(seven_cnt) as seven_cnt, sum(eight_cnt) as eight_cnt, " +
//			"				   sum(nine_cnt) as nine_cnt, sum(ten_cnt) as ten_cnt, sum(eleven_cnt) as eleven_cnt, sum(twelve_cnt) as twelve_cnt, " +
//			"				   sum(thirteen_cnt) as thirteen_cnt, sum(other_cnt) as other_cnt " +
//			"		from (	 " +
//			"			SELECT player_name, player_team_name " + 
//			"					,(case when (hTeam = player_team_name and hScore = 0) or (vTeam = player_team_name and vScore = 0) then 1 else 0 end ) as zero_cnt " + 
//			"					,(case when (hTeam = player_team_name and hScore = 1) or (vTeam = player_team_name and vScore = 1) then 1 else 0 end ) as one_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 2) or (vTeam = player_team_name and vScore = 2) then 1 else 0 end ) as two_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 3) or (vTeam = player_team_name and vScore = 3) then 1 else 0 end ) as three_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 4) or (vTeam = player_team_name and vScore = 4) then 1 else 0 end ) as four_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 5) or (vTeam = player_team_name and vScore = 5) then 1 else 0 end ) as five_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 6) or (vTeam = player_team_name and vScore = 6) then 1 else 0 end ) as six_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 7) or (vTeam = player_team_name and vScore = 7) then 1 else 0 end ) as seven_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 8) or (vTeam = player_team_name and vScore = 8) then 1 else 0 end ) as eight_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 9) or (vTeam = player_team_name and vScore = 9) then 1 else 0 end ) as nine_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 10) or (vTeam = player_team_name and vScore = 10) then 1 else 0 end ) as ten_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 11) or (vTeam = player_team_name and vScore = 11) then 1 else 0 end ) as eleven_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 12) or (vTeam = player_team_name and vScore = 12) then 1 else 0 end ) as twelve_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore = 13) or (vTeam = player_team_name and vScore = 13) then 1 else 0 end ) as thirteen_cnt  " +
//			"					,(case when (hTeam = player_team_name and hScore > 13) or (vTeam = player_team_name and vScore > 13) then 1 else 0 end ) as other_cnt  " +
//			"			FROM apps.mlb_scores , apps.mlb_player " +
//			"			where (hTeam = player_team_name or vTeam = player_team_name ) " +
//			"			and gameType = (Select prmvalue from apps.mlb_cntl where prm = 'SEASON') " +
//			"			and (gameStatus = 'Final' or gameStatus = 'Completed Early') " +
//			" 			and urlDate > '" + urlDateStart + "'" +
//			" 			and urlDate <= '" + urlDateEnd +  "'" +
//			"		) a " +
//			" 	group by player_name " +	
//			" 	) b " +
//			" 	group by player_name " +
//			") c " +
//			" group by player_name order by match_cnt desc, thirteen_cnt desc, twelve_cnt desc, eleven_cnt desc, ten_cnt desc, nine_cnt desc, eight_cnt desc, seven_cnt desc, six_cnt desc, five_cnt desc, four_cnt desc, three_cnt desc, two_cnt desc, one_cnt desc, zero_cnt desc";
//
//		PreparedStatement pstmt = null;
//		sRtn = sRtn + "<table border=\"1\" align=\"center\" width=\"90%\"><th>Player</th><th>Team</th><th>0</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>9</th><th>10</th><th>11</th><th>12</th><th>13</th><th>Other</th><th>Matches</th><th>Games Played</th>";
//		try {
//
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//
//			ResultSet rs = pstmt.executeQuery();
//			
//			ArrayList<String> lw = new ArrayList<String>();
//			boolean bWinner = false;
//			while (rs.next()) {
//				sRtn = sRtn + "<tr>";
//				sRtn = sRtn + formatCell(rs.getString(1));
//				sRtn = sRtn + "<td align=\"center\"><a href=\"../mlb/Team.jsp?Team=" + rs.getString(2) + "\"class=\"Team\"</a>" + "<img src=\"../res/mlb_teams/" + rs.getString(2) + ".png\" width=\"16\" height=\"16\"/>" + rs.getString(2) + "</td>";
//				sRtn = sRtn + formatCell(rs.getString(3));
//				sRtn = sRtn + formatCell(rs.getString(4));
//				sRtn = sRtn + formatCell(rs.getString(5));
//				sRtn = sRtn + formatCell(rs.getString(6));
//				sRtn = sRtn + formatCell(rs.getString(7));
//				sRtn = sRtn + formatCell(rs.getString(8));
//				sRtn = sRtn + formatCell(rs.getString(9));
//				sRtn = sRtn + formatCell(rs.getString(10));
//				sRtn = sRtn + formatCell(rs.getString(11));
//				sRtn = sRtn + formatCell(rs.getString(12));
//				sRtn = sRtn + formatCell(rs.getString(13));
//				sRtn = sRtn + formatCell(rs.getString(14));
//				sRtn = sRtn + formatCell(rs.getString(15));
//				sRtn = sRtn + formatCell(rs.getString(16));
//				sRtn = sRtn + "<td align=\"center\">" + rs.getString(17) + "</td>";
//				sRtn = sRtn + formatCell(rs.getString(18));
//				sRtn = sRtn + "<td align=\"center\">" + rs.getString(19) + "</td>";
//				sRtn = sRtn + "</tr>";
//			}
//
//			sRtn = sRtn + "</table>";
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
//		return sRtn;
//	}
	private static String formatCell(String sIn) {
		String sRtn = "";
		
		if (sIn.equals("0")){
			sRtn = sRtn + "<td align=\"center\" bgcolor=\"yellow\">" + sIn + "</td>";
		}
		else
		{
			sRtn = sRtn + "<td align=\"center\">" + sIn + "</td>";
		}
		
		return sRtn;
	}
	public static String printTeamGameResults(String urlDateStart, String urlDateEnd) throws NamingException{
		
		if (urlDateStart.equals("")){
			urlDateStart = defaultDateStart;
		}
		if (urlDateEnd.equals("")){
			urlDateEnd = getCurrentDate();
		}	
		String sRtn = "";
		String sql = "SELECT urlDate, gameNum, gameStatus, gameType, hTeam, hScore, vTeam, vScore " + 
					" FROM apps.mlb_scores  " +
					" where " +
					" urlDate > '" + urlDateStart + "'" +
					" and urlDate < '" + urlDateEnd + "'" +
					" and gameType = (Select prmvalue from apps.mlb_cntl where prm = 'SEASON') " +
					" and (gameStatus = 'Final' or gameStatus = 'Completed Early') " +
					" order by 1";

		PreparedStatement pstmt = null;
		sRtn = sRtn + "<br><br><center><H2><b>Game Scores</b></H2></center><table border=\"1\" align=\"center\" width=\"50%\" class=\"dataTables_info\" id=\"datatable\"><thead><tr><th>Date</th><th>Team</th><th>Score</th><th>Team</th><th>Score</th></tr><tbody>";
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td align=\"center\">" + rs.getString(1) + "</td>";
				sRtn = sRtn + "<td align=\"center\">" + rs.getString(5) + "</td>";
				sRtn = sRtn + "<td align=\"center\">" + rs.getString(6) + "</td>";
				sRtn = sRtn + "<td align=\"center\">" + rs.getString(7) + "</td>";
				sRtn = sRtn + "<td align=\"center\">" + rs.getString(8) + "</td>";
				sRtn = sRtn + "</tr>";
			}
			sRtn = sRtn + "</tbody></table>";
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
	private static String formatCell2(String sIn) {
		String sRtn = "";
		
		if (sIn.equals("")){
			sRtn = sRtn + "<td align=\"center\" bgcolor=\"yellow\">" + sIn + "</td>";
		}
		else
		{
			sRtn = sRtn + "<td align=\"center\">" + sIn + "</td>";
		}
		
		return sRtn;
	}
}
