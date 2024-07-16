<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 상세보기</h1>
	<!-- EL(Expression Language)표기법 -->
<%--	<!-- HTML주석: ${deptInfo} ${} -->  --%>
	<!-- JSP가 해석되어 HTML이 만들어진다. -->
	<%-- JSP주석: ${deptInfo} 
		
<%-- ${} : getAttribute. getter의 역할을 함. 
			      변수 이름만 써도 getter 호출.
		
서블릿에서 요청(deptInfo)을 받음.
->요청(deptInfo)을set해둠 
->그걸 JSP(deptUpdate.jsp)에서 get함.
-> forward받은 JSP가 브라우저로 응답함.
			
--%>
	<p>${deptInfo.department_id}</p>
	<p>${deptInfo.department_name}</p>
</body>
</html>