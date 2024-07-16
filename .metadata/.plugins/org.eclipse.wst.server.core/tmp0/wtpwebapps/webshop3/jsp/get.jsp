<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	HttpSession : 브라우저 창 꺼지면 값이 사라짐.
	ServletContext : 브라우저 창 꺼도 서버가 켜져있으면 값이 살아있음. 서버가 죽으면 사라짐. 
	--%>
	<h1>get.jsp</h1>
	<h1>request : : ${myinfo}</h1>
	<h1>HttpSession : ${myinfo2}</h1>
	<h1>ServletContext: ${myinfo3}</h1>
	<h1>initParameter: ${initParam['menu_member']}</h1>
	<h1>initParameter: ${initParam['menu_order']}</h1>
	
	<ul>
		<c:forEach var="member" items="${initParam['menu_member']}">
			<li>${member}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="member" items="${initParam['menu_order']}">
			<li>${member}</li>
		</c:forEach>
	</ul>
	<%-- web.xml에 정의해 둔 값이 들어옴. --%>
	<p>은행이름 : ${initParam["bankname"]}</p>
</body>
</html>