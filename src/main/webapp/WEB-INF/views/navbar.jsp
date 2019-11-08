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


<section>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg  navigation">
				<h2>
					<a class="navbar-brand" href="/electronics/">
						SINGLA ELECTRONICS
					</a>
					</h2>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto main-nav ">
							<li class="nav-item active">
								<a class="nav-link" href="/electronics/">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/electronics/product">Products</a>
							</li>
							<sec:authorize access="hasRole('ROLE_PARTNER')">
							<li class="nav-item">
								<a class="nav-link" href="/electronics/product/proposal">Add Proposal</a>
							</li>
							</sec:authorize>
							<sec:authorize access="hasRole('ROLE_PARTNER') or hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')">
							<li class="nav-item dropdown dropdown-slide">
								<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Profile <span><i class="fa fa-angle-down"></i></span>
								</a>
								<!-- Dropdown list -->
								<div class="dropdown-menu dropdown-menu-right">
								<sec:authorize access="hasRole('ROLE_CUSTOMER')">
									<a class="dropdown-item" href="/electronics/profileCustomer">Update profile</a>
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_PARTNER')">
									<a class="dropdown-item" href="/electronics/profilePartner">Update profile</a>
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_PARTNER') or hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')">
									<a class="dropdown-item" href="/electronics/changepassword">Reset Password</a>
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_PARTNER') or hasRole('ROLE_CUSTOMER')">
									<a class="dropdown-item" href="/electronics/feedback">Rate us</a>
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_PARTNER') or hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')">
									<a class="dropdown-item" href="javascript:formSubmit()">Logout</a>
									</sec:authorize>
								</div>
							</li>
							</sec:authorize>
							<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_CUSTOMER')">
							<li class="nav-item dropdown dropdown-slide">
								<a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									Actions <span><i class="fa fa-angle-down"></i></span>
								</a>
								<!-- Dropdown list -->
								<div class="dropdown-menu dropdown-menu-right">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<a class="dropdown-item" href="/electronics/product/add">Add Product</a>
									<a class="dropdown-item" href="/electronics/product/addCategory">Add Category</a>
									<a class="dropdown-item" href="/electronics/vieworder">Orders</a>
									<a class="dropdown-item" href="/electronics/viewfeedback">Feedbacks</a>
									</sec:authorize>
									<sec:authorize access="hasRole('ROLE_CUSTOMER')">
									<a class="dropdown-item" href="/electronics/cart">Cart</a>
									<a class="dropdown-item" href="/electronics/order/show">My Orders</a>
									</sec:authorize>
								</div>
							</li>
							</sec:authorize>
						</ul>
						<sec:authorize access="!hasRole('ROLE_PARTNER') and !hasRole('ROLE_CUSTOMER') and !hasRole('ROLE_ADMIN')">
						<ul class="navbar-nav ml-auto mt-10">
							<li class="nav-item">
								<a class="nav-link login-button" href="/electronics/login">Login</a>
							</li>
							<li class="nav-item">
								<a class="nav-link add-button" href="/electronics/register"><i class="fa fa-plus-circle"></i> Register</a>
							</li>
						</ul>
						</sec:authorize>
					</div>
				</nav>
			</div>
		</div>
	</div>
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


