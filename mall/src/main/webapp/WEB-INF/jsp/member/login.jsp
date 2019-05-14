<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberLogin</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="${pageContext.request.contextPath}/member/login" method="post">
		ID <input type="text" id="memberId" name="memberId">
		Password <input type="password" id="memberPw" name="memberPw">
		<button type="submit">Login</button><br>
	</form><br>
		<a href="${pageContext.request.contextPath}/member/idSearchForm">아이디 찾기</a>
		<a href="${pageContext.request.contextPath}/member/passwordSearchForm">비밀번호 찾기</a>
</body>
</html>