<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Title</title>
<%@ page import="java.util.*" %>
<%@ page import="com.golf.*" %>
<jsp:include page="../masterinclude.jsp"></jsp:include>

<!-- Remote -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <link rel="stylesheet" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css"> -->
<!-- <script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.xyz {
    width: 667px;
    padding: 0px;
    margin: 0px;
}
.myTh{
/* 	width: 20px; */
	padding: 0px; 
	margin: 0px; 
    text-align: center;
}

.myTh{
/* 	width: 20px; */
	padding: 0px; 
	margin: 0px; 
    text-align: center;
}
.ptsEarnedWidth {
     width: 65px;
/*      padding: 0px;  */
    margin: 0px;
    text-align: center;
}
.myNameWidth {
     width: 80px; 
     padding: 0px; 
     margin: 0px;
    text-align: center;
}
.myPaidWidth {
     width: 50px; 
/*     padding: 0px; */
/*     margin: 0px; */
    text-align: center;
}
.myWidth {
     width: 65px; 
/*     padding: 0px; */
/*     margin: 0px; */
    text-align: center;
}
.myHiddenWidth {
    visibility: hidden;
    width: 20px;
    padding: 0px;
    margin: 0px;
    text-align: center;
}
.idWidth {
    width: 40px;
    padding: 0px;
    margin: 0px;
    text-align: center;
}
</style>
<script>
function myFunction(id, pid){
	var str = "";
	str = $('#ptsEarned--' + id).find(":selected").text();
    //alert("hi  " + id + "  " + pid + "  " + str );
    $.post("ScoresSaveEarned.jsp",
    	    {
    	        xId: id,
    	        xEarn: str
     	    });    
}
function btnMarkPaid(id, pd){
    //alert("hi  " + id + "  " + pd);
    $.post("ScoresSavePaid.jsp",
    	    {
    	        xId: id,
    	        xPaid: pd
     	    });
    window.location.reload();
}
function btnMarkClosestTo(id, pd){
    //alert("hi  " + id + "  " + pid + "  " + str );
    $.post("ScoresSaveClosestTo.jsp",
    	    {
    	        xId: id,
    	        xClosestTo: pd
     	    });
    window.location.reload();
}
</script>
</head>
<body>
<br>
<br>
<br>
<div class="xyz">
	<div id="containerScore" style="width:98%; margin:0 auto;">
	<P><CENTER><FONT SIZE="7">Scores</FONT></CENTER></P>
	<%
		ScoresDao sc = new ScoresDao();
		//out.print(sc.getScoreTable());
	%>
	</div>
</div>
<div id="result"></div>
</body>
</html>