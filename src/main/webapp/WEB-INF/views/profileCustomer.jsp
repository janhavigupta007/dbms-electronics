<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>

	<form:form action="/electronics/profileCustomer" method="post" modelAttribute="customer">
	<table>
		
		<tr>
		<td><form:label path="name">Name</form:label></td>
		<td><form:input type="text" path="name" value="${customer.name}"/></td></tr>
		
		<tr>
		<td><form:label path="contact">Contact</form:label></td>
		<td>
		<form:input type="number" path="contact" value="${customer.contact}"/></td></tr>
		
		<tr>
		<td><form:label path="email">E-mail</form:label></td>
		<td><form:input type="text" path="email" value="${customer.email}" /></td></tr>
		
		<tr>
		<td><form:label path="houseno">House No.</form:label></td>
		<td>
		<form:input type="number" path="houseno" value="${customer.houseno}" /></td></tr>
		
		<tr>
		<td><form:label path="locality">Locality</form:label></td>
		<td>
		<form:input type="text" path="locality" value="${customer.locality}"/></td></tr>
		
		<tr>
		<td><form:label path="city">City</form:label></td>
		<td>
		<form:input type="text" path="city" value="${customer.city}"/></td></tr>
	
		 <tr><td><input type = "submit" value="Update"/></td></tr>
	</table>	
	</form:form>

	${msg}
</body>
</html>