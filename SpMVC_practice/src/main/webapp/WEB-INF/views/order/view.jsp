<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 웹서비스</title>
</head>
<body>
	<h3>주문내역 상세보기</h3>
	<p>주문번호 : ${ORDER.o_num}</p>
	<p>고객번호 : ${ORDER.o_cnum}</p>
	<p>주문일자 : ${ORDER.o_date}</p>
	<p>상품코드 : ${ORDER.o_pcode}</p>
	<p>가격 : ${ORDER.o_price}</p>
	<p>수량 : ${ORDER.o_qty}</p>

</body>
</html>