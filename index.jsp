<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page import="com.common.*" %>
<title>Pick your game</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

</head>
<body>
<div class="container">
  <div>
  <% IdxCntlDB iDB = new IdxCntlDB();
  if (iDB.getIdxCntlByApp("mm").equals("Y")){
  %>
  	<center><a href="./mm/Scores.jsp"><img src="./images/marchmadness_logo.gif" height="150" width="250"><br>Winner - Loser Numbers</a></center>
  <%} %>
  </div>
  <div>
  <%
  if (iDB.getIdxCntlByApp("nfl").equals("Y")){
  %>
  	<center><a href="./nfl/Standings.jsp"><img src="./res/196px-National_Football_League_2008.svg.png" height="150" width="250"><br>22 Point Challenge</a></center>
  </div>
  <%} %>
  <div>
  <%
  if (iDB.getIdxCntlByApp("mlb").equals("Y")){
  %>
  	<center><a href="./mlb/Standings.jsp"><img src="./res/1280px-Major_League_Baseball.svg.png" height="150" width="250"><br>13 Run Challenge</a></center>
  </div>
  <%} %>
  <div>
  <%
  if (iDB.getIdxCntlByApp("pv").equals("Y")){
  %>
  	<center><a href="./pv/Brackets.jsp?yr=2016"><img src="./res/collegebowlgames.jpg" height="150" width="250"><br>2016-2017 Pig Valve Bowl Challenge</a></center>
  </div>
  <%} %>  
  <div>
  <%
  if (iDB.getIdxCntlByApp("sb").equals("Y")){
  %>
  	<center><a href="./sb/SuperBowl.jsp"><img src="./res/Super_Bowl_logo_svg.png" height="150" width="250"><br>2017 Super Bowl Squares</a></center>
  <%} %>  
  </div>  
</div>
</body>
</html>