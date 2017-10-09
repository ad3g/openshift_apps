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
    //alert("hi  " + id + "  " + pid + "  " + str );
    $.post("ScoreSavePaid.jsp",
    	    {
    	        xId: id,
    	        xPaid: pd
     	    });
    window.location.reload();
}
function btnMarkClosestTo(id, pd){
    //alert("hi  " + id + "  " + pid + "  " + str );
    $.post("ScoreSaveClosestTo.jsp",
    	    {
    	        xId: id,
    	        xClosestTo: pd
     	    });
    window.location.reload();
}
</script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-3">
			<h3>
				Start Round
			</h3>
			<form role="form">
				<div class="form-group">
	                <div class='input-group date' id='datetimepicker1'>
	                    <input type='text' class="form-control" />
	                    <span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>
            	</div>
				<script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({format: 'MM/DD/YYYY',defaultDate: new Date()});
		            });
		        </script>				
				<div class="dropdown">
				  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Score Type
				  <span class="caret"></span></button>
				  <ul class="dropdown-menu">
				    <li><a href="#">Individual</a></li>
				    <li><a href="#">Scramble</a></li>
				  </ul>
				</div>
				<br>
				<div class="dropdown">
				  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Rain Out
				  <span class="caret"></span></button>
				  <ul class="dropdown-menu">
				    <li><a href="#">No</a></li>
				    <li><a href="#">Yes</a></li>
				  </ul>
				</div>				
				<br>				
				<div class="form-group">
					<button type="submit" class="btn btn-default">
						Submit
					</button>
					<button type="submit" class="btn btn-default">
						Cancel
					</button>
				</div>				
			</form>
		</div>
	</div>
</div>
</body>
</html>
