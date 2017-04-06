<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
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
<link rel="stylesheet" type="text/css" href="form.css">
<link rel="shortcut icon" href="/pics/favicon.ico" type="image/x-icon" />
</head>
<body>

	<%-- <div class="container">
		<div class="text-center">
			<h2>Change User Details</h2>
		</div>
		<form class="form-horizontal" action="EditUser.do" method="POST">
		<input type="hidden" name="id" value="${member.id}">
			<div class="form-group">
				<label class="control-label col-sm-2">Edit username:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username"
						value="${member.username}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Change password:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="password"
						value="${member.password}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" value="Edit User Details" class="btn btn-default">Submit Changes</button>
				</div>
			</div>
		</form>
	</div> --%>
	
	<!-- ************* -->
	
	<div class="container">
		<div class="text-center">
			<h2>Edit Account</h2>
		</div>
		<div class="main-login main-center">
			<form class="" method="POST" action="EditUser.do">
				<input type="hidden" name="id" value="${member.id}">
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">Edit username</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="username" value="${member.username}"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="amount" class="cols-sm-2 control-label">Change
					password</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
								type="text" class="form-control" name="password" value="${member.password}"/>
						</div>
					</div>
				</div>
				<div class="form-group text-center">
					<button type="submit" class="btn btn-default btn-block">Submit Changes</button>
				</div>
			</form>
		</div>
	</div>
	

</body>
</html>