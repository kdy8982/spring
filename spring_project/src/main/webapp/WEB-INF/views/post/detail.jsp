<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${post.id}번글 상세 보기</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<table border="1">
		<div>
			<tr>
				<td>제목</td>
				<td>${post.title}</td>
			</tr>
			<tr>
				<td>게시자</td>
				<td>${post.memberName}</td>
			</tr>
			<tr>
				<td>게시일</td>
				<td><spring:eval expression="post.datetime"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${post.content}</td>
			</tr>

		</div>
	</table>
	<a href="<c:url value='/post/delete.do'/>">글 삭제</a>
	<a href="<c:url value='/post/list.do'/>">글 목록으로..</a>
	
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>