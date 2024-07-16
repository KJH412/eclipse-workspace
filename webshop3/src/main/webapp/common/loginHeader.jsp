<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>${loginEmp.first_name}님 환영합니다.</h1>
<a href="${pageContext.request.servletContext.contextPath}/auth/logout.do">로그아웃</a>
<%-- 절대경로 씀 --%>
<%-- ${pageContext.request.servletContext.contextPath} => /webshop3 --%>
<hr>

<%-- JSP초기문법 권장X --%>
<% 
	//자바코드...service메서드 안으로 들어간다.
%>
<%!
	//선언문(멤버변수,멤버 메서드)
	String subject= "자바";
	//void call(){};
%>
<%-- 출력 --%>
<%=subject %>