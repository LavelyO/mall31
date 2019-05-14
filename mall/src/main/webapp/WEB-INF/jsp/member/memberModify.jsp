<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<h1>회원정보수정</h1>
	<form id="memberModifyForm" action="${pageContext.request.contextPath}/member/memberModify" method="post">
		<input name="memberNo" value="${param.memberNo}" type="hidden">
		<table border="1">
			<tr>
				<th>ID</th>
				<td><input class="form-control" name="memberId" value="${member.memberId}" type="text" readonly="readonly"></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="button" onclick="location.href='/member/passwordUpdate?memberNo=${param.memberNo}'" value="비밀번호 변경"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input class="form-control" name="memberName" value="${member.memberName}" id="memberName" type="text" readonly="readonly"></td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td><input class="form-control" name="memberPhone" value="${member.memberPhone}" id="memberPhone" type="text"></td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td><input class="form-control" name="memberAddress" value="${member.memberAddress}" id="memberAddress" type="text"></td>
			</tr>
			<tr>
				<th>LEVEL</th>
				<td><input class="form-control" name="memberLevel" value="${member.memberLevel}" id="memberLevel" type="text" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2">
				<a href="/member/myPage?memberNo=${loginMember.memberNo}">뒤로가기</a>
				<input class="btn btn-default" id="modifyButton" type="submit" value="회원정보수정">
				<input type="button" onclick="location.href='/member/deleteMember?memberNo=${param.memberNo}'" value="회원탈퇴"></td>
			</tr>
		</table>
	</form>
</body>
</html>