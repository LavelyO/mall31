<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script>
	$(document).ready(function(){
		$('#searchBtn').click(function(){
			$('#searchForm').submit();
		});
	});
</script>
</head>
<body>
	<h2>상품리스트</h2>
		<form id="searchForm" action="${pageContext.request.contextPath}/product/list?categoryNo=${categoryNo}&searchWord=${searchWord}&currentPage=${currentPage}" method="get">
			<input type="hidden" value="${categoryNo}" name="categoryNo">
			productName 검색어: <input type="text" name="searchWord">
			<button id="searchBtn" type="button">검색</button>
		</form>
		<table>
			<tr>
				<td>상품명</td>
				<td>상품가격</td>
			</tr>
			<c:forEach items="${list}" var="productCommon">
			<tr>
				<td><a href="${pageContext.request.contextPath}/product/detail?productCommonNo=${productCommon.productCommonNo}">${productCommon.productCommonName}</a></td>
				<td>${productCommon.productCommonPrice}원</td>
			</tr>
			</c:forEach>
		</table>
		
		<div>
		<%-- <a href="${pageContext.request.contextPath}/product/list?categoryNo=${category.categoryNo}">${category.categoryName}</a> --%>
			<c:if test='${lastPage != 1}'>
			<c:if test='${currentPage > 1}'>	<!-- 현재 페이지가 1보다 크면 아래 문장을 출력한다. -->
				<a href="${pageContext.request.contextPath}/product/list?categoryNo=${categoryNo}&currentPage=${startPage}">처음</a>
				<a href="${pageContext.request.contextPath}/product/list?categoryNo=${categoryNo}&currentPage=${currentPage-1}">이전</a>
			</c:if>
			
			<c:forEach begin="1" end="${lastPage}" var="page" step="1">		<!-- 1부터 lastPage까지 나열하는데 변수명으로 page를 사용하고 1씩 증가한다. -->
				<a href="${pageContext.request.contextPath}/product/list?categoryNo=${categoryNo}&currentPage=${page}&searchWord=${searchWord}">${page}</a>
			</c:forEach>
			
			<c:if test='${currentPage < lastPage}'>		<!-- 현재 페이지가 lastPage보다 작으면 아래 문장을 출력한다. -->
				<a href="${pageContext.request.contextPath}/product/list?categoryNo=${categoryNo}&currentPage=${currentPage+1}">다음</a>	<!-- 다음페이지는 currentPage+1 -->
				<a href="${pageContext.request.contextPath}/product/list?categoryNo=${categoryNo}&currentPage=${lastPage}">끝</a>
			</c:if>
			<!-- 이전/다음/product/getProductListByCategory?category&currentPage -->
			</c:if>
		</div>
</body>
</html>