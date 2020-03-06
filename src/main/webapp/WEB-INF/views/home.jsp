<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>community</title>
</head>
<body>
<h1>
	여행동호회 
</h1>

<c:if test="${loginId != null }">
	${sessionScope.loginName} (${sessionScope.loginId})님 로그인<br>
</c:if>

<ul>

<c:if test="${loginId == null}">
	<li><a href="customer/join">회원 가입 </a>
	<li><a href="customer/login">로그인 </a>
</c:if>
<c:if test="${loginId != null}>">
	<li><a href="customer/logout">로그아웃 </a>
	<li><a href="customer/update">개인정보 수정 </a>
</c:if>
	<li><a href="board/list">게시판 </a>
</ul>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
