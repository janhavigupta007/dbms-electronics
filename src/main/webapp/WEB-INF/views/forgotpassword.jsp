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
	<section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4">Forgot Password?</h3>
	<form:form action="/electronics/forgotpassword" method="post" modelAttribute="user">
	 <fieldset class="p-4">
	<form:label path="username" > Enter your UserId</form:label><br>
		<form:input type="text" path="username" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
	
		 <input type = "submit" value="Send" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/>
	</fieldset>
	</form:form>
</div>
            </div>
        </div>
    </div>
</section> 
</body>
</html>