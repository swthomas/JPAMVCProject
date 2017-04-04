<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Website CSS style -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css">
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="index.css">
<title>Admin</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>Frugal Sign Up.</h5>
				<form action="CreateFamily.do" method="POST">

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Family
							Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="name" id="name" placeholder="Enter your Name" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">User
							Name</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="email" id="email"
									placeholder="Enter your Email" />
								<form action="CreateFamilyAdmin.do" method="POST">
						<div class="form-group text-center">
							<button type="submit" class="btn btn-default btn-block">Sign
								Up</button>
				</form>

			</div>
		</div>


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
</body>
</html>