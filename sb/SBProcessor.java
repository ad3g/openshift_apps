package com.sb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.sb.*;

import static java.util.Comparator.comparing;

import com.nfl.*;

public class SBProcessor {
	static String line;
	static ArrayList<Game> lGame = null;
	static ArrayList<Player> lPlayer = null;
	static ArrayList<Player> lUniquePlayer = null;
	static final String CR = "<BR>";
	static ArrayList<String> lNotes = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException, ParseException, NamingException {
		ArrayList<String> lGameids = GameStatsDB.getListOfGameidsByWeek("2016", "Regular","16");
		for (int i = 0;i < lGameids.size();i++){
			processGameid(lGameids.get(i));
			//break;
		}
		for (int x = 0;x < lNotes.size();x++){
			System.out.println("Note: " + lNotes.get(x));
		}		

	}
	public static void processGameid(String gid) throws IOException, ParseException, NamingException {
		
		JsonParser jp = new JsonParser();
		//String gid = "2017011400";
		
		GameStat gs = GameStatsDB.getGameStatByGameid(gid);
		Game g = new Game();
		g.setAFCAbbr(gs.getATeam());
		g.setNFCAbbr(gs.getHTeam());
//		g.getGame();
//		gid = g.getGameid();
		String gameCtrJson = CallGameCenter.getUrlSource("http://www.nfl.com/liveupdate/game-center/" + gid + "/" + gid + "_gtd.json");

		JSONObject jsonObject;
		jsonObject = (JSONObject) JSONValue.parseWithException(gameCtrJson);
		
		JSONObject jsonObjectGameid = (JSONObject) jsonObject.get(gid);
		GameidJsonRoot root = jp.loadRoot(jsonObjectGameid); 
		
	 	Scores sc = new Scores();
		sc.resetScores();
		
		displayScoringPlays(root, g);
		System.out.println("stop");
		
//		
//		if (Logger.DefineLogFile()) {
//			Logger.log("SquareProcessor Starting","Info");
//			if (args.length == 1) {
//				sInputFileName = args[0];
//				Logger.log("Input File Name: " + sInputFileName,"Info");
//				ProcessInput(sInputFileName);
//			}
//			else
//			{
//				Logger.log("Error: Incorrect Arguments passed", "Error");
//				for (String s: args) {
//					Logger.log("arg: " + s,"Error");
//		        }
//				Logger.log("Usage: SquareProcessor File Name", "Error");
//				return;
//			}
//		} 
//		Logger.log(" ","Info");
//		Logger.log(" ","Info");
//		Logger.log("SquareProcessor Complete","Info");
	}
	private static void displayScoringPlays(GameidJsonRoot root, Game g) throws NamingException{
		
		ArrayList<Plays> lAllPlays = new ArrayList<Plays>();
		
		for (int i = 0;i < root.getlDrives().size();i++){
			for (int j = 0;j < root.getlDrives().get(i).getlPlays().size();j++){
				if (root.getlDrives().get(i).getlPlays().get(j).getSp().equals("1")){
					Plays p = new Plays();
					p = root.getlDrives().get(i).getlPlays().get(j);
					p.setPosteam(root.getlDrives().get(i).getPosteam());
					lAllPlays.add(p);
					
//					System.out.println("sp: " + root.getlDrives().get(i).getlPlays().get(j).getSp()
//					+ " id: " + root.getlDrives().get(i).getlPlays().get(j).getId()
//					+ " qtr: " + root.getlDrives().get(i).getlPlays().get(j).getQtr()
//					+ " note: " + root.getlDrives().get(i).getlPlays().get(j).getNote()
//					);
				}
			}
		}
// This works on string but because numbers 1629 comes before 734 this doesn't work
//		Collections.sort(lAllPlays, new Comparator<Plays>() {
//		    public int compare(Plays v1, Plays v2) {
//		        return v1.getId().compareTo(v2.getId());
//		    }
//		});		

		Collections.sort(lAllPlays, new Comparator<Plays>() {
		    public int compare(Plays v1, Plays v2) {
		        return v1.getId() - (v2.getId());
		    }
		});		
		for (int x = 0;x < lAllPlays.size();x++){
			//System.out.println("id: " + lAllPlays.get(x).getId());
			System.out.println("sp: " + lAllPlays.get(x).getSp()
					+ " id: " + lAllPlays.get(x).getId()
					+ " qtr: " + lAllPlays.get(x).getQtr()
					+ " team: " + lAllPlays.get(x).getPosteam()
					+ " note: " + lAllPlays.get(x).getNote()
					);
		 	Scores sc = new Scores();
		 	sc.setQtr(lAllPlays.get(x).getQtr());
			sc.setDivision(convertDivision(root.getHome().getAbbr(), root.getAway().getAbbr(), lAllPlays.get(x).getPosteam(), lAllPlays.get(x).getNote(), g));
			sc.setPTS(convertNoteToScore(lAllPlays.get(x).getNote()));
			sc.insertScore();
			if (!lNotes.contains(lAllPlays.get(x).getNote())){
				lNotes.add(lAllPlays.get(x).getNote());
			}
		}

	}
	public static String convertDivision(String home, String away, String div, String note, Game g){
		String rtn = "";
		
		if (g.getNFCAbbr().equals(div)){
//		if (home.contains(div)){
			if (note.equals("SAF") || note.equals("2PPF")){
				rtn = "AFC";
			}
			else
			{
				rtn = "NFC";
			}
		}
		else
		{
			if (note.equals("SAF") || note.equals("2PPF")){
				rtn = "NFC";
			}
			else
			{
				rtn = "AFC";
			}
		}
		//ArrayList<String> lNfc = new ArrayList<String>();
		//ArrayList<String> lAfc = new ArrayList<String>();
		
//		lNfc.add("DAL");//json.put("cowboys", "DAL");
//		lNfc.add("NYG");//json.put("giants", "NYG");
//		lNfc.add("PHI");//json.put("eagles", "PHI");
//		lNfc.add("WAS");//json.put("redskins", "WAS");
//		lNfc.add("ATL");//json.put("falcons", "ATL");
//		lNfc.add("CAR");//json.put("panthers", "CAR");
//		lNfc.add("NO");//json.put("saints", "NO");
//		lNfc.add("TB");//json.put("buccaneers", "TB");
//		lNfc.add("CHI");//json.put("bears", "CHI");
//		lNfc.add("DET");//json.put("lions", "DET");
//		lNfc.add("GB");//json.put("packers", "GB");
//		lNfc.add("MIN");//json.put("vikings", "MIN");
//		lNfc.add("ARI");//json.put("cardinals", "ARI");
//		lNfc.add("LA");//json.put("rams", "STL");    ???????????????
//		lNfc.add("SF");//json.put("49ers", "SF");
//		lNfc.add("SEA");//json.put("seahawks", "SEA");
		
//		lAfc.add("BUF");//json.put("bills", "BUF");
//		lAfc.add("MIA");//json.put("dolphins", "MIA");
//		lAfc.add("NE");//json.put("patriots", "NE");
//		lAfc.add("NYJ");//json.put("jets", "NYJ");
//		lAfc.add("HOU");//json.put("texans", "HOU");
//		lAfc.add("IND");//json.put("colts", "IND");
//		lAfc.add("JAC");//json.put("jaguars", "JAC");
//		lAfc.add("TEN");//json.put("titans", "TEN");
//		lAfc.add("BAL");//json.put("ravens", "BAL");
//		lAfc.add("CIN");//json.put("bengals", "CIN");
//		lAfc.add("CLE");//json.put("browns", "CLE");
//		lAfc.add("PIT");//json.put("steelers", "PIT");
//		lAfc.add("DEN");//json.put("broncos", "DEN");
//		lAfc.add("KC");//json.put("chiefs", "KC");
//		lAfc.add("OAK");//json.put("raiders", "OAK");
//		lAfc.add("SD");//json.put("chargers", "SD");
		
//		if (lNfc.contains(div)){
//			rtn = "NFC";
//		}
//		else
//		{
//			rtn = "AFC";
//		}
		
		return rtn;
	}
	public static String convertNoteToScore(String note){
		String score = "0";

		if (note.equals("XP")){
			score = "1";
		}
		if (note.equals("TD")){
			score = "6";
		}
		if (note.equals("SAF")){
			score = "2";
		}
		if (note.equals("FG")){
			score = "3";
		}
		if (note.equals("2PR")){
			score = "2";
		}
		if (note.equals("2PPF")){
			score = "2";
		}
		
		// 1 point safety
		// 6 points for TD offensive and defensive teams
		// 2 points for SAF
		// 3 points for FG
		// 2 points for 2PPF ???
		// 2 points for 2PR  ???
		return score;
	}
//	public class NewspaperClass implements Comparable<NewspaperClass>{
//		   public String name;
//
//		   @Override
//		   public int compareTo(NewspaperClass another) {
//		      return name.compareTo(another.name);
//		   }
//	}
// Check if number of scores are different than the number in the database, if so update the table.
	
	
	
//	private static void ProcessInput(String iFile) throws IOException {
//
//		lGame = new ArrayList<Game>();
//		lPlayer = new ArrayList<Player>();
//		lUniquePlayer = new ArrayList<Player>();
//		openFile(iFile);
//		openWriteFiles();
//		
//		while ((line = readFileLine()) != null) {
//			Logger.log("Line: " + line, "Info");
//			if (line.substring(0, 1).equals("G")){
//				Game g = new Game();
//				g.load(line);
//				lGame.add(g);
//				//String[] f = line.split("\t");
//				
//				if (g.getHNumbers().equals("N/A")){
//					
//					List<String> HNUM = GetList(10);
//					SuffleList(HNUM);
//					List<String> VNUM = GetList(10);
//					SuffleList(VNUM);
//					List<String> PNUM = GetList(100);
//					SuffleList(PNUM);
//					g.setHNumbers(HNUM.toString().replace("[", "").replace("]", "").replace(" ", ""));	
//					g.setVNumbers(VNUM.toString().replace("[", "").replace("]", "").replace(" ", ""));
//					g.setPNumbers(PNUM.toString().replace("[", "").replace("]", "").replace(" ", ""));
//				}
//				wSource.write(g.buildString());
//			}
//			if (line.substring(0, 1).equals("P")){
//				//wSource.write(line + "\r\n");
//				Player p = new Player();
//				p.load(line);
//				lPlayer.add(p);
//				//wSource.write(p.buildString());
//			}
//			if (!line.substring(0, 1).equals("P") && !line.substring(0, 1).equals("G")){
//				wSource.write(line + "\r\n");
//			}
//		}
//		for (int i = 0;i < lPlayer.size();i++){
//			wSource.write(lPlayer.get(i).buildString());
//		}
//		//for (int i = 0;i < lGame.size();i++){
//			//buildGameFile(lGame.get(i));
//			buildGameFile();
//			//break;
//		//}
//		
//		//buildPayoutsFile();
//		try 
//		{
//			wSource.close();
//		} 
//		catch (IOException e) 
//		{
//			Logger.log(e.getLocalizedMessage(), "Error");
//		}
//	}

