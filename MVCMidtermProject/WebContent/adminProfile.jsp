<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator Account</title>
</head>
<body>


	<div class="container" id="list">
		<table class="table-hover table-responsive">
			<thead class="thead-inverse">
				<tr>
					<th>Name</th>
					<th>Amount</th>
					<th>Date Due</th>
					<th>Date Paid</th>
					<th colspan="3">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bill" items="${familyBills}">
					<tr>
						<td class="spacing">${bill.name}</td>
						<td class="spacing">$${bill.amount}</td>
						<td class="spacing">${bill.dateDue}</td>
						<td class="spacing">${bill.datePaid}</td>
						
						<td class="editButton"><form action="EditAdminBill.do"
								method="POST">
								<button type="submit" name="bill" value="${bill}"
									class="btn btn-xs btn-warning">edit</button>
							</form></td>
						<td class="deleteButton"><form action="DeleteBill.do"
								method="POST">
								<button type="submit" name="bill" value="${bill}"
									class="btn btn-xs btn-danger">delete</button>
							</form></td>
					</tr>
					<c:choose>
        				<form action="******.do" method="POST" name="bs">
							<c:when test="${empty user}">
		        				<td class="spacing"><input type="text" class="form-control" name="name"
								value="${bill.name}"></td>
								<td class="spacing"><input type="text" class="form-control" name="amount"
								value="${bill.amount}"></td>
								<td class="spacing"><input type="text" class="form-control" name="dateDue"
								value="${bill.dateDue}"></td>
								<td class="spacing">$<input type="text" class="form-control" name="datePaid"
								value="${bill.datePaid}"></td>
	   						</c:when>
        				</form>
					</c:choose>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container" id="list">
		<table class="table-hover table-responsive">
			<thead class="thead-inverse">
				<tr>
					<th>Name</th>
					<th>Amount</th>
					<th>Date Due</th>
					<th>Date Paid</th>
					<th colspan="3">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bill" items="${memberBills}">
					<tr>
						<td class="spacing">${bill.name}</td>
						<td class="spacing">$${bill.amount}</td>
						<td class="spacing">${bill.dateDue}</td>
						<td class="spacing">${bill.datePaid}</td>
						<td class="editButton"><form
								action="EditProduct.do?ID=${item.ID}" method="GET">
								<button type="submit" name="ID" value="${item.ID}"
									class="btn btn-xs btn-warning">edit</button>
							</form></td>
						<td class="deleteButton"><form action="DeleteProductData.do"
								method="POST">
								<button type="submit" name="ID" value="${item.ID}"
									class="btn btn-xs btn-danger">delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>