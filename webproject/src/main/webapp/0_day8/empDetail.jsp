<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpDAO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%-- 자바 사용 --%>  
 <% 
 	String empid = request.getParameter("empid");
 	if(empid == null) return;
 	int i_empid = Integer.parseInt(empid);
 	EmpService service = new EmpService();
 	EmpDTO emp = service.selectById(i_empid); //selectById(100);
 %>

 <%-- HTML형태로 보내는 방법 --%>
 <ul>
  <li> <%=emp.getEmployee_id() %> </li>
  <li> <%=emp.getFirst_name() %> </li>
</ul>
 
 
 
 
 