<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Frugal Account</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="profile.css">
</head>
<body>

		</div>
	
			<div class="container" id="accounts">
			<h2>Family Frugal Account</h2>
			$${member.account.frugalSum}
			<h2>Personal Account</h2>
			$${member.account.bankAccount}
			<br><br>
		</div>

	<div class="container" id="userbills">
	<h2>Family Bills</h2>
		<table class="table-hover table-responsive">
			<thead class="thead-inverse">
				<tr>
					<th>Name</th>
					<th>Amount</th>
					<th>Date Due</th>
					<th>Date Paid</th>
					<th colspan="3">Percent</th>
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="bill" items="${member.family.bills}">
					<tr>
						<c:forEach var="br" items="${bill.billResponsibilities}">
					 <c:if test="${br.member.id == member.id}">
							<td class="spacing">${bill.name}</td>
							<td class="spacing">$${bill.amount}</td>
							<td class="spacing">${bill.dateDue}</td>
							<td class="spacing">${bill.datePaid}</td>
							<td class="spacing">${br.percent}%</td>
    					</c:if> 
    					</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
		<div class="container" id="memberbills">
		<h2>Your Bills</h2>
		<table class="table-hover table-responsive">
			<thead class="thead-inverse">
				<tr>
					<th>Name</th>
					<th>Amount</th>
					<th>Date Due</th>
					<th>Date Paid</th>
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="bill" items="${member.bills}">
							<tr>
							<td class="spacing">${bill.name}</td>
							<td class="spacing">$${bill.amount}</td>
							<td class="spacing">${bill.dateDue}</td>
							<td class="spacing">${bill.datePaid}</td>
							</tr>
					<tr>

						<td class="editbutton"><form action="EditBillForm.do"
								method="POST">
								<button type="submit" name="id" value="${bill.id}"
									class="btn btn-xs btn-warning">edit</button>
							</form></td>
						<td class="deleteButton"><form action="DeleteBill.do"
								method="POST">
								<button type="submit" name="id" value="${bill.id}"
									class="btn btn-xs btn-danger">delete</button>
							</form></td>
						<td class="paidButton"><form action="PayBill.do"
								method="POST">
								<button type="submit" name="id" value="${bill.id}"
									class="btn btn-xs btn-danger">pay</button>
							</form></td>
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="AddBillForm.do" method="POST">
								<button type="submit" name="id" class="btn btn-xs btn-danger">add bill</button>
							</form>


</body>
</html>