<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>March Madness - # Bracket Tournament</title>
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
	$(window).load(function() {
		callScoresSend();
	});
	$('#wButtons').change(function(){
	    var wValue = $( 'input[name=wRadio]:checked' ).val()
	    callScoresSend();
	});
});

function callScoresSend(){
    $.post("ScoresSend.jsp",
    {
    	 dt : $( 'input[name=wRadio]:checked' ).val()
//         dt: $("#datepicker").val()
    },
    function(data, status){
    	$("#result").html(data);
    });
};
</script>
<style>
.container {
	margin: 0;
	padding: 0;
	text-align: left;
	max-width: 640px
}
.myCenter { 
	text-align: center; 
	align: center; 
}
.mySmall {
	font-size: 75%;
	text-align: center;
}
.myAuto { 
	margin: auto; 
}
.myDivWidth {
	max-width: 500px;
}  
.myLeft {
	text-align: left;
}
.myLarge {
	font-size: 150%;
}
.myBottom {
	border: 0px solid black;
	border-bottom: 2px solid black;
}
</style>
<body>
<div class="container myCenter">
	<img src="../images/marchmadness_logo.gif" style="width:325px;height:325px;">
<!-- 	<center><div id="datepicker"></div></center> -->
<br>
	<div id="wButtons" class="btn-group" data-toggle="buttons">
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w0" value="2016/03/18"/>3/16
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w1" value="2017/03/17"/>3/17
    </label>
    <br>
    <br>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w2" value="2017/03/18"/>3/18
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w3" value="2017/03/19"/>3/19
    </label>
    <br>
    <br>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w4" value="2017/03/23"/>3/23
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w5" value="2017/03/24"/>3/24
    </label>
    <br>
    <br>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w6" value="2017/03/25"/>3/25
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w7" value="2017/03/26"/>3/26
    </label>
    <br>
    <br>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w8" value="2017/04/01"/>4/01
    </label>
    <label class="btn btn-primary">
        <input type="radio" name="wRadio" id="w9" value="2017/04/03"/>4/03
    </label>
    
    </div>
	<br>
	<br>
	<div class="myLarge">
		<a href="PlayerNumbers.jsp">Players Numbers</a>
		<br>
		<a href="Winners.jsp">Winners</a>
		<br>
	</div>
	<br>
	<div id="result"></div>
</div>

<br>
</body>
</html>