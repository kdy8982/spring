<!--
 *   관리자 페이지의 로그아웃 후 로그인 페이지로 이동한다.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    session.invalidate();
    response.sendRedirect("/sample");
%>