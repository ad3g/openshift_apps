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
a {
    color: blue;
}
a:link {
    text-decoration: underline;
}
.ctrHdr {
	text-align: center;
}
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
	$("#addbtnPlayer").click(function(){
		//alert("canbtnStartSeason pressed within StartSeason.jsp");
 		window.location = "PlayerAddEdit.jsp?abc=0";	
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
	<div id="containerGame"">
		<h1 class="ctrHdr">Players</h1>
		<%
			PlayerDao pDao = new PlayerDao();
			ArrayList<Player> pList = pDao.getAllPlayers();
 			out.print("<div class=\"ctrHdr\">");
			for (int i=0; i < pList.size(); i++) {
				out.print("<a href=\"../golf/PlayerAddEdit.jsp?abc=" + pList.get(i).getpId() + "\" class=\"h3\">" + pList.get(i).getpName() + "</a><br>");
			}
			out.print("</div>");
		%>
	</div>
	<div class="form-group ctrHdr">
		<button type="button" id="addbtnPlayer" class="btn btn-primary col-lg-3 ">
			Add New Player
		</button>
		<button type="button" id="mainbtn" class="btn btn-default col-lg-3 ">
			Main Page
		</button>
	</div>	
</div>
</body>
</html>