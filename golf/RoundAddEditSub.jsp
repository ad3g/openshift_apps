<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %><%@ page import = "java.text.SimpleDateFormat" %><%@ page import = "java.util.Date" %><%@ page import = "java.text.SimpleDateFormat" %><%@ page import = "java.util.*" %>
<%
System.out.println("in RoundAddEditSub.jsp");
String id, styp, rout, dt = "";
id=request.getParameter("xId");
System.out.println("id: " + id);

styp=request.getParameter("xType");
System.out.println("styp: " + styp);

rout=request.getParameter("xOut");
System.out.println("rout: " + rout);

dt=request.getParameter("xDate");
System.out.println("Dt: " + dt);

SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
java.util.Date stDate = sdf1.parse(dt);

RoundDao rDao = new RoundDao();
Round r = new Round();
if (!id.equals("0")){
	System.out.println("RoundAddEditSub.jsp, id not 0");
	r.setrId(Integer.parseInt(id));
	r.setrType(styp);
	r.setrRainOut(rout);
	r.setrDate(new java.sql.Date(stDate.getTime()));
	rDao.persistRound(r);
}
else
{
	System.out.println("RoundAddEditSub.jsp, id 0");
	PlayerDao pDao = new PlayerDao();
	ScoresDao sDao = new ScoresDao();
	
	ArrayList<Player> lPlayers = new ArrayList<Player>();
	lPlayers = pDao.getAllPlayers();
	ArrayList<Round> lRounds = new ArrayList<Round>();
	
	//Build and insert round, check if date already exists
	r.setrDate(new java.sql.Date(stDate.getTime()));
	rDao.loadRoundByDate(r);
	if (r.getrId() == 0){
		rDao.insertRound(r);
		rDao.loadRoundByDate(r);
		System.out.println("RoundAddEditSub.jsp, rId: " + r.getrId());
	}
	//Get all rounds greater than start date and add score records, one for each player.
	for (int k = 0;k < lPlayers.size();k++){
		Score s = new Score();
		s.setsId(0);
		s.setrId(r.getrId());
		Score sNeed = new Score();
		sNeed = sDao.getMostRecentScoreByPid(lPlayers.get(k).getpId());
		s.setpId(lPlayers.get(k).getpId());
		s.setsPtsNeeded(sNeed.getsPtsNextWk());
		sDao.persistScore(s);
	}
}
%>