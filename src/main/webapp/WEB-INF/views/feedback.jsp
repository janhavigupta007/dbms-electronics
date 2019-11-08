<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<html>

<head>

 

</head>

<body class="body-wrapper">
<%@include file='/WEB-INF/views/navbar.jsp' %>


<section class="blog single-blog section">
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
				
				<div class="block comment">
					<h4>Rate Us!!!</h4>
					<form:form action="/electronics/feedback" method="post" modelAttribute="feedback">
						<!-- Message -->
						
						<div class="row">
							<div class="col-sm-12 col-md-6">
								<!-- Name -->
								<div class="form-group mb-30">
								    <form:label path="rating">Rating</form:label>
								    <form:input type="number" class="form-control" path="rating" min="1" max="5" required="true"/>
								    
								</div>
							</div>
							
						</div>
						<div class="form-group mb-30">
						    <form:label path="description">Description</form:label>
						    <form:input type="text" path="description" class="form-control" maxlength="100"/>
						</div>
						<input type = "submit" value="Leave Comment" class="btn btn-transparent"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</section>



 

</body>

</html>