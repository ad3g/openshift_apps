<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.golf.*" %>
<%
System.out.println("in ScoresSaveEarned.jsp");
String ern, num = "";
num=request.getParameter("xId");
System.out.println("id: " + num);
ern=request.getParameter("xEarn");
System.out.println("earned: " + ern);
ScoresDao sDao = new ScoresDao();

Score s = new Score();
s.setsId(Integer.parseInt(num));
sDao.loadScore(s);
s.setsPtsEarned(Integer.parseInt(ern));
int iDiff = 0;
iDiff = sDao.calculateDifference(s);
s.setsPtsDiff(iDiff);
int iNext = 0;
iNext = sDao.calculateNextWeek(s);
s.setsPtsNextWk(iNext);
System.out.println("Needed: " + s.getsPtsNeeded() + "  Earned: " + ern + "  Diff: " + iDiff + "   Next: " + iNext);
sDao.persistScore(s);
%>