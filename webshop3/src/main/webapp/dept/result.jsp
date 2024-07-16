<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <%-- "3;deptList"는 서블릿주소, 3초 후 deptList(서블릿)로 이동, refresh --%>
<meta http-equiv="refresh" content="3;deptList.do">

<title>Insert title here</title>
</head>
<body>
	<h1>dept입력결과:${message}</h1>
</body>
</html>