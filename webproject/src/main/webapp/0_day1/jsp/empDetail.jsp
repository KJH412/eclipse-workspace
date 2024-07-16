<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	EmpService eservice = new EmpService();
	String empid = request.getParameter("empid");
	int i_empid = 0;
	EmpDTO emp = null;
	if(empid != null){
		i_empid = Integer.parseInt(empid);
		emp = eservice.selectById(i_empid);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 정보 상세보기</h1>
	<p>직원 번호: <%=emp.getEmployee_id() %></p>
	<p>First_name: <%=emp.getFirst_name() %></p>
	<p>Last_name: <%=emp.getLast_name() %></p>
	<p>Email: <%=emp.getEmail() %></p>
	<p>Commission_pct: <%=emp.getCommission_pct() %></p>
	<p>Department_id: <%=emp.getDepartment_id() %></p>
	<p>Phone_number: <%=emp.getPhone_number() %></p>
	<p>Salary: <%=emp.getSalary() %></p>
	<p>Hire_date: <%=emp.getHire_date() %></p>
	<p>Manager_id: <%=emp.getManager_id() %></p>
	<p>Job_id: <%=emp.getJob_id() %></p>
</body>
</html>