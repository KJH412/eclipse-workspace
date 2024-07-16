<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 등록</h1>
	<%-- 1)form action : 서블릿에 요청하기 --%>
	<%-- <form action="deptInsert.do" method="post">  --%>
	
	 <%--2)form action : 자바빈즈 기술 이용
	 	  인코딩 필요없는 get방식   --%>
	<%-- 실제로 이렇게 사용하진 않음.? 테스트용 --%>
	<form action="javaBeansTest.jsp" method="get"> 
		부서번호 : <input type="number" name="department_id" value="300"><br>
		부서이름 : <input type="text" name="department_name" value="aa"><br>
		매니저 : <input type="number" name="manager_id" value="100"><br>
		지역코드 : <input type="number" name="location_id" value="1700"><br>
		<input type="submit" value="부서저장">
	</form>
</body>
</html>