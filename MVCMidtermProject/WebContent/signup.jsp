<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
<title>Sign Up</title>
</head>
<body>

	<form action="logout.do" method="POST">
					<div class="form-group text-center">
						<button type="submit" class="btn btn-default btn-block"><img src="pics/button_logout.jpg"></button>
					</div>
				</form>

		<div class="container">
			<div class="row main">
				<div class="main-login main-center">
					<form class="" method="POST" action="CreateFamily.do">

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Family
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="name" 
										placeholder="Enter your family name" />
								</div>
							</div>
						</div>

					<!-- 	<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">User
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-user fa-lg" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="username" id="username"
										placeholder="Enter your username" />
								</div>
							</div>
						</div> -->
						<div class="text-center">
							<span id="badlogin"> <c:if test="${! empty badLogin}">
									${badLogin}
								</c:if>
							</span>
						</div>
					<!-- </form>
					<form action="CreateFamily.do" method="POST">
						<div class="form-group text-center"> -->
							<button type="submit" class="btn btn-default btn-block">Sign
								Up</button>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>