<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
</head>
<body>
	<c:if test='${param.memberId != null}'>
		<table>
			<tr>
				<td>
					입력하신 정보로 가입된 아이디가 있습니다.<br>
					회원님의 아이디는 ${param.memberId} 입니다.<br>
					항상 저희 사이트를 이용해 주셔서 감사합니다.<br>
					고객님의 아이디 찾기가 성공적으로 이루어졌습니다.<br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="location.href='/member/login'" value="로그인">
				</td>
				<td>
					<input type="button" onclick="location.href='/member/passwordSearchForm'" value="비밀번호 찾기">
				</td>
			</tr>
		</table>
	</c:if>
	<c:if test='${param.memberId == null}'>
		<table>
			<tr>
				<td>
					입력하신 정보로 아이디를 찾을 수 없습니다.<br>
					가입시 입력한 정보를 정확히 입력해주세요<br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="location.href='${pageContext.request.contextPath}/member/idSearchForm'" value="뒤로가기">
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>