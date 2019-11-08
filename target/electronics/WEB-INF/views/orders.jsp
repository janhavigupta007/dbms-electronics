<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>

  
</head>

<body class="body-wrapper">
<%@include file='/WEB-INF/views/navbar.jsp' %>
<div align="center">${msg }</div>
<section class="dashboard section">
	<!-- Container Start -->
	<div class="container">
		<!-- Row Start -->
		<div class="row">
			
					
			<div class="col-md-10 offset-md-1 col-lg-10 offset-lg-0">
				<!-- Recently Favorited -->
				<div class="widget dashboard-container my-adslist">
					<h3 class="widget-header">Orders</h3>
					<table class="table table-responsive product-dashboard-table">
						<thead>
							<tr>
								<th class="text-center">Order Id</th>
								<th class="text-center">Date of creation</th>
								<th class="text-center">Payment Method</th>
								<th class="text-center">Order Details</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${invoice }">
							<tr>
								<td class="product-category"><span class="categories">${item.invoiceid }</span></td>
								<td class="product-category"><span class="categories">${item.dateofissue }</span></td>
								<td class="product-category"><span class="categories">${item.paymentmethod }</span></td>
								<td class="product-category"><span class="categories"><a href="/electronics/orderdetails/${item.invoiceid }">>>View</a></span></td>
							</tr>
							<tr>
							</c:forEach>
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