<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니 결과</h1>
	<table border="1">
		<tr>
			<th>메뉴이름</th><th>개수</th>
		</tr>
		<c:forEach items="${cart}" var="menu">
		<tr>
			<td>${menu.key}</td>
			<td>${menu.value}</td>
		</tr>
		</c:forEach>
	</table>
	<form action="orderRemove.go">
		<input type="submit" value="장바구니비우기">
	</form>
	<a href="order.go">계속주문</a>
</body>
</html>