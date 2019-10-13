<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<h3>Feedback</h3>
	<table border="1">
		<tr>
			<th>User</th>
			<th>Rating</th>
			<th>Description</th>
		</tr>
		<c:forEach var="feedback" items="${feedbacks }">
			<tr>
			<td>${feedback.username }</td>
				<td>${feedback.rating }</td>
				<td>${feedback.description }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>