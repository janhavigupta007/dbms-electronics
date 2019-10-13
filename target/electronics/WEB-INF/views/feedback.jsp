<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
<html>
<head>
<title></title>
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/sample.js" />"></script>
</head>
<body>
<button class="open-button" onclick="openForm()">Open Form</button>
<div class="form-popup" id="myForm">
	<form:form action="/electronics/feedback" method="post" modelAttribute="feedback" class="form-container">
	<table>
		
		<tr>
		<td><form:label path="rating">Rating</form:label></td>
		<td><form:input type="number" path="rating" min="1" max="5"/></td></tr>
		
		<tr>
		<td><form:label path="description">Description</form:label></td>
		<td><form:input type="text" path="description" /></td></tr>
	
		 <tr><td><input type = "submit" value="Rate" class="btn"/></td></tr>
	</table>	
	</form:form>
	 <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </div>
</body>
</html>