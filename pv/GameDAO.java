package com.pv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;

import com.common.MVDBHelper;
import com.pv.models.Example;
import com.pv.models.NCAA_Football;

public class GameDAO {

	int iT1S2Q = 0;
	int iT2S2Q = 0;
	int iT1SF  = 0;
	int iT2SF  = 0;
	ArrayList<String> T1NUM = null;
	ArrayList<String> T2NUM = null;
	ArrayList<String> PNUM = null;
//	public void deletePlayer(Game g) throws NamingException {
////		System.out.println("MLB_Player, deletePlayer, plaer_id: " + player_id);
//
//		String sql = "DELETE FROM apps.pv_player WHERE pid = ?";
//
//		PreparedStatement pstmt = null;
//
//		Statement stmt;
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//			pstmt.setString(1, p.getpNum());
//
//			pstmt.executeUpdate();
//
//			pstmt.close();
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
	public void persistGame(Game g) throws NamingException {
//		System.out.println("MLB_Player, persistPlayer, iPlayer_id: " + iPlayer_id + " sPlayer_Name: " + sPlayer_Name + " sPlayer_Team_Name: " + sPlayer_Team_Name);
		
		Game gRetrieved = new Game();
		gRetrieved.setgNum(g.getgNum());
		boolean bFound = loadGame(gRetrieved);
		
		if (bFound){
			try {
				System.out.println("b4 updateGame, gNum: " + g.getgNum());
				updateGame(g);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			insertGame(g);
		}
	}
	private void insertGame(Game g)  throws NamingException {
//		System.out.println("MLB_Player, insertPlayer, player_id: " + player_id + " player_Name: " + player_name + " player_team_name: " + player_team_name);

//		PreparedStatement pstmt = null;
//
//		String inssql = "INSERT INTO apps.PV_GAME (gid, gname) VALUES (?, ?)";
//
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(1, g.getgNum());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			pstmt.setString(2, g.getgName());
//		} 
//		catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//
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
	}
	private void updateGame(Game g) throws NamingException, Exception {
//		System.out.println("MLB_Player, updatePlayer, player_id: " + player_id + " player_Name: " + player_name + " player_team_name: " + player_team_name);

		PreparedStatement pstmt = null;

		String inssql = "UPDATE apps.PV_GAME set GNAME = ?, T1_NAME = ?, T1_NUM = ?, T1_S1 = ?, T1_S2 = ?, T1_S3 = ?, T1_S4 = ?, T1_SF = ?, T2_NAME = ?, T2_NUM = ?, T2_S1 = ?, T2_S2 = ?, T2_S3 = ?, T2_S4 = ?, T2_SF = ?, PAY_1 = ?, PAY_2 = ?, PAY_3 = ?, PAY_4 = ?, PAY_F = ?, WIN_1 = ?, WIN_2 = ?, WIN_3 = ?, WIN_4 = ?, WIN_F = ?, LOC = ?, DTE = ?, TV = ?, P_NUM = ?, BRACKET_HTML = ? where gid = ?";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		pstmt.setString(1, g.getgName());
		pstmt.setString(2, g.getT1NAME());
		pstmt.setString(3, g.getT1NUM());
		pstmt.setString(4, g.getT1S1());
		pstmt.setString(5, g.getT1S2());
		pstmt.setString(6, g.getT1S3());
		pstmt.setString(7, g.getT1S4());
		pstmt.setString(8, g.getT1SF());
		pstmt.setString(9, g.getT2NAME());
		pstmt.setString(10, g.getT2NUM());
		pstmt.setString(11, g.getT2S1());
		pstmt.setString(12, g.getT2S2());
		pstmt.setString(13, g.getT2S3());
		pstmt.setString(14, g.getT2S4());
		pstmt.setString(15, g.getT2SF());
		pstmt.setString(16, g.getPay1());
		pstmt.setString(17, g.getPay2());
		pstmt.setString(18, g.getPay3());
		pstmt.setString(19, g.getPay4());
		pstmt.setString(20, g.getPayF());
		pstmt.setString(21, g.getWin1());
		pstmt.setString(22, g.getWin2());
		pstmt.setString(23, g.getWin3());
		pstmt.setString(24, g.getWin4());
		pstmt.setString(25, g.getWinF());
		pstmt.setString(26, g.getLoc());
		pstmt.setString(27, g.getDte());
		pstmt.setString(28, g.getTv());
		pstmt.setString(29, g.getpNum());
		pstmt.setString(30, g.getBracketHtml());
		pstmt.setString(31, g.getgNum());
		
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

	public boolean loadGame(Game g) throws NamingException {
		boolean bRtn = false;
//		System.out.println("MLB_Player, loadPlayer, player_id: " + player_id);

		String sql = "select GID, GNAME, T1_NAME, T1_NUM, T1_S1, T1_S2, T1_S3, T1_S4, T1_SF, T2_NAME, T2_NUM, T2_S1, T2_S2, T2_S3, T2_S4, T2_SF, PAY_1, PAY_2, PAY_3, PAY_4, PAY_F, WIN_1, WIN_2, WIN_3, WIN_4, WIN_F, LOC, DTE, TV, P_NUM, BRACKET_HTML, YR FROM apps.PV_GAME where gid = ?";
		//String sql = "select gid, gname FROM apps.PV_GAME where gid = ?";

		Statement stmt;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, g.getgNum());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bRtn = true;
				//System.out.println("MLB_Player, loadPlayer within select, player_id: " + player_id);
//				g.setgNum(rs.getString("GID"));
				g.setgYr(rs.getString("YR"));
				g.setgName(rs.getString("GNAME"));
				g.setLoc(rs.getString("LOC"));
				g.setDte(rs.getString("DTE"));
				g.setTv(rs.getString("TV"));
				g.setBracketHtml(rs.getString("BRACKET_HTML"));
				g.setpNum(rs.getString("P_NUM"));

				g.setT1NAME(rs.getString("T1_NAME"));
				g.setT1NUM(rs.getString("T1_NUM"));
				g.setT1S1(rs.getString("T1_S1"));
				g.setT1S2(rs.getString("T1_S2"));
				g.setT1S3(rs.getString("T1_S3"));
				g.setT1S4(rs.getString("T1_S4"));
				g.setT1SF(rs.getString("T1_SF"));
				
				g.setT2NAME(rs.getString("T2_NAME"));
				g.setT2NUM(rs.getString("T2_NUM"));
				g.setT2S1(rs.getString("T2_S1"));
				g.setT2S2(rs.getString("T2_S2"));
				g.setT2S3(rs.getString("T2_S3"));
				g.setT2S4(rs.getString("T2_S4"));
				g.setT2SF(rs.getString("T2_SF"));
				
				g.setWin1(rs.getString("WIN_1"));
				g.setWin2(rs.getString("WIN_2"));
				g.setWin3(rs.getString("WIN_3"));
				g.setWin4(rs.getString("WIN_4"));
				g.setWinF(rs.getString("WIN_F"));
				
				g.setPay1(rs.getString("PAY_1"));
				g.setPay2(rs.getString("PAY_2"));
				g.setPay3(rs.getString("PAY_3"));
				g.setPay4(rs.getString("PAY_4"));
				g.setPayF(rs.getString("PAY_F"));
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
	public ArrayList<Game> getAllGames(String yr) throws NamingException {
//		System.out.println("MLB_Player, getAllPlayers");
		
		ArrayList<Game> lGames = new ArrayList<Game>();

		String sql = "select GID, GNAME, T1_NAME, T1_NUM, T1_S1, T1_S2, T1_S3, T1_S4, T1_SF, T2_NAME, T2_NUM, T2_S1, T2_S2, T2_S3, T2_S4, T2_SF, PAY_1, PAY_2, PAY_3, PAY_4, PAY_F, WIN_1, WIN_2, WIN_3, WIN_4, WIN_F, LOC, DTE, TV, P_NUM, BRACKET_HTML, YR FROM apps.PV_GAME where YR = ? order by gid";

		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Game g = new Game();
				g.setgNum(rs.getString("GID"));
				g.setgName(rs.getString("GNAME"));
				g.setLoc(rs.getString("LOC"));
				g.setDte(rs.getString("DTE"));
				g.setTv(rs.getString("TV"));
				g.setBracketHtml(rs.getString("BRACKET_HTML"));
				g.setpNum(rs.getString("P_NUM"));

				g.setT1NAME(rs.getString("T1_NAME"));
				g.setT1NUM(rs.getString("T1_NUM"));
				g.setT1S1(rs.getString("T1_S1"));
				g.setT1S2(rs.getString("T1_S2"));
				g.setT1S3(rs.getString("T1_S3"));
				g.setT1S4(rs.getString("T1_S4"));
				g.setT1SF(rs.getString("T1_SF"));
				
				g.setT2NAME(rs.getString("T2_NAME"));
				g.setT2NUM(rs.getString("T2_NUM"));
				g.setT2S1(rs.getString("T2_S1"));
				g.setT2S2(rs.getString("T2_S2"));
				g.setT2S3(rs.getString("T2_S3"));
				g.setT2S4(rs.getString("T2_S4"));
				g.setT2SF(rs.getString("T2_SF"));
				
				g.setWin1(rs.getString("WIN_1"));
				g.setWin2(rs.getString("WIN_2"));
				g.setWin3(rs.getString("WIN_3"));
				g.setWin4(rs.getString("WIN_4"));
				g.setWinF(rs.getString("WIN_F"));
				
				g.setPay1(rs.getString("PAY_1"));
				g.setPay2(rs.getString("PAY_2"));
				g.setPay3(rs.getString("PAY_3"));
				g.setPay4(rs.getString("PAY_4"));
				g.setPayF(rs.getString("PAY_F"));
				g.setgYr(yr);
				lGames.add(g);
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

		return lGames;
	}
	public static List GetList(int sz) {
        
        List l = new ArrayList<String>();
        for (int i = 0; i < sz;i++){
               l.add(i);
        }
        return l; 
	}
	public static List SuffleList(List lToShuffle) {
        
        Collections.shuffle(lToShuffle);
        return lToShuffle;
	}
	public void assignNumbers(String yr) {
		
		ArrayList<Game> lGames = new ArrayList<Game>(); 
		try {
			lGames = getAllGames(yr);
		} catch (NamingException e) {
			e.printStackTrace();
		}

		for (int i = 0;i < lGames.size();i++){
			List<String> T1NUM = GetList(10);
			SuffleList(T1NUM);
			List<String> T2NUM = GetList(10);
			SuffleList(T2NUM);
			List<String> PNUM = GetList(100);
			SuffleList(PNUM);
			lGames.get(i).setpNum(PNUM.toString().replace("[", "").replace("]", "").replace(" ", ""));
			lGames.get(i).setT1NUM(T1NUM.toString().replace("[", "").replace("]", "").replace(" ", ""));
			lGames.get(i).setT2NUM(T2NUM.toString().replace("[", "").replace("]", "").replace(" ", ""));
			try {
				persistGame(lGames.get(i));
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
	public void buildGameInserts(String url, String yr) throws Exception {
		//String isrtSql = "INSERT INTO `apps`.`PV_GAME` (`GID`,`YR`,`GNAME`,`T1_NAME`,`T2_NAME`,`LOC`,`DTE`,`TV`, `PAY_2`, `PAY_F`, `BRACKET_HTML`)VALUES(UUID(),'";
		String isrtSql = "";
		//INSERT INTO `apps`.`PV_GAME` (`GID`,`YR`,`GNAME`,`T1_NAME`,`T2_NAME`,`LOC`,`DTE`,`TV`, `PAY_2`, `PAY_F`, `BRACKET_HTML`)VALUES(UUID(),'2016',
		//		'Boca Raton Bowl Conference USA vs. American','Memphis','Western Kentucky','FAU Stadium, Boca Raton, Fla.','Dec. 20 / 7pm','ESPN', '25', '50','Bracket Numbers Not Assigned');
		NCAA_Football fb = new NCAA_Football();
		Example ex = fb.getJSONObject(url);
		for (int i = 0;i < ex.getScoreboard().size();i++){
			for (int k = 0;k < ex.getScoreboard().get(i).getGames().size();k++){
				isrtSql = "INSERT INTO `apps`.`PV_GAME` (`GID`,`YR`,`GNAME`,`T1_NAME`,`T2_NAME`,`LOC`,`DTE`,`TV`, `PAY_2`, `PAY_F`, `BRACKET_HTML`)VALUES(UUID(),'";
				isrtSql += yr + "', '";
				isrtSql += ex.getScoreboard().get(i).getGames().get(k).getConference().replaceAll("\'","");
				isrtSql += "', '";
				isrtSql += ex.getScoreboard().get(i).getGames().get(k).getHome().getNameRaw().replaceAll("\'","");
				isrtSql += "', '";
				isrtSql += ex.getScoreboard().get(i).getGames().get(k).getAway().getNameRaw().replaceAll("\'","");
				isrtSql += "', '";
				isrtSql += ex.getScoreboard().get(i).getGames().get(k).getLocation().replaceAll("\'","");
				isrtSql += "', '";
				isrtSql += ex.getScoreboard().get(i).getGames().get(k).getStartDateDisplay() + " - " + ex.getScoreboard().get(i).getGames().get(k).getStartTime().replaceAll("\'","");
				isrtSql += "', '";
				isrtSql += ex.getScoreboard().get(i).getGames().get(k).getNetworkLogo().replaceAll("\'","");
				isrtSql += "', '";
				isrtSql += "25', '50', 'Bracket Numbers Not Assigned');";
				System.out.println(isrtSql);
			}
		}
//		Game g = new Game();
//		g.setgNum(id);
//		loadGame(g);
//		ex.setGame(g);
//		findScoreboard(ex);
//		
//		System.out.println("xT1S1: " + ex.getGame().getT1S1() + " T1S2: " + ex.getGame().getT1S2() + " T1S3: " + ex.getGame().getT1S3() + " T1S4: " + ex.getGame().getT1S4() + " T1SF: " + ex.getGame().getT1SF());
//		System.out.println("xT2S1: " + ex.getGame().getT2S1() + " T2S2: " + ex.getGame().getT2S2() + " T2S3: " + ex.getGame().getT2S3() + " T2S4: " + ex.getGame().getT2S4() + " T2SF: " + ex.getGame().getT2SF());
//
//		persistGame(ex.getGame());
		
//		System.out.println("stop");
	}
	public void testUpdateScores(String yr) throws Exception {
		long begin = System.currentTimeMillis();
		String id = "";
		ArrayList<Game> lG = new ArrayList<Game>();
		ArrayList<String> lUrls = new ArrayList<String>();
		if (yr.equals("2015")){
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/15/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/16/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/17/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/18/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2015/19/scoreboard.html");
		}
		else
		{
			//lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/15/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/16/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/17/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/18/scoreboard.html");
			lUrls.add("http://data.ncaa.com/jsonp/scoreboard/football/fbs/2016/19/scoreboard.html");			
		}
		lG = getAllGames(yr);
		
		//id = "4e46115f-bb54-11e6-ba5a-84a6c88e5b39";
		for (int i = 0; i < lG.size();i++){
			Game g = new Game();
			g.setgNum(lG.get(i).getgNum());
			loadGame(g);
			System.out.println("gameid in process: " + lG.get(i).getgNum());
			if (i>39){
				System.out.println("gameid in process: ");
			}

			boolean bFound = false;
			Example ex = null;
			for (int k = 0;k < lUrls.size();k++){
				System.out.println("url in process: " + lUrls.get(k));
				ex = getScoreboard(lUrls.get(k));
				if (ex!=null){
					ex.setGame(g);
					bFound = findScoreboard(ex);
					if (bFound){break;}
				}
			}
			
			//System.out.println("xT1S1: " + ex.getGame().getT1S1() + " T1S2: " + ex.getGame().getT1S2() + " T1S3: " + ex.getGame().getT1S3() + " T1S4: " + ex.getGame().getT1S4() + " T1SF: " + ex.getGame().getT1SF());
			//System.out.println("xT2S1: " + ex.getGame().getT2S1() + " T2S2: " + ex.getGame().getT2S2() + " T2S3: " + ex.getGame().getT2S3() + " T2S4: " + ex.getGame().getT2S4() + " T2SF: " + ex.getGame().getT2SF());
	
			if (ex!=null){
				persistGame(ex.getGame());
			}
		}
		long end = System.currentTimeMillis();
		long elapse = end - begin;
		long seconds = (elapse / 1000) % 60;

		System.out.println("testUpdateScores, seconds: " + seconds);
	}
	public Example getScoreboard(String url) throws Exception{
		NCAA_Football fb = new NCAA_Football();
		Example ex;
		try {
			ex = fb.getJSONObject(url);
		} catch (Exception e) {
			ex = null;
			System.out.println("url error");
		}
		
		return ex;
	}
	public boolean findScoreboard(Example ex){
		//scDate = Tuesday, December 29, 2015
		//gDate = Sat. Jan. 2 / 6:45pm
		boolean bFound = false;
		for (int i = 0;i < ex.getScoreboard().size();i++){
			String scDate = ex.getScoreboard().get(i).getDay();
			String gDate = ex.getGame().getDte();
			
			if (scDate.equals(gDate)){
				bFound = true;
				System.out.println("Scoreboard day match found: " + scDate + " - " + gDate);
				//System.out.println("stop);
				findGame(ex, i);
				break;
			}
		}
		return bFound;
	}
	public void findGame(Example ex, int iSc){
		for (int i = 0;i < ex.getScoreboard().get(iSc).getGames().size();i++){
			String aName = ex.getScoreboard().get(iSc).getGames().get(i).getAway().getNameRaw();
			String hName = ex.getScoreboard().get(iSc).getGames().get(i).getHome().getNameRaw();
			
			if (aName.equals(ex.getGame().getT1NAME()) && (hName.equals(ex.getGame().getT2NAME()))) {
				System.out.println("Team names match found A=T1 and H=T2" + "Away: " + aName + " - Home:" + hName);
				findScore(ex, iSc, i);
			}
			if (hName.equals(ex.getGame().getT1NAME()) && (aName.equals(ex.getGame().getT2NAME()))) {
				System.out.println("Team names match found A=T2 and H=T1" + "Away: " + aName + " - Home:" + hName);
				findScore(ex, iSc, i);
			}
		}
	}
	public void findScore(Example ex, int iSc, int iG){

		String aName = ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getNameRaw();
		String hName = ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getNameRaw();

		for (int i = 0;i < ex.getScoreboard().get(iSc).getGames().get(iG).getScoreBreakdown().size();i++){
			String aSc = ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i);
			String hSc = ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i);
			double aFinal = 0;
			double hFinal = 0;
			if (aName.equals(ex.getGame().getT1NAME()) && (hName.equals(ex.getGame().getT2NAME()))) { 
				if (i == 0){ex.getGame().setT1S1(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				if (i == 1){ex.getGame().setT1S2(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				if (i == 2){ex.getGame().setT1S3(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				if (i == 3){ex.getGame().setT1S4(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				ex.getGame().setT1SF(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getCurrentScore());
				//if (i > 3){aFinal = aFinal + Double.parseDouble(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
	
				if (i == 0){ex.getGame().setT2S1(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				if (i == 1){ex.getGame().setT2S2(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				if (i == 2){ex.getGame().setT2S3(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				if (i == 3){ex.getGame().setT2S4(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				ex.getGame().setT2SF(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getCurrentScore());
				//if (i > 3){hFinal = hFinal + Double.parseDouble(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				//ex.getGame().setT1SF(String.valueOf(aFinal));
				//ex.getGame().setT2SF(String.valueOf(hFinal));
			}
			else
			{
				if (i == 0){ex.getGame().setT2S1(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				if (i == 1){ex.getGame().setT2S2(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				if (i == 2){ex.getGame().setT2S3(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				if (i == 3){ex.getGame().setT2S4(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				ex.getGame().setT2SF(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getCurrentScore());
				//if (i > 3){aFinal = aFinal + Double.parseDouble(ex.getScoreboard().get(iSc).getGames().get(iG).getAway().getScoreBreakdown().get(i));}
				
				if (i == 0){ex.getGame().setT1S1(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				if (i == 1){ex.getGame().setT1S2(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				if (i == 2){ex.getGame().setT1S3(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				if (i == 3){ex.getGame().setT1S4(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				ex.getGame().setT1SF(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getCurrentScore());
				//if (i > 3){hFinal = hFinal + Double.parseDouble(ex.getScoreboard().get(iSc).getGames().get(iG).getHome().getScoreBreakdown().get(i));}
				//ex.getGame().setT2SF(String.valueOf(aFinal));
				//ex.getGame().setT1SF(String.valueOf(hFinal));
			}
		}
		System.out.println("T1S1: " + ex.getGame().getT1S1() + " T1S2: " + ex.getGame().getT1S2() + " T1S3: " + ex.getGame().getT1S3() + " T1S4: " + ex.getGame().getT1S4() + " T1SF: " + ex.getGame().getT1SF());
		System.out.println("T2S1: " + ex.getGame().getT2S1() + " T2S2: " + ex.getGame().getT2S2() + " T2S3: " + ex.getGame().getT2S3() + " T2S4: " + ex.getGame().getT2S4() + " T2SF: " + ex.getGame().getT2SF());
	}

	public void refreshBrackets(String yr) throws NamingException {
		
		iT1S2Q = 0;
		iT2S2Q = 0;
		iT1SF  = 0;
		iT2SF  = 0;
		
		PlayerDAO pDAO = new PlayerDAO();
		ArrayList<Game> lGames = new ArrayList<Game>(); 
		try {
			lGames = getAllGames(yr);
		} catch (NamingException e) {
			e.printStackTrace();
		}

		for (int i = 0;i < lGames.size();i++){
			refreshBracket(lGames.get(i));
		}
	}
	public void refreshBracket(Game g) throws NamingException {
		
		iT1S2Q = 0;
		iT2S2Q = 0;
		iT1SF  = 0;
		iT2SF  = 0;
		
		PlayerDAO pDAO = new PlayerDAO();

//		if (g.getT1S2().equals("NA") || g.getT1SF().equals("NA") || g.getT2S2().equals("NA") || g.getT2SF().equals("NA")){
			if (g.getT1S2().equals("NA")){iT1S2Q = 0;} else {iT1S2Q = Integer.parseInt(g.getT1S2()) + Integer.parseInt(g.getT1S1());}
			if (g.getT2S2().equals("NA")){iT2S2Q = 0;} else {iT2S2Q = Integer.parseInt(g.getT2S2()) + Integer.parseInt(g.getT2S1());}
			if (g.getT1SF().equals("NA")){iT1SF = 0;} else {iT1SF = Integer.parseInt(g.getT1SF());}
			if (g.getT2SF().equals("NA")){iT2SF = 0;} else {iT2SF = Integer.parseInt(g.getT2SF());}
//		}
//		else
//		{
//			iT1S2Q = Integer.parseInt(g.getT1S1()) + Integer.parseInt(g.getT1S2());
//			iT2S2Q = Integer.parseInt(g.getT2S1()) + Integer.parseInt(g.getT2S2());
//			iT1SF  = Integer.parseInt(g.getT1SF());
//			iT2SF  = Integer.parseInt(g.getT2SF());
//		}
		String sRtn = "";
		T1NUM = new ArrayList<String>(Arrays.asList(g.getT1NUM().split(",")));
		T2NUM = new ArrayList<String>(Arrays.asList(g.getT2NUM().split(",")));
		PNUM = new ArrayList<String>(Arrays.asList(g.getpNum().split(",")));
		sRtn = sRtn + "<table class=\"myTable\" border=\"1\">";
		sRtn = sRtn + "<caption class=\"myP3\">" + g.getgName() + "  -  " + g.getT1NAME() + "  -  " + g.getT2NAME()  + "</caption>";
		sRtn = sRtn + "<caption class=\"myP3\">" + g.getDte() + " - " + g.getTv() + "</caption>";
		sRtn = sRtn + "<th class=\"myTd3\">Team</th><th class=\"myTd3\">1st Qtr</th><th class=\"myTd3\">2nd Qtr</th><th class=\"myTd3\">3rd Qtr</th><th class=\"myTd3\">4th Qtr</th><th class=\"myTd3\">Final</th>";
		sRtn = sRtn + "<tr><td class=\"myTd3\">" + g.getT1NAME() + "</td><td class=\"myTd4\">" + g.getT1S1() + "</td><td class=\"myTd4\">" + g.getT1S2() + "</td><td class=\"myTd4\">" + g.getT1S3() + "</td><td class=\"myTd4\">" + g.getT1S4() + "</td><td class=\"myTd4\">" + g.getT1SF() + "</td></tr>";
		sRtn = sRtn + "<tr><td class=\"myTd3\">" + g.getT2NAME() + "</td><td class=\"myTd4\">" + g.getT2S1() + "</td><td class=\"myTd4\">" + g.getT2S2() + "</td><td class=\"myTd4\">" + g.getT2S3() + "</td><td class=\"myTd4\">" + g.getT2S4() + "</td><td class=\"myTd4\">" + g.getT2SF() + "</td></tr>";			
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</table><br><br>";
		sRtn = sRtn + "<table class=\"myTable\" border=\"1\">";
		sRtn = sRtn + "<tr class=\"myTr1\"><td class=\"myTd4\" colspan=\"12\">" + g.getT1NAME() + "</td></tr>";
		sRtn = sRtn + "<tr class=\"myTr1\"><td class=\"myTd4\" rowspan=\"12\">" + g.getT2NAME() + "</td></tr>";
		sRtn = sRtn + "<tr class=\"myTr1\">";
		sRtn = sRtn + "<td class=\"myTd2\"></td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(0) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(1) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(2) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(3) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(4) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(5) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(6) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(7) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(8) + "</td>";
		sRtn = sRtn + "<td class=\"myTd2\">" + T1NUM.get(9) + "</td>";
		sRtn = sRtn + "</tr>";
					
		int pn = 0;
		for (int k = 0;k < T2NUM.size();k++){
			int vn = 0;
			sRtn = sRtn + "<tr class=\"myTr1\">";
			sRtn = sRtn + "<td  class=\"myTd2\">" + T2NUM.get(k) + "</td>";
			sRtn = sRtn + checkScore(PNUM.get(pn), 0, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 1, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 2, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 3, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 4, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 5, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 6, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 7, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 8, k, g);pn++;vn++;
			sRtn = sRtn + checkScore(PNUM.get(pn), 9, k, g);pn++;vn++;
			sRtn = sRtn + "</tr>";
		}
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"12\" class=\"myP3\">Halftime Score Payout: $" + g.getPay2() + "</td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td colspan=\"12\" class=\"myP3\">Final Score Payout: $" + g.getPayF() + "</td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "</table>";
		sRtn = sRtn + "</p>";
		g.setBracketHtml(sRtn);
		try {
			persistGame(g);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private String checkScore(String pnum, int T1Num, int T2Num, Game g) throws NamingException{
		String sRtn = "";
		PlayerDAO pDAO = new PlayerDAO();
		System.out.println("t1num: " + T1Num + "    t2num: " + T2Num + "    iT1S2Q: " + iT1S2Q + "    iT2S2Q: " + iT2S2Q  + "    t1sf: " + g.getT1SF() + "    t2sf: " + g.getT2SF() + "     player: " + pDAO.getPlayerName(pnum));
		//The scores entered are per quarter score except for the final which is already added up.  iT1S2F & iT2S2F is already added as well.
		String tmpt1s2Q = Integer.toString(iT1S2Q).substring(Integer.toString(iT1S2Q).length() - 1);
		String tmpt2s2Q = Integer.toString(iT2S2Q).substring(Integer.toString(iT2S2Q).length() - 1);
		String tmpt1sF = g.getT1SF().substring(g.getT1SF().length() - 1);
		String tmpt2sF = g.getT2SF().substring(g.getT2SF().length() - 1);
		/*
		 * 
		 */
		if (g.getT1S2().equals("NA") && g.getT2S2().equals("NA") && g.getT1SF().equals("NA") && g.getT2SF().equals("NA")){
			sRtn = "<td class=\"myTd1\">" + pDAO.getPlayerName(pnum) + "</td>";
			return sRtn;
		}
		else
		{
			//Final Score is NA
			if (g.getT1SF().equals("NA") || g.getT2SF().equals("NA")){
				sRtn = "<td class=\"myTd1\">" + pDAO.getPlayerName(pnum) + "</td>";
				return sRtn;
			}
			else
			{
				int idxOfT1NumF = T1NUM.indexOf(tmpt1sF);
				int idxOfT2NumF = T2NUM.indexOf(tmpt2sF);
				if (T1Num == idxOfT1NumF && T2Num == idxOfT2NumF){  
					sRtn = "<td class=\"myTd1\" bgcolor=\"yellow\">" + pDAO.getPlayerName(pnum) + "</td>";
					//if (T1Num == idxOfT1NumF && T2Num == idxOfT2NumF){
						g.setWinF(pnum);
						return sRtn;
					//}
				}
			}
			//Half time score is NA
			if (g.getT1S2().equals("NA") || g.getT2S2().equals("NA")){
				sRtn = "<td class=\"myTd1\">" + pDAO.getPlayerName(pnum) + "</td>";
				//sRtn = "<td align=\"center\">" + pnum + " - " + pDAO.getPlayerName(pnum) + "</td>";
			}
			else
			{
				int idxOfT1Num2Q = T1NUM.indexOf(tmpt1s2Q);
				int idxOfT2Num2Q = T2NUM.indexOf(tmpt2s2Q);
				if ((T1Num == idxOfT1Num2Q && T2Num == idxOfT2Num2Q)){  
					sRtn = "<td class=\"myTd1\" bgcolor=\"yellow\">" + pDAO.getPlayerName(pnum) + "</td>";
					//if (T1Num == idxOfT1Num2Q && T2Num == idxOfT2Num2Q){
						g.setWin2(pnum);
						return sRtn;
					//}
				}
			}
		}
		sRtn = "<td class=\"myTd1\">" + pDAO.getPlayerName(pnum) + "</td>";
		return sRtn;
	}
	public String getGameEdit(Game g) {
		System.out.println("getGameEdit, gnum: " + g.getgNum());
		String sRtn = "";
		PreparedStatement pstmt = null;
		try {
			boolean bFound = loadGame(g);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		sRtn = sRtn + "<table class=\"table\" frame=\"box\">";
		sRtn = sRtn + "<tbody>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td><label align=\"center\">Team Name<input type=\"text\" class=\"form-control specWidth3\" id=\"g1Name\" value=\"" + g.getT1NAME() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">1<input type=\"text\" class=\"form-control specWidth\" id=\"t1s1\" value=\"" + g.getT1S1() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">2<input type=\"text\" class=\"form-control specWidth\" id=\"t1s2\" value=\"" + g.getT1S2() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">3<input type=\"text\" class=\"form-control specWidth\" id=\"t1s3\" value=\"" + g.getT1S3() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">4<input type=\"text\" class=\"form-control specWidth\" id=\"t1s4\" value=\"" + g.getT1S4() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">F<input type=\"text\" class=\"form-control specWidth\" id=\"t1sF\" value=\"" + g.getT1SF() + "\"></label></td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr>";
		sRtn = sRtn + "<td><label align=\"center\">Team Name<input type=\"text\" class=\"form-control specWidth3\" id=\"g2Name\" value=\"" + g.getT2NAME() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">1<input type=\"text\" class=\"form-control specWidth\" id=\"t2s1\" value=\"" + g.getT2S1() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">2<input type=\"text\" class=\"form-control specWidth\" id=\"t2s2\" value=\"" + g.getT2S2() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">3<input type=\"text\" class=\"form-control specWidth\" id=\"t2s3\" value=\"" + g.getT2S3() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">4<input type=\"text\" class=\"form-control specWidth\" id=\"t2s4\" value=\"" + g.getT2S4() + "\"></label></td>";
		sRtn = sRtn + "<td><label align=\"center\">F<input type=\"text\" class=\"form-control specWidth\" id=\"t2sF\" value=\"" + g.getT2SF() + "\"></label></td>";
		sRtn = sRtn + "</tr>";

		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Game Name<input type=\"text\" class=\"form-control specWidth2\" id=\"gname\" value=\"" + g.getgName() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Location<input type=\"text\" class=\"form-control specWidth2\" id=\"gloc\" value=\"" + g.getLoc() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Date<input type=\"text\" class=\"form-control specWidth2\" id=\"gdte\" value=\"" + g.getDte() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Tv<input type=\"text\" class=\"form-control specWidth2\" id=\"gtv\" value=\"" + g.getTv() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><button type=\"button\" id=\"subbtn\" class=\"btn btn-submit\">Submit</button></td></tr>";
//		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Winner at First Quarter<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gwin1\" value=\"" + g.getWin1() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Winner at Half Time<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gwin2\" value=\"" + g.getWin2() + "\"></label></td></tr>";
//		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Winner at Third Quarter<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gwin3\" value=\"" + g.getWin3() + "\"></label></td></tr>";
//		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Winner at Fourth Quarter<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gwin4\" value=\"" + g.getWin4() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Winner at Final Score<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gwinF\" value=\"" + g.getWinF() + "\"></label></td></tr>";
//		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Amount of Payout for First Quarter<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gpay1\" value=\"" + g.getPay1() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Amount of Payout for Second Quarter<input type=\"text\" class=\"form-control specWidth2\" id=\"gpay2\" value=\"" + g.getPay2() + "\"></label></td></tr>";
//		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Amount of Payout for Third Quarter<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gpay3\" value=\"" + g.getPay3() + "\"></label></td></tr>";
//		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Amount of Payout for Fourth Quarter<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gpay4\" value=\"" + g.getPay4() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Amount of Payout at Final Score<input type=\"text\" class=\"form-control specWidth2\" id=\"gpayF\" value=\"" + g.getPayF() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Game Number (Key)<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gnum\" value=\"" + g.getgNum() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Player numbers<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gpnum\" value=\"" + g.getpNum() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Team 1 numbers<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gt1num\" value=\"" + g.getT1NUM() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Team 2 numbers<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gt2num\" value=\"" + g.getT2NUM() + "\"></label></td></tr>";
		sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Year<input readonly type=\"text\" class=\"form-control specWidth2\" id=\"gyr\" value=\"" + g.getgYr() + "\"></label></td></tr>";
		//sRtn = sRtn + "<tr><td colspan=\"6\"><label align=\"center\">Bracket HTML<input type=\"text\" class=\"form-control specWidth2\" id=\"gbracket\" value=\"" + g.getBracketHtml() + "\"></label></td></tr>";
		sRtn = sRtn + "</tbody>";
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}

	public String getPayouts(String yr) throws NamingException  {
		System.out.println("getPayouts");
		String sRtn = "";
		PreparedStatement pstmt = null;
		//String sql = "SELECT WIN, PAY FROM ( SELECT DISTINCT(X.WIN) AS WIN, SUM(X.PAY) AS PAY FROM ( SELECT (SELECT P.PNAME FROM `apps`.`PV_PLAYER` P WHERE WIN_2 = P.PID) AS WIN, SUM(G.PAY_2) AS PAY FROM `apps`.`PV_GAME` G WHERE (WIN_2 <> 'NA') GROUP BY WIN UNION 	SELECT (SELECT P.PNAME FROM `apps`.`PV_PLAYER` P WHERE WIN_F = P.PID) AS WIN, SUM(G.PAY_F) AS PAY FROM `apps`.`PV_GAME` G WHERE (WIN_F <> 'NA') GROUP BY WIN ) X GROUP BY X.WIN ) Y ORDER BY Y.PAY DESC";
		//String sql = "SELECT WIN, PAY FROM ( SELECT DISTINCT(X.WIN) AS WIN, SUM(X.PAY) AS PAY FROM (SELECT P.PNAME AS WIN, SUM(G.PAY_2) AS PAY FROM `apps`.`PV_PLAYER` P, `apps`.`PV_GAME` G WHERE P.PYR = ? AND G.YR = ? AND G.WIN_2 = P.PID GROUP BY G.WIN_2, G.YR UNION SELECT P.PNAME AS WIN, SUM(G.PAY_F) AS PAY FROM `apps`.`PV_PLAYER` P, `apps`.`PV_GAME` G WHERE P.PYR = ? AND G.YR = ? AND G.WIN_F = P.PID GROUP BY G.WIN_F, G.YR )X GROUP BY X.WIN ) Y ORDER BY Y.PAY DESC ";
		String sql = "SELECT DISTINCT(Y.WIN) AS WIN, SUM(Y.PAY) AS PAY FROM ( SELECT WIN, SUM(PAY) AS PAY FROM ( SELECT WIN, SUM(PAY) AS PAY FROM ( SELECT P.PNAME AS WIN, SUM(G.PAY_2) AS PAY FROM `apps`.`PV_PLAYER` P, `apps`.`PV_GAME` G WHERE P.PYR = ?  AND G.YR = ? AND G.WIN_2 = P.PID GROUP BY G.WIN_2, G.YR) P1 GROUP BY P1.WIN UNION ALL SELECT WIN, SUM(PAY) AS PAY FROM ( SELECT P.PNAME AS WIN, SUM(G.PAY_F) AS PAY FROM `apps`.`PV_PLAYER` P, `apps`.`PV_GAME` G WHERE P.PYR = ?  AND G.YR = ? AND G.WIN_F = P.PID	 GROUP BY G.WIN_F, G.YR ) P2 GROUP BY P2.WIN ) X GROUP BY X.WIN ) Y GROUP BY Y.WIN DESC ORDER BY Y.PAY DESC, Y.WIN";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, yr);
			pstmt.setString(3, yr);
			pstmt.setString(4, yr);
			
			ResultSet rs = pstmt.executeQuery();
			sRtn = sRtn + "<table class=\"table\" frame=\"box\" width=\"50%\"><thead>";
			sRtn = sRtn + "<tr><th class=\"myTd2\">Player Name</th><th class=\"myTd2\">Winning Amount</th></tr></thead><tbody>";

			while (rs.next()) {
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td class=\"myTd1\">" + rs.getString(1) + "</td>";
				sRtn = sRtn + "<td class=\"myTd1\">" + rs.getString(2) + "</td>";
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

}
