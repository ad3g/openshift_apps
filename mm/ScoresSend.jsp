<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page import = "com.mm.*" %><%@ page import = "java.text.SimpleDateFormat" %><%@ page import = "java.util.*" %>
<%
System.out.println("in ScoresSend.jsp");
System.out.println("dt:" + request.getParameter("dt"));
String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
System.out.println("date1:" + date);
if (request.getParameter("dt") != null){
	date = request.getParameter("dt");
}
System.out.println("date2:" + date);
NCAA_Basketball g = new NCAA_Basketball();
NCAA_Basketball_JsonClasses bb = new NCAA_Basketball_JsonClasses();

bb = g.getJSONObject(date);

if (bb != null){
	out.print("<div class=\"myLarge\">" + bb.getScoreboard().get(0).getDay() + "</div>");
	
	RenderGame rg = new RenderGame();
	for (int i = 0;i < bb.getScoreboard().get(0).getGames().size();i++) {
		if (rg.formatGame(bb.getScoreboard().get(0).getGames().get(i)) != null){
			out.print("<div class=\"myDivWidth\">" + rg.formatGame(bb.getScoreboard().get(0).getGames().get(i)) + "</div>");
			//break;
		}
	}
}
else
{
	out.print("<div class=\"myLarge\">Something is wrong</div>");
}
%>