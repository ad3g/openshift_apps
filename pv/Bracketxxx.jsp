<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Pig Valve</title>
<%@ page import="java.util.*"%>
<%@ page import="com.pv.*"%>
<jsp:include page="../masterinclude.jsp"></jsp:include>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css"></script>
<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.xyz {
	width: 300px;
	padding: 2px;
	margin: 2px;
}

.specWidth {
	width: 40px;
	padding: 0px;
	margin: 0px;
	align: center;
}

.specWidth2 {
	width: 350px;
	padding: 0px;
	margin: 0px;
	align: center;
}

.specWidth3 {
	width: 80px;
	padding: 0px;
	margin: 0px;
	align: center;
}
</style>
<script>
	$(document).ready(function() {
		$("#subbtn").click(function() {
			alert("subbtn pressed");
			$.post("EditGameSave.jsp", {
				data : $("#EditGame").serialize()
			// 	    	i1Team: $("#i1Team").val(),
			// 	    	t1s1: $("#t1s1").val(),
			}, function(data, status) {
				window.location.replace("Admin.jsp");
			});
		});
		$(function() {
			$("#accordion").accordion({
				heightStyle : "content"
			});
		});

	});
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<div id="accordion">
		<h3 align="center">Rules</h3>
		<div>
			<p>
			<UL type="circle">
				<LI>Once schedule is determined by NCAA the teams are entered
					into the system.</LI>
				<LI>All participating players names are entered into the
					system.</LI>
				<LI>The system then generates all brackets using random number
					generator for each team scores and player square assignments.</LI>
				<LI>At this point all team scores and player assignment has
					been finalized and it's time to watch the games and root for your
					team and numbers.</LI>
				<LI>As games are played the scores will be entered into the
					system. The system will automatically highlight the winners as well
					as accumulate the players winnings.</LI>
				<LI>Every effort will be made to keep this page up to date with
					scores but most likely will be updated as time permits.</LI>
			</UL>
			</p>
		</div>
		<h3 align="center">R+L Carriers New Orleans Bowl Sun Belt vs.
			Mountain West - Dec. 20 11 a.m. - ESPN - Louisiana-Lafayette vs.
			Nevada</h3>
		<div>
			<p>
			<table border="1" align="center" width="90%">
				<th>Team</th>
				<th>1st Quarter</th>
				<th>2nd Quarter</th>
				<th>3rd Quarter</th>
				<th>4th Quarter</th>
				<th>Final</th>
				<tr>
					<td>Louisiana-Lafayette</td>
					<td>10</td>
					<td>10</td>
					<td>10</td>
					<td>16</td>
					<td>16</td>
				</tr>
				<tr>
					<td>Nevada</td>
					<td>0</td>
					<td>3</td>
					<td>3</td>
					<td>3</td>
					<td>3</td>
				</tr>
				</tr>
			</table>
			</center>
			<BR>
			<table border="1" align="center" width="90%">
				<th rowspan="12"><FONT SIZE="5">Louisiana-Lafayette</th>
				<th colspan="12"><P ALIGN="CENTER">
						<FONT SIZE="5">Nevada</FONT>
					</P></th>
				<tr style="border: 6px solid black;" height=50px>
					<td align="center"></td>
					<td align="center">1</td>
					<td align="center">0</td>
					<td align="center">2</td>
					<td align="center">3</td>
					<td align="center">5</td>
					<td align="center">9</td>
					<td align="center">6</td>
					<td align="center">8</td>
					<td align="center">7</td>
					<td align="center">4</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">4</td>
					<td a width="7%" align="center">Dak</td>
					<td a width="7%" align="center">B. Botham</td>
					<td a width="7%" align="center">Rob E</td>
					<td a width="7%" align="center">E. Perrigo</td>
					<td a width="7%" align="center">Curtis</td>
					<td a width="7%" align="center">Batch</td>
					<td a width="7%" align="center">T. Hicks</td>
					<td a width="7%" align="center">Willie</td>
					<td a width="7%" align="center">Cindy M.</td>
					<td a width="7%" align="center">Chuck Norris</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">1</td>
					<td a width="7%" align="center">John G.</td>
					<td a width="7%" align="center">Tiffany</td>
					<td a width="7%" align="center">Curtis</td>
					<td a width="7%" align="center">Chuck Norris</td>
					<td a width="7%" align="center">Jeff</td>
					<td a width="7%" align="center">Joe Mawma</td>
					<td a width="7%" align="center">Fred</td>
					<td a width="7%" align="center">C. Perrigo</td>
					<td a width="7%" align="center">Buda</td>
					<td a width="7%" align="center">Dave Niemi</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">9</td>
					<td a width="7%" align="center">Cislo</td>
					<td a width="7%" align="center">Hon Sheriff</td>
					<td a width="7%" align="center">Marjorie</td>
					<td a width="7%" align="center">Jeremy Remy</td>
					<td a width="7%" align="center">Tageson</td>
					<td a width="7%" align="center">Batch</td>
					<td a width="7%" align="center">T. Harris</td>
					<td a width="7%" align="center">T. Hicks</td>
					<td a width="7%" align="center">John</td>
					<td a width="7%" align="center">FRAT</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">0</td>
					<td a width="7%" align="center">Tiffany</td>
					<td a width="7%" align="center">Fred</td>
					<td a width="7%" align="center">Albert</td>
					<td width="7%" align="center" bgcolor="yellow">Tim C</td>
					<td a width="7%" align="center">Cindy M.</td>
					<td a width="7%" align="center">John G.</td>
					<td a width="7%" align="center">Art</td>
					<td a width="7%" align="center">Paul W</td>
					<td a width="7%" align="center">Connie</td>
					<td a width="7%" align="center">Delecki</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">2</td>
					<td a width="7%" align="center">Duff</td>
					<td a width="7%" align="center">Annette</td>
					<td a width="7%" align="center">Dave Niemi</td>
					<td a width="7%" align="center">Andy G.</td>
					<td a width="7%" align="center">Jimmer</td>
					<td a width="7%" align="center">Joe Mawma</td>
					<td a width="7%" align="center">Delecki</td>
					<td a width="7%" align="center">Buda</td>
					<td a width="7%" align="center">Albert</td>
					<td a width="7%" align="center">Joe W</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">6</td>
					<td a width="7%" align="center">Art</td>
					<td a width="7%" align="center">Dak</td>
					<td a width="7%" align="center">Roger</td>
					<td width="7%" align="center" bgcolor="yellow">C. Baker</td>
					<td a width="7%" align="center">Andy G.</td>
					<td a width="7%" align="center">Rob E</td>
					<td a width="7%" align="center">Delecki</td>
					<td a width="7%" align="center">Buda/Jimmer</td>
					<td a width="7%" align="center">Ehren</td>
					<td a width="7%" align="center">Buda/Jimmer</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">7</td>
					<td a width="7%" align="center">M. Miller</td>
					<td a width="7%" align="center">C. Baker</td>
					<td a width="7%" align="center">Delecki</td>
					<td a width="7%" align="center">C. Perrigo</td>
					<td a width="7%" align="center">Dave L</td>
					<td a width="7%" align="center">Marjorie</td>
					<td a width="7%" align="center">Drew</td>
					<td a width="7%" align="center">T. Harris</td>
					<td a width="7%" align="center">Joe W</td>
					<td a width="7%" align="center">Drew</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">5</td>
					<td a width="7%" align="center">Smiley Bill</td>
					<td a width="7%" align="center">Tim C</td>
					<td a width="7%" align="center">Natalie</td>
					<td a width="7%" align="center">FRAT</td>
					<td a width="7%" align="center">Taso</td>
					<td a width="7%" align="center">Rob/Jeremy</td>
					<td a width="7%" align="center">B. Botham</td>
					<td a width="7%" align="center">Ehren</td>
					<td a width="7%" align="center">Hon Sheriff</td>
					<td a width="7%" align="center">Roger</td>
				</tr>
				<tr style="border: 6px solid black;" height=50px>
					<td width="7%" align="center">3</td>
					<td a width="7%" align="center">Duff</td>
					<td a width="7%" align="center">Cislo</td>
					<td a width="7%" align="center">E. Perrigo</td>
					<td a width="7%" align="center">Paul W</td>
					<td a width="7%" align="center">Jimmer</td>
					<td a width="7%" align="center">Connie</td>
					<td a width="7%" align="center">Luckymanincalif</td>
					<td a width="7%" align="center">M. Miller</td>
					<td a width="7%" align="center">Natalie</td>
					<td a width="7%" align="center">Dave L</td>
				</tr>
				<tr>
					<td width="7%" align="center">8</td>
					<td a width="7%" align="center">Luckymanincalif</td>
					<td a width="7%" align="center">Jeff</td>
					<td a width="7%" align="center">Taso</td>
					<td a width="7%" align="center">Tageson</td>
					<td a width="7%" align="center">Annette</td>
					<td a width="7%" align="center">Smiley Bill</td>
					<td a width="7%" align="center">Rob/Jeremy</td>
					<td a width="7%" align="center">Jeremy Remy</td>
					<td a width="7%" align="center">Willie</td>
					<td a width="7%" align="center">John</td>
				</tr>
			</table>
			<P ALIGN="CENTER">
				<FONT SIZE="5">Game has 2 payouts of $50, for the 2nd Quarter
					and Final Scores</FONT>
			</P>
			<P ALIGN="CENTER">
				<FONT SIZE="5">Scores have been entered, Winning Player(s)
					have been highlighted in Yellow</FONT>
			</P>
			<P ALIGN="CENTER">
				<FONT SIZE="5">To See Each Player(s) Winnings See The Last
					Section of the Page</FONT>
			</P>
			</p>
		</div>
	</div>
</body>
</html>
