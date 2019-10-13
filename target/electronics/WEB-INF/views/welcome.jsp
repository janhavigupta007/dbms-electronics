<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<body>
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

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h4>
			Hello : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h4>
	</c:if>
	${msg }<br>
	<sec:authorize access="hasRole('ROLE_CUSTOMER')">
	<a href='/electronics/profileCustomer'>View and Update profile</a><br>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_PARTNER')">
	<a href='/electronics/profilePartner'>View and Update profile</a><br>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_PARTNER') or hasRole('ROLE_CUSTOMER')">
	<a href='/electronics/feedback'>Rate us!!!</a><br>
	</sec:authorize>
	<a href='/electronics/product'>Show Products</a>
	<br>
	<sec:authorize access="hasRole('ROLE_CUSTOMER')">
	<a href='/electronics/order/show'>View my orders</a><br>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_PARTNER') or hasRole('ROLE_CUSTOMER')">
	<a href='/electronics/changepassword'>Change Password</a><br>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href='/electronics/viewfeedback'>View all Feedbacks</a><br>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href='/electronics/vieworder'>View all orders</a><br>
	</sec:authorize>
</body>
</html>