<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>All Users in System</h2>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${list}" var="u">
		<tr>
			<td>${u.id}</td>
			<td>${u.name}</td>
			<td>${u.email}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>