<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<p class="login-box-msg">로그인 페이지</p>

	<form action="/sample/member/loginPost.do" method="post">
		<label>이메일</label> 
		<input type="text" name="memberEmail" placeholder="이메일" size="50" /> <br> 
		
		<label>비밀번호</label>
		<input type="password" name="memberPw" placeholder="비밀번호" size="50" />               
		<button type="submit">로그인</button> <br>
		
		<input type="checkbox" name="userCookie">로그인 유지</input>
	</form>
</body>
</html>