	public String printRules() {
		String sRtn = "";
		sRtn = sRtn + "<table border=\"0\" align=\"center\" width=\"90%\">";
		sRtn = sRtn + "<tr><td><b>$100 Squares for Super Bowl</b></td></tr>";
		sRtn = sRtn + "<tr><td><b>Rules:</b></td></tr><tr><td></td></tr>";
		sRtn = sRtn + "<tr><td>Each Square will have 2 sets of numbers associated with it.</td></tr>";
		sRtn = sRtn + "<tr><td>One set is for the first and second quarters.</td></tr>";
		sRtn = sRtn + "<tr><td>The second set is for the third and end of game score.</td></tr>";
		sRtn = sRtn + "<tr><td><b>Per Score Payouts:</b></td></tr><tr><td></td></tr>";
		sRtn = sRtn + "<tr><td>Each time the score changes, $250 will be paid out.</td></tr>";
		sRtn = sRtn + "<tr><td>For example if NFC scores the 1st TD, the square with NFC 6 and AFC 0 would win $250.</td></tr>";
		sRtn = sRtn + "<tr><td>If the extra point is kicked and made, then NFC 7 and AFC 0 would also win $250.</td></tr>";
		sRtn = sRtn + "<tr><td><b>Quarter Payouts:</b></td></tr><tr></tr>";
		sRtn = sRtn + "<tr><td>The numbers that land at the end of each Quarter are paid an additional bonus.</td></tr>";
		sRtn = sRtn + "<tr><td>The reverse numbers at the end of each Quater are paid $100.</td></tr>";
		sRtn = sRtn + "<tr><td><b>Double Number Payouts (Matchy):</b></td></tr><tr></tr>";
		sRtn = sRtn + "<tr><td>If you have two of the same numbers, then you get $50(NFC 1 and AFC 1, NFC 2 and AFC 2, etc..)</td></tr>";
		sRtn = sRtn + "<tr><td>Numbers change at half time, they also get the $50.</td></tr>";
		sRtn = sRtn + "<tr><td><b>Bonus Payouts (All money left over after payouts, 25% per Quarter)</b></td></tr><tr></tr>";
		sRtn = sRtn + "<tr><td>If there is a tie at the end of the 4th Quarter, there is no payout for that Quarter.</td></tr>";
		sRtn = sRtn + "<tr><td>We will use the end of the game score to determine Quarter payout.</td></tr>";
		sRtn = sRtn + "</table>";
		return sRtn;
	}
	public String buildBracket() throws IOException, NamingException {
		String sRtn = "";
		Scores s = new Scores();
		s.getScores();
		Game g = new Game();
		g.getGame();
		Player p = new Player();
		lPlayer = p.getPlayerList();
		
		//Write Game Sections
		ArrayList<String> NFCNUM1 = new ArrayList<String>(Arrays.asList(g.getNFCNumbers1().split(",")));
		ArrayList<String> AFCNUM1 = new ArrayList<String>(Arrays.asList(g.getAFCNumbers1().split(",")));
		ArrayList<String> NFCNUM2 = new ArrayList<String>(Arrays.asList(g.getNFCNumbers2().split(",")));
		ArrayList<String> AFCNUM2 = new ArrayList<String>(Arrays.asList(g.getAFCNumbers2().split(",")));

		ArrayList<String> PNUM = new ArrayList<String>(Arrays.asList(g.getPlayerNumbers().split(",")));

		sRtn = sRtn + "<div>";
		sRtn = sRtn + "<p>";
		sRtn = sRtn + "<table border=\"1\" align=\"center\" width=\"90%\">";
		sRtn = sRtn + "<th>Team</th><th>Pts in 1st Quarter</th><th>Pts in 2nd Quarter</th><th>Pts in 3rd Quarter</th><th>Pts in 4th Quarter</th><th>Pts in OT</th><th>Final</th>";
		sRtn = sRtn + "<tr><td align=\"center\">" + g.getNFCTeam() + "</td><td align=\"center\">" + s.getNQtr1() + "</td><td align=\"center\">" + s.getNQtr2() + "</td><td align=\"center\">" + s.getNQtr3() + "</td><td align=\"center\">" + s.getNQtr4() + "</td><td align=\"center\">" + s.getNQtr5() + "</td><td align=\"center\">" + s.getNQtrF() + "</td></tr>";
		sRtn = sRtn + "<tr><td align=\"center\">" + g.getAFCTeam() + "</td><td align=\"center\">" + s.getAQtr1() + "</td><td align=\"center\">" + s.getAQtr2() + "</td><td align=\"center\">" + s.getAQtr3() + "</td><td align=\"center\">" + s.getAQtr4() + "</td><td align=\"center\">" + s.getAQtr5() + "</td><td align=\"center\">" + s.getAQtrF() + "</td></tr>";
		sRtn = sRtn + "</tr></table></center><BR>";

		sRtn = sRtn + "<table border=\"1\" align=\"center\" width=\"90%\">";
		sRtn = sRtn + "<th rowspan=\"13\"><FONT SIZE=\"5\">" + g.getAFCTeam() + "</th>";
		sRtn = sRtn + "<th colspan=\"13\"><P ALIGN=\"CENTER\"><FONT SIZE=\"5\">" + g.getNFCTeam() + "</FONT></P></th>";
		sRtn = sRtn + "<tr style=\"border: 6px solid black;\" height=50px >";
		sRtn = sRtn + "<td align=\"center\">End</td>";
		sRtn = sRtn + "<td align=\"center\"></td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(0) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(1) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(2) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(3) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(4) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(5) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(6) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(7) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(8) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM2.get(9) + "</td>";
		sRtn = sRtn + "</tr>";
		sRtn = sRtn + "<tr style=\"border: 6px solid black;\" height=50px >";
		sRtn = sRtn + "<td align=\"center\"></td>";
		sRtn = sRtn + "<td align=\"center\">1st</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(0) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(1) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(2) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(3) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(4) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(5) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(6) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(7) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(8) + "</td>";
		sRtn = sRtn + "<td align=\"center\">" + NFCNUM1.get(9) + "</td>";
		sRtn = sRtn + "</tr>";

		int pn = 0;
		for (int k = 0;k < NFCNUM2.size();k++){
			sRtn = sRtn + "<tr style=\"border: 6px solid black;\" height=50px >";
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + AFCNUM2.get(k) + "</td>";
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + AFCNUM1.get(k) + "</td>";
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "<td width=\"7%\" align=\"center\">" + lPlayer.get(Integer.parseInt(PNUM.get(pn).trim())).getPlayerName() + "</td>"; pn++;
			sRtn = sRtn + "</tr>";
		}
		sRtn = sRtn + "</table>";
			
		return sRtn;
	}
		

	private static String CheckScore(String sGridHScore, String sGridVScore, Game g, Player p) {
		String sRtn = "";

		String gH = sGridHScore.substring(sGridHScore.length() - 1);	//Grid Home Score
		String gV = sGridVScore.substring(sGridVScore.length() - 1);	//Grid Visitor Score

		return sRtn;
	}

}
