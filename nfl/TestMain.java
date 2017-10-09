package com.nfl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import com.common.MVDBHelper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class TestMain {

	public static JSONObject json = null;
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, NamingException {
		System.out.println("Start");
/*
 * 
 * http://www.nfl.com/liveupdate/scorestrip/ss.xml
 * 
 * 
 */
		
//		initializeData("2017", "Regular");
		
//		initializeLoad("2016", "Preseason");
//		initializeData("2012", "Preseason");
//		initializeData("2012", "Regular");
//
//		initializeData("2013", "Preseason");
//		initializeData("2013", "Regular");
//
//		initializeData("2014", "Preseason");
//		initializeData("2014", "Regular");
//
//		initializeData("2015", "Preseason");
//		initializeData("2015", "Regular");
//
//		initializeData("2016", "Preseason");
//		initializeData("2016", "Regular");

		extractGameidsFromNflHtml();
		//test1();
		//loadPageTest();
		
		System.out.println("Done");
	}
	public static UpdInfo timeForUpdate(String yr, String seas) throws NamingException{
		/*- Determine last update date/time (saved in parm table)
		  - If date/time > updateFreq in hours
			o   return true
		  - Date/time < 4 hours
			o   return false
		*/

		UpdInfo updInfo = new UpdInfo();
		boolean bRtn = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		String updFreq = ParmDB.getParmAsString("Update_Freq");
		String lastUpd = ParmDB.getParmAsString("Last_Update");

		Calendar calendar1_lstUpd = Calendar.getInstance();
		Calendar calendar2_current = Calendar.getInstance();
		calendar1_lstUpd.setTime(new Date(lastUpd));
		long milsecs1= calendar1_lstUpd.getTimeInMillis();
		long milsecs2 = calendar2_current.getTimeInMillis();
		long diff = milsecs2 - milsecs1;
		long dsecs = diff / 1000;
		long dminutes = diff / (60 * 1000);
		long dhours = diff / (60 * 60 * 1000);
		long ddays = diff / (24 * 60 * 60 * 1000);

		System.out.println("Your Hour Difference= " + dhours);

		if (dhours >= Integer.parseInt(updFreq)){
			updInfo.setUpdData(true);
			System.out.println(" hours greater or equal to update frequency - perform an update: " + dateFormat.format(calendar1_lstUpd.getTime()));
			ParmDB.updateParmLastUpdateDate(dateFormat.format(calendar2_current.getTime()));		   //No matter what date is passed into application update to current date
			updInfo.setLastUpdateTm(dateFormat.format(calendar2_current.getTime()));
			calendar2_current.add(Calendar.HOUR_OF_DAY, 4);
			updInfo.setNextUpdateTm(dateFormat.format(calendar2_current.getTime()));
		}
		else
		{
			updInfo.setUpdData(false);
			updInfo.setLastUpdateTm(dateFormat.format(calendar1_lstUpd.getTime()));
			calendar1_lstUpd.add(Calendar.HOUR_OF_DAY, 4);
			updInfo.setNextUpdateTm(dateFormat.format(calendar1_lstUpd.getTime()));
		}
		return updInfo;
	}
	public static void initializeLoad(String yr, String seas) throws NamingException{
		loadBracket(yr, seas);

		initializeData(yr, seas);
//		initializeData("2012", "Preseason");
//		initializeData("2012", "Regular");
//
//		initializeData("2013", "Preseason");
//		initializeData("2013", "Regular");
//
//		initializeData("2014", "Preseason");
//		initializeData("2014", "Regular");
//
//		initializeData("2015", "Preseason");
//		initializeData("2015", "Regular");
//
//		initializeData("2016", "Preseason");
//		initializeData("2016", "Regular");
	}

	public static void initializeData(String yr, String seas) throws NamingException{
		
		ArrayList<String> lWks = new ArrayList<String>();
		lWks = getNumberOfWeeks(yr, seas);
		long startTime = System.currentTimeMillis();
		
		for (int i = 0;i < lWks.size();i++){
			System.out.println("initializeData, b4 retrieveGameCenterData Week: " + lWks.get(i) + " yr: " + yr + " seas: " + seas);
			retrieveGameCenterData(yr, seas, lWks.get(i));
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
	    
		long startTime2 = System.currentTimeMillis();
		pullDataFromGameStatsToBracket(yr, seas);
		long stopTime2 = System.currentTimeMillis();
		long elapsedTime2 = stopTime2 - startTime2;
	    System.out.println(elapsedTime2);
	    
	}
	public static void initializeDataCurrentPeriod(String yr, String seas) throws NamingException{
		
		ArrayList<String> lWks = new ArrayList<String>();
		lWks = getNumberOfWeeks(yr, seas);
		long startTime = System.currentTimeMillis();
		
		System.out.println("initializeData, b4 retrieveGameCenterData yr: " + yr + " seas: " + seas);
		retrieveGameCenterDataCurrentPeriod(yr, seas);

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
	    
//		long startTime2 = System.currentTimeMillis();
//		pullDataFromGameStatsToBracket(yr, seas);
//		long stopTime2 = System.currentTimeMillis();
//		long elapsedTime2 = stopTime2 - startTime2;
//	    System.out.println(elapsedTime2);
	    
	}

//	public static void loadPageTest() throws NamingException{
//		String sql = "Select distinct(Wk), Yr, Season from `apps`.`nfl_gamestats` where gamejson = 'NA'";
//		PreparedStatement pstmt = null;
//		
//		try {
//			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				System.out.println("select gamestats, yr-season-week-hteam-hscore-ateam-ascore: " + rs.getString("Yr") + "-" + rs.getString("Season") + "-" + rs.getString("Wk"));
//				BracketDB.loadPage(rs.getString("Yr"), rs.getString("Season"), rs.getString("Wk"));
//			}
//
//			rs.close();
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
	public static void extractGameidsFromNflHtml(){
		json = new JSONObject();
		loadTeamNames();

		ArrayList<String> lGameids = new ArrayList<String>();
		System.out.println("INSERT INTO `apps`.`nfl_gamestats` (`Yr`, `Season`, `Gameid`, `Wk`, `HTeam`, `HScore`, `ATeam`, `AScore`, `GameJson`) VALUES");
		Scanner scanner = null;
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2012nflhtmlpreseason");String yr = "2012";String seas = "Preseason";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2012nflhtmlregularseason");String yr = "2012";String seas = "Regular";//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2013nflhtmlpreseason");String yr = "2013";String seas = "Preseason";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2013nflhtmlregularseason");String yr = "2013";String seas = "Regular";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2014nflhtmlpreseason");String yr = "2014";String seas = "Preseason";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2014nflhtmlregularseason");String yr = "2014";String seas = "Regular";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2015nflhtml");String yr = "2015";String seas = "Regular";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2015nflhtmlpreseason2016-04-25Test");String yr = "2015";String seas = "Preseason";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2016nflhtmlregularseason");String yr = "2016";String seas = "Regular";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2016nflhtmlpreseason");String yr = "2016";String seas = "Preseason";
		File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2017nflhtmlpreseason");String yr = "2017";String seas = "Preseason";
		//File f = new File("/home/healthyhix/@OpenShift/19 Point Challenge/2017nflhtmlregularseason");String yr = "2017";String seas = "Regular";
		String sRtn = "";
		try {
			scanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
		   final String lineFromFile = scanner.nextLine();
		   //int len = lineFromFile.length();
		   //if (yr.equals("2012") && seas.equals("Preseason")){
		   if (yr.equals("2012")){
			   if(lineFromFile.contains("<a href=\"/gamecenter/")) {
			       String[] flds = lineFromFile.split("[/@\"]");
			       if (!lGameids.contains(flds[3])){
			    	   lGameids.add(flds[3]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[3] + "', '" + flds[5].substring(3) + "', '" + json.get(flds[6]) + "', ' ', ' ', '" + json.get(flds[7]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			   }
		   }

		   if (yr.equals("2013") && seas.equals("Preseason")){
			   if(lineFromFile.contains("<a target=\"_top\" href=\"http://www.nfl.com/gamecenter/")) {    //use for 2014
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/@?\"]");
			       if (!lGameids.contains(flds[7])){
			    	   lGameids.add(flds[7]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[7] + "', '" + flds[9].substring(3) + "', '" + json.get(flds[10]) + "', ' ', ' ', '" + json.get(flds[11]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("bGameid: " + flds[7] + " Week: " + flds[9].substring(3) + " Team1: " + flds[10] + "-" + json.get(flds[10]) + " Team2: " + flds[11] + "-" + json.get(flds[11]));
			   }
		   }
		   if (yr.equals("2013") && seas.equals("Regular")){
			   //if(lineFromFile.contains("<a target=\"_top\" href=\"http://www.nfl.com/gamecenter/")) {    //use for 2014
			   if(lineFromFile.contains("<a target=\"_top\" href=\"http://www.nfl.com/gamecenter/")) { 
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/@?\"]");
			       if (!lGameids.contains(flds[7])){
			    	   lGameids.add(flds[7]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[7] + "', '" + flds[9].substring(3) + "', '" + json.get(flds[10]) + "', ' ', ' ', '" + json.get(flds[11]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("bGameid: " + flds[7] + " Week: " + flds[9].substring(3) + " Team1: " + flds[10] + "-" + json.get(flds[10]) + " Team2: " + flds[11] + "-" + json.get(flds[11]));
			   }
			   else
			   {
				   if(lineFromFile.contains("<a href=\"/gamecenter/")) {
				       String[] flds = lineFromFile.split("[/@\"]");
				       if (!lGameids.contains(flds[3])){
				    	   lGameids.add(flds[3]);
				    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[3] + "', '" + flds[5].substring(3) + "', '" + json.get(flds[6]) + "', ' ', ' ', '" + json.get(flds[7]) + "', 'NA'), " + System.getProperty("line.separator");
				       }
				   }
			   }
		   }
		   if (yr.equals("2014") && seas.equals("Preseason")){
			   if(lineFromFile.contains("<a target=\"_top\" href=\"http://www.nfl.com/gamecenter/")) {    //use for 2014
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/@?\"]");
			       if (!lGameids.contains(flds[7])){
			    	   lGameids.add(flds[7]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[7] + "', '" + flds[9].substring(3) + "', '" + json.get(flds[10]) + "', ' ', ' ', '" + json.get(flds[11]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("bGameid: " + flds[7] + " Week: " + flds[9].substring(3) + " Team1: " + flds[10] + "-" + json.get(flds[10]) + " Team2: " + flds[11] + "-" + json.get(flds[11]));
			   }

		   }
		   if (yr.equals("2014") && seas.equals("Regular")){
			   if(lineFromFile.contains("<a href=\"/gamecenter/")) {    //use for 2014
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/@\"]");
			       if (!lGameids.contains(flds[3])){
			    	   lGameids.add(flds[3]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[3] + "', '" + flds[5].substring(3) + "', '" + json.get(flds[6]) + "', ' ', ' ', '" + json.get(flds[7]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("aGameid: " + flds[3] + " Week: " + flds[6].substring(3) + " Team1: " + flds[7] + "-" + json.get(flds[7]) + " Team2: " + json.get(flds[8].substring(0,flds[8].length()-1)) + " xxx: " + flds[8]);
			   }
		   }
		   if (yr.equals("2016") && seas.equals("Preseason")){
			   if(lineFromFile.contains("<a href=\"/gamecenter/")) {    //use for 2014
			       System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/@\"]");
			       if (!lGameids.contains(flds[3])){
			    	   lGameids.add(flds[3]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[3] + "', '" + flds[5].substring(3) + "', '" + json.get(flds[6]) + "', ' ', ' ', '" + json.get(flds[7]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       System.out.println("aGameid: " + flds[3] + " Week: " + flds[6].substring(3) + " Team1: " + flds[7] + "-" + json.get(flds[7]) + " Team2: " + json.get(flds[8].substring(0,flds[8].length()-1)) + " xxx: " + flds[8]);
			   }
		   }
		   if ( yr.equals("2015") || (yr.equals("2016") && seas.equals("Regular"))){
		   		if(lineFromFile.contains("url: \"http://www.nfl.com/gamecenter/")) {   //use for 2015
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/-]");
			       if (!lGameids.contains(flds[4])){
			    	   lGameids.add(flds[4]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[4] + "', '" + flds[6].substring(3) + "', '" + json.get(flds[7]) + "', ' ', ' ', '" + json.get(flds[8].substring(0,flds[8].length()-1)) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("Gameid: " + flds[4] + " Week: " + flds[6].substring(3) + " Team1: " + flds[7] + "-" + json.get(flds[7]) + " Team2: " + flds[8] + "-" + json.get(flds[8].substring(0,flds[8].length()-1)));
			   }
		   }
		   if (yr.equals("2017") && seas.equals("Preseason")){
			   if(lineFromFile.contains("<a target=\"_top\" href=\"http://www.nfl.com/gamecenter/")) {    //use for 2014
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/@?\"]");
			       if (!lGameids.contains(flds[7])){
			    	   lGameids.add(flds[7]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[7] + "', '" + flds[9].substring(3) + "', '" + json.get(flds[10]) + "', ' ', ' ', '" + json.get(flds[11]) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("bGameid: " + flds[7] + " Week: " + flds[9].substring(3) + " Team1: " + flds[10] + "-" + json.get(flds[10]) + " Team2: " + flds[11] + "-" + json.get(flds[11]));
			   }

//			   if(lineFromFile.contains("<a href=\"/gamecenter/")) {    //use for 2014
//			       System.out.println(lineFromFile);
//			       String[] flds = lineFromFile.split("[/@\"]");
//			       if (!lGameids.contains(flds[3])){
//			    	   lGameids.add(flds[3]);
//			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[3] + "', '" + flds[5].substring(3) + "', '" + json.get(flds[6]) + "', ' ', ' ', '" + json.get(flds[7]) + "', 'NA'), " + System.getProperty("line.separator");
//			       }
//			       System.out.println("aGameid: " + flds[3] + " Week: " + flds[6].substring(3) + " Team1: " + flds[7] + "-" + json.get(flds[7]) + " Team2: " + json.get(flds[8].substring(0,flds[8].length()-1)) + " xxx: " + flds[8]);
//			   }
		   }
		   if ( (yr.equals("2017") && seas.equals("Regular"))){
		   		if(lineFromFile.contains("url: \"http://www.nfl.com/gamecenter/")) {   //use for 2015
			       //System.out.println(lineFromFile);
			       String[] flds = lineFromFile.split("[/-]");
			       if (!lGameids.contains(flds[4])){
			    	   lGameids.add(flds[4]);
			    	   sRtn += "('" + yr + "', '" + seas + "', '" + flds[4] + "', '" + flds[6].substring(3) + "', '" + json.get(flds[7]) + "', ' ', ' ', '" + json.get(flds[8].substring(0,flds[8].length()-1)) + "', 'NA'), " + System.getProperty("line.separator");
			       }
			       //System.out.println("Gameid: " + flds[4] + " Week: " + flds[6].substring(3) + " Team1: " + flds[7] + "-" + json.get(flds[7]) + " Team2: " + flds[8] + "-" + json.get(flds[8].substring(0,flds[8].length()-1)));
			   }
		   }
		}
		//System.out.println("Lines: " + linecount);
		sRtn = sRtn.substring(0,sRtn.length() - 3);
		System.out.println(sRtn);
	}
	@SuppressWarnings("unchecked")
	private static void loadTeamNames(){
		
		json = new JSONObject();
		json.put("rams", "STL");
		json.put("49ers", "SF");
		json.put("seahawks", "SEA");
		json.put("cardinals", "ARI");
		json.put("chargers", "SD");
		json.put("broncos", "DEN");
		json.put("vikings", "MIN");
		json.put("packers", "GB");
		json.put("lions", "DET");
		json.put("eagles", "PHI");
		json.put("giants", "NYG");
		json.put("redskins", "WAS");
		json.put("raiders", "OAK");
		json.put("cowboys", "DAL");
		json.put("chiefs", "KC");
		json.put("titans", "TEN");
		json.put("colts", "IND");
		json.put("jaguars", "JAC");
		json.put("texans", "HOU");
		json.put("steelers", "PIT");
		json.put("browns", "CLE");
		json.put("ravens", "BAL");
		json.put("saints", "NO");
		json.put("buccaneers", "TB");
		json.put("panthers", "CAR");
		json.put("patriots", "NE");
		json.put("jets", "NYJ");
		json.put("bills", "BUF");
		json.put("bengals", "CIN");
		json.put("dolphins", "MIA");
		json.put("falcons", "ATL");
		json.put("bears", "CHI");
	}

	//public static String loadBracket(String sNumberOfWeeks) throws NamingException{
	public static String loadBracket(String yr, String seas) throws NamingException{
		String sRtn = "loadBracket Started" + "<BR>";
		try {
			BracketDB.deleteBracket(yr, seas);
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		sRtn = sRtn + "bracket deleted" + "<BR>";
		
		ArrayList<String> lPlayers = null;
		try {
			lPlayers = ParmDB.getListOf("Player");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		sRtn = sRtn + "list of players retrieved" + "<BR>";
		for (int i = 0;i < lPlayers.size();i++){
			System.out.println("Player: " + lPlayers.get(i));
			try {
				BracketDB.insertBracketStarter(lPlayers.get(i), yr, seas);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		sRtn = sRtn + "basic bracket created" + "<BR>";
		ArrayList<String> lTeams = null;
		
		ArrayList<String> lWks = new ArrayList<String>();
		lWks = getNumberOfWeeks(yr, seas);
		
		for (int k = 0;k < lWks.size();k++){
			try {
				lTeams = GameStatsDB.getListOfTeams(yr, seas, lWks.get(k));
			} catch (NamingException e) {
				e.printStackTrace();
			}
			System.out.println("team size: " + lTeams.size());
			System.out.println("player size: " + lPlayers.size());
			SuffleList(lTeams);
			for (int i = 0;i < lPlayers.size();i++){
				System.out.println("Week: " + lWks.get(k) + " Team: " + lTeams.get(i) + " Player: " + lPlayers.get(i));
				BracketDB.updateBracketAssignTeams(lWks.get(k), lTeams.get(i), lPlayers.get(i));
			}
			lTeams.clear();
			//break;
		}
		sRtn = sRtn + " loadbracket complete" + "<BR>";
		return sRtn;
	}	
	public static ArrayList<String> getNumberOfWeeks(String yr, String seas) throws NamingException {
		ArrayList<String> lRtn = new ArrayList<String>();
		
		int iRtn = 0;
		String sql = "Select distinct(wk) as cnt from `apps`.`nfl_gamestats` where yr= ? and season= ? and wk <> '0' order by wk * 1 asc";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				iRtn++;
				lRtn.add(rs.getString(1));
			}
			System.out.println("getNumberOfWeeks -- select gamestats, yr-seas: " + yr + " - " + seas + " number of weeks: " + iRtn);
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
	public static List SuffleList(List lToShuffle) {
        
        Collections.shuffle(lToShuffle);
        return lToShuffle;
	}
	public static void pullDataFromGameStatsToBracket(String yr, String seas) throws NamingException{
		
		/*
		 * select all the records from the gamestats table
		 *    for each record
		 *        perform Update on Bracket table (where week = , team* = HTeam) score* = HScore  
		 * 
		 */
		String sql = "Select * from `apps`.`nfl_gamestats` where yr= ? and season= ? and wk <> '0'";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
			//pstmt.setString(3, wk);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("pullDataFromGameStatsToBracket, select gamestats, week-hteam-hscore-ateam-ascore: " + rs.getString("Wk") + " - " + rs.getString("HTeam") + " - " + rs.getString("HScore") + " - " + rs.getString("ATeam") + " - " + rs.getString("AScore"));
				//iRtn = Integer.parseInt(rs.getString(1));
				BracketDB.updateBracket(yr, seas, rs.getString("Wk"), rs.getString("HScore"), rs.getString("HTeam"));
				BracketDB.updateBracket(yr, seas, rs.getString("Wk"), rs.getString("AScore"), rs.getString("ATeam"));
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
	}

	public static void retrieveGameCenterData(String yr, String seas, String wk) throws NamingException{
		System.out.println("retrieveGameCenterData, yr: " + yr + " season: " + seas + " week: " + wk);
		String sUrl = "http://www.nfl.com/liveupdate/game-center/";
		//String sGid = "2016122405";
		String sGid = "";
		String sUrlSfx = "_gtd.json";
		String abc = "";
		
		ArrayList<String> lGameids = null;
		try {
			lGameids = GameStatsDB.getListOfGameidsByWeek(yr, seas, wk);
		} catch (NamingException e1) {
			e1.printStackTrace();
		}

		
		if (lGameids.size() < 1){
			System.out.println("***************************************************");
			System.out.println("No Game Ids found to update");
			System.out.println("***************************************************");
		}
		for (int i = 0;i < lGameids.size();i++){
			if (lGameids.get(i).equals("2016122409")){
				System.out.println("TestStop");
			}
			System.out.println("retrieveGameCenterData calling gamecenter, gameid: " + lGameids.get(i));
			sGid = lGameids.get(i);
			try {
				abc = CallGameCenter.getUrlSource(sUrl + sGid + "/" + sGid + sUrlSfx);
				//abc = CallGameCenter.getUrlSource(sUrl + sGid + "/" + sGid + sUrlSfx);
			} catch (IOException e) {
				e.printStackTrace();
			}
			GameStat gs = null;
			try {
				gs = GameStatsDB.getGameStatByGameid(sGid);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			gs.setGameJson(abc);
			
			GameParser gp = new GameParser();
			gp.parse(gs);	
			
			try {
				GameStatsDB.updateGameStats(gs);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
	public static void retrieveGameCenterDataCurrentPeriod(String yr, String seas) throws NamingException{
		System.out.println("retrieveGameCenterDataCurrentPeriod, yr: " + yr + " season: " + seas);
		String sUrl = "http://www.nfl.com/liveupdate/game-center/";
		//String sGid = "2014122101";
		String sGid = "";
		String sUrlSfx = "_gtd.json";
		String abc = "";
		
		ArrayList<String> lGameids = null;
		try {
			lGameids = GameStatsDB.getListOfGameidsCurrentPeriod(yr, seas);
		} catch (NamingException e1) {
			e1.printStackTrace();
		}

		if (lGameids.size() < 1){
			System.out.println("***************************************************");
			System.out.println("No Game Ids found to update");
			System.out.println("***************************************************");
		}
		for (int i = 0;i < lGameids.size();i++){
			System.out.println("retrieveGameCenterData calling gamecenter, gameid: " + lGameids.get(i));
			if (lGameids.get(i).equals("2016122409")){
				System.out.println("TestStop");
			}
			sGid = lGameids.get(i);
			try {
				abc = CallGameCenter.getUrlSource(sUrl + sGid + "/" + sGid + sUrlSfx);
			} catch (IOException e) {
				e.printStackTrace();
			}
			GameStat gs = null;
			try {
				gs = GameStatsDB.getGameStatByGameid(sGid);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			gs.setGameJson(abc);
			
			GameParser gp = new GameParser();
			gp.parse(gs);	
			
			try {
				GameStatsDB.updateGameStats(gs);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			BracketDB.updateBracket(yr, seas, gs.getWk(), gs.getHScore(), gs.getHTeam());
			BracketDB.updateBracket(yr, seas, gs.getWk(), gs.getAScore(), gs.getATeam());
		}
	}

//		
//		if (abc.equals("Not Found")){
//			gs = new GameStat();
//			gs.setGameid(sGid);
//		}
//		else
//		{
//		}
		
//		String wk = "";

//		String def = "";
//		try {
//			def = ParmDB.getWeekByDate("8/23/2014");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	
//		ArrayList<String> lPlayers = null;
//		try {
//			lPlayers = ParmDB.getListOf("Player");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		for (int i = 0;i < lPlayers.size();i++){
//			System.out.println("Player: " + lPlayers.get(i));
//		}
//		ArrayList<String> lTeams = null;
//		try {
//			lTeams = ParmDB.getListOf("Team");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		for (int i = 0;i < lTeams.size();i++){
//			System.out.println("Team: " + lTeams.get(i));
//		}
//		
//		String ghi = "";
//		try {
//			ghi = ParmDB.getPlayerNameByNumber("00");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//
//
//	}
	
	
//	ArrayList<String> lGameids = null;
//	try {
//		lGameids = GameidSource.getGameidsByWeek(wk);
//	} catch (NamingException e) {
//		e.printStackTrace();
//	}
//	
//	for (int i = 0;i < lGameids.size();i++){
//		System.out.println(lGameids.get(i));
//		sGid = lGameids.get(i);
//		try {
//			GameStatsDB.deleteGameStats(lGameids.get(i));;
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		


//	private static String getUrlSource(String url) throws IOException {
//		URL yahoo = new URL(url);
//		URLConnection yc = yahoo.openConnection();
//		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
//		String inputLine;
//		StringBuilder a = new StringBuilder();
//		while ((inputLine = in.readLine()) != null) {
//			a.append(inputLine);
//		}
//		in.close();
//		return a.toString();
//	}
}
