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
	max-width: 640px
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
    width: 90%;
}

th, td {
    text-align: center;
    padding: 8px;
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
$(function() {
	$("body").on("click", ".mlbAssignNumbers", function (e) 
	  {
	 	e.preventDefault();
		alert("in AssignNumbers");
 		$.post( "../mlb/AssignNumbers.jsp",
 			function(data,status)
 			{
				parent.location.reload();
			});
	  });
	$("body").on("click", ".mlbTest", function (e) 
			  {
			 	e.preventDefault();
				alert("in Test");
		 		$.post( "../mlb/Test.jsp",
		 			function(data,status)
		 			{
						parent.location.reload();
					});
			  });
	$("#datatable").dataTable({
	    bFilter: true,
	    bPaginate: true,
	    "pagingType": "full_numbers",
	    iDisplayLength: 10,
	    bSort: true,
	    bStateSave: true,
	    iCookieDuration: 60,   // set to 60 secs..format 60*60*24; // 1 day
	    bInfo: false,
	    bServerSide: false
	});
});
</script>
</head>
<body>
<div id="ScoreSection" class="container">
<center><img src="../res/1280px-Major_League_Baseball.svg.png" height="150" width="250"></center>
<BR>
<center><font size="36">MLB 13 Run Pool - Standings</font></center>
<button class="mlbAssignNumbers"> <img src="../res/add_new.png" height="20" width="50">Assign Numbers</button>
<BR>
<%
//MLBProcessor.LoadAllBetweenDateRange("", "");

//out.print(MLBProcessor.printStandings(request.getParameter("st"), request.getParameter("end")));
%>
<BR>
<BR>
<button class="mlbTest"> <img src="../res/add_new.png" height="20" width="50">Test</button>
<BR>
</div>
<div class="container">
<%
//out.print(MLBProcessor.printTeamGameResults(request.getParameter("st"), request.getParameter("end")));
%>
</div>
</html>