<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>INDEX</h1>
	<h3>쇼핑몰 메인 페이지</h3>
	<div>
		<ul>
		<c:if test='${loginMember == null}'>
			<li><a href="/member/login">Login</a></li>
			<li><a href="/member/join">Join</a></li>
		</c:if>
		<c:if test='${loginMember != null}'>
			<li>${memberName}님, ${memberLevel}로 로그인 중</li>
			<li><a href="/member/logout">Logout</a></li>
			<li><a href="/member/myPage?memberNo=${loginMember.memberNo}">MyPage</a></li>
			<!-- <li><a href="/member/memberModify">회원정보수정</a></li> -->
		</c:if>
		</ul>
	</div>
	<!-- 쇼핑몰 메뉴 -->
	<div>
		<ul>
			<c:forEach var="category" items='${categoryList}'>
				<li>
					<a href="${pageContext.request.contextPath}/product/list?category_no=${category.categoryNo}">${category.categoryName}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>