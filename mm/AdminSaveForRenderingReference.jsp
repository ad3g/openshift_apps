<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang='en'>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>March Madness Admin</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
.xyz {
    width: 325px;
    padding: 10px;
    margin: 0px;
}
</style>
<script>
$(document).ready(function(){
	$("#subbtn").click(function(){
		alert("subbtn pressed");
	    $.post("AdminSend.jsp",
	    {
	        name: "Donald Duck",
	        city: "Duckburg"
	    },
	    function(data, status){
	    	$("#result").html(data);
	        alert("Data: " + data + "\nStatus: " + status);
	        
	    });
	});
});
</script>
</head>
<body>
<br>
<br>
<div class="xyz">
<table class="table" frame="box">
	<thead>
		<tr bgcolor="#CBDCFD">
		  <th>Round of 64
		  <th>1</th>
		  <th>2</th>
		  <th></th>
		  <th>Final</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		  <td align="left" style="white-space:nowrap;"><img src="../images/mm_teams/KennesawSt.png" height="25px" width="25px">Team 1 (1)</td>
		  <td>30</td>
		  <td>33</td>
		  <td>0</td>
		  <td><b>63</b></td>
		</tr>
		<tr>
		  <td align="left" style="white-space:nowrap;"><img src="../images/mm_teams/KennesawSt.png" height="25px" width="25px">Team 1 (16)</td>
		  <td>31</td>
		  <td>39</td>
		  <td>12</td>
		  <td><b>70</b></td>
		</tr>
		<tr>
		  <td colspan="5" align="center" width="50%"><b>Winners: Player Name(0-1) / Player Name(3-0)</b></td>
		</tr>
	</tbody>
</table>
</div>
<br>
<br>
<br>
<div class="xyz">
<table class="table" frame="box">
	<thead>
		<tr bgcolor="#CBDCFD">
		  <th>Round of 64
		  <th>1</th>
		  <th>2</th>
		  <th></th>
		  <th>Final</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		  <td align="left" style="white-space:nowrap;"><img src="../images/mm_teams/KennesawSt.png" height="25px" width="25px">Team 1 (1)</td>
		  <td><input type="text" class="form-control" id="i1First"></td>
		  <td><input type="text" class="form-control" id="i1Second"></td>
		  <td><input type="text" class="form-control" id="i1OT"></td>
		  <td><input type="text" class="form-control" id="i1Final"></td>
		</tr>
		<tr>
		  <td align="left" style="white-space:nowrap;"><img src="../images/mm_teams/KennesawSt.png" height="25px" width="25px">Team 1 (16)</td>
		  <td><input type="text" class="form-control" id="i2First"></td>
		  <td><input type="text" class="form-control" id="i2Second"></td>
		  <td><input type="text" class="form-control" id="i2OT"></td>
		  <td><input type="text" class="form-control" id="i2Final"></td>
		</tr>
		<tr>
<!-- 			<td colspan="5"><button>Submit</button></td> -->
			<td colspan="5"><button type="button" id="subbtn" class="btn btn-submit">Submit</button></td>
		</tr>
	</tbody>
</table>
</div>
<div id="result"></div>
</body>
</html>
