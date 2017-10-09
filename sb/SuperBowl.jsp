<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.*" %>
<%@ page import = "com.sb.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Super Bowl 2016</title>
<!-- <script type="text/javascript" src="../../resources/reptlibs/jquery/jquery-1-8-2.js"></script> -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.js"></script> -->
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<!-- <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css"> -->
<script>
$(function() {
	$("body").on("click", ".addScore", function (e) {
	 	e.preventDefault();
 		$.post( "../sb/addScores.jsp",
 			{
				Qtr:$('input[name=Qtr]:checked').val(),
				Div:$('input[name=Div]:checked').val(),
				Pts:$('input[name=Pts]:checked').val()
			},
 			function(data,status)
 			{
				parent.location.reload();
			});
		});
//	});
	$("body").on("click", ".assignNumbers", function (e) 
	  {
	 	e.preventDefault();
		//alert("in assignNumbers");
 		$.post( "../sb/assignNumbers.jsp",
 			function(data,status)
 			{
				parent.location.reload();
			});
	  });
	$("body").on("click", ".resetScores", function (e) 
			  {
			 	e.preventDefault();
				//alert("in assignNumbers");
		 		$.post( "../sb/resetScores.jsp",
		 			function(data,status)
		 			{
						parent.location.reload();
					});
			  });
});
</script>
</head>
<body>
<div id="ScoreSection" class="container">
<!-- <center><font size="36"><img src="../res/196px-National_Football_League_2008.svg.png" height="150" width="250"><img src="../res/250px-New_England_Patriots_logo.svg.png" height="150" width="250">     Super Bowl 2015       <img src="../res/547px-SeattleSeahawks.svg.png" height="150" width="250"><img src="../res/Super_Bowl_logo_svg.png" height="150" width="250"></font></center> -->
<center><font size="36"><img src="../res/196px-National_Football_League_2008.svg.png" height="150" width="250">     Super Bowl 2017       <img src="../res/Super_Bowl_logo_svg.png" height="150" width="250"></font></center>
<%
SBProcessor sbp = new SBProcessor();
String abc = sbp.buildBracket();
out.print(abc);	
%>
</div>

<div id="msg" class="container">
<%
Scores s = new Scores();
ArrayList<Scores> lScores = new ArrayList<Scores>();
s.getScores();
String sGameScores = s.print1HalfScores();
out.print(sGameScores);
String sMatchiesScores = s.printMatchies();
out.print(sMatchiesScores);
String sQtrScores = s.printQtrScores();
out.print(sQtrScores);
out.print("<div>");
out.print("<BR><HR>");
out.print(sbp.printRules());
// out.print("<table  border=\"0\" align=\"center\" width=\"90%\"><tr><td align=\"center\"><h2>Game Scores</h2></td><td align=\"center\"><h2>Qtr Scores</h2></td><td align=\"center\"><h2>Matchies</h2></td></tr>");
// out.print("<tr><td align=\"center\">" + sGameScores + "</td><td align=\"center\">" + sQtrScores + "</td><td align=\"center\">" + sMatchiesScores + "</td></tr></table>");
// out.print("</div>");
%>
<HR>
<%
if (request.getParameter("Scores")==null) { } else {
	
if (request.getParameter("Scores").equals("Yes")) {
 %>
<div id="addscoresbtns" class="container">
<h2>Manually Enter Score</h2>
<%
Game gm = new Game();
gm.getGame();
%> 
<input type="radio" name="Qtr" value="1" checked>1st Quarter
<br>
<input type="radio" name="Qtr" value="2">2nd Quarter
<br>
<input type="radio" name="Qtr" value="3">3rd Quarter
<br>
<input type="radio" name="Qtr" value="4">4th Quarter
<br>
<input type="radio" name="Qtr" value="5">OT
<br>
<br>
<input type="radio" name="Div" value="NFC" checked> <%out.print(gm.getNFCTeam()); %>
<br>
<input type="radio" name="Div" value="AFC"> <%out.print(gm.getAFCTeam()); %>
<br>
<br>
<input type="radio" name="Pts" value="6" checked>Touchdown (6pts)
<br>
<input type="radio" name="Pts" value="3">Field Goal (3pts)
<br>
<input type="radio" name="Pts" value="2">PAT Conversion or Safety (2pts)
<br>
<input type="radio" name="Pts" value="1">PAT (1pts)
<br><br>
<button id="sub" class="addScore"> <img src="../res/add_new.png" height="20" width="50"> Submit Score </button><br>
<br>
<%
boolean bLoad = gm.numbersLoaded(); 
if (!bLoad) { %>
	<button id="NFC" id2="1" class="assignNumbers"> <img src="../res/add_new.png" height="20" width="50"> Assign Numbers </button><br>
<%	
} %>
<BR>
<button class="resetScores"> <img src="../res/add_new.png" height="20" width="50"> Reset Scores</button>
<%
}}
%>
</div>
</html>