<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<h3>Orders Page</h3>
	<table border="1">
		<tr>
			<th>Order Id</th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Sub Total</th>
			<th>Invoice </th>
		</tr>
		<c:forEach var="order" items="${orders }">
			<tr>
			    <td>${order.orderid }</td>
				<td>${order.item.product.productid }</td>
				<td>${order.item.product.name }</td>
				<td>${order.item.product.brand }</td>
				<td>${order.item.product.price }</td>
				<td>${order.item.product.category }</td>
				<td>${order.item.quantity }</td>
				<td>${order.item.product.price * order.item.quantity }</td>
				<td><a href = '${pageContext.request.contextPath }/invoice/${order.orderid}'>View</a>
			</tr>
		</c:forEach>
	</table>
	<br>
${msg}
</body>
</html>