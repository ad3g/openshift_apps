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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>
<!-- <link rel="stylesheet" href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css"> -->
<!-- <script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script> -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
<style>
.ctrHdr {
	text-align: center;
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
</style>
<script>
$(document).ready(function(){
	$("#subbtnStartSeason").click(function(){
		//alert("subbtnStartSeason pressed within index.jsp");
		window.location = "StartSeason.jsp";
		//$.get("StartSeason.jsp");
	});
// 	function btnMarkClosestTo(id, pd){
// 	    //alert("hi  " + id + "  " + pid + "  " + str );
// 	    $.post("ScoresSaveClosestTo.jsp",
// 	    	    {
// 	    	        xId: id,
// 	    	        xClosestTo: pd
// 	     	    });
// 	    window.location.reload();
// 	}
	$("#subbtnRounds").click(function(){
		//alert("subbtnRounds pressed within index.jsp");
	    window.location = "RoundList.jsp";
	});
	$("#subbtnPlayers").click(function(){
		//alert("subbtnPlayers pressed within index.jsp");
	    window.location = "PlayerList.jsp";
	});

	$("#subbtnWinnings").click(function(){
		//alert("subbtnWinnings pressed within index.jsp");
	    //$.post("Winners.jsp",
		window.location = "WinnerSummary.html";
	});
});
</script>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<br><br>
			<h1 class="ctrHdr">Montante Golf League</h1>
			<br>
			<div class="form-group ctrHdr">
				<br>
				<div class="col-sm-offset-1 col-sm-10">
					<button type="button" id="subbtnPlayers" class="btn btn-primary col-sm-1 ">
						Edit / View Players
					</button>
				</div>
				<br>
				<div class="col-sm-offset-1 col-sm-10">
					<button type="button" id="subbtnRounds" class="btn btn-primary col-sm-1 ">
						Enter / View Scores by Week
					</button>
				</div>
				<br>
				<div class="col-sm-offset-1 col-sm-10">
					<button type="button" id="subbtnWinnings" class="btn btn-primary col-sm-1 ">
						View Winnings
					</button>
				</div>
				<br>
				<%
				RoundDao rDao = new RoundDao();
				boolean bFound = rDao.roundsExistForYear();
				if (!bFound){
				%>
					<div class="col-sm-offset-1 col-sm-10">
						<button type="button" id="subbtnStartSeason" class="btn btn-primary col-sm-1 ">
							Start New Season
						</button>
					</div>
					<%
				}
				%>
			</div>
		</div>
	</div>
</div>
</body>
</html>