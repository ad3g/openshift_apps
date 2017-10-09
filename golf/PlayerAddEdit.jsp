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
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet" href="../css/styles.css">
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
//		alert("subbtn pressed within PlayerAddEdit.jsp");
	    $.post("PlayerAddEditSub.jsp",
	    	    {
	    	        xNme: $("#inputName").val(),
	    	        xEml: $("#inputEmail").val(),
	    	        xPh: $("#inputPhone").val(),
	    	        xId: $("#inputId").val(),
	     	    });    
	    window.location = "PlayerList.jsp";	
	});
	$("#canbtn").click(function(){
		//alert("canbtnStartSeason pressed within StartSeason.jsp");
 		window.location = "PlayerList.jsp";	
 	});
	$("#mainbtn").click(function(){
		//alert("canbtnStartSeason pressed within StartSeason.jsp");
 		window.location = "index.jsp";	
 	});
});
</script>
</head>
<body>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-left">
				Add / Edit Player
			</h3>
			<%
			PlayerDao pDao = new PlayerDao();
			Player p = new Player();
			p.setpId(Integer.parseInt(request.getParameter("abc")));
			out.print(pDao.getPlayerEdit(p));
			%>
		</div>
	</div>
</div>
</body>
</html>