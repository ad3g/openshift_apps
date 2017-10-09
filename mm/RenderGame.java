package com.mm;

import java.util.List;
import java.lang.Object;

public class RenderGame {

	public void checkWinner(Game g){
		if (g.getCurrentPeriod().startsWith("Final")){
			WinnerDAO wDAO = new WinnerDAO();
			Winner w = new Winner();
			w.setGameid(g.getId());
			w.setPlayer("JEFF");
			w.setStdate(g.getStartDate());
			w.setUrl(g.getUrl());
			w.setAmt(Double.parseDouble(getAmount(g, "half")));
			w.setPeriod("half");
			
			wDAO.insertWinner(w);
			
			w.setPeriod("final");
			w.setPlayer("JEFF");
			w.setAmt(Double.parseDouble(getAmount(g, "final")));
			
			wDAO.insertWinner(w);
		}
	}
	public String getAmount(Game g, String period){
		String sRtn = "0";
		
		if (g.getBracketRound().startsWith("First") && period.equals("half")){sRtn = "15";}
		if (g.getBracketRound().startsWith("First") && period.equals("final")){sRtn = "30";}
		
		if (g.getBracketRound().startsWith("Second") && period.equals("half")){sRtn = "30";}
		if (g.getBracketRound().startsWith("Second") && period.equals("final")){sRtn = "60";}
		
		if (g.getBracketRound().startsWith("Sweet") && period.equals("half")){sRtn = "60";}
		if (g.getBracketRound().startsWith("Sweet") && period.equals("final")){sRtn = "120";}
		
		if (g.getBracketRound().startsWith("Elite") && period.equals("half")){sRtn = "120";}
		if (g.getBracketRound().startsWith("Elite") && period.equals("final")){sRtn = "240";}
		
		if (g.getBracketRound().startsWith("FINAL") && period.equals("half")){sRtn = "240";}
		if (g.getBracketRound().startsWith("FINAL") && period.equals("final")){sRtn = "480";}
		
		if (g.getBracketRound().startsWith("Champ") && period.equals("half")){sRtn = "700";}
		if (g.getBracketRound().startsWith("Champ") && period.equals("final")){sRtn = "1400";}
		
		return sRtn;
	}
	public String formatGame(Game g) {
		
		String sRtn = "";

		if (g != null){
			if (g.getBracket() != null && g.getBracket().startsWith("MBB") && !g.getBracketRound().startsWith("FIRST")){
		
				Winner wHalf = new Winner();
				Winner wFinal = new Winner();
				
				sRtn = sRtn + "<div class=\"xyzz\">";
				sRtn = sRtn + "<a href=\"" + g.getUrl() +"\"><table class=\"table myBottom\" frame=\"box\">";
				sRtn = sRtn + "<thead>";
				System.out.println("url: " + g.getUrl());
				wHalf.setUrl(g.getUrl());
				wFinal.setUrl(g.getUrl());
				wHalf.setGameid(g.getId());
				wFinal.setGameid(g.getId());
				wHalf.setStdate(g.getStartDate());
				wFinal.setStdate(g.getStartDate());
				/*
				 * Header Row
				 */
				sRtn = sRtn + "<tr bgcolor=\"#CBDCFD\">";
				//sRtn = sRtn + "<th class=\"myLeft\">" + g.getContestName() + "</th>";
				if (g.getGameState().equals("final")){
					sRtn = sRtn + "<th colspan=\"3\">Final</th>";
				}
				else
				{
					if (g.getGameState().equals("pre")){
						sRtn = sRtn + "<th colspan=\"3\">" + g.getStartTime() + "</th>";
					}
					else
					{
						sRtn = sRtn + "<th colspan=\"3\">" + g.getCurrentPeriod() + "&nbsp&nbsp&nbsp&nbsp" + g.getTimeclock() + "</th>";
					}
				}
				List Periods = g.getScoreBreakdown();
				for (int i = 0; i < Periods.size();i++){
					sRtn = sRtn + "<th class=\"myCenter\">" + Periods.get(i) + "</th>";
				}
				sRtn = sRtn + "<th class=\"myCenter\">Total</th>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "</thead>";
				sRtn = sRtn + "<tbody>";
				/*
				 * Away Team Row
				 */
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td>" + "<img src=\"" + g.getAway().getIconURL() + "\" style=\"width:30px;height:30px;\" >" + "</td>";
				if (g.getBracket() == null){
					if (g.getAway().getTeamRank().equals("0")){
						sRtn = sRtn + "<td></td>";
					}
					else
					{
						sRtn = sRtn + "<td class=\"mySmall\">" + g.getAway().getTeamRank() + "</td>";
					}
				}
				else
				{
					sRtn = sRtn + "<td>" + g.getAway().getTeamSeed() + "</td>";
				}
				sRtn = sRtn + "<td class=\"myLeft\">" + g.getAway().getNameRaw() + "&nbsp(" + g.getAway().getDescription() + ")</td>";
				List scAway = g.getAway().getScoreBreakdown();
				for (int i = 0; i < scAway.size();i++){
					sRtn = sRtn + "<td class=\"myCenter\">" + scAway.get(i) + "</td>";
				}
				sRtn = sRtn + "<td class=\"myCenter\">" + g.getAway().getCurrentScore() + "</td>";
				sRtn = sRtn + "</tr>";
		
				/*
				 * Home Team Row
				 */
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "<td>" + "<img src=\"" + g.getHome().getIconURL() + "\" style=\"width:30px;height:30px;\" >" + "</td>";
				if (g.getBracket() == null){
					if (g.getHome().getTeamRank().equals("0")){
						sRtn = sRtn + "<td></td>";
					}
					else
					{
						sRtn = sRtn + "<td class=\"mySmall\">" + g.getHome().getTeamRank() + "</td>";
					}
		
				}
				else
				{
					sRtn = sRtn + "<td>" + g.getHome().getTeamSeed() + "</td>";
				}
				sRtn = sRtn + "<td class=\"myLeft\">" + g.getHome().getNameRaw() + "&nbsp(" + g.getHome().getDescription() + ")</td>";
				List scHome = g.getHome().getScoreBreakdown();
				for (int i = 0; i < scHome.size();i++){
					sRtn = sRtn + "<td class=\"myCenter\">" + scHome.get(i) + "</td>";
				}
				sRtn = sRtn + "<td class=\"myCenter\">" + g.getHome().getCurrentScore() + "</td>";
				sRtn = sRtn + "</tr>";
				Bracket b = new Bracket();
				String winnerLastDigit = "0";
				String losingLastDigit = "0";
				if (g.getGameState().startsWith("final") || g.getCurrentPeriod().equals("2nd Half") || g.getCurrentPeriod().contains("OT")){
					int a = 0;
					int h = 0;
					try {
						String sA = (String) scAway.get(0);
						a = Integer.parseInt(sA);
					} catch (Exception e) {
						e.printStackTrace();
						a = 0;
					}
					try {
						String sH = (String) scHome.get(0);
						h = Integer.parseInt(sH);
					} catch (Exception e) {
						e.printStackTrace();
						h = 0;
					}
					System.out.println("in final, a: " + a + " h: " + h);
					if (a > h){
						winnerLastDigit = getLastDigit((String) scAway.get(0));
						losingLastDigit = getLastDigit((String) scHome.get(0));
					}
					else
					{
						losingLastDigit = getLastDigit((String) scAway.get(0));
						winnerLastDigit = getLastDigit((String) scHome.get(0));
					}
					wHalf.setPeriod("half");
					wHalf.setPlayer(b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)));
					sRtn = sRtn + "<tr><td colspan=\"100%\">Half Winner with " + winnerLastDigit + " and " + losingLastDigit + " - " + b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)) + "</td></tr>";
					try {
						String sA = (String) g.getAway().getCurrentScore();
						a = Integer.parseInt(sA);
					} catch (Exception e) {
						e.printStackTrace();
						a = 0;
					}
					try {
						String sH = (String) g.getHome().getCurrentScore();
						h = Integer.parseInt(sH);
					} catch (Exception e) {
						e.printStackTrace();
						h = 0;
					}
					if (a > h){
						winnerLastDigit = getLastDigit((String) g.getAway().getCurrentScore());
						losingLastDigit = getLastDigit((String) g.getHome().getCurrentScore());
					}
					else
					{
						losingLastDigit = getLastDigit((String) g.getAway().getCurrentScore());
						winnerLastDigit = getLastDigit((String) g.getHome().getCurrentScore());
					}
					if (g.getGameState().startsWith("final")){
						wHalf.setAmt(Double.parseDouble(getAmount(g,"half")));
						wFinal.setAmt(Double.parseDouble(getAmount(g,"final")));
						wFinal.setPeriod("final");
						wFinal.setPlayer(b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)));
						WinnerDAO wDAO = new WinnerDAO();
						wDAO.insertWinner(wHalf);
						wDAO.insertWinner(wFinal);
						sRtn = sRtn + "<tr><td colspan=\"100%\">Final Winner with " + winnerLastDigit + " and " + losingLastDigit + " - " + b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)) + "</td></tr>";
					}
					else
					{
						sRtn = sRtn + "<tr><td colspan=\"100%\">Current (not final) Winner with " + winnerLastDigit + " and " + losingLastDigit + " - " + b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)) + "</td></tr>";	
					}
				}
		//		else
		//		{
				if (g.getCurrentPeriod().equals("1st Half") || g.getCurrentPeriod().equals("Halftime")){
					int a = 0;
					int h = 0;
					try {
						String sA = (String) scAway.get(0);
						a = Integer.parseInt(sA);
					} catch (Exception e) {
						e.printStackTrace();
						a = 0;
					}
					try {
						String sH = (String) scHome.get(0);
						h = Integer.parseInt(sH);
					} catch (Exception e) {
						e.printStackTrace();
						h = 0;
					}
					System.out.println("in final, a: " + a + " h: " + h);
					if (a > h){
						winnerLastDigit = getLastDigit((String) scAway.get(0));
						losingLastDigit = getLastDigit((String) scHome.get(0));
					}
					else
					{
						losingLastDigit = getLastDigit((String) scAway.get(0));
						winnerLastDigit = getLastDigit((String) scHome.get(0));
					}
					if (g.getCurrentPeriod().equals("Halftime")){
						sRtn = sRtn + "<tr><td colspan=\"100%\">Half Winner with " + winnerLastDigit + " and " + losingLastDigit + " - " + b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)) + "</td></tr>";
					}
					else
					{
						sRtn = sRtn + "<tr><td colspan=\"100%\">Current (not final) Half Winner with " + winnerLastDigit + " and " + losingLastDigit + " - " + b.getPlayerName(b.getPlayerNumbers(winnerLastDigit, losingLastDigit)) + "</td></tr>";
					}
				}
				sRtn = sRtn + "<tr>";
				sRtn = sRtn + "</tr>";
				sRtn = sRtn + "</tbody>";
				sRtn = sRtn + "</table></a>";
				sRtn = sRtn + "</div>";
			}
		}
		return sRtn;
	}
	private String getLastDigit(String sIn){
		String sRtn = "";
		
		if (sIn.length() == 0){
			sRtn = "0";
		}
		if (sIn.length() == 1){
			sRtn = sIn;
		}
		if (sIn.length() > 1){
			sRtn = sIn.substring(sIn.length()-1);
		}
		return sRtn;
	}
}
