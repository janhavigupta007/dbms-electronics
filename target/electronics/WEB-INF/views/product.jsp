<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
<style>
/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  border: 3px solid #f1f1f1;
}


</style>
</head>
<body>

	<h3>Products Page</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Category</th>
			<sec:authorize access="hasRole('ROLE_CUSTOMER')">
			<th>Buy</th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th>View Proposal</th>
			</sec:authorize>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.productid }</td>
				<td>${product.name }</td>
				<td>${product.brand }</td>
				<td>${product.price }</td>
				<td>${product.category }</td>
				<sec:authorize access="hasRole('ROLE_CUSTOMER')">
				<td align="center">
					<a href="${pageContext.request.contextPath }/cart/buy/${product.productid}">Buy Now</a></td>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td align="center">
					<a href="${pageContext.request.contextPath }/proposal/${product.productid}">View</a></td>
					</sec:authorize>
			</tr>
		</c:forEach>
	</table>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<br>
	<a href="/electronics/product/add">Add Product</a>
	<br>
	<a href="/electronics/product/addCategory">Add Category</a>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_CUSTOMER')">
	<br>
	<a href="/electronics/cart">View Cart</a>
	<br>
	${msg}
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_PARTNER')">
	<br>
	<button class="open-button" onclick="openForm()">Add Proposal</button>
<div class="form-popup" id="myForm">
	 <form action='/electronics/product/proposal' method='post'>
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		Product id:<br>
  		<input type="number" name="productid"><br>
  		Price:<br>
  		<input type="number" name="price">
  		<input type = "submit" value="Add"/>
	<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
	</form> 
		</div>
	${mesg}
	</sec:authorize>
	<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
</body>
</html>