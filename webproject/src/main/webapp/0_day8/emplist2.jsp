<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- 
	jsp의 실행결과가 HTML, TEXT, JSON, XML 
--%>
{ "emplist":[
	<%
	EmpService eservice = new EmpService();
	List<EmpDTO> emplist = eservice.selectAll();
	for(int i=0; i<emplist.size(); i++){
	%>
		{"no":<%=emplist.get(i).getEmployee_id() %>,  
		 "name" : "<%=emplist.get(i).getFirst_name() %>", 
		 "capital" : "<%=emplist.get(i).getEmail() %>", 
		 "region": <%=emplist.get(i).getSalary() %>
		}
		
	<% 
		//마지막:emplist.size()-1
		 if(i< emplist.size()-1 ){
			 out.print(",");
		 }
	
	} //for문 닫음
	%>
] }
