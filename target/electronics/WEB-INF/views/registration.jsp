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
                    <h3 class="bg-gray p-4">Register</h3>
	<form:form action="/electronics/register" method="post" modelAttribute="user">
	<fieldset class="p-4">
		
		<form:label path="username">UserId</form:label><br>
		<form:input type="text" path="username" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="password">Password</form:label><br>
		
		<form:input type="password" path="password" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="name">Name</form:label><br>
		<form:input type="text" path="name" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="contact">Contact</form:label><br>
		<form:input type="number" path="contact" class="border p-3 w-100 my-2" required="true" /><br>
		
	    <form:label path="email">Email</form:label><br>
		<form:input type="email" path="email" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
	
		 <input type = "submit" name = "Customer" value="Register as Customer" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/>
     <input type = "submit" name = "Partner" value="Register as Partner" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/>
	</fieldset>	
	</form:form>
</div>
            </div>
        </div>
    </div>
</section>
		
	
</body>
</html>