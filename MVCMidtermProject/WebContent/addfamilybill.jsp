<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Bill</title>
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

	<div class="container">
		<div class="text-center">
			<h2>Add a Bill</h2>
		</div>
		<div class="main-login main-center">
			<form class="" method="POST" action="CreateFamilyBill.do">
				<input type="hidden" class="form-control" name="familybillid"
					value="${family.id}">
				<div class="form-group">
					<label for="name" class="cols-sm-2 control-label">Add name</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-check-square fa"
								aria-hidden="true"></i></span> <input type="text" class="form-control"
								name="billname" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="amount" class="cols-sm-2 control-label">Add
						amount</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-money fa-lg" aria-hidden="true"></i></span> <input
								type="text" class="form-control" name="amount" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="dueDate" class="cols-sm-2 control-label">Add
						due date</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="fa fa-calendar fa-lg" aria-hidden="true"></i></span> <input
								type="text" class="form-control" name="dateDue"
								placeholder="YYYY-MM-DD" />
						</div>
					</div>
				</div>
				<div class="form-group text-center">
					<button type="submit" class="btn btn-default btn-block">Submit</button>
				</div>
			</form>
		</div>
	</div>


</body>
</html>