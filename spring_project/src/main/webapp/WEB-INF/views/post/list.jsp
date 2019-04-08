<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sample.domain.*" %>
<%@ page import="com.sample.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판11</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<table border="1">
	<div>
		<tr>
			<td>글번호111</td>
			<td>글제목</td>
			<td>게시일</td>
		</tr>
		<c:forEach var="post" items="${postList}">
		<tr>
			<td>${post.id}</td>
			<td><a href="<c:url value='detail/${post.id}.do'/>"> ${post.title}</a></td>
			<td>${post.datetime}</td>
		</tr>
		</c:forEach> 
	</div>
</table>

<c:forEach var="index" items="${pageIndex}" varStatus="status">
<a href="<c:url value='list.do?pid=${status.count}'/>">${status.count}</a>
</c:forEach>
<a href="<c:url value='form.do'/>">새글쓰기</a></td>
<br>
<br>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

