<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<br>
	<br>
	<div class="container text-center">
		<h1>Security Prj</h1>
		<br>
	</div>
	<div class="container col-md-4">
		<form class="px-4 py-3" action='<c:url value="/login"/>' method="post">
			<div class="form-group">
				<label for="exampleDropdownFormEmail1">ID</label> <input type="text"
					class="form-control" name="loginId" placeholder="example"
					value="${loginId }">
			</div>
			<div class="form-group">
				<label for="exampleDropdownFormPassword1">Password</label> <input
					type="password" class="form-control" name="loginPwd"
					placeholder="Password" value="${loginPwd }">
			</div>


			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				<font color="red">
					<p>
						로그인 시도가 실패했습니다. <br />
						${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
					</p> <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
				</font>
			</c:if>


			<div class="form-check">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input"> Remember me
				</label>
			</div>
			<input name="${_csrf.parameterName}" type="hidden"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-primary">Sign in</button>
		</form>
		<div class="dropdown-divider"></div>
		<a class="dropdown-item" href="#">New around here? Sign up</a> <a
			class="dropdown-item" href="#">Forgot password?</a>
	</div>

</body>
</html>