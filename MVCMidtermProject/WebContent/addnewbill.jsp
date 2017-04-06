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
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="********">
<link rel="shortcut icon" href="/pics/favicon.ico" type="image/x-icon"/>
</head>
<body>

	<form action="logout.do" method="POST">
					<div class="form-group text-center">
						<button type="submit" class="btn btn-default btn-block"><img src="pics/button_logout.jpg"></button>
					</div>
				</form>

<div class="container">
		<div class="text-center">
			<h2>Add a Bill</h2>
		</div>
		<form class="form-horizontal" action="CreateBill.do" method="POST">
			<div class="form-group">
				<label class="control-label col-sm-2">Add name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="billname">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Add amount:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="amount">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Add Due Date:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="dateDue">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>