<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="eng">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>What Is Drink Responsibly?</title>
</head>
<body>
<c:import url="/WEB-INF/navigation.html"/>
<section class="container">

<div class="panel panel-warning">
<div class="panel-heading">
<h4>Welcome To Drink Responsibly!</h4>
</div>
<div class="panel-body">
	<p>This app is intended to give you a responsible drinking game plan for a night out 
	(or in) depending on your goal. It IS NOT meant to tell you how much you can drink before reaching the legal DUI limit,
	and assumes that if you plan to travel at all, you have a responsible designated driver.
	The information provided was made possible through careful research of 
	standard blood alcohol level charts based on gender and weight. While the 
	information was carefully calculated and the results aim for game plans 
	within reason, it is important to note that not everybody is the same.
	If you feel at all unsure on if you should have another drink, simply refrain. 
	This app is not a game to reach a high-score in!</p>
</div>
</div>

<div class="center-text">
	
	<div class="panel panel-info">
	<div class="panel-heading">
	<h4>In This App, One Drink Is The Equivalent Of Any One Of These</h4>
	</div>
	<div class="panel-body">
		<ul style="font-weight: bold;">
			<li>12 fl oz of beer</li>
			<li>5 fl oz of glass wine</li>
			<li>1.5 fl oz shot of liquor (80 proof)</li>
		</ul>
	<p>If you plan on drinking something with more alcohol content than the above 
	listed drinks, take that into account and drink even less. Be smart about it!</p>
	</div>
	</div>
	
	<div class="panel panel-danger">
	<div class="panel-heading"><h3>IMPORTANT: DO NOT DRINK AND DRIVE</h3></div>
	<div class="panel-body">
	Whether you have one sip or several drinks, always have a responsible designated driver if planning to travel at all.
	Keep yourself and others safe from harm, and out of trouble. Thanks!
	</div>
	</div>

	<hr>
	
<h2>Are You Ready To Drink Responsibly?</h2>
	<h1><span class="label label-primary" id="drop-shadow"><a href="form">Let's!</a></span></h1>
	
</div><!-- end text center -->

</section>
</body>
</html>