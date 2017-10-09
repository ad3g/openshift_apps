<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NFL 22 Point Pool - Initialize</title>
<%@ page import="java.util.*" %>
<%@ page import="com.nfl.*" %>
<jsp:include page="../masterinclude.jsp"></jsp:include>

</head>
<body>
<br>
<br>
<div id="container" style="width:1000px; margin:0 auto;">
<%
	String yr = "2017";
	String seas = "Regular";
	if(request.getParameter("yr") == null){
//		out.print("Year not found <BR>");
	}
	else
	{
		yr = request.getParameter("yr");
	}
	if(request.getParameter("seas") == null){
//		out.print("Season not found <BR>");
	}
	else
	{
		seas = request.getParameter("seas");
	}

 	TestMain.initializeLoad(yr, seas);
	out.print("Done");
%>
</div>
<div id="result"></div>
</body>
</html>
