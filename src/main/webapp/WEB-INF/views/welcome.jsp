<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>

<body class="body-wrapper">
<%@include file='/WEB-INF/views/navbar.jsp' %>	
<section class="blog section">
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1 col-lg-9 offset-lg-0">
			<c:forEach var="feedback" items="${feedbacks }">
				<!-- Article 01 -->
				<article>
	<h3>Rating ${feedback.rating }/5</h3>
	<ul class="list-inline">
		<li class="list-inline-item">by ${feedback.username }</li>
	</ul>
	<!-- Post Description -->
	<p class="">${feedback.description }</p>
	<!-- Read more button -->
	
</article>		
</c:forEach>	
			</div>
		</div>
	</div>
</section>
</body>

</html>

