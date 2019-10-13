<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title></title>
</head>
<body>

	<form:form action="/electronics/forgotpassword" method="post" modelAttribute="user">
	<table>
		
		<tr>
		<td><form:label path="username"> Enter your UserId</form:label></td>
		<td><form:input type="text" path="username" /></td></tr>
	
		 <tr><td><input type = "submit" value="Send"/></td></tr>
	</table>	
	</form:form>

</body>
</html>