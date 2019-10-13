<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<style>
#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
}

</style>
<head>
<title>Login Page</title>
</head>
<body onload='document.loginForm.username.focus();'>	
	<div id="login-box">
		<h3>Login</h3>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
		
		<br>
		<a href='/electronics/forgotpassword'>Forgot Password?</a>
		<br>
		${mesg}
		<br>
		<a href='/electronics/confirmotp'>Confirm your OTP</a>
		
		
	</div>
</body>
</html>