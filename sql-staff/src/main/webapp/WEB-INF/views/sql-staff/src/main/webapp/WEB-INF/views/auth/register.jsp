<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/auth/registerProcess" method="post">
		<input name="email" placeholder="email">
		<input name="name" placeholder="name">
		<input name="group" placeholder="group">
		<input name="password" placeholder="password">
		<input name="confirm_password" placeholder="confirm_password">
		<input type="submit">
	</form>
</body>
</html>