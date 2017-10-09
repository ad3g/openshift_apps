<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>March Madness - # Bracket Tournament = Admin</title>
<%@ page import="java.util.*" %>
<%@ page import="com.mm.*" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%-- <jsp:include page="../masterinclude.jsp"></jsp:include> --%>
<!-- Remote -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$("#subbtn").click(function(){
		callAdminSend("del");
	});
	$("#reload").click(function(){
		callAdminSend("relo");
	});
});
function callAdminSend(xyz){
    $.post("AdminSend.jsp",
    { ky : xyz},
    function(data, status){
    	$("#result").html(data);
    });
};

</script>
<body>
<div class="container myCenter">
	<br>
	<button type="button" id="subbtn" class="btn btn-submit">Delete Winners</button>
	<br>
	<br>
	<br>
	<button type="button" id="reload" class="btn btn-submit">Reload Winners</button>
	<div id="result"></div>
</div>

<br>
</body>
</html>