<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Dashboard</title>
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
<link rel="shortcut icon" href="/pics/favicon.ico" type="image/x-icon"/>
</head>
<body>

	<form action="logout.do" method="POST">
					<div class="form-group text-center">
						<button type="submit" class="btn btn-default btn-block"><img src="pics/button_logout.jpg"></button>
					</div>
				</form>

<!-- THIS PAGE IS A STRETCH GOAL -->

	<div class="container">
		<div class="text-center">
			<h2>Admin Dashboard</h2>
		</div>
		<form class="form-horizontal" action="EditMemberDetails.do" method="POST">
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
	</div>
	
	<div class="container" id="memberbills">
		<h2>Members in your family:</h2>
		<table class="table-hover table-responsive">
			<thead class="thead-inverse">
				<tr>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="member" items="${memberlist}">
							<tr>
							<td class="spacing">${member.username}</td>
							<td class="spacing">${member.fName}</td>
							<td class="spacing">${member.lName}</td>
							</tr>
					<tr>

						<td class="editbutton"><form action="EditUser.do"
								method="POST">
								<button type="submit" name="id" value="${member.id}"
									class="btn btn-xs btn-warning">edit</button>
							</form></td>
						<td class="deleteButton"><form action="DeleteUser.do"
								method="POST">
								<button type="submit" name="id" value="${member.id}"
									class="btn btn-xs btn-danger">delete</button>
							</form></td>
							
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

</body>
</html>