<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script>
	$(document).load(function(){
		$('#searchBtn').click(function(){
			$('#searchForm').submit();
		});
	});
</script>
</head>
<body>
	<h2>상품리스트</h2>
		<table>
			<c:forEach items="${list}" var="productCommon">
				<tr>
					<td>${productCommon.productCommonName}</td>
					<td>${productCommon.productCommonDescription}</td>
				</tr>
			</c:forEach>
		</table>
		<form id="searchForm" action="${pageContext.request.contextPath}/product/getProductListByCategory?categoryNo=${categoryNo}" method="get">
			<!-- <input type="hidden" value="${categoryNo} name="categoryNo"> -->
			<input type="text" name="searchWord">
			productName 검색어: <input type="text" name="searchWord">
			<button id="searchBtn" type="button">검색</button>
		</form>
		<div>
			<!-- 이전/다음/product/getProductListByCategory?category&currentPage -->
		</div>
</body>
</html>