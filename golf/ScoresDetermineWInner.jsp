<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %><%@ page import = "java.util.*" %>
<%
System.out.println("in ScoresDetermineWinner.jsp");
String id, num = "";
id=request.getParameter("xId");
System.out.println("id: " + id);

ScoresDao sDao = new ScoresDao();
WinnerDao wDao = new WinnerDao();
Winner w = new Winner();

//Delete all previous winner entries for round id
w.setrId(Integer.parseInt(id));
wDao.deleteWinner(w);

//Get all score entries that were paid for the week
ArrayList<Score> lScores = new ArrayList<Score>();
lScores = sDao.getAllScoresByRoundAndPaid(Integer.parseInt(id));

for (int i = 0;i < lScores.size();i++){
	boolean bMissingScore = false;
	if (lScores.get(i).getsPtsEarned() == 0){
		bMissingScore = true;
	}
	if (lScores.get(i).getsClosestTo().equals("Y")){
		w.setpId(lScores.get(i).getpId());
		w.setwAmt(8);
		w.setwType("Closest To Pin");
		wDao.persistInfo(w);
	}
}

// Score s = new Score();
// s.setsId(Integer.parseInt(num));
// sDao.loadScore(s);
// s.setsClosestTo(nme);
// sDao.persistScore(s);
%>