<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 결과</title>
</head>
<body>
	<c:if test='${param.memberId != null}'>
		<table>
			<tr>
				<td>
					입력하신 정보로 비밀번호를 찾아, 이메일로 발송하였습니다.<br>
					항상 저희 사이트를 이용해 주셔서 감사합니다.<br>
				</td>
			</tr>
			<!-- <tr>
				<td>
					<input type="text" name="sendEmail" id="sendEmail">
					<input type="button" onclick="location.href='/member/##'" value="이메일전송하기">
				</td>
			</tr> -->
		</table>
	</c:if>
	<c:if test='${param.memberId == null}'>
		<table>
			<tr>
				<td>
					입력하신 정보와 일치하는 회원정보를 찾을 수 없습니다.<br>
					가입시 입력한 정보를 정확히 입력해주세요<br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="location.href='${pageContext.request.contextPath}/member/pwSearchForm'" value="뒤로가기">
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>