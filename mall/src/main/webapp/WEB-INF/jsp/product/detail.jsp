<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세보기</title>
</head>
<body>
	<h1>${productCommon.productCommonName}</h1>
		<div>
			<div>
				<img src="https://postfiles.pstatic.net/20160402_266/maddara_1459607019787jgqjc_JPEG/Untitled-1.jpg?type=w1" alt="">
			</div>
			<div>
				판매가격 : ${productCommon.productCommonPrice}
			</div>
			<div>
				<form action="#" method="post">
					<select name="색상">
						<c:forEach items="${productCommon.products}" var="products">
							<option value="색상">색상: ${products.productColor}</option>
						</c:forEach>
					</select>
					</div>
					<div>
					<select name="사이즈">
						<c:forEach items="${productCommon.products}" var="products">
							<option value="사이즈">사이즈: ${products.productSize} / 재고수량: ${products.productStock}</option>
						</c:forEach>
					</select>
					<button id="buy">Buy it</button>
				</form>
			</div>
			<div>
					상품 상세정보 :
					${productCommon.productCommonDescription}
					반품/환불 유의사항 : 상품 불량, 하자가 있는 경우가 아니면, 단순변심에 의한 반품이 불가합니다.
			</div>
		</div>
</body>
</html>