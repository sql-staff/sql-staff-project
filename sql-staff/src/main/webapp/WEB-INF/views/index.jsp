<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<div>
	<c:if test="${ empty login }">
		로그인 상태가 아닙니다.
	</c:if>
	<c:if test="${ not empty login }">
		로그인 상태 입니다.
		<form action="/auth/logoutProcess" method="POST">
			<input type="submit" value="로그아웃">
		</form>
	</c:if>
	${ login.user_name } 님
	<h1>home</h1>
	<a href="/auth/login">로그인</a>
	<a href="/auth/register">회원가입</a>
</div>
<%@ include file="include/footer.jsp" %>