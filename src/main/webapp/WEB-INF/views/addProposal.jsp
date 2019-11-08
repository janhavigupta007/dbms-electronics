<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                    <h3 class="bg-gray p-4">Add Proposal</h3>
	
	 <form action='/electronics/product/proposal' method='post'>
	 	 <fieldset class="p-4">
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		Product id:<br>
  		<input type="number" name="productid" class="border p-3 w-100 my-2" required="true"><br>
  		Price:<br>
  		<input type="number" name="price" class="border p-3 w-100 my-2" required="true">
  		<input type = "submit" value="Add" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/>
	</fieldset>
	</form> 
	</div>
            </div>
        </div>
    </div>
</section> 
</body>
</html>