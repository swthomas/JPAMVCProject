<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Frugal</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
	
<link rel="stylesheet" type="text/css" href="about.css">
<link rel="shortcut icon" href="/pics/favicon.ico" type="image/x-icon"/>
</head>
<body>

	<form action="logout.do" method="POST">
					<div class="form-group text-center">
						<button type="submit" class="btn btn-default btn-block"><img src="pics/button_logout.jpg"></button>
					</div>
				</form>
				
				

	<div class="container">
		<div class="row text-center" id="h1">
			<h1><img src="pics/frugal.jpg"></h1>
			<!-- <p>Budgeting through amalgamation.</p> -->
		</div>
		<div class="row text-center">
			<p>Through acrimonious amalgamation, you and your partner can
				climb the mountain to financial freedom.</p>
			<hr>
			<img src="pics/about_us.jpg">
		</div>
		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
					<form class="" method="POST" action="login.do">

						<div class="form-group">
							<label for="vision" class="cols-sm-2 control-label"><img
								src="pics/our_vision.jpg"></label>
							<div class="cols-sm-10">
								<div class="input-group">
									<p>At Frugal we believe knowledge is power. Especially when
										it comes to your finances! Our goal is to keep couples
										informed and aware of their spending so they can make the best
										financial decisions for their future. Our site lets couples
										share their bills with each other online and establish a plan
										to tackle them together.</p>
					</form>
				</div>
				<br> <br> <br> <img src="pics/questions.jpg"> <br>
				<br>

				<p>
				<form action="mailto:willrobo@protonmail.com" method="POST"
					enctype="text/plain">
					Name:<br> <input type="text" name="name"><br>
					E-mail:<br> <input type="text" name="mail"><br>
					Comment:<br> <input type="text" name="comment" size="50"><br>
					<br> <input type="submit" value="Send">
				</form>



			</div>
		</div>
	</div>

	</form>
	</div>
	</div>
	</div>
	</div>


</body>
</html>