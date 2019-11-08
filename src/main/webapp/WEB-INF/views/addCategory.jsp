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
                    <h3 class="bg-gray p-4">Add Category</h3>
	<form:form action="/electronics/product/addCategory" method="post" modelAttribute="category">
<fieldset class="p-4">		
		<form:label path="name">Category Name</form:label><br>
		<form:input type="text" path="name" class="border p-3 w-100 my-2" required="true" maxlength="40" /><br>
		
		<form:label path="description">Description</form:label><br>
		<form:input type="text" path="description" class="border p-3 w-100 my-2" required="true" maxlength="100"/><br>
		<input type="submit" value="Add category" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/><br>
</fieldset>
	</form:form>

	
		
	</div>
            </div>
        </div>
    </div>
</section>
</body>
</html>