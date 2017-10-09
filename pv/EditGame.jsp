<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pig Valve Admin - Edit Game</title>
<%@ page import="java.util.*" %>
<%@ page import="com.pv.*" %>
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
.xyz {
    width: 300px;
    padding: 2px;
    margin: 2px;
}
.specWidth {
    width: 40px;
    padding: 5px;
    margin: 0px;
    align: center;
}
.specWidth2 {
    width: 350px;
    padding: 5px;
    margin: 0px;
    align: center;
}
.specWidth3 {
    width: 80px;
    padding: 5px;
    margin: 0px;
    align: center;
}

</style>
<script>
$(document).ready(function(){
	$("#subbtn").click(function(){
		//alert("subbtn pressed");
		var tYr = $("#gyr").val();
	    $.post("EditGameSave.jsp",
	    {
	    	g1Name: $("#g1Name").val(),
	    	t1s1: $("#t1s1").val(),
	    	t1s2: $("#t1s2").val(),
	    	t1s3: $("#t1s3").val(),
	    	t1s4: $("#t1s4").val(),
	    	t1sF: $("#t1sF").val(),
	    	
	    	g2Name: $("#g2Name").val(),
	    	t2s1: $("#t2s1").val(),
	    	t2s2: $("#t2s2").val(),
	    	t2s3: $("#t2s3").val(),
	    	t2s4: $("#t2s4").val(),
	    	t2sF: $("#t2sF").val(),
	    	
	    	gname: $("#gname").val(),
	    	gloc: $("#gloc").val(),
	    	gdte: $("#gdte").val(),
	    	gtv: $("#gtv").val(),
	    	
	    	gwin1: $("#gwin1").val(),
	    	gwin2: $("#gwin2").val(),
	    	gwin3: $("#gwin3").val(),
	    	gwin4: $("#gwin4").val(),
	    	gwinF: $("#gwinF").val(),
	    	
	    	gpay1: $("#gpay1").val(),
	    	gpay2: $("#gpay2").val(),
	    	gpay3: $("#gpay3").val(),
	    	gpay4: $("#gpay4").val(),
	    	gpayF: $("#gpayF").val(),

	    	gnum: $("#gnum").val(),
	    	gpnum: $("#gpnum").val(),
	    	gt1num: $("#gt1num").val(),
	    	gt2num: $("#gt2num").val(),
	    	gyr: $("#gYr").val(),
	    	gbracket: $("#gbracket").val()

	    },
	    function(data, status){
	    	window.location.replace("Admin.jsp?yr=" + tYr);
	    });
	});
});
</script>
</head>
<body>
<form id="EditGame">
<br>
<br>
<br>
<div class="xyz">
<%
GameDAO gDAO = new GameDAO();
Game g = new Game();
g.setgNum(request.getParameter("abc"));
g.setgYr(request.getParameter("yr"));

out.print(gDAO.getGameEdit(g));

%>
</div>

<div id="result"></div>
</form>

</body>
</html>
