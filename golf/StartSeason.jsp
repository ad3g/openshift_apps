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
	$("#subbtnStartSeason").click(function(){
		//alert("subbtnStartSeason pressed within StartSeason.jsp");
		var str = "";
		var formatted = "xx";
// 		var date = "";
// 		date = $("#datetimepicker1").datetimepicker("getDate");
// 		formatted = moment(date).toString();
// 		var yourDate = moment(date).format('MM/DD/YYYY');      //date.format('L');
		   //formatted = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDay();
		yourDate = $("#mydate").val();
		str = $('#ddWeeks').find(":selected").text();
	    //alert("hi  " + str + "   " + formatted.toString() + "   " + yourDate);
	    $.post("StartSeasonSub.jsp",
	    	    {
	    	        xWk: yourDate,
	    	        xNumWks: str,
	     	    });    
	    window.location = "index.jsp";	
	});
	$("#canbtnStartSeason").click(function(){
		//alert("canbtnStartSeason pressed within StartSeason.jsp");
 		window.location = "index.jsp";	
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
			<h3>
				Start Season
			</h3>
			<h5>
				Select first week of the season
			</h5>
			<form role="form">
				<div class="form-group col-sm-2">
	                <div class='input-group date' id='datetimepicker1'>
	                    <input id="mydate" type='text' class="form-control" />
	                    <span class="input-group-addon">
	                        <span class="glyphicon glyphicon-calendar"></span>
	                    </span>
	                </div>
            	</div>
				<script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({format: 'MM/DD/YYYY',defaultDate: new Date()});
		            });
		        </script><br><br>				
			<h5>
				Select the number of weeks in the season
			</h5>
				<div class="dropdown">
					<td class="myWidth"><select id="ddWeeks" class="form-control ptsEarnedWidth">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16" selected="selected">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					</select></td>
            	</div>
				<br>
				<br>				
				<div class="form-group">
					<button type="button" id="subbtnStartSeason" class="btn btn-primary col-sm-1 ">
						Submit
					</button>
					<button type="button" id="canbtnStartSeason" class="btn btn-default col-sm-1 ">
						Cancel
					</button>
					<button type="button" id="mainbtn" class="btn btn-default col-sm-1 ">
						Main Page
					</button>
				</div>				
			</form>
		</div>
	</div>
</div>
</body>
</html>