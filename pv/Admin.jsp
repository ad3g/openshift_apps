<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pig Valve III - Bowl Championship Challenge 2016-2017 - Admin</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>

.EditPlayer { 
	align: center; 
} 
</style>
<script>
$(document).ready(function(){
	$("#datatable").dataTable({
		"iDisplayLength": 10
	});
	$("#datatableGame").dataTable({
		"iDisplayLength": 50
	});
	$("#datatableInfo").dataTable({
		"iDisplayLength": 10
	});
// 	$(function() {
// 		$( "#accordion" ).accordion({ heightStyle: "content"});
// 	});
	$("body").on("click", ".EditPlayer", function (e) {
		alert("You clicked on Edit Player");
	    $.post("EditPlayer.jsp",
	    {
	        xnum: $("#abc").val(),
	        xyr: $("#yr").val()
 	    });
	});
	$("body").on("click", ".EditInfo", function (e) {
		alert("You clicked on Edit Info");
	    $.post("EditInfo.jsp",
	    {
	        xnum: $("#abc").val(),
	        xyr: $("#yr").val()
 	    });
	});
	$("body").on("click", ".EditGame", function (e) {
		alert("You clicked on Edit Game");
	    $.post("EditGame.jsp",
	    {
	        xnum: $("#abc").val(),
	        xyr: $("#yr").val()
 	    });
	});
	$("body").on("click", "#subbtnAssign", function (e) {
		alert("You clicked on Assign b4 confirmation");
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
		if (confirm('Are you sure you want to assign numbers?')) {
	    	$.post("AssignNumbers.jsp",
	    	  {
	    		xyr: tYr
	    	  });
	    	alert("Numbers Assigned");
		};
	});
	$("body").on("click", "#subbtnRefreshBrackets", function (e) {
		alert("You clicked on Assign b4 confirmation");
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
    	$.post("RefreshBrackets.jsp",
    		{
    			xyr: tYr
  	  		});
    		alert("RefreshBrackets");
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
		out.print("Year not found <BR>");
	}
	else
	{
		yr = request.getParameter("yr");
	}
GameDAO gx = new GameDAO();
ArrayList<Game> gListx = gx.getAllGames(yr);
//if (gListx.get(0).getpNum().isEmpty() || gListx.get(0).getpNum().equals("NA")){
%>
<%
//}
%>
<div id="containerGame" style="width:90%; margin:0 auto;">
<P ALIGN="CENTER"><FONT SIZE="7">Edit Games</FONT></P>
<%
	out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"stripe\" id=\"datatableGame\">");
	out.print("<thead><tr><th nowrap>Game</th></tr></thead>"); 
	out.print("<tbody>");
	for (int i=0; i < gListx.size(); i++) {
		out.print("<tr><td ALIGN=\"CENTER\"><a href=\"../pv/EditGame.jsp?abc=" + gListx.get(i).getgNum() + "&yr=" + gListx.get(i).gYr + "\" class=\"EditGame\"> " + gListx.get(i).getgName() + "</a></td></tr>");
	}
	out.print("</tbody>");	
	out.print("</table>");
%>

</div>

<div id="container" style="width:90%; margin:0 auto;">
<P ALIGN="CENTER"><FONT SIZE="7">Edit Players</FONT></P>
<%
	PlayerDAO p = new PlayerDAO();
	ArrayList<Player> pList = p.getAllPlayers(yr);
	out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"stripe\" id=\"datatable\">");
	out.print("<thead><tr><th nowrap>Player</th></tr></thead>");
	out.print("<tbody>");
	for (int i=0; i < pList.size(); i++) {
		out.print("<tr><td ALIGN=\"CENTER\"><a href=\"../pv/EditPlayer.jsp?abc=" + pList.get(i).getpNum() + "&yr=" + pList.get(i).getpYr() + "\" class=\"EditPlayer\"> " + pList.get(i).getpName() + "</a></td></tr>");
	}
	out.print("</tbody>");	
	out.print("</table>");
%>
</div>

<div id="containerInfo" style="width:90%; margin:0 auto;">
<P ALIGN="CENTER"><FONT SIZE="7">Edit Info</FONT></P>
<%
	InfoDAO in = new InfoDAO();
	ArrayList<Info> iList = in.getAllInfos(yr);
	out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" class=\"stripe\" id=\"datatableInfo\">");
	out.print("<thead><tr><th nowrap>Information Message</th></tr></thead>");
	out.print("<tbody>");
	for (int i=0; i < iList.size(); i++) {
		out.print("<tr><td ALIGN=\"CENTER\"><a href=\"../pv/EditInfo.jsp?abc=" + iList.get(i).getiNum() + "&yr=" + iList.get(i).getiYr() + "\" class=\"EditInfo\"> " + iList.get(i).getiName() + "</a></td></tr>");
	}
	out.print("</tbody>");	
	out.print("</table>");
%>
<center><button type="button" id="subbtnAssign" class="btn btn-submit">Assign Numbers</button></center><br><br>
<center><button type="button" id="subbtnRefreshBrackets" class="btn btn-submit">Refresh Brackets</button></center><br><br>
<center><button type="button" id="subbtnUpdateScores" class="btn btn-submit">Update Scores</button></center>
<br>
<br>
</div>


<div id="result"></div>

</body>
</html>
