<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/member/idSearchResult" method="post">
		<table>
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
					휴대폰번호
				</td>
				<td>
					<input type="text" name="memberPhone" id="memberPhone">
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