<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/loginHeader.jsp" %>
	<h1>주문선택</h1>
	<form action="order.go" method="post">
		메뉴: <input name="lunch" type="radio" value="김밥" checked>김밥
			 <input name="lunch" type="radio" value="짜장면">짜장면
			 <input name="lunch" type="radio" value="초밥">초밥
			 <input name="lunch" type="radio" value="햄버거">햄버거
			 <input name="lunch" type="radio" value="국밥">국밥
			 <input name="count" type="number" value="1">
			 <input type="submit" value="주문">
	</form>
</body>
</html>