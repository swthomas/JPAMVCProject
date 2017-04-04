
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
</head>
<body>
asdfasdfasdfa
<%-- <p>${member.id}</p>
 --%><c:forEach items="${members}" var="member">

   <p>${member.id}</p>
   <p>${member.username}</p>
   <p>${member.fName}</p>
   <p>${member.lName}</p>
</c:forEach>
</body>
</html>