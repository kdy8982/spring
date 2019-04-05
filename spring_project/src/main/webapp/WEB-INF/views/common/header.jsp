<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.header{background-color:#D5D5D5;text-align:right;}
</style>
</head>
<body>
	<header class="header">
		<a href="<c:url value='/'/>">홈으로</a>
		<a href="<c:url value='/member/form.do'/>">회원가입</a>
	</header>
	<br>
</body>
</html>