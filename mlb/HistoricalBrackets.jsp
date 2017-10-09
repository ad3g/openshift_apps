<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.*" %>
<%@ page import = "com.mlb.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MLB 13 Run Pool - Winning Bracket</title>
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
<div id="ScoreSection" class="container">
	<center><img src="../res/1280px-Major_League_Baseball.svg.png" height="150" width="250"></center>
	<BR>
	<center><font size="36">MLB 13 Run Pool - Historical Brackets</font></center>
	<div>
<!-- 	<ul> -->
<!-- 		<li><b>2016-04-17</b></li> -->
<!-- 		<a href="../mlb/SingleHistoricalBracket.jsp?bid=f1f563c3-132a-43b3-a4a6-2b9e986c8b50&dt=2016-04-17">xxxx</a> -->
<!-- 	</ul> -->
	<%
		out.print(MLBProcessor.printHistoricalList());
	%>
	</div>
</div>
</html>