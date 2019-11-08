<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<html>
<head>

  <!-- SITE TITTLE -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
  
  <!-- PLUGINS CSS STYLE -->
  <link href="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.css" />" rel="stylesheet">
  <!-- Bootstrap -->
  <link href="<c:url value="/resources/plugins/bootstrap/dist/css/bootstrap.min.css" />" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
  <!-- Owl Carousel -->
  <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/slick-carousel/slick/slick-theme.css" />" rel="stylesheet">
  <!-- Fancy Box -->
  <link href="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/jquery-nice-select/css/nice-select.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/css/bootstrap-slider.min.css" />" rel="stylesheet">
  <!-- CUSTOM CSS -->
  <link type="text/css" href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<style><%@include file='/WEB-INF/views/style.css' %></style>
  <!-- FAVICON -->
  <link href="<c:url value="/resources/img/favicon.png" />" rel="shortcut icon">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<body class="body-wrapper">

<%@include file='/WEB-INF/views/navbar.jsp' %>	


<!--===============================
=            Hero Area            =
================================-->
<h5 align="center">${msg}</h5>
<section class="hero-area bg-1 text-center overly">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Header Contetnt -->
				<div class="content-block">
					<h1>Get the best deals </h1>
					<p>Range of products of various brands available here <br> Hurry up, analyse now and choose</p>
					
				</div>
				<!-- Advance Search -->
				
				
			</div>
		</div>
	</div>
	<!-- Container End -->
</section>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>



  <!-- JAVASCRIPTS -->
  <script src="<c:url value="/resources/plugins/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/jquery-ui/jquery-ui.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/tether/js/tether.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/raty/jquery.raty-fa.js" />"></script>
  <script src="<c:url value="/resources/plugins/bootstrap/dist/js/popper.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/bootstrap/dist/js/bootstrap.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/seiyria-bootstrap-slider/dist/bootstrap-slider.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/slick-carousel/slick/slick.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/jquery-nice-select/js/jquery.nice-select.min.js" />"></script>
  <script src="<c:url value="/resources/plugins/fancybox/jquery.fancybox.pack.js" />"></script>
  <script src="<c:url value="/resources/plugins/smoothscroll/SmoothScroll.min.js" />"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
  <script src="<c:url value="/resources/js/scripts.js" />"></script>

</body>

</html>


