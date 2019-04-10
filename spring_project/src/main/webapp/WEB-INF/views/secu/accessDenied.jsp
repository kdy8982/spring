<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content=스크립틀릿 페이지 이동"text/html; charset=UTF-8">
<script>
window.onload=function(){
	setTimeout(function() {
		location.href="/sample/";
	},2000)
}
</script>

<title>Login</title>

</head>
<body>
	<h6>권한이 없어 접근이 불가합니다.<br>관리자에게 문의하세요.</h6>
</body>
</html>
