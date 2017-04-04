<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>test</p>

		${member.fName}  ${member.lName}<br>
		${member.family.name}<br>
		
		<table>
		<tr><th>Account Id</th><th>Account</th><th>Total</th></tr>
		<tr><td>${member.account.id}</td><td>Bank Account</td>
		</table>

		<br>

		<div class="familyBillsDiv">
		<table>
		<tr><th>Bill ID</th><th>Bill Name</th><th>Amount</th></tr>
		<c:forEach items="${memberBills}" var="bill">
  			  <tr><td>${bill.id}</td><td>${bill.name}</td><td>${bill.amount}</td></tr>
		</c:forEach>
		</table>
		</div>

		<br>

		<div class="memberBillsDiv">
		<table>
		<tr><th>Bill ID</th><th>Bill Name</th><th>Amount</th><th>Bill Responsibility</th></tr>
		<c:forEach items="${familyBills}" var="bill">
  			  <tr><td>${bill.id}</td><td>${bill.name}</td><td>${bill.amount}</td></tr>
		</c:forEach>
		</table>
		</div>
		
		
	

</body>
</html>