<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>March Madness - # Bracket Tournament - Winners</title>
<%@ page import="java.util.*" %>
<%@ page import="com.mm.*" %>
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
</head>
<body>
<br>
<br>
<br>
<div class="container">
	<center>
	<img src="../images/marchmadness_logo.gif" style="width:325px;height:325px;">
	<br>
	<div class="myLarge">
		<a href="Scores.jsp">Scores</a>
		<br>
		<a href="PlayerNumbers.jsp">Players Numbers</a>
		<br>
	</div>

	<br>
	<br>
	<% 
	WinnerDAO w = new WinnerDAO(); 
	out.print("<div >" + w.formatWinnerTable() + "</div>");
	%>
	<br>
	</center>
</div>
</body>
</html>