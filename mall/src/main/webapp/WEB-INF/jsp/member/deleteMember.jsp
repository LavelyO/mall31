<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<h3>회원 탈퇴</h3>
	<div>회원 탈퇴하시면 더이상 당사의 서비스를 제공 받지 못하며, 사용하던 아이디로 재가입 하실 수 없습니다.</div>
	<form id="deleteMemberForm" action="${pageContext.request.contextPath}/member/deleteMember" method="post">
		<input name="memberNo" value="${param.memberNo}" type="hidden">
		<table>
		<tr>
			<div>
				<td><label for="deleteMemberReason">탈퇴사유 :</label></td>
				<td>
				<div class="container mt-3">
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="reasonA" id="reasonA" name="reasonA">
							<label class="custom-control-label" for="reasonA">너무 많은 이메일, 초대, 요청을 받고 있어요.</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="reasonB" id="reasonB" name="reasonB">
							<label class="custom-control-label" for="reasonB">안전하지 않은 것 같아요.</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="reasonC" id="reasonC" name="reasonC">
							<label class="custom-control-label" for="reasonC">사용 방법을 모르겠어요.</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="reasonD" id="reasonD" name="reasonD">
							<label class="custom-control-label" for="reasonD">여기에 너무 많은 시간을 허비하고 있습니다.</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="reasonE" id="reasonE" name="reasonE">
							<label class="custom-control-label" for="reasonE">계정이 해킹당했습니다.</label>
						</div>
						<div class="custom-control custom-radio custom-control-inline">
							<input type="radio" class="custom-control-input" value="reasonF" id="reasonF" name="reasonF">
							<label class="custom-control-label" for="reasonF">기타</label></div>
						<div>
							<textarea class="custom-control" name="reasonG" id="reasonG" rows="4" cols="50"></textarea>
						</div>
					</div>
					</td>
			</div>
			</tr>
			<tr>
			<div>
				<td><label for="memberPw">비밀번호 :</label></td>
            	<td><input class="form-control" id="memberPw" name="memberPw" type="password">
				<input class="btn btn-default" id="deleteMember" type="submit" value="회원탈퇴"></td>
			</div>
			</tr>
		</table>
	</form>
</body>
</html>