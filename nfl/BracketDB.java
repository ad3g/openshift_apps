package com.nfl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.naming.NamingException;

import com.common.MVDBHelper;

public class BracketDB {

	private static int iPot = 0;
	private static int iBuyin = 0;
	private static int iWinningNumber = 0;
	private static ArrayList<String> sWinnerList;
	private static ArrayList<Integer> iWinnerAmount;
	private static ArrayList<Winners> lWinner;
	
	private static ArrayList<Bracket> getListOfBracket(String yr, String seas) throws NamingException {
		ArrayList<Bracket> lRtn = new ArrayList<Bracket>();
		//System.out.println("BracketDB, getListOfBracket");
		String sql = "SELECT `Player`, `Team1`, `Score1`, `Team2`, `Score2`, `Team3`, `Score3`, `Team4`, `Score4`, `Team5`, `Score5`, `Team6`, `Score6`, `Team7`, `Score7`, `Team8`, `Score8`, `Team9`, `Score9`, `Team10`, `Score10`, `Team11`, `Score11`, `Team12`, `Score12`, `Team13`, `Score13`, `Team14`, `Score14`, `Team15`, `Score15`, `Team16`, `Score16`, `Team17`, `Score17`, `Yr`, `Season` FROM `apps`.`nfl_bracket` where yr = ? and Season = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);
			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				//System.out.println("BracketDB, getListOfBracket within select");
				Bracket b = new Bracket();
				b.setPlayer(rs.getString("Player"));
				b.setTeam1(rs.getString("Team1"));
				b.setTeam2(rs.getString("Team2"));
				b.setTeam3(rs.getString("Team3"));
				b.setTeam4(rs.getString("Team4"));
				b.setTeam5(rs.getString("Team5"));
				b.setTeam6(rs.getString("Team6"));
				b.setTeam7(rs.getString("Team7"));
				b.setTeam8(rs.getString("Team8"));
				b.setTeam9(rs.getString("Team9"));
				b.setTeam10(rs.getString("Team10"));
				b.setTeam11(rs.getString("Team11"));
				b.setTeam12(rs.getString("Team12"));
				b.setTeam13(rs.getString("Team13"));
				b.setTeam14(rs.getString("Team14"));
				b.setTeam15(rs.getString("Team15"));
				b.setTeam16(rs.getString("Team16"));
				b.setTeam17(rs.getString("Team17"));
				b.setScore1(rs.getString("Score1"));
				b.setScore2(rs.getString("Score2"));
				b.setScore3(rs.getString("Score3"));
				b.setScore4(rs.getString("Score4"));
				b.setScore5(rs.getString("Score5"));
				b.setScore6(rs.getString("Score6"));
				b.setScore7(rs.getString("Score7"));
				b.setScore8(rs.getString("Score8"));
				b.setScore9(rs.getString("Score9"));
				b.setScore10(rs.getString("Score10"));
				b.setScore11(rs.getString("Score11"));
				b.setScore12(rs.getString("Score12"));
				b.setScore13(rs.getString("Score13"));
				b.setScore14(rs.getString("Score14"));
				b.setScore15(rs.getString("Score15"));
				b.setScore16(rs.getString("Score16"));
				b.setScore17(rs.getString("Score17"));
				b.setYr(yr);
				b.setSeason(seas);
				lRtn.add(b);
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
		return lRtn;
	}
	
//	public static String loadPage(String yr, String seas, String wk) throws NamingException{
		/*- Determine last update date/time (saved in parm table)
		  - If date/time > updateFreq in hours
			o   Determine week based on current day
			o   Take week and get gameids where ascore or hscore is blank
			o   Take gameid and get json data
				§  If available parse data and update scores
				§  If not available continue
			o   Take week and update bracket scores for the week
		  - Date/time < 4 hours
			o   No updates
		  - Render bracket to page
			o   Accumulate current pot until winner
			o   If winning score found, add to winners grid
			o   Render winners grid
		*/
//		lWinner = new ArrayList<Winner>();
//		String sRtn = "";
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Calendar cal = Calendar.getInstance();
		
//		if (dt.equals("")){
//			dt = dateFormat.format(cal.getTime());
//			System.out.println("loadPage, defaulted dt: " + dt);
//		}
//		else
//		{
//			System.out.println("loadPage, received value for dt: " + dt);
//		}
		
