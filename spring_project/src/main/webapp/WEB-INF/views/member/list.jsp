<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<a href="<c:url value='/member/form.dy'/>">회원가입</a> <br/>

<c:forEach var="member" items="${memberList}">
회원 번호 : ${member.id} <br>
회원 이름 : ${member.name} <br>
가입일 : ${member.joined} <br><br>
</c:forEach> 
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>

