<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>Drink Responsibly</title>
<script type="text/javascript">
function isNum(press){
	var charCode = (press.which) ? press.which : event.keyCode; 
	if(charCode < 48 || charCode > 57){
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
<c:import url="/WEB-INF/navigation.html"/>
<section class="container">
<form class="form-control" method="post" action="calculate-drink-amount" id="drop-shadow-primary">

<div class="form-group row">
<label class="col-sm-2 form-control-label">Gender:</label>
<div class="col-sm-10">
<select name="gender">
	<option value="male">Male</option>
	<option value="female">Female</option>
</select>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 form-control-label">Weight:</label>
<div class="col-sm-10">
<input type="text" name="weight" placeholder="enter weight here" onkeypress="return isNum(event)" required>
<br>
lbs <input type="radio" name="unit" value="lbs" checked/>
kg <input type="radio" name="unit" value="kg" />
</div>
</div>




<div class="form-group row">
<label class="col-sm-2 form-control-label">Active Drinking Time:</label>
<div class="col-sm-10">
<select name="drink-time">
	<option value="0">Half an hour  or less</option>
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
	<option value="12">12+</option>
</select>
</div>
</div>

<div class="form-group row">
<label class="col-sm-2 form-control-label">Your Goal Tonight:</label>
<div class="col-sm-10">
<select name="goal">
	<option value="drunk">To Not Get Drunk</option>
	<option value="sick">To Not Get Sick</option>
</select>
</div>
</div>

<input type="submit" value="Calculate Drink Amount" name="submit">
</form>
</section>
</body>
</html>