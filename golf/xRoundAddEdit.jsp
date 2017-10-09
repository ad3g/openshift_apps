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
// function myFunction(id){
// 	var sType, rOut  = "";
// 	sType = $('#scoreType').find(":selected").text();
// 	rOut = $('#rainOut').find(":selected").text();
//     alert("hi  " + sType + "  " + rOut );
//     $.post("RoundAddEditSub.jsp",
//     	    {
//     	        xId: id,
//     	        xType: sType,
//     	        xOut: rOut,
//      	    });    
// }
</script>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-left">
				Add / Edit Round
			</h3>
			<%
			RoundDao rDao = new RoundDao();
			Round r = new Round();
			r.setrId(Integer.parseInt(request.getParameter("abc")));
			out.print(rDao.getRoundEdit(r));
			%>
		</div>
	</div>
</div>
</body>
</html>