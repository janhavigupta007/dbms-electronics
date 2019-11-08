<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>

  
</head>

<body class="body-wrapper">
<%@include file='/WEB-INF/views/navbar.jsp' %>
<div  align="center">
    ${msg }
</div>
<section class="dashboard section">
	<!-- Container Start -->
	<div class="container">
		<!-- Row Start -->
		<div class="row">
			
					
			<div class="col-md-10 offset-md-1 col-lg-10 offset-lg-0">
				<!-- Recently Favorited -->
				<div class="widget dashboard-container my-adslist">
					<h3 class="widget-header">Cart</h3>
					<table class="table table-responsive product-dashboard-table">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product</th>
								<th class="text-center">Quantity</th>
								<th class="text-center">Sub-Total</th>
								<th class="text-center">Action</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="total" value="0"></c:set>
							<c:forEach var="item" items="${cart }">
						<c:set var="total"
								value="${total + item.product.price * item.quantity }"></c:set>
							<tr>
								
								<td class="product-thumb">
									<img width="80px" height="auto" src="<c:url value="${item.product.photo }"/>" alt="Product"></td>
								<td class="product-details">
									<h3 class="title">${item.product.name }</h3>
									<span class="add-id"><strong>Brand:</strong> ${item.product.brand }</span>
									<span><strong>Price: </strong>${item.product.price } </span>
									<span class="location"><strong>Category:</strong>${item.product.category }</span>
								</td>
								<td class="product-category"><span class="categories">${item.quantity }</span></td>
								<td class="product-category"><span class="categories">${item.product.price * item.quantity }</span></td>
								<td class="action" data-title="Action">
									<div class="">
										<ul class="list-inline justify-content-center">
											
											<li class="list-inline-item">
												<a class="delete" href="${pageContext.request.contextPath }/cart/delete/${item.product.productid}">
													<i class="fa fa-trash"></i>
												</a>
											</li>
										</ul>
									</div>
								</td>
							</tr>
							<tr>
							</c:forEach>
				<tr>
					<td align="center">Sum</td>
						<td>${total }</td>
				</tr>
								
								
						</tbody>
					</table>
					<br>
	
	<br>
	<a href="${pageContext.request.contextPath }/product">Continue
		Shopping</a>
	<br>
	<a href="/electronics/order/submit">Checkout</a>
				</div>
			</div>
		</div>
		<!-- Row End -->
	</div>
	<!-- Container End -->
</section>

  
</body>

</html>