<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@page import="com.shinhan.emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <script src="/webproject/webapp/js/jquery-3.7.1.min.js"></script> -->
<!-- jquery Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

	#container{
		width: 1130px;
		/* border: 1px solid red; */
		margin: 0 auto;
	}
	
	table,th,td{
		border-collapse: collapse;
		text-align: center
		
	}
	th,td{
		padding:5px;
	}
	thead{
		background-color: lightblue;
		color: hotpink;
	}
	/* 칸을 띄우면 자손을 의미. */
	tbody tr:nth-child(2n){
		background-color: #ddd;
	}
	tbody tr:nth-child(2n+1){
		background-color: #fff;
	}
	caption{
		width:100%;
	}
	h1{
		font-size: 40px;
		height: 100px;
		text-align: center;
		line-height: 100px;
		color: #000;
	}
	a.decoNone{
		background-color: hotpink;
		color: #fff;
		padding: 10px;
		border-radius: 30px;
	}
	a{
		text-decoration: none;
		color: #000;
	}
	td[data-lname]{
		font-size: 20px;
		font-weight: bold;
	}
	td[data-lname ^= 'A']{
		color: red;
	}
	td[data-job ~= 'IT_PROG']{
		color: blue;
	}
	td[data-hdate |= '2005'],td[data-hdate $= '07']{
		color: lime;
	}
	td[data-phone *='123']{ /* 속성값 중에 123이 있는 td 요소 */
		color: yellow;
	}
	tr:has(td[data-phone *='423']){ /*td[]를 가지고 있는 tr행 전체를 변경한다. */
		color: purple;
	}
	
	/* data중에 첫번째 tr의 border,background의 색깔 바꾸기 */
	tbody tr:nth-child(1){
		background-color: orange;
	}
	tbody tr:nth-of-type(1){
		border: 3px dotted blue;
	}
	tr td:nth-of-type(1){
		background-color: yellow;
	}
	/*td:nth-child(4){
		border: 3px dotted blue;
	} 
	*/
	td:nth-child(3n){
		border: 7px dotted hotpink;
	}
	tbody tr:last-child{
		background-color: olive;
	}
	.caption::after, .caption::before{
		content: "@@@@@@@";	
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- jquery -->
<script>
	$(function() {
		//이메일 찾기
		$("#btn1").on("click", function() {
			$("tr td:nth-child(4)").css("color" , "black");
			$("tr td:nth-child(4)").filter(function(index, item) {
				//필터 조건
				if($(item).text().indexOf($("#email").val()) >= 0) return true;
				return false;
			}).css("color","hotpink");	
		});
		//급여 찾기 : salary >= 10000
		$("#btn2").on("click", function() {
			$("tr td:nth-child(8)").css("color" , "black");
			$("tr td:nth-child(8)").filter(function(index, item) {
				return  Number($(item).text()) >= Number($("#salary").val()) ;
			}).css("color" , "red");
		});
	});
</script>
</head>
<body>
	<div id="container">
		<h1>전체 직원 정보</h1>
		<button type="button" class="btn btn-outline-primary">Primary</button>
		<a class="decoNone" href="empInsert.jsp">신규 직원 등록</a>
		<a class="decoNone" href="empAll.jsp">직원 조회</a>
		<input type="text" id="email" value="@">
		<button id="btn1">이메일 찾기</button>
		<input type="number" id="salary" value="10000">
		<button id="btn2">급여 찾기</button>
		<table border="1">
			<caption class="caption">직원 목록</caption>
			<thead>
				<tr>
					<th>직원번호</th>
					<th>First_name</th>
					<th>Last_name</th>
					<th>Email</th>
					<th>Commission_pct</th>
					<th>Department_id</th>
					<th>Phone_number</th>
					<th>Salary</th>
					<th>Hire_date</th>
					<th>Manager_id</th>
					<th>Job_id</th>
				</tr>
			</thead>
			<tbody>
			<%
				EmpService eservice = new EmpService();
				List<EmpDTO> emplist = eservice.selectAll(); 
			%>
			<!-- 옛날 문법 java -->
			<% for(EmpDTO emp:emplist){ %>
				<tr>
					<td>
						<a href="empDetail.jsp?empid=<%=emp.getEmployee_id() %>">
							<%=emp.getEmployee_id() %>
						</a>
					</td>
					<td>
						<a href="empDetail.jsp?empid=<%=emp.getFirst_name() %>">
							<%=emp.getFirst_name() %>
						</a>
					</td>
					<td data-lname="<%=emp.getLast_name() %>">
						<%=emp.getLast_name() %>
					</td>
					<td>
						<%=emp.getEmail() %>
					</td>
					<td>
						<%=emp.getCommission_pct() %>
					</td>
					<td><%=emp.getDepartment_id() %></td>
					<td data-phone="<%=emp.getPhone_number() %>"><%=emp.getPhone_number() %></td>
					<td><%=emp.getSalary() %></td>
					<td data-hdate="<%=emp.getHire_date() %>"><%=emp.getHire_date() %></td>
					<td><%=emp.getManager_id() %></td>
					<td data-job="<%=emp.getJob_id() %>"><%=emp.getJob_id() %></td>
				</tr>
			<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>