<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.mm.*" %>
<%
System.out.println("in PlayerNumbersSend.jsp");
System.out.println("wVal:" + request.getParameter("wVal"));
System.out.println("lVal:" + request.getParameter("lVal"));


// bb = g.getJSONObject(request.getParameter("dt"));

// out.print("<div class=\"myLarge\">" + bb.getScoreboard().get(0).getDay() + "</div>");

// RenderGame rg = new RenderGame();
// for (int i = 0;i < bb.getScoreboard().get(0).getGames().size();i++) {
// //for (int i = 0;i < 1;i++) {
// out.print("<div class=\"myDivWidth\">" + rg.formatGame(bb.getScoreboard().get(0).getGames().get(i)) + "</div>");
	//break;
//}
String wVal = request.getParameter("wVal");
String lVal = request.getParameter("lVal");
Bracket b = new Bracket();
out.print("<br><br><div class=\"myLarge\"><table><tr><td>Winning #:</td><td>" + wVal + "</td></tr><tr><td>Losing #:</td><td>" + lVal + "</td></tr><tr><td>Player:</td><td>" + b.getPlayerName(b.getPlayerNumbers(wVal, lVal)) + "</td></tr></table></div>");
%>