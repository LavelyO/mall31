<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
</head>
<body>
	<h1>가입을 축하합니다!</h1>
	<h2>로그인</h2>
	<form action="${pageContext.request.contextPath}/member/login" method="post">
		ID <input type="text" id="memberId" name="memberId">
		Password <input type="password" id="memberPw" name="memberPw">
		<button type="submit">Login</button>
	</form>
</body>
</html>