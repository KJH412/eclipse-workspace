<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP문법연습</h1>
	<%!
	int call(){
		System.out.print("JSP에서 자바코드가 가능하다.");
		return 100;
	}
	%>
	<%-- 내장객체 out,request 등 --%>
	<%
	String subject ="자바";	
	out.write("<h1>out내장객체</h1>");
	//스크립트릿문법
	EmpDTO emp = (EmpDTO)session.getAttribute("loginEmp");
	%>
	<h1><%=subject %></h1>
	<h1><%=call() %></h1>
	<h1><%=request.getRequestURI() %></h1>
	<h1><%=request.getContextPath() %></h1>
	<h1>Expression사용: <%=emp.getFirst_name() %></h1>
	<h1>EL문법사용: ${loginEmp.first_name}</h1>
</body>
</html>