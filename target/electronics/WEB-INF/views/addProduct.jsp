<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>

	<form:form action="/electronics/product/add" method="post" modelAttribute="product">
	<table>
		
		<tr>
		<td><form:label path="name">Product Name</form:label></td>
		<td><form:input type="text" path="name" /></td></tr>
		
		<tr>
		<td><form:label path="brand">Brand</form:label></td>
		<td>
		<form:input type="text" path="brand" /></td></tr>
		<tr>
		<td><form:label path="price">Price</form:label></td>
		<td><form:input type="number" path="price" /></td></tr>
		
		<tr>
		<td><form:label path="category">Category</form:label></td>
		<td>
		<form:input type="text" path="category" /></td></tr>
	
		<tr><td><input type="submit" value="Add Product" /></td></tr>
	</table>	
	</form:form>

	${msg}
	<br>
	<a href="/electronics/product">View Products</a>
</body>
</html>