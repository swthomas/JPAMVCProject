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
<link rel="stylesheet" type="text/css" href="*****">
</head>
<body>

	<%-- <div class="container-fluid">
		
			<c:forEach items="${memberBills}" var="bill">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6" id="beerinfo">
							<strong>Bill:</strong> ${bill.name}<br> 
							<strong>Amount:</strong> $${bill.amount}<br> 
							<strong>Date due:</strong> ${bill.dateDue}<br> 
							<strong>Date paid:</strong> ${bill.datePaid}<br> <br>
					</div>
					<div class="col-sm-3"></div>
				</div> --%>
				<%-- <div class="row text-center">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<form action="ViewBeer.do" method="GET">
							<button type="submit" name="name" value="${beer.name}"
								class="btn btn-primary">Select Beer</button>
						</form>
					</div>
					<div class="col-sm-2">
						<form action="DeleteBeer.do" method="POST">
							<button type="submit" name="name" value="${beer.name}"								
							class="btn btn-danger">Delete Beer</button>
						</form>
					</div>
					<div class="col-sm-4"></div>
				</div> --%>
			<%-- </c:forEach>
	</div> --%>
	
	<div class="container" id="inventoryList">
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
							<td class="viewButton"><form
									action="ViewProduct.do?ID=${item.ID}" method="GET">
									<button type="submit" name="ID" value="${item.ID}"
										class="btn btn-xs btn-primary">view</button>
								</form></td>
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