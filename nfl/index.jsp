<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NFL 22 Point Challenge</title>
<%@ page import="java.util.*" %>
<%@ page import="com.nfl.*" %>
<jsp:include page="../masterinclude.jsp"></jsp:include>
</head>
<body>
<br>
<br>
<div id="container" style="width:90%; margin:0 auto;">
	<center><img src="../res/196px-National_Football_League_2008.svg.png" height="150" width="150"></center>
	<center><font size="36">NFL 22 Point Challenge</font></center>
	
<%
	BracketDB bDb = new BracketDB();
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

	out.print(bDb.renderBracket(yr, seas, "1"));
	%>

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
	</div>
	<br>
	<br>
	<ul>
	<li><a href="Bracket.jsp?yr=2012&seas=Preseason">2012 Pre-Season</a></li>
	<li><a href="Bracket.jsp?yr=2012&seas=Regular">2012 Regular Season</a></li>
	<li><a href="Bracket.jsp?yr=2013&seas=Preseason">2013 Pre-Season</a></li>
	<li><a href="Bracket.jsp?yr=2013&seas=Regular">2013 Regular Season</a></li>
	<li><a href="Bracket.jsp?yr=2014&seas=Preseason">2014 Pre-Season</a></li>
	<li><a href="Bracket.jsp?yr=2014&seas=Regular">2014 Regular Season</a></li>
	<li><a href="Bracket.jsp?yr=2015&seas=Preseason">2015 Pre-Season</a></li>
	<li><a href="Bracket.jsp?yr=2015&seas=Regular">2015 Regular Season</a></li>
	<li><a href="Bracket.jsp?yr=2016&seas=Preseason">2016 Pre-Season</a></li>
	<li><a href="Bracket.jsp?yr=2016&seas=Regular">2016 Regular Season</a></li>
	<li><a href="Bracket.jsp?yr=2017&seas=Preseason">2017 Pre-Season</a></li>
	<li><a href="Bracket.jsp?yr=2017&seas=Regular">2017 Regular Season</a></li>
	</ul>
</div>
<BR>
<BR>
<BR>
<BR>
<div id="result"></div>
</body>
</html>
