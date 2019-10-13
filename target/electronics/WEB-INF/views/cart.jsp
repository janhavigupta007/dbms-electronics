<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>

	<h3>Cart Page</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Sub Total</th>
			<th>Remove</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${cart }">
			<c:set var="total"
				value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
				<td>${item.product.productid }</td>
				<td>${item.product.name }</td>
				<td>${item.product.brand }</td>
				<td>${item.product.price }</td>
				<td>${item.product.category }</td>
				<td>${item.quantity }</td>
				<td>${item.product.price * item.quantity }</td>
				<td><a href="${pageContext.request.contextPath }/cart/delete/${item.product.productid}">Remove</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">Sum</td>
			<td>${total }</td>
		</tr>
	</table>
	<br>
	${msg }
	<br>
	<a href="${pageContext.request.contextPath }/product">Continue
		Shopping</a>
	<br>
	<a href="/electronics/checkout">Checkout</a>
</body>
</html>