<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>


<table border="1">
	<div>
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>게시일</td>
		</tr>
	</div>
</table>
<br><br>



<c:forEach var="post" items="${postList}">
글번호  : ${post.postId} <br>
글제목 : ${post.postTitle} <br>
글내용 : ${post.postContent} <br>
게시일 : ${post.postDatetime} <br><br>
</c:forEach> 
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

