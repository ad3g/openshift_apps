<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import = "java.util.*" %>
<%@ page import = "com.mlb.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>MLB 13 Run Pool - Team</title>
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
<style>
.xyz {
    width: 550px;
    padding: 0px;
    margin: 0px;
}
.specWidth {
    width: 40px;
    padding: 0px;
    margin: 0px;
    align: center;
}
</style>
</head>
<body>
<div id="ScoreSection" class="container">
<center><img src="../res/1280px-Major_League_Baseball.svg.png" height="150" width="250"></center>
<BR>
<center><font size="36">MLB 13 Run Pool - Team</font></center>
<br>
<a class="btn btn-default" href="../mlb/Standings.jsp">Back to Standings</a>
<br>
<div>

<%
//	out.print(MLBProcessor.getGame(request.getParameter("Team")));
%>
</div>
</div>
</body>

</html>