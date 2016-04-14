<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#drink-result").animate({ opacity: 0 }, 0);
	$("#drink-result").animate({width: '75px', height: '65px', opacity: 1}, "slow");
	$("#enlarge").animate({fontSize: '60px'}, "slow");
});
</script>
<title>Drink Responsibly - Your Results</title>
</head>
<body>
<c:import url="/WEB-INF/navigation.html"/>
<section class="container">

<h3>According To Your Input And Goal:</h3>
<table class="table-bordered" style="width: 100%;">
<tr>
	<td>Gender</td> 
	<td><c:out value="${gender}"></c:out></td>
</tr>
<tr>
	<td>Weight</td> 
	<td><c:out value="${weight} lbs"></c:out></td>
</tr>
<tr>
	<td>Active Drink Time</td>
	<td><c:out value="${time} hour(s)"></c:out></td> 
</tr>
<tr>
	<td>Drink Goal</td> 
	<td>to not get <c:out value="${goal}"></c:out></td>
</tr>
</table>

<div class="center-text">
<h2>You Should Not Have More Than</h2>
<h1 id="enlarge"><span class="label label-info" id="drink-result"><c:out value="${drinks}"></c:out></span></h1>
<h4>Drink(s)</h4>
<h2>To Drink Responsibly!</h2>
<span class="label label-success" id="drop-shadow-green" style="font-family: 'Poiret One', cursive; font-size: 15px;"><a href="form">try again</a></span>
</div>

</section>
</body>
</html>