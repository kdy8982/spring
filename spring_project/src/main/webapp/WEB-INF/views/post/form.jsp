<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새글 작성</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
	<div>
		<form:form commandName="post" action="/sample/post/post.do" method="POST">
			<table border="1">
				<tr>
					<td>제목</td>
					<td>
						<form:input path="title" size="50"/>
						<form:errors path="title" /> 
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<form:input path="content" size="50"/>
						<form:errors path="content" />
					</td>
				</tr>
			</table>
			<input type="submit" value="글쓰기"/> 
		</form:form>
	</div>
	
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>