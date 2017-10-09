<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pig Valve III - Bowl Championship Challenge 2016-2017 - Brackets</title>
<%@ page import="java.util.*" %>
<%@ page import="com.pv.*" %>
<jsp:include page="../masterinclude.jsp"></jsp:include>
<!-- Local -->
<!-- <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
<!-- <script src="../js/jquery.js"></script> -->
<!-- <script src="../css/jquery.dataTables.min.css"></script> -->
<!-- <script src="../js/jquery.dataTables.min.js"></script> -->
<!-- <script src="../js/bootstrap.min.js"></script> -->

<!-- Remote -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<style>
/* .myH3a { */
/* 	.section-accordions .accordion-heading {background: red !important;} */
/* } */
.myH3b {
	background-color: aqua;
}
.myH3c {
	background-color: khaki;
}
.myH3d {
	background-color: wheat;
}
.myH3e {
	background-color: lightsalmon;
}

.myDiv {
	margin:-20px
}

.myTable {
	width: 100%;
}
.myP1 { 
	text-align: center;
}

.myP2 { 
	text-align: center;
	font-weight: bold;
}

.myP3 { 
	text-align: center;
	font-weight: bolder;
	font-size: 1.375em;
}

.myTd1 { 
	text-align: center;
	font-size: 0.775em;
	min-width: 1.75em;
	max-width: 2.25em;
	overflow: hidden;
	 
}

.myTd2 { 
	text-align: center;
	font-size: 1.375em;
	min-width: 2.25em;
	font-weight: bold; 
	background-color: lightblue; 
}

.myTd3 { 
	text-align: center;
	font-size: 1.375em;
	min-width: 2.25em; 
	font-weight: bolder;
	background-color: lightblue; 
}
.myTd4 { 
	text-align: center;
	font-size: 1.375em;
	min-width: 2.25em; 
	font-weight: bolder;
}
.myTr1 {
}
</style>
<script>
$(document).ready(function(){
	$(function() {
		$( "#accordion" ).accordion({ heightStyle: "content"});
	});
	$("body").on("click", "#subbtnUpdateScores", function (e) {
		alert("You clicked on getScores b4 confirmation");
		var getUrlParameter = function getUrlParameter(sParam) {
		    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
		        sURLVariables = sPageURL.split('&'),
		        sParameterName,
		        i;

		    for (i = 0; i < sURLVariables.length; i++) {
		        sParameterName = sURLVariables[i].split('=');

		        if (sParameterName[0] === sParam) {
		            return sParameterName[1] === undefined ? true : sParameterName[1];
		        }
		    }
		};
		var tYr = getUrlParameter('yr');
    	$.post("UpdateScores.jsp",
    		{
    			xyr: tYr
  	  		});
    		alert("UpdateScores");
		});
});
</script>
</head>
<body>
<br>
<br>
<%
String yr = "2016";
if(request.getParameter("yr") == null){
	//out.print("Year not found <BR>");
}
else
{
	yr = request.getParameter("yr");
}
GameDAO gDAO = new GameDAO();
PlayerDAO pDAO = new PlayerDAO();
//gDAO.refreshBrackets();
ArrayList<Game> gList = gDAO.getAllGames(yr);

InfoDAO iDAO = new InfoDAO();
ArrayList<Info> iList = iDAO.getAllInfos(yr);

%>

<BODY><BR>
<P class="myP3">Pig Valve III - Bowl Championship Challenge 2016-2017 - Brackets</P>
<div id="accordion">
<h3  align="center">Rules</h3>
<div class="myDiv">
<p>
<UL type="circle">
<%
for (int i = 0;i < iList.size();i++){
	out.print("<LI>" + iList.get(i).getiName() + "</LI>");
}
%>
</UL>
</p>
</div>
<%
out.print("<h3 align=\"center\">Payouts</H3>");
out.print("<div class=\"myDiv\">" + gDAO.getPayouts(yr) + "</div>");

for (int i = 0;i < gList.size();i++){
	if (gList.get(i).getWin2().equals("NA")){
		out.print("<h3 align=\"center\">" + gList.get(i).getgName() + "  -  " + gList.get(i).getT1NAME() + "  -  " + gList.get(i).getT2NAME()  +  "<BR>Half: $" + gList.get(i).getPay2() + "&nbsp~&nbspFinal: $" + gList.get(i).getPayF() + "</H3>");
	}
	else
	{
		out.print("<h3 align=\"center\">" + gList.get(i).getgName() + "  -  " + gList.get(i).getT1NAME() + "  -  " + gList.get(i).getT2NAME()  +  "<BR>Half: " + pDAO.getPlayerName(gList.get(i).getWin2()) + "&nbsp$" + gList.get(i).getPay2() + "&nbsp&nbsp~&nbsp&nbspFinal: " + pDAO.getPlayerName(gList.get(i).getWinF()) + "&nbsp$"  + gList.get(i).getPayF() + "</H3>");
 	}
// 	if (gList.get(i).getPay2().equals("75")){
// 		out.print("<h3 class=\"myH3b\" align=\"center\">" + gList.get(i).getgName() + "</H3>");
// 	}
// 	if (gList.get(i).getPay2().equals("100")){
// 		out.print("<h3 class=\"myH3c\" align=\"center\">" + gList.get(i).getgName() + "</H3>");
// 	}
// 	if (gList.get(i).getPay2().equals("300")){
// 		out.print("<h3 class=\"myH3d\" align=\"center\">" + gList.get(i).getgName() + "</H3>");
// 	}
	out.print("<div class=\"myDiv\">" + gList.get(i).getBracketHtml() + "</div>");
}


%>

</div> <!-- end of accordion tag -->

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="result"></div>
<center><button type="button" id="subbtnUpdateScores" class="btn btn-submit btn-xs">Update Scores</button></center>

</body>
</html>
