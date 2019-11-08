<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<html>

<head>
<style>
</style>
 

</head>

<body class="body-wrapper">
<%@include file='/WEB-INF/views/navbar.jsp' %>

<div  align="center">
    ${msg }
</div>
<section class="section-sm">
	<div class="container">
		
		<div class="row">
			
			<div class="col-md-9">
				
				<div class="product-grid-list">
					<div class="row mt-30">
					<c:forEach var="product" items="${products}">
						<div class="col-sm-12 col-lg-4 col-md-6">
							<!-- product card -->
<div class="product-item bg-light">
	<div class="card">
		<div class="thumb-content">
			<!-- <div class="price">$200</div> -->
			
				<img class="card-img-top img-fluid" src="<c:url value="${product.photo }" />" alt="Product">
			
		</div>
		<div class="card-body">
		    <h4 class="card-title">${product.name}</h4>
		    <ul class="list-inline product-meta">
		    	<li class="list-inline-item">
		    		<i class="fa fa-folder-open-o"></i>${product.category}
		    	</li>
		    	<li class="list-inline-item">
		    		<i class="fa fa-folder-open-o"></i>${product.brand }
		    	</li>
		    </ul>
		    <p class="card-text">Price: ${product.price }<br>
		    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
		    <a href="${pageContext.request.contextPath }/cart/buy/${product.productid}">Add To Cart</a>
					</sec:authorize><br>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<a href="${pageContext.request.contextPath }/proposal/${product.productid}">View Proposals</a>
					</sec:authorize></p>
		    
		</div>
	</div>
</div>
						</div>	
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>




 

</body>

</html>