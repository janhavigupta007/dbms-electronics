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
                    <h3 class="bg-gray p-4">Profile</h3>
	<form:form action="/electronics/profilePartner" method="post" modelAttribute="partner">
	<fieldset class="p-4">
	
		<form:label path="firm">Firm</form:label><br>
		<form:input type="text" path="firm" value="${partner.firm}" class="border p-3 w-100 my-2" maxlength="40"/><br>
		
		<form:label path="name">Agent Name</form:label><br>
		<form:input type="text" path="name" value="${partner.name}" class="border p-3 w-100 my-2" required="true" maxlength="40"/><br>
		
		<form:label path="contact">Contact</form:label><br>
		<form:input type="number" path="contact" value="${partner.contact}" required="true" class="border p-3 w-100 my-2"/><br>
		
		<form:label path="email">E-mail</form:label><br>
		<form:input type="email" path="email" value="${partner.email}" required="true" class="border p-3 w-100 my-2" maxlength="40"/><br>
		
		 <input type = "submit" value="Update" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/>
	</fieldset>	
	</form:form>

	${msg}
	</div>
            </div>
        </div>
    </div>
</section>
</body>
</html>