<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JSP = 자바 + HTML(***)  <= html이 목적
	//Servlet = 자바(***) + HTML  <=자바가 목적
	//자바 영역
	String str = "JSP연습";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=str %></h1>
</body>
</html>