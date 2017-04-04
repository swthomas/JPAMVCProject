<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="edit.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit and Add Users</title>
</head>
<body>
****************************** ${family.id } **********************************
	<div class="container">

		<header>
		<h1>Edit and Add User Forms</h1>

		</header>
		<section>
		<div id="container_demo">
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="mysuperscript.php" autocomplete="on">
						<h1>Edit User</h1>

						<!-- Edit User -->
						<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
							url="jdbc:mysql://localhost:3306/frugaldb" user="student"
							password="student" />

						<sql:query dataSource="${snapshot}" var="result">
SELECT m.fName, m.LName FROM member m WHERE m.familyId = 1;
</sql:query>

						<c:forEach var="row" items="${result.rows}">
							<tr>
								<td><label for="firstname" class="fname"><c:out
											value="${row.fName}" /></label></td>
								<td><label for="firstname" class="fname"><c:out
											value="${row.lName}" /></label></td>
								<td>
									<form action="edit.do">
										<p align="right">
											<button type="submit" name="Edit" value="${member.id}">
												Edit</button>
										</p>
								</td>
					</form>


					<td><p align="right">
						<form action="delete.do">
							<p align="right">
								<button type="submit" name="Delete" value="${member.id}">Delete</button>
							</p>

						</form>
						</p></td> <br>
					</tr>
					</c:forEach>

					<br /> <br />

					<!-- Add User -->


					<form action="createMembers.do" method="POST">

						<h1>Add User</h1>

						<label for="firstname" class="fname">First Name:</label><input
							class="form-control" type="text" name="fName"><br> <label
							for="lastname" class="lname">Last Name:</label><input
							class="form-control" type="text" name="lName"><br> <label
							for="username" class="username">User Name:</label><input
							class="form-control" type="text" name="username"><br>
						<p class="submit button">
							<input type="submit" value="submit" />
						</p>

					</form>
				</div>
			</div>
		</div>
</body>

</html>