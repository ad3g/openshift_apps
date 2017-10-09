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
 		out.print("Year not found <BR>");
 	}
 	else
 	{
 		yr = request.getParameter("yr");
 	}
 	if(request.getParameter("seas") == null){
 		out.print("Season not found <BR>");
 	}
 	else
 	{
 		seas = request.getParameter("seas");
 	}

	out.print(bDb.renderBracket(yr, seas, "1"));
	UpdInfo updInfo = TestMain.timeForUpdate(yr, seas);
	%>
	<center><font size="2">Last system update: <% out.print(updInfo.getLastUpdateTm()); %><br> Next system update: <% out.print(updInfo.getNextUpdateTm()); %></font></center>
	
<!-- 	<h3><B>What is the NFL 33 Point Challenge:</B></h3> -->
<!-- 		<div> -->
<!-- 		<ul> -->
<!-- 			<li>Limited to 26 players, due to teams having bye weeks (guarantee's each player has a team each week)</li> -->
<!-- 			<li>A player can enter more than once, but must pay for each entry</li> -->
<!-- 			<li>One time entry fee of $102, for each entry ($6 per week)</li> -->
<!-- 			<li>Total prize pool $2652 (26 * 6 * 17= 2652)</li> -->
<!-- 			<li>Players are randomly assigned a different NFL team for each week of the regular season</li> -->
<!-- 			<li>Teams are assigned before the season starts, once all players have paid their entry fee</li> -->
<!-- 			<li>A player may be assigned the same team multiple times, it's a random draw</li> -->
<!-- 			<li>Pot will start out at $156 in Week 1</li> -->
<!-- 			<li>Pot grows $156 each week until a team scores 33 points</li> -->
<!-- 			<li>Once a team scores 33 points and takes the pot, it will start out at $156 the following week</li> -->
<!-- 			<li>If multiple teams score 33 points in a week the total accumulated pot to that point is divided amoungst the # of winners, ex. Week 2 Pot is $312, and 2 teams hit 33 points each player receives $156</li> -->
<!-- 			<li>Pots are split at the completion of a week, not the first team to score 33 points</li> -->
<!-- 			<li>To ensure all prizes are awarded, if no team scores exactly 33 points in Week 17, the team(s) closest to 33 (over or under) in Week 17 will take the final payout.</li> -->
<!-- 			<br> -->
<!-- 			<li>33 points were scored 6 times in the 2013 season. </li> -->
<!-- 			<li>33 points were scored 7 times in the 2014 season. </li> -->
<!-- 		</ul> -->
<!-- 		</div> -->
		<br>
		<br>
</div>
<div>
<center>
<!-- 
<h3><B>Example Payout:</B></h3>
<br>
<table cellspacing="0" border="1">
	<colgroup span="7" width="150"></colgroup>
	<tr>
		<td height="33" align="center"><font face="Liberation Serif">Week</font></td>
		<td align="center"><font face="Liberation Serif">$6/wk ($102 for Season)</font></td>
		<td align="center"><font face="Liberation Serif">Winner(s) Paid a Total</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="1" sdnum="1033;"><font face="Liberation Serif">1</font></td>
		<td align="center" sdval="26" sdnum="1033;"><font face="Liberation Serif">156</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="2" sdnum="1033;"><font face="Liberation Serif">2</font></td>
		<td align="center" sdval="52" sdnum="1033;"><font face="Liberation Serif">312</font></td>
		<td align="center" sdval="52" sdnum="1033;"><font face="Liberation Serif">312</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="3" sdnum="1033;"><font face="Liberation Serif">3</font></td>
		<td align="center" sdval="26" sdnum="1033;"><font face="Liberation Serif">156</font></td>
		<td align="center"><font face="Liberation Serif">Pot reset</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="4" sdnum="1033;"><font face="Liberation Serif">4</font></td>
		<td align="center" sdval="52" sdnum="1033;"><font face="Liberation Serif">312</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="5" sdnum="1033;"><font face="Liberation Serif">5</font></td>
		<td align="center" sdval="78" sdnum="1033;"><font face="Liberation Serif">468</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="6" sdnum="1033;"><font face="Liberation Serif">6</font></td>
		<td align="center" sdval="104" sdnum="1033;"><font face="Liberation Serif">624</font></td>
		<td align="center" sdval="104" sdnum="1033;"><font face="Liberation Serif">624</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="7" sdnum="1033;"><font face="Liberation Serif">7</font></td>
		<td align="center" sdval="26" sdnum="1033;"><font face="Liberation Serif">156</font></td>
		<td align="center"><font face="Liberation Serif">Pot reset</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="8" sdnum="1033;"><font face="Liberation Serif">8</font></td>
		<td align="center" sdval="52" sdnum="1033;"><font face="Liberation Serif">312</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="9" sdnum="1033;"><font face="Liberation Serif">9</font></td>
		<td align="center" sdval="78" sdnum="1033;"><font face="Liberation Serif">468</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="10" sdnum="1033;"><font face="Liberation Serif">10</font></td>
		<td align="center" sdval="104" sdnum="1033;"><font face="Liberation Serif">624</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="11" sdnum="1033;"><font face="Liberation Serif">11</font></td>
		<td align="center" sdval="130" sdnum="1033;"><font face="Liberation Serif">780</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="12" sdnum="1033;"><font face="Liberation Serif">12</font></td>
		<td align="center" sdval="156" sdnum="1033;"><font face="Liberation Serif">936</font></td>
		<td align="center" sdval="156" sdnum="1033;"><font face="Liberation Serif">936</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="13" sdnum="1033;"><font face="Liberation Serif">13</font></td>
		<td align="center" sdval="26" sdnum="1033;"><font face="Liberation Serif">156</font></td>
		<td align="center"><font face="Liberation Serif">Pot reset</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="14" sdnum="1033;"><font face="Liberation Serif">14</font></td>
		<td align="center" sdval="52" sdnum="1033;"><font face="Liberation Serif">312</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="15" sdnum="1033;"><font face="Liberation Serif">15</font></td>
		<td align="center" sdval="78" sdnum="1033;"><font face="Liberation Serif">468</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="16" sdnum="1033;"><font face="Liberation Serif">16</font></td>
		<td align="center" sdval="104" sdnum="1033;"><font face="Liberation Serif">624</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="17" sdnum="1033;"><font face="Liberation Serif">17</font></td>
		<td align="center" sdval="130" sdnum="1033;"><font face="Liberation Serif">780</font></td>
		<td align="center" sdval="130" sdnum="1033;"><font face="Liberation Serif">780</font></td>
	</tr>
	<tr>
		<td height="17" align="center" sdval="17" sdnum="1033;"><font face="Liberation Serif">Total</font></td>
		<td align="center"><font face="Liberation Serif"><br></font></td>
		<td align="center" sdval="476" sdnum="1033;"><font face="Liberation Serif">2652</font></td>
	</tr>
</table>
</center>
 -->
</div>
<!-- <a href="entryfee.jsp">Entry Fee Breakdown</a> -->
<BR>
<BR>
<BR>
<BR>
<div id="result"></div>
</body>
</html>
