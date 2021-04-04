<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Response</title>
<link rel = "stylesheet" type = "text/css" href = "home.css">
</head>
<body>
		<div class="topnav">
  			<a class="active" href="HomePage.html">Home</a>
  			
  			<a href="About.html">About</a>
  			<a href="Contact.html">Contact</a>
  			<a href = "AdminLogin.html">Admin Login</a>
		</div>
		<div class = "welcome">
			<p>Welcome ${param.firstname} ${param.lastname} to our gym.</p>
		</div>
		
					<img class = "image" alt="Fitness and Muscle Studio" src="Photo1.jpg">
		
		
		<div class = "second">
				<h1 id = "t2align"> Our Programs: </h1>
				<ul>
					<li>Weight Training</li>
					<li >Cardio</li>
					<li>Fat Loss</li>
					<li>Weight Gain</li>
					<li>Supplements and Diets</li>
				</ul>
				<p>If you want to achieve your fitness goal then book a free demo by <a href = "BookDemo.html"> clicking here</a></p>
			</div>
			
				<footer>
  		<p>Author: Prabhat Kumar</p>
  		<a href="https://www.linkedin.com/in/prabhat-kumar-17257a146?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BBGAYwQi%2BT92mgxde0op4qw%3D%3D">Contact me.</a>
	</footer>
</body>
</html>