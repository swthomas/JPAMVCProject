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


	<div class="container" id="familybills">
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
					<tr>

						<td class="editbutton"><form action="EditBill.do" method="POST">
								<button type="submit" name="id" value="${bill.id}" class="btn btn-xs btn-warning">edit</button>
							</form></td>
							
						<td class="deleteButton"><form action="DeleteAdminBill.do" method="POST">
								<button type="submit" name="id" value="${bill.id}" class="btn btn-xs btn-danger">delete</button>
							</form></td>
							
						<td class="paidButton"><form action="PayBill.do" method="POST">
								<button type="submit" name="id" value="${bill.id}" class="btn btn-xs btn-danger">paid</button>
							</form></td>
							

					</tr>
				</c:forEach>

			</tbody>
		</table>
							<form action="AddFamilyBillForm.do" method="POST">
								<button type="submit" name="addid" class="btn btn-xs btn-danger">add bill</button>
							</form>
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

						<td class="editbutton"><form action="EditBill.do" method="POST">
								<button type="submit" name="id" value="${bill.id}" class="btn btn-xs btn-warning">edit</button>
							</form></td>
							
						<td class="deleteButton"><form action="DeleteBill.do" method="POST">
								<button type="submit" name="deleteid" value="${bill.id}" class="btn btn-xs btn-danger">delete</button>
							</form></td>
							
						<td class="paidButton"><form action="PayBill.do" method="POST">
								<button type="submit" name="id" value="${bill.id}" class="btn btn-xs btn-danger">paid</button>
							</form></td>
							

					</tr>
				</c:forEach>
			</tbody>
		</table>
						<form action="AddBillForm.do" method="POST">
							<button type="submit" name="id" class="btn btn-xs btn-danger">add bill</button>
						</form>
		
		<div class="account">
			<h2>Family Frugal Account</h2>
			$${member.account.frugalSum}
			<h2>Personal Account</h2>
			$${member.account.bankAccount}
			<br><br>
		</div>


		<td class="logoutButton">
			<form action="logout.do" method="POST">
				<button type="submit" class="btn btn-xs btn-danger">Logout</button>
			</form>
		</td>
	</div>




</body>
</html>