<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empByDept</title>
<style type="text/css">
#container{
	background-color: rgba(255,0,0,0.3);
	width: 960px;	
}
#deptlist{
	background-color: rgba(0,255,0,0.3);
	width: 33%;
	float: left;
}
#emplist{
	background-color: rgba(0,0,255,0.3);
	width: 66%;
	float: right;
}
</style>
<%-- jquery --%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
	function call(deptid) {
		$.ajax({
			url:"empByDept.do",
			type:"post",
			data:{"deptid":deptid}, //"key이름":속성값 =>key이름을 읽음
			success: function(responseData) {
				$("#emplist").html(responseData);
			}
		});
	}
</script>
</head>
<body>
	<h1>binding연습2</h1>
	<p>1.ServletContext:${appData}</p>
	<p>2.HttpSession:${sessionData}</p>
	<p>3.HttpServletRequest:${requestData}</p>
	
	<div id="container">
		<div id="deptlist">
			<table border="1">
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서이름</th>
						<th>매니저</th>
						<th>지역</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dept" items="${deptlist}">
						<tr>
							<td>
							<%-- a를 눌렀을 때 call() 실행됨. --%>
							<a href="javascript:call(${dept.department_id})">${dept.department_id}</a>
							</td>
							<td>${dept.department_name}</td>
							<td>${dept.manager_id}</td>
							<td>${dept.location_id}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="emplist">
		
		</div>
	</div>
</body>
</html>