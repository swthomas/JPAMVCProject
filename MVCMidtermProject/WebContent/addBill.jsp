<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Bill</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="****">
</head>
<body>

	<div class="container">
		<div class="text-center">
			<h2>Add Bill</h2>
		</div>
		<form class="form-horizontal" action="CreateFamilyBill.do" method="POST">

			<div class="form-group">
				<label class="control-label col-sm-2">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Amount:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="amount">
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Date Due:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="dateDue">
				</div>
			</div>

			<input type="hidden" name="member" value="${member}">
			<input type="hidden" name="paid" value="false">

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" value="Add Bill" class="btn btn-default">Add Bill</button>
				</div>
			</div>

		</form>
	</div>

</body>
</html>