<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>

<jsp:include page="../common/header.jsp"></jsp:include>


<div>
<form:form commandName="member" action="/sample/member/post.dy" method="POST">
	<p>
		<label>이름</label>
		<form:input path="name" size="50"/><br>
		
		<form:errors path="name" cssClass="smdis-error-message"/>
	</p>
    <input type="submit" value="저장"/> 
</form:form>
</div>


<a href="<c:url value='/member/list.dy'/>">전체 회원 목록</a>
<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>