<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>

	<form:form action="/electronics/register" method="post" modelAttribute="user">
	<table>
		
		<tr>
		<td><form:label path="username">UserId</form:label></td>
		<td><form:input type="text" path="username" /></td></tr>
		
		<tr>
		<td><form:label path="password">Password</form:label></td>
		<td>
		<form:input type="password" path="password" /></td></tr>
		
		<tr>
		<td><form:label path="name">Name</form:label></td>
		<td><form:input type="text" path="name" /></td></tr>
		
		<tr>
		<td><form:label path="contact">Contact</form:label></td>
		<td>
		<form:input type="number" path="contact" /></td></tr>
		
		<tr>
		<td><form:label path="email">Email</form:label></td>
		<td>
		<form:input type="text" path="email" /></td></tr>
	
		 <tr><td><input type = "submit" name = "Customer" value="Register as Customer"/></td></tr>
     <tr><td><input type = "submit" name = "Partner" value="Register as Partner"/></td></tr> 
	</table>	
	</form:form>

	${msg}
</body>
</html>