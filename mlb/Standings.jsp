<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.*" %>
<%@ page import = "com.mlb.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MLB 13 Run Pool - Standings</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%-- <jsp:include page="../masterinclude.jsp"></jsp:include> --%>
<!-- Remote -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.container {
	margin: 0;
	padding: 0;
	text-align: left;
/* 	max-width: 840px */
}
.myLeft {
	text-align: left;
}
.myCenter {
	text-align: center;
}
.myFont {
	font-size: 200%;
}
.myMedLarge {
	font-size: 125%;
}
.myLarge {
	font-size: 150%;
}
.myWidth {
	max-width: 20px;
}
.myWidthSmall {
	max-width: 40px;
}
.myWidth2 {
	max-width: 100px;
}
.myTable {
	margin: 0;
	padding: 0;
}
/* table, th, td { */
/*     border: 1px solid black; */
/* } */

/* .parent th, td { */
/* 	text-align: center; */
/* 	padding: 10; */
/* }  */
table {
    border-collapse: collapse;
    width: 96%;
}

th, td {
    text-align: center;
    padding: 8px;
}
.parent th, thOther, thGP {
    text-align: center;
    padding: 0px;
    width: 10px;
}
.parent td, tdOther, tdGP {
    text-align: center;
    padding: 0px;
    width: 10px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #459FF5;
    color: white;
}
.btn {
    padding: 7px 7px;
    font-size: 22px;
}
</style>
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
	<center><img src="../res/1280px-Major_League_Baseball.svg.png" height="150" width="250"></center>
	<BR>
	<center><font size="36">MLB 13 Run Pool - Standings</font></center>
	<div id="accordion">
		<h3><B>Standings</B></h3>
		<div>
	<%
 		MLBProcessor.LoadAllBetweenDateRange("", "");
 		String bid = MLBProcessor.saveBracket("", "");
 		out.print(MLBProcessor.printStandings(bid));
 		out.print(MLBProcessor.checkForWinner());
	%>
		</div>
<!-- 		<h3><B>Today's Games</B></h3> -->
<!-- 		<div> -->
	<%
//		out.print(MLBProcessor.TodaysGames());
	%>
<!-- 		</div> -->
		<h3><B>What is a 13-Run Baseball Pool:  (Rules)</B></h3>
		<div>
		<ul>
			<li><b>Here are the rules for our 13-Run pools:</b></li>
			<li>A maximum of 30 members can join a pool</li>
			<li>$100 per player</li>
			<li>Each member is assigned a team</li>
			<li>Each time your team plays, the number of runs they scored will be tracked</li>
			<li>The goal is to be the first member to have their team score every number, from 0 to 13 runs.</li>
			<li>If your team scores more than 13 runs in a game it's kept track of but is not included in the matches count, or towards winning.</li>
			<li>The site updates the pool standings any time a person visits the site.</li>
			<br>
			<li><b>Winning:</b></li>
			<li>First person to have their team score all runs 0 thru 13 is declared the winner:</li>
			<li>Should no team accomplish this goal or two or more teams accomplish on the same day (see Tie breaker rules).</li>
			<li>1st Place Pays $1500</li>
			<li>2nd Place Pays $1000</li>
			<li>3rd Place Pays  $500</li>
			<br>
			<li><b>Second/Third Place:</b></li>
			<li>Once a winner is declared, the players with the second and third highest matches will be declared the second/third place winners.</li>
			<li>Should no team accomplish this goal or two or more teams accomplish on the same day (see Tie breaker rules).</li>
			<br>
			<li><b>Tie breaker rules:</b></li>
			<li>Winner won't be declared until the end of the day's games.  Should two players reach the 13 runs on the same day they will split first and second place winnings.</li>
			<li>Team with the most occurrences of the most runs (13) is declared the winner.</li>
			<li>This will continue until a winner is declared should it be a complete match all the way to 0 runs then the winnings are split equally between the tied players.</li>
			<br>
		</ul>
		</div>
	<%
	//out.print(MLBProcessor.printTeamGameResults("", ""));
	%>
	</div>
</div>
</html>