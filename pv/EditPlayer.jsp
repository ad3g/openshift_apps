<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pig Valve Admin - Edit Player</title>
<%@ page import="java.util.*" %>
<%@ page import="com.pv.*" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.xyz {
    width: 325px;
    padding: 10px;
    margin: 0px;
}
.idWidth {
    width: 40px;
    padding: 0px;
    margin: 0px;
    align: center;
}
.nameWidth {
    width: 150px;
    padding: 0px;
    margin: 0px;
    align: center;
}
</style>
<script>
$(document).ready(function(){
	$("#subbtn").click(function(){
		alert("subbtn pressed within EditPlayer.jsp");
		var tYr = $("#pYr").val();
	    $.post("EditPlayerSave.jsp",
	    {
	    	xnum: $("#pNum").val(),
	    	xnme: $("#pName").val(),
	    	xyr: $("#pYr").val(),
	    },
	    function(data, status){
	    	window.location.replace("Admin.jsp?yr=" + tYr);
	    });
	});
});
</script>
</head>
<body>
<br>
<br>
<br>
<div class="xyz">
<%
PlayerDAO pDAO = new PlayerDAO();
Player p = new Player();
p.setpNum(request.getParameter("abc"));
p.setpYr(request.getParameter("yr"));
out.print(pDAO.getPlayerEdit(p));
%>
</div>
<div id="result"></div>
</body>
</html>
