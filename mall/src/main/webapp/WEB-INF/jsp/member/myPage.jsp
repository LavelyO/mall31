<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
</head>
<body>
	<a href="/">▶Home</a>
	<h1>회원정보조회</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<td>${member.memberId}</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>${member.memberName}</td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td>${member.memberPhone}</td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td>${member.memberAddress}</td>
			</tr>
			<tr>
				<th>LEVEL</th>
				<td>${member.memberLevel}</td>
			</tr>
			<tr>
				<td colspan="2"><a href="/member/memberModify?memberNo=${loginMember.memberNo}">회원정보수정하기</a></td>
			</tr>
		</table>
</body>
</html>