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
	<section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4">Reset Password</h3>
	 <form action='/electronics/changepassword' method='post'>
	 <fieldset class="p-4">
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		Username:<br>
  		<input type="text" name="username" value = "${username }" class="border p-3 w-100 my-2" readonly><br>
  		Old Password:<br>
  		<input type="password" name="oldpassword" class="border p-3 w-100 my-2" required="true" maxlength="40"><br>
  		New Password:<br>
  		<input type="password" name="newpassword" class="border p-3 w-100 my-2" required="true" maxlength="40"><br>
  		Confirm Password:<br>
  		<input type="password" name="confirmpassword" class="border p-3 w-100 my-2" required="true" maxlength="40"><br>
  		<input type = "submit" value="Change" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3"/>
	</fieldset>	
	</form>
	</div>
            </div>
        </div>
    </div>
</section> 
</body>
</html>