		//ParmDB p = new ParmDB();
		//String week = p.getWeekByDate(dt);
		//System.out.println("loadPage, getWeekByDate dt: " + dt + " week returned: " + week);
		//String updFreq = p.getParmAsString("Update_Freq");
		//String lastUpd = p.getParmAsString("Last_Update");

//		Calendar calendar1 = Calendar.getInstance();
//		Calendar calendar2 = Calendar.getInstance();
//		calendar1.setTime(new Date(lastUpd));
//		calendar2.setTime(new Date(dt));
//		long milsecs1= calendar1.getTimeInMillis();
//		long milsecs2 = calendar2.getTimeInMillis();
//		long diff = milsecs2 - milsecs1;
//		long dsecs = diff / 1000;
//		long dminutes = diff / (60 * 1000);
//		long dhours = diff / (60 * 60 * 1000);
//		long ddays = diff / (24 * 60 * 60 * 1000);
//
//		System.out.println("Your Hour Difference= " + dhours);


//		if (dhours >= Integer.parseInt(updFreq)){
//			System.out.println(" hours greater or equal to update frequency - perform an update");
//			p.updateParmLastUpdateDate(dateFormat.format(cal.getTime()));		   //No matter what date is passed into application update to current date
//			TestMain.retrieveGameCenterData(yr, seas, wk);
//		
//		return sRtn;
//	}
	private static int getPot (){
	
		int iRtn = 0;
		String sRtn = "0";
		
		ParmDB pDB = new ParmDB();
		try {
			sRtn = pDB.getParmAsString("Pot");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iRtn = Integer.parseInt(sRtn);
		
		return iRtn;
	}
	public static String renderBracket(String yr, String seas, String wk) throws NamingException{
		String sRtn = "";
		
		System.out.println("renderBracket, yr: " + yr + " seas: " + seas + " week: " + wk);
		iWinningNumber = ParmDB.getParmAsInteger("Winning_Number");
		ArrayList<Bracket> lb = new ArrayList<Bracket>();
		lb = getListOfBracket(yr, seas);
		System.out.println("buy-in: " + iBuyin + " lb: " + lb.size());

		if (wk.equals("1")){
			iPot = getPot();
		}
		else
		{
			iPot = 0;
		}
		System.out.println("Pot: " + iPot);
		iPot = iBuyin * lb.size();
		sRtn = sRtn + "<div class=\"table-responsive\"><center><font size=\"18\">Year: " + yr + "  Season: " + seas + "</font></center>";
		
		//table-striped
		sRtn = sRtn + "<table class=\"table table-bordered text-center \"><thead><tr><th class=\" text-center \">Player Name</th>"; 
		int iColumns = 0;
		if (!lb.get(0).getTeam1().equals(" ")){iColumns = 1;sRtn = sRtn + "<th  class=\" text-center \">1</th>";}
		if (!lb.get(0).getTeam2().equals(" ")){iColumns = 2;sRtn = sRtn + "<th  class=\" text-center \">2</th>";}
		if (!lb.get(0).getTeam3().equals(" ")){iColumns = 3;sRtn = sRtn + "<th  class=\" text-center \">3</th>";}
		if (!lb.get(0).getTeam4().equals(" ")){iColumns = 4;sRtn = sRtn + "<th  class=\" text-center \">4</th>";}
		if (seas.equals("Regular")){
			if (!lb.get(0).getTeam5().equals(" ")){iColumns = 5;sRtn = sRtn + "<th  class=\" text-center \">5</th>";}
			if (!lb.get(0).getTeam6().equals(" ")){iColumns = 6;sRtn = sRtn + "<th  class=\" text-center \">6</th>";}
			if (!lb.get(0).getTeam7().equals(" ")){iColumns = 7;sRtn = sRtn + "<th  class=\" text-center \">7</th>";}
			if (!lb.get(0).getTeam8().equals(" ")){iColumns = 8;sRtn = sRtn + "<th  class=\" text-center \">8</th>";}
			if (!lb.get(0).getTeam9().equals(" ")){iColumns = 9;sRtn = sRtn + "<th  class=\" text-center \">9</th>";}
			if (!lb.get(0).getTeam10().equals(" ")){iColumns = 10;sRtn = sRtn + "<th  class=\" text-center \">10</th>";}
			if (!lb.get(0).getTeam11().equals(" ")){iColumns = 11;sRtn = sRtn + "<th  class=\" text-center \">11</th>";}
			if (!lb.get(0).getTeam12().equals(" ")){iColumns = 12;sRtn = sRtn + "<th  class=\" text-center \">12</th>";}
			if (!lb.get(0).getTeam13().equals(" ")){iColumns = 13;sRtn = sRtn + "<th  class=\" text-center \">13</th>";}
			if (!lb.get(0).getTeam14().equals(" ")){iColumns = 14;sRtn = sRtn + "<th  class=\" text-center \">14</th>";}
			if (!lb.get(0).getTeam15().equals(" ")){iColumns = 15;sRtn = sRtn + "<th  class=\" text-center \">15</th>";}
			if (!lb.get(0).getTeam16().equals(" ")){iColumns = 16;sRtn = sRtn + "<th  class=\" text-center \">16</th>";}
			if (!lb.get(0).getTeam17().equals(" ")){iColumns = 17;sRtn = sRtn + "<th  class=\" text-center \">17</th>";}
		}
		sRtn = sRtn + "</tr></thead><tbody>";
		
		for (int i = 0;i < lb.size();i++){
			Bracket b = new Bracket();
			b = lb.get(i);
			sRtn = sRtn + "<tr>";
			sRtn = sRtn + formatCell(yr, seas, b.getPlayer(), "", "", "");
			if (iColumns > 0){sRtn = sRtn + formatCell(yr, seas, b.getTeam1(),b.getScore1(), b.getPlayer(), "1");}
			if (iColumns > 1){sRtn = sRtn + formatCell(yr, seas, b.getTeam2(),b.getScore2(), b.getPlayer(), "2");}
			if (iColumns > 2){sRtn = sRtn + formatCell(yr, seas, b.getTeam3(),b.getScore3(), b.getPlayer(), "3");}
			if (iColumns > 3){sRtn = sRtn + formatCell(yr, seas, b.getTeam4(),b.getScore4(), b.getPlayer(), "4");}
			if (seas.equals("Regular")){
				if (iColumns > 4){sRtn = sRtn + formatCell(yr, seas, b.getTeam5(),b.getScore5(), b.getPlayer(), "5");}
				if (iColumns > 5){sRtn = sRtn + formatCell(yr, seas, b.getTeam6(),b.getScore6(), b.getPlayer(), "6");}
				if (iColumns > 6){sRtn = sRtn + formatCell(yr, seas, b.getTeam7(),b.getScore7(), b.getPlayer(), "7");}
				if (iColumns > 7){sRtn = sRtn + formatCell(yr, seas, b.getTeam8(),b.getScore8(), b.getPlayer(), "8");}
				if (iColumns > 8){sRtn = sRtn + formatCell(yr, seas, b.getTeam9(),b.getScore9(), b.getPlayer(), "9");}
				if (iColumns > 9){sRtn = sRtn + formatCell(yr, seas, b.getTeam10(),b.getScore10(), b.getPlayer(), "10");}
				if (iColumns > 10){sRtn = sRtn + formatCell(yr, seas, b.getTeam11(),b.getScore11(), b.getPlayer(), "11");}
				if (iColumns > 11){sRtn = sRtn + formatCell(yr, seas, b.getTeam12(),b.getScore12(), b.getPlayer(), "12");}
				if (iColumns > 12){sRtn = sRtn + formatCell(yr, seas, b.getTeam13(),b.getScore13(), b.getPlayer(), "13");}
				if (iColumns > 13){sRtn = sRtn + formatCell(yr, seas, b.getTeam14(),b.getScore14(), b.getPlayer(), "14");}
				if (iColumns > 14){sRtn = sRtn + formatCell(yr, seas, b.getTeam15(),b.getScore15(), b.getPlayer(), "15");}
				if (iColumns > 15){sRtn = sRtn + formatCell(yr, seas, b.getTeam16(),b.getScore16(), b.getPlayer(), "16");}
				if (iColumns > 16){sRtn = sRtn + formatCell(yr, seas, b.getTeam17(),b.getScore17(), b.getPlayer(), "17");}
			}
			sRtn = sRtn + "</tr>";
		}

		sRtn = sRtn + "</tbody></table></div>";
		sRtn = sRtn + "<br>";

		int iPot = 0;
		int iNumWinners = 0;
		boolean bWinnerFound = false;
		WinnersDB.deleteWinners(yr, seas);
		int iStop = 0;
		if (seas.equals("Regular")){
			iStop = 17;
		}
		else
		{
			iStop = 4;
		}
		for (int i = 1;i <= iStop;i++){
			iPot = iPot + 156;
			for (int k = 0;k < lb.size();k++){
				//System.out.println("i: " + i + " k: " + k + " Score1: " + lb.get(k).getScore1() + " Score2: " + lb.get(k).getScore2() + " Score3: " + lb.get(k).getScore3() + " Score4: " + lb.get(k).getScore4() + " Score5: " + lb.get(k).getScore5() + " Score6: " + lb.get(k).getScore6() + " Score7: " + lb.get(k).getScore7() + " Score8: " + lb.get(k).getScore8() + " Score9: " + lb.get(k).getScore9() + " Score10: " + lb.get(k).getScore10() + " Score11: " + lb.get(k).getScore11() + " Score12: " + lb.get(k).getScore12() + " Score13: " + lb.get(k).getScore13() + " Score14: " + lb.get(k).getScore14() + " Score15: " + lb.get(k).getScore15() + " Score16: " + lb.get(k).getScore16() + " Score17: " + lb.get(k).getScore17());
				if ((i == 1 && lb.get(k).getScore1().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(1), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
				if ((i == 2 && lb.get(k).getScore2().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(2), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
				if ((i == 3 && lb.get(k).getScore3().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(3), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
				if ((i == 4 && lb.get(k).getScore4().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(4), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
				if (seas.equals("Regular")){
					if ((i == 5 && lb.get(k).getScore5().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(5), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 6 && lb.get(k).getScore6().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(6), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 7 && lb.get(k).getScore7().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(7), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 8 && lb.get(k).getScore8().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(8), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 9 && lb.get(k).getScore9().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(9), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 10 && lb.get(k).getScore10().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(10), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 11 && lb.get(k).getScore11().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(11), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 12 && lb.get(k).getScore12().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(12), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 13 && lb.get(k).getScore13().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(13), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 14 && lb.get(k).getScore14().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(14), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 15 && lb.get(k).getScore15().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(15), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 16 && lb.get(k).getScore16().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(16), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
					if ((i == 17 && lb.get(k).getScore17().equals(Integer.toString(iWinningNumber)))) {WinnersDB.insertWinners(lb.get(k).getYr(), seas, Integer.toString(17), lb.get(k).getPlayer());bWinnerFound = true;iNumWinners++;}
				}
			}
			if (bWinnerFound){
				Double amt = (double) (iPot / iNumWinners);
				WinnersDB.updateWinnersAmt(yr, seas, Integer.toString(i), amt);
				bWinnerFound = false;
				iPot = 0;
				iNumWinners = 0;
			}
		}
		sRtn = sRtn + WinnersDB.renderWinners(yr, seas);
		
		return sRtn;

	}
	private static String xxxx(Bracket b){
		String sRtn = "";
		
		return sRtn;
	}
	private static String formatCell(String yr, String seas, String sTeam, String sScore, String sPlayer, String sWk) {
		String sRtn = "";
		//System.out.println("Score: " + sScore + " score length: " + sScore.length() + "  Week: " + sWk + " Team: " + sTeam);
		//System.out.println("Score: " + sScore + " score length: " + sScore.length() + "  winnerNumber: " + Integer.toString(iWinningNumber));
//		if (sScore.equals("22")){
//			System.out.println(" ");
//		}
		if (sScore.equals(Integer.toString(iWinningNumber))){
//			Winners w = new Winners();
//			w.setWk(sWk);
//			w.setPlayer(sPlayer);
			sRtn = sRtn + "<td align=\"center\" bgcolor=\"FFFB33\" >" + sTeam + "<BR>" + sScore + "</td>";
		}
		else
		{
			sRtn = sRtn + "<td align=\"center\" bgcolor=\"FFFFFF\" >" + sTeam + "<BR>" + sScore + "</td>";
		}		
		return sRtn;
	}
	public static void deleteBracket(String yr, String seas) throws NamingException {
		String sql = "DELETE FROM apps.nfl_bracket where yr = ? and season = ?";
		PreparedStatement pstmt = null;
		Statement stmt;
		try {

			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, yr);
			pstmt.setString(2, seas);

			pstmt.executeUpdate();

			pstmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		finally 
		{
		}	
	}	
	public static void updateBracketAssignTeams(String wk, String tm, String pl) throws NamingException{
		
		String sql = "update `apps`.`nfl_bracket` set Team" + wk + "= ? Where Player  = ?";
		System.out.println("Update SQL: " + sql + "    " + tm + "    " + pl);
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			pstmt.setString(1, tm);
			pstmt.setString(2, pl);
			
			int iUpd = pstmt.executeUpdate();

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
	public static void updateBracket(String yr, String seas, String wk, String sc, String tm) throws NamingException{
		
		String sql = "update `apps`.`nfl_bracket` set Score" + wk + "= '" + sc + "' Where yr = '" + yr + "' and Season = '" + seas + "' and Team" + wk + " = '" + tm + "'";
		System.out.println("Update SQL: " + sql);
		PreparedStatement pstmt = null;
		
		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(sql);
			//pstmt.setString(1, typ);
			
			int iUpd = pstmt.executeUpdate();

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

	public static void insertBracketStarter(String pl, String yr, String seas) throws NamingException {
//		System.out.println("ScoresJson, persist, urlDate: " + urlDate + " gameNum: " + gameNum);
		PreparedStatement pstmt = null;
		String inssql = "INSERT INTO apps.nfl_bracket (Player, Yr, Season) VALUES (?, ?, ?)";

		try {
			pstmt = MVDBHelper.getLocalConnection().prepareStatement(inssql);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			pstmt.setString(1, pl);
			pstmt.setString(2, yr);
			pstmt.setString(3, seas);
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			int iCount = pstmt.executeUpdate();

			pstmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
		}		
	}
}
