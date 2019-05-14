<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경하기</title>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<form id="passwordUpdateForm" action="${pageContext.request.contextPath}/member/passwordUpdate" method="post">
		<input name="memberNo" value="${param.memberNo}" type="hidden">
		<table>
			<div>
				<label for="memberPw">현재비밀번호 :</label>
             	<input class="form-control" id="memberPw" name="currentPw" type="password">
			</div>
			<div>
				<label for="memberPw">새 비밀번호 :</label>
            	 <input class="form-control" id="memberPw" name="memberPw" type="password">
			</div>
			<div>
				<label for="memberPw">비밀번호 확인 :</label>
            	 <input class="form-control" id="memberPw" name="confirmPw" type="password">
			</div>
			<%-- <c:if test='${memberPw == confirmPw}'> --%>
			<div>
				<input class="btn btn-default" id="passwordUpdate" type="submit" value="비밀번호변경">
			</div>
			<%-- /c:if> --%>
		</table>
	</form>
</body>
</html>