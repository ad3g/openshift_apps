<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.*" %>
<%@ page import="com.nfl.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NFL 22 Point Pool - Standings</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<jsp:include page="../masterinclude.jsp"></jsp:include>
<!-- Remote -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$(function() {
		$( "#accordion" ).accordion({ heightStyle: "content"});
	});
});
</script>
</head>
<body>
<div id="ScoreSection" class="container">
	<center><img src="../res/196px-National_Football_League_2008.svg.png" height="150" width="250"></center>
	<BR>
	<center><font size="36">NFL 22 Point Pool - Standings</font></center>
<!-- 	<div id="accordion"> -->
<!-- 		<h3><B>Standings</B></h3> -->
		<div>
<%
  	String yr = "2017";
  	String seas = "Regular";
 	if(request.getParameter("yr") == null){
// 		out.print("Year not found <BR>");
 	}
 	else
 	{
 		yr = request.getParameter("yr");
 	}
 	if(request.getParameter("seas") == null){
// 		out.print("Season not found <BR>");
 	}
 	else
 	{
 		seas = request.getParameter("seas");
 	}

 	UpdInfo updInfo = TestMain.timeForUpdate(yr, seas);
 	
 	if (updInfo.isUpdData()){
 		TestMain.initializeDataCurrentPeriod(yr,seas);
 	}
	out.print(BracketDB.renderBracket(yr, seas, "1"));
	//out.print(BracketDB.renderBracket("2017", "Regular", "1"));
	%>
	</div>
	
	<h3><B>What is the NFL 22 Point Challenge:</B></h3>
	<div>
		<ul>
			<li>Limited to 26 players, due to teams having bye weeks (guarantee's each player has a team each week)</li>
			<li>A player can enter more than once, but must pay for each entry (ie. James I, James II)</li>
			<li>One time entry fee of $102, for each entry ($6 per week)</li>
			<li>Total prize pool $2652 (26 * 6 * 17= 2652)</li>
			<li>Players are randomly assigned an NFL team for each week of the regular season</li>
			<li>Teams are assigned before the season starts, once all players have paid their entry fee</li>
			<li>A player may be assigned the same team multiple times, it's a random draw</li>
			<li>Pot will start out at $156 in Week 1</li>
			<li>Pot grows $156 each week until a team scores 22 points</li>
			<li>Once a team scores 22 points and wins the pot, it will reset to $156 the following week</li>
			<li>If multiple teams score 22 points in a week the total accumulated pot to that point is divided amoung the # of winners, ex. Week 2 Pot is $312, and 2 teams hit 22 points each player receives $156</li>
			<li>Pots are split at the completion of a week, not the first team to score 22 points</li>
			<li>Any left over pot is carried forward to next year</li>
			<li>Current players have priority to enter next years season, by providing the next years entry fee</li>
		<br>
		</ul>
<!-- 	</div> -->
	</div>
	<%
	if(request.getParameter("showhistory") != null){
		out.print("<ul>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2012&seas=Preseason\">2012 Pre-Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2012&seas=Regular\">2012 Regular Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2013&seas=Preseason\">2013 Pre-Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2013&seas=Regular\">2013 Regular Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2014&seas=Preseason\">2014 Pre-Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2014&seas=Regular\">2014 Regular Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2015&seas=Preseason\">2015 Pre-Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2015&seas=Regular\">2015 Regular Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2016&seas=Preseason\">2016 Pre-Season</a></li>");
 		out.print("<li><a href=\"Bracket.jsp?yr=2016&seas=Regular\">2016 Regular Season</a></li>");
		out.print("</ul>");
	}
	%>
	<center><font size="2">Last system update: <% out.print(updInfo.getLastUpdateTm()); %><br> Next system update: <% out.print(updInfo.getNextUpdateTm()); %></font></center>
</div>
</html>