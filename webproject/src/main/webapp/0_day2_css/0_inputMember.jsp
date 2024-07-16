<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String uid = request.getParameter("uid"); 
	String upw = request.getParameter("upw"); 
	String uname = request.getParameter("uname"); 
	String uphone = request.getParameter("uphone"); 
	String udate = request.getParameter("udate"); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h1>회원가입 정보 확인</h1>
 	<p>아이디: <%=uid %></p>
 	<p>비밀번호: <%=upw %></p>
 	<p>이름: <%=uname %></p>
 	<p>전화번호: <%=uphone %></p>
 	<p>생년월일: <%=udate %></p>
</body>
</html>