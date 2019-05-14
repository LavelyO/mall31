<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/member/pwSearchResult" method="post">
		<table>
			<tr>
				<td>
					아이디
				</td>
				<td>
					<input type="text" name="memberId" id="memberId">
				</td>
			</tr>
			<tr>
				<td>
					이름
				</td>
				<td>
					<input type="text" name="memberName" id="memberName">
				</td>
			</tr>
			<tr>
				<td>
					이메일
				</td>
				<td>
					<input type="text" name="memberEmail" id="memberEmail" placeholder="가입시 작성한 이메일">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">확인</button><br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>