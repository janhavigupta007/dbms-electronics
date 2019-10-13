<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>

	<form:form action="/electronics/product/addCategory" method="post" modelAttribute="category">
	<table>
		
		<tr>
		<td><form:label path="name">Category Name</form:label></td>
		<td><form:input type="text" path="name" /></td></tr>
		
		<tr>
		<td><form:label path="description">Description</form:label></td>
		<td>
		<form:input type="text" path="description" /></td></tr>
		<tr>
	
		<tr><td><input type="submit" value="Add category" /></td></tr>
	</table>	
	</form:form>

	${msg}
		<a href="/electronics/product">View Products</a>
	
</body>
</html>