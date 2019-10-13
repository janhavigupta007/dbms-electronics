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

	 <form action='/electronics/confirmotp' method='post'>
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		Username:<br>
  		<input type="text" name="username"><br>
  		OTP:<br>
  		<input type="text" name="otp"><br>
  		<input type = "submit" value="Confirm"/>
	</form> 
</body>
</html>