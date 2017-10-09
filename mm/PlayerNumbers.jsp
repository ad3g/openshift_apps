<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>March Madness - # Bracket Tournament - Players #'s</title>
<%@ page import="java.util.*" %>
<%@ page import="com.mm.*" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<%-- <jsp:include page="../masterinclude.jsp"></jsp:include> --%>
<!-- Remote -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.container {
	margin: 0;
	padding: 0;
	text-align: left;
	max-width: 640px
}
.myLeft {
	text-align: left;
}
.myCenter {
	text-align: center;
}
.myFont {
	font-size: 200%;
}
.myMedLarge {
	font-size: 125%;
}
.myLarge {
	font-size: 150%;
}
.myWidth {
	max-width: 20px;
}
.myWidthSmall {
	max-width: 40px;
}
.myWidth2 {
	max-width: 100px;
}
.myTable {
	margin: 0;
	padding: 0;
}
/* table, th, td { */
/*     border: 1px solid black; */
/* } */

/* .parent th, td { */
/* 	text-align: center; */
/* 	padding: 10; */
/* }  */
table {
    border-collapse: collapse;
    width: 90%;
}

th, td {
    text-align: center;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #459FF5;
    color: white;
}
.btn {
    padding: 7px 7px;
    font-size: 22px;
}
</style>
<script>
$(document).ready(function(){
	$('#wButtons').change(function(){
	    var wValue = $( 'input[name=wRadio]:checked' ).val();
	    var lValue = $( 'input[name=lRadio]:checked' ).val();

	    //alert(wValue + " - " + lValue);
	    $.post("PlayerNumbersSend.jsp",
   	    {
   	        wVal: wValue,
   	        lVal: lValue
   	    },
   	    function(data, status){
   	    	$("#result").html(data);
   	    });
	});
	$('#lButtons').change(function(){
	    var wValue = $( 'input[name=wRadio]:checked' ).val();
	    var lValue = $( 'input[name=lRadio]:checked' ).val();

	    //alert(wValue + " - " + lValue);
	    $.post("PlayerNumbersSend.jsp",
   	    {
   	        wVal: wValue,
   	        lVal: lValue
   	    },
   	    function(data, status){
   	    	$("#result").html(data);
   	    });
	});
}); 	
</script>
</head>
<body>
<br>
<br>
<br>
<div class="container">
	<center>
	<img src="../images/marchmadness_logo.gif" style="width:325px;height:325px;">
	<br>
	<div class="myLarge">
		<a href="Scores.jsp">Scores</a>
		<br>
		<a href="Winners.jsp">Winners</a>
		<br>
	</div>
	<br>
	<div id="wButtons" class="btn-group" data-toggle="buttons">
	<p class="myLarge">Select Winning Number</p>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w0" value="0" checked/>0
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w1" value="1"/>1
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w2" value="2"/>2
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w3" value="3"/>3
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w4" value="4"/>4
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w5" value="5"/>5
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w6" value="6"/>6
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w7" value="7"/>7
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w8" value="8"/>8
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w9" value="9"/>9
    </label>
	</div>
	<br>
	<br>
	<div id="lButtons" class="btn-group" data-toggle="buttons">
    <p class="myLarge">Select Losing Number</p>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w0" value="0" checked/>0
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w1" value="1"/>1
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w2" value="2"/>2
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w3" value="3"/>3
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w4" value="4"/>4
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w5" value="5"/>5
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w6" value="6"/>6
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w7" value="7"/>7
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w8" value="8"/>8
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="lRadio" id="w9" value="9"/>9
    </label>
	</div>
	
	<div id="result"></div>
    <br>
	<br>
	<br>
	<% 
	Bracket b = new Bracket(); 
	out.print("<div >" + b.buildNumberBracket() + "</div>");
	%>
	<br>
	</center>
</div>
</body>
</html>