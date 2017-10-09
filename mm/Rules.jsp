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
</head>
<body>
<br>
<br>
<br>
<div class="container myCenter">
	<img src="../images/marchmadness_logo.gif" style="width:325px;height:325px;">
<br>
<div class="myLarge">
	<a href="PlayerNumbers.jsp">Players Numbers</a>
	<br>
	<a href="Winners.jsp">Winners</a>
	<br>
	<a href="Scores.jsp">Scores</a>
	<br>
</div>
<h3>Rules</h3>
<div>
	<p>
	<ul>
		<B>Here's how it works:</B>
		<li>It's similar to football squares, except the numbers you have for this pool are good for both the halftime and final scores of EVERY game in the March Madness Tournament. That means there are 2 payouts for each game. There are 63 games in the tournament (excluding play-in games) providing 126 chances for your numbers to hit one or more times. The payouts increase with each round of the tournament.</li>
		<br>
		<B>The buy-in:</B>
		<li>The cost per square is $100. Total pool is $10,000.</li>
		<br>
		<B>The payout schedule:</B>
		<br>
		<table width="623" cellpadding="7" cellspacing="0">
				<colgroup><col width="90">
				<col width="90">
				<col width="90">
				<col width="90">
				<col width="90">
				<col width="89">
				</colgroup><tbody><tr valign="top">
					<td width="90" style="border-top: none; border-bottom: 1px solid #00000a; border-left: none; border-right: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0in; padding-right: 0.08in">
						<p><br>
						</p>
					</td>
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center" style="margin-bottom: 0in"><b># of </b>
						</p>
						<p align="center"><b>Games</b></p>
					</td>
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center"><b>Chances to Win</b></p>
					</td>
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center"><b>Each Halftime Score Pays</b></p>
					</td>
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center"><b>Each Final Score Pays</b></p>
					</td>
					<td width="89" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center" style="margin-bottom: 0in"><b>Total $ </b>
						</p>
						<p align="center"><b>Paid Out</b></p>
					</td>
				</tr>
				<tr valign="top">
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p><b>First Round</b></p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">32</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">64</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$15</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$30</p>
					</td>
					<td width="89" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$1,440</p>
					</td>
				</tr>
				<tr valign="top">
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p><b>Second Round</b></p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">16</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">32</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$30</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$60</p>
					</td>
					<td width="89" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$1,440</p>
					</td>
				</tr>
				<tr valign="top">
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p><b>Sweet 16</b></p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">8</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">16</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$60</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$120</p>
					</td>
					<td width="89" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$1,440</p>
					</td>
				</tr>
				<tr valign="top">
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p><b>Elite 8</b></p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">4</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">8</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$120</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$240</p>
					</td>
					<td width="89" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$1,440</p>
					</td>
				</tr>
				<tr valign="top">
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p><b>Final 4</b></p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">2</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">4</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$240</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$480</p>
					</td>
					<td width="89" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$1,440</p>
					</td>
				</tr>
				<tr valign="top">
					<td width="90" bgcolor="#bdd6ee" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p><b>Championship</b></p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">1</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">2</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$800</p>
					</td>
					<td width="90" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">    $1,500</p>
					</td>
					<td width="89" style="border: 1px solid #00000a; padding-top: 0in; padding-bottom: 0in; padding-left: 0.08in; padding-right: 0.08in">
						<p align="center">$2,300</p>
					</td>
				</tr>
			</tbody></table>
		<br>
		<B>Matching Numbers (Matchies)</B>
		<li>In addition to the above payouts, if you have two of the same number (1,1 or 2,2) then you will get $50.</li>
		<br>
		<B>The details:</B>
		<li>You can buy as many squares as you like. Once all 100 squares have been bought and the names placed in all the squares, the numbers will be randomly drawn. Once all of the numbers are in place, the squares will be distributed. The numbers on the top row will go to the winning team, and the numbers on the left side will go to the losing team. For halftime, the numbers go to the teams winning and losing as of halftime. If the score is tied at halftime, the payout goes to the person that has matching numbers for the winning and losing teams.</li>
		<li>Possibly the best part of this pool is that you don't need to be a college hoops expert. There is no need to do any research (or coin flips) to fill out a bracket, which will probably bust after the first couple of rounds. In the squares pool, each and every game presents an opportunity to win some $ throughout the ENTIRE tournament.</li>
		<B>FAILURE TO PAY FOR YOUR SQUARE(S) IN FULL BY SUNDAY, MARCH 15 WILL RESULT IN YOUR SQUARE BEING SOLD TO SOMEONE ON THE WAITING LIST.</B>
	</ul>
	</p>
</div>
</body>
</html>