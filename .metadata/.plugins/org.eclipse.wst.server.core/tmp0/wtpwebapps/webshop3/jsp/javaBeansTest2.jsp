<%@page import="com.shinhan.dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바빈즈 이용하기(getting)</h1>
	<jsp:useBean id="dept2" class="com.shinhan.dept.DeptDTO" scope="request"></jsp:useBean>
	<%-- get (데이터 읽음) 
		 name=dept2여기서 읽어옴. 
	 --%>
	부서번호 : <jsp:getProperty property="department_id" name="dept2"/>
	부서이름 : <jsp:getProperty property="department_name" name="dept2"/>
	지역번호 : <jsp:getProperty property="location_id" name="dept2"/>
	매니저 : <jsp:getProperty property="manager_id" name="dept2"/>
</body>
</html>









