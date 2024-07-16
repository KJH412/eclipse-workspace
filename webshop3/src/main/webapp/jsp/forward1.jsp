<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward1</h1>
	<%-- 
		forward1.jsp를 요청하면 forward2.jsp로 위임한다. 
		페이지 내용은 forward2.jsp로 가지만(보여짐)
		주소는 그대로 forward1.jsp이다. 
	--%>
	<%-- <jsp:forward page="forward2.jsp"></jsp:forward> --%>
	<jsp:include page="forward2.jsp"></jsp:include>
	<jsp:include page="forward2.jsp"></jsp:include>
	
</body>
</html>