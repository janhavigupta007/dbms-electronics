<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<h3>Pending proposals for product ${productid}</h3>
	<table border="1">
		<tr>
			<th>Partner UserId</th>
			<th>Price</th>
			<th>Accept</th>
		</tr>
		<c:forEach var="proposal" items="${proposals }">
			<tr>
				<td>${proposal.partner }</td>
				<td>${proposal.price }</td>
				<td align="center">
				<a href="${pageContext.request.contextPath }/proposal/${productid}/${proposal.partner}">Accept</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	${msg }
</body>
</html>