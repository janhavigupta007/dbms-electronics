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

	 <form action='/electronics/changepassword' method='post'>
	 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  		Username:<br>
  		<input type="String" name="username" value = "${username }" readonly><br>
  		Old Password:<br>
  		<input type="password" name="oldpassword"><br>
  		New Password:<br>
  		<input type="password" name="newpassword"><br>
  		Confirm Password:<br>
  		<input type="password" name="confirmpassword"><br>
  		<input type = "submit" value="Change"/>
	</form> 
</body>
</html>