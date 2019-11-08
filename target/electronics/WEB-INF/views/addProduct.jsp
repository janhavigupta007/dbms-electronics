<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>
<%@include file='/WEB-INF/views/navbar.jsp' %>
<div align="center">${msg}</div>	
	<section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4">Add Product</h3>
	<form:form action="/electronics/product/add" method="post" modelAttribute="product">
	<fieldset class="p-4">
		<form:label path="name">Product Name</form:label><br>
		<form:input type="text" path="name" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="brand">Brand</form:label><br>
		<form:input type="text" path="brand" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="price">Price</form:label><br>
		<form:input type="number" path="price" class="border p-3 w-100 my-2" required="true"/><br>
		
		<form:label path="category">Category</form:label><br>
		<form:input type="text" path="category" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="photo">Photo Url</form:label><br>
		<form:input type="text" path="photo" class="border p-3 w-100 my-2" maxlength="500"/><br>
	
		<input type="submit" value="Add Product" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/><br>
</fieldset>
	</form:form>
	
				<a href = "/electronics/product/addCategory">Add Category</a>
	
	</div>
	
            </div>
        </div>
    </div>
</section>
</body>
</html>