<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="java.sql.Date"%>
<%@page import="com.shinhan.util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8"); //post방식일 때는 필수이다.

	int empid = Integer.parseInt( request.getParameter("employee_id")); //input의 name
	String fname = request.getParameter("first_name");
	String lname = request.getParameter("last_name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone_number");
	Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
	String jobid = request.getParameter("job_id");
	int sal = Integer.parseInt(request.getParameter("salary"));
	double commission = Double.parseDouble(request.getParameter("commission_pct"));
	int mid = Integer.parseInt(request.getParameter("manager_id"));
	int deptid = Integer.parseInt(request.getParameter("department_id"));
	
	EmpService eservice = new EmpService();
	EmpDTO emp = new EmpDTO();
	emp.setCommission_pct(commission);
	emp.setDepartment_id(deptid);
	emp.setEmail(email);
	emp.setEmployee_id(empid);
	emp.setFirst_name(fname);
	emp.setHire_date(hdate);
	emp.setJob_id(jobid);
	emp.setLast_name(lname);
	emp.setManager_id(mid);
	emp.setSalary(sal);
	emp.setPhone_number(phone);
	
	eservice.empInsert(emp);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empDBInsert</title>
</head>
<body>
	<h1>DB에 입력하기...............</h1>
</body>
</html>