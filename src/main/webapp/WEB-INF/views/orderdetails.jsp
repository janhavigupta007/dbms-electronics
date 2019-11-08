<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>

  
</head>

<body class="body-wrapper">
<%@include file='/WEB-INF/views/navbar.jsp' %>

<section class="dashboard section">
	<!-- Container Start -->
	<div class="container">
		<!-- Row Start -->
		<div class="row">
			
					
			<div class="col-md-10 offset-md-1 col-lg-10 offset-lg-0">
				<!-- Recently Favorited -->
				<div class="widget dashboard-container my-adslist">
					<h3 class="widget-header">Order ${orderid}</h3>
					<table class="table table-responsive product-dashboard-table">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product</th>
								<th class="text-center">Price</th>
								<th class="text-center">Quantity</th>
								<th class="text-center">Sub-Total</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="total" value="0"></c:set>
							<c:forEach var="order" items="${orders }">
						<c:set var="total"
								value="${total + order.item.product.price * order.item.quantity }"></c:set>
							<tr>
								
								<td class="product-thumb">
									<img width="80px" height="auto" src="<c:url value="${order.item.product.photo }"/>" alt="Product"></td>
								<td class="product-details">
									<h3 class="title">${order.item.product.name }</h3>
									<span class="add-id"><strong>Brand:</strong> ${order.item.product.brand }</span>
									<span><strong>Price: </strong>${order.item.product.price } </span>
									<span class="location"><strong>Category:</strong>${order.item.product.category }</span>
								</td>
								<td class="product-category"><span class="categories">${order.item.product.price }</span></td>
								<td class="product-category"><span class="categories">${order.item.quantity }</span></td>
								<td class="product-category"><span class="categories">${order.item.product.price * order.item.quantity }</span></td>
								
							</tr>
							<tr>
							</c:forEach>
				<tr>
					<td align="center">Sum</td>
						<td>${total }</td>
				</tr>
								
								
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- Row End -->
	</div>
	<!-- Container End -->
</section>

  
</body>

</html>