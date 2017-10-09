<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %><%@ page import = "java.text.SimpleDateFormat" %><%@ page import = "java.util.*" %>
<%
System.out.println("in StartSeasonSub.jsp");
String nme, num = "";
num=request.getParameter("xWk");
System.out.println("num: " + num);
nme=request.getParameter("xNumWks");
System.out.println("nme: " + nme);

SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");

RoundDao rDao = new RoundDao();
PlayerDao pDao = new PlayerDao();
ScoresDao sDao = new ScoresDao();

java.util.Date stDateSave = sdf1.parse(num);
java.util.Date stDate = sdf1.parse(num);

ArrayList<Player> lPlayers = new ArrayList<Player>();
lPlayers = pDao.getAllPlayers();
Round r = new Round();
ArrayList<Round> lRounds = new ArrayList<Round>();

//Build and insert rounds by adding 7 days after the starting week
int iNum = Integer.parseInt(nme);
for (int i = 0;i < iNum;i++){
	r.setrDate(new java.sql.Date(stDate.getTime()));
	rDao.loadRoundByDate(r);
	if (r.getrId() == 0){
		//System.out.println("date: " + stDate);
		rDao.insertRound(r);
	}
	Date tomorrow = new Date( stDate.getYear(), stDate.getMonth(), stDate.getDate() + 7 );
	stDate = tomorrow;
}
//Get all rounds greater than start date and add score records, one for each player.
lRounds = rDao.getAllRoundsGTDate(new java.sql.Date(stDateSave.getTime()));
for (int j = 0;j < lRounds.size();j++){
	for (int k = 0;k < lPlayers.size();k++){
		Score s = new Score();
		s.setsId(0);
		s.setrId(lRounds.get(j).getrId());
		Score sNeed = new Score();
		sNeed = sDao.getMostRecentScoreByPid(lPlayers.get(k).getpId());
		s.setpId(lPlayers.get(k).getpId());
		s.setsPtsNeeded(sNeed.getsPtsNextWk());
		sDao.persistScore(s);
	}
}
%>