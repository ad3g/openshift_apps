<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page import="com.golf.*" %>
<%@ page import="java.util.*" %>
<title>Golf League Tracker</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<style>
.xyz {
    width: 450px;
    padding: 10px;
    margin: 0px;
}
.container {
    width: 450px;
    padding: 10px;
    margin: 0px;
}
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
.ptsNeededWidth {
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
.myRoundWidth {
     width: 240px; 
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
/*     width: 50px; */
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
.rotate {
             filter:  progid:DXImageTransform.Microsoft.BasicImage(rotation=0.083);  /* IE6,IE7 */
         -ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=0.083)"; /* IE8 */
     -moz-transform: rotate(-90.0deg);  /* FF3.5+ */
      -ms-transform: rotate(-90.0deg);  /* IE9+ */
       -o-transform: rotate(-90.0deg);  /* Opera 10.5 */
  -webkit-transform: rotate(-90.0deg);  /* Safari 3.1+, Chrome */
          transform: rotate(-90.0deg);  /* Standard */
          align: center;
          white-space: nowrap;
          width: 10px;
}
</style>
<script>
$(document).ready(function(){
	$("#btnDetermineWinners").click(function(){
		var rid = $('#rId').val();
	    alert("dtr winners  " + rid);
	    $.post("ScoresDetermineWInner.jsp",
	    	    {
	    	        xId: rid
	     	    });
	    window.location.reload();
	});
	$("#subbtn").click(function(){
		alert("subbtn pressed within RoundAddEdit.jsp");
		var id, sType, rOut, dt  = "";
		id = $('#inputId').val();
		sType = $('#scoreType').find(":selected").text();
		rOut = $('#rainOut').find(":selected").text();
		dt = $("#mydate").val();
		alert("ty: " + sType + " out: " + rOut + " dt: " + dt);
		$.post("RoundAddEditSub.jsp",
	    	    {
			        xId: id,
			        xDate: dt,
			        xType: sType,
			        xOut: rOut,
	     	    });    
	    window.location = "RoundList.jsp";	
	});
	$("#canbtn").click(function(){
		//alert("canbtnStartSeason pressed within StartSeason.jsp");
 		window.location = "RoundList.jsp";	
 	});
	$("#mainbtn").click(function(){
		//alert("canbtnStartSeason pressed within StartSeason.jsp");
 		window.location = "index.jsp";	
 	});
});
function myFunction(id, pid){
	var str = "";
	str = $('#ptsEarned--' + id).find(":selected").text();
    //alert("hi  " + id + "  " + pid + "  " + str );
    $.post("ScoresSaveEarned.jsp",
    	    {
    	        xId: id,
    	        xEarn: str
     	    });
    window.location.reload();
}
function myWinAmount(id, pid){
	var str = "";
	str = $('#winAmt--' + id).find(":selected").text();
    //alert("hi  " + id + "  " + pid + "  " + str );
    $.post("ScoresSaveWinAmt.jsp",
    	    {
    	        xId: id,
    	        xAmt: str
     	    });
    window.location.reload();
}
function btnMarkPaid(id, pd){
//    alert("hi  " + id + "  " + pd);
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
<%
WinnerDao wDao = new WinnerDao();
Winner w = new Winner();
//w.setwId(Integer.parseInt(request.getParameter("abc")));
%>

<div class="container-fluid">
	<div class="xyz">
	
		<div id="containerScore" style="width:98%; margin:0 auto;">
			<h3 class="text-left">
				Winners
			</h3>		<%
			out.print(wDao.getWinnerEdit());
		%>
		</div>
	</div>
	<br>
	<br>
</div>
</div>

</body>
</html>