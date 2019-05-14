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
				<td>${productCommon.productCommonName}</td>
				<td>${productCommon.productCommonPrice}원</td>
			</tr>
			</c:forEach>
		</table>
		
		<div>
			<!-- 이전/다음/product/getProductListByCategory?category&currentPage -->
		</div>
</body>
</html>