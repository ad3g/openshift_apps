<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pig Valve II - Bowl Championship Challenge 2015-2016 - Admin Edit Info</title>
<%@ page import="java.util.*" %>
<%@ page import="com.golf.*" %>
<jsp:include page="../masterinclude.jsp"></jsp:include>

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
    width: 250px;
    padding: 0px;
    margin: 0px;
    align: center;
}
</style>
<script>
$(document).ready(function(){
	$("#subbtn").click(function(){
		//alert("subbtn pressed within EditInfo.jsp");
	    $.post("EditInfoSave.jsp",
	    {
	    	xnum: $("#iNum").val(),
	    	xnme: $("#iName").val(),
	    },
	    function(data, status){
	    	window.location.replace("TestDataTable.jsp");
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
InfoDAO iDAO = new InfoDAO();
Info p = new Info();
p.setiNum(request.getParameter("abc"));
out.print(iDAO.getInfoEdit(p));
%>
</div>
<div id="result"></div>
<!-- Piwik -->
<script type="text/javascript">
  var _paq = _paq || [];
  _paq.push(['trackPageView']);
  _paq.push(['enableLinkTracking']);
  (function() {
    var u="//piwik-ad3g.rhcloud.com/";
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setSiteId', 1]);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();
</script>
<noscript><p><img src="//piwik-ad3g.rhcloud.com/piwik.php?idsite=1" style="border:0;" alt="" /></p></noscript>
<!-- End Piwik Code -->
</body>
</html>
