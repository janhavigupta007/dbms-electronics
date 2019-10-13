<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>

	<form:form action="/electronics/profilePartner" method="post" modelAttribute="partner">
	<table>
		<tr>
		<td><form:label path="firm">Firm</form:label></td>
		<td><form:input type="text" path="firm" value="${partner.firm}"/></td></tr>
		
		<tr>
		<td><form:label path="name">Agent Name</form:label></td>
		<td><form:input type="text" path="name" value="${partner.name}"/></td></tr>
		
		<tr>
		<td><form:label path="contact">Contact</form:label></td>
		<td>
		<form:input type="number" path="contact" value="${partner.contact}"/></td></tr>
		
		<tr>
		<td><form:label path="email">E-mail</form:label></td>
		<td><form:input type="text" path="email" value="${partner.email}" /></td></tr>
		
		 <tr><td><input type = "submit" value="Update"/></td></tr>
	</table>	
	</form:form>

	${msg}
</body>
</html>