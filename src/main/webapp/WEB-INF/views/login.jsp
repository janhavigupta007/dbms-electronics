<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>


<head>
<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>
<%@include file='/WEB-INF/views/navbar.jsp' %>	
	<section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4">Login Now</h3>
		<div align="center"><c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		${mesg}
		</div>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>
 <fieldset class="p-4">
	
					Username:<br>
					<input type='text' name='username' placeholder="Username" class="border p-3 w-100 my-2" required="true" maxlength="40"/>
					<br>
					Password:<br>
					<input type='password' name='password' placeholder="Password" class="border p-3 w-100 my-2" required="true"/>
					<input name="submit" type="submit" value="Login" class="d-block py-3 px-5 bg-primary text-white border-0 rounded font-weight-bold mt-3" maxlength="40"/>
				
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				<a class="mt-3 d-block  text-primary" href='/electronics/forgotpassword'>Forgot Password?</a>
				
		
		<a class="mt-3 d-inline-block text-primary" href='/electronics/confirmotp'>Confirm your OTP</a>
 </fieldset>
		</form>
		
		
		</div>
            </div>
        </div>
    </div>
</section>
		
</body>
</html>