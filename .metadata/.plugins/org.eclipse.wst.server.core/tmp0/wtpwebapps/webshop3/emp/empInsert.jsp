<%@page import="com.shinhan.emp.JobDTO"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%-- 톰캣 태그 라이브러리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>empInsert</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- 부트스트랩 --%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<%-- jquery --%>
<script src="/webshop3/static/js/jquery-3.7.1.min.js"></script>
<script>
	$(function() {
		$("form").on("submit",call);
		
		//ID중복체크(ajax)
		$("#btnDupCheck").on("click", f_dupCheck);
	});
	
	function f_dupCheck() {//ID 중복 체크
		var empid = $("#employee_id").val();
		if(empid==""){
			alert("직원번호를 입력하세요");
			document.querySelector("#employee_id").focus();
			return;
		}
		//DB연결
		$.ajax({
			url:"empIdCheck.do",
			data:{"empid" : empid},
			type: "get",
			success: function(responseData) {
				var message = "";
				if(responseData == "0"){
					message = "사용가능";
				}else{
					message = "사용 불가능";
					$("#employee_id").val("");
					document.querySelector("#employee_id").focus();
				}
				$("#resultMessage").val(message);
			}, 
			error: function(data) {
				alert(data);
			}
		})
	}
	
	function call(event) {
		var salary = $("#salary").val();
		//alert(salary); 급여를 안써도 다음으로 넘어감.
		if(salary == "" || salary<=0){
			alert("salary값은 0보다 큰 값이어야 한다.");
			event.preventDefault(); //default이벤트 취소(서버 전송 취소)
			document.querySelector("#salary").focus();
		}
	}
</script>
</head>
<body>
	<div class="container mt-3">
	<a href="emplist.do">직원목록보기</a>
		<h2>신규 직원 등록</h2>
		
		<%-- post방식(서블릿 post에서 작업) --%>
		<form action="empInsert.do" method="post">
			<div class="mb-3 mt-3">
				<label for="employee_id">직원 번호 : </label>
				<input type="number" class="form-control" id="employee_id" placeholder="Enter number" name="employee_id" required>
				
				<%-- ID중복체크 추가 --%>
				<input type="button" value="중복체크" id="btnDupCheck">
				<input type="text" value="아이디 입력 후 중복체크" id="resultMessage">
				
			</div>
			<div class="mb-3 mt-3">
				<label for="first_name">이름 : </label>
				<input type="text" class="form-control" id="first_name" placeholder="Enter first_name" name="first_name">
			</div>
			<div class="mb-3 mt-3">
				<label for="last_name">last_name : </label>
				<input type="text" class="form-control" id="last_name" placeholder="Enter last_name" name="last_name" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="email">email : </label>
				<input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="phone_number">전화번호 : </label>
				<input type="text" class="form-control" id="phone_number" placeholder="Enter number" name="phone_number">
			</div>
			<div class="mb-3 mt-3">
				<label for="hire_date">입사일 : </label>
				<input type="date" class="form-control" id="hire_date" placeholder="Enter date" name="hire_date" required>
			</div>
			<div class="mb-3 mt-3">
			<%-- ScriptLet문법보다는 EL(반복문 없음), JSTL문법을 사용하는 것이 좋다. 
				for(JobDTO job:jlist){}
			--%>
				<label for="job_id">job_id : </label>
				<select name="job_id">
					<%-- JSTL태그 --%>
					<c:forEach items="${jlist}" var="job"> <%-- 1건이 job으로 들어옴. --%>
						<%--HTML태그, EL문법:${} --%>
						<option value="${job.job_id}" ${ empInfo.job_id == job.job_id ? "selected ":"" }>
							${ job.job_id } / ${ job.job_title }
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="salary">급여 : </label>
				<input type="number" class="form-control" id="salary" placeholder="Enter salary" name="salary">
			</div>
			<div class="mb-3 mt-3">
				<label for="commission_pct">커미션 : </label>
				<input type="text" class="form-control" id="commission_pct" placeholder="Enter commission_pct" name="commission_pct">
			</div>
			<div class="mb-3 mt-3">
				<label for="manager_id">매니져 번호 : </label>
				<select name="manager_id">
				<%--  
					<%
					//자바문법
					List<HashMap<String,Object>> mlist = (List<HashMap<String,Object>>)request.getAttribute("mlist");
					for(HashMap<String,Object> map:mlist){
					%>
					<option value="<%=map.get("employee_id")%>"><%=map.get("fullname") %></option>
					<% } %>
				--%>
				<c:forEach var="manager" items="${mlist}" > <%-- 값을 꺼내옴 --%>
					<option value="${ manager.employee_id }" ${ empInfo.manager_id == manager.employee_id ? "selected ":" " }>
							${ manager.employee_id } / ${ manager.fullname }
						</option>
				</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="department_id">부서번호 : </label>
				<select name="department_id">
					<%-- 
					<% 
					//set한 값을 get한다.
					//setAttribute("deptlist")를 get함.
					List<DeptDTO> dlist = (List<DeptDTO>)request.getAttribute("deptlist"); 
					for(DeptDTO dept:dlist){
					%>
					<option value="<%=dept.getDepartment_id() %>"><%=dept.getDepartment_name() %></option>
					<% } %> 
					--%>
					<c:forEach items="${deptlist}" var="dept">
						<option value="${ dept.department_id }" ${ empInfo.department_id == dept.department_id ? "selected ":" " }>
							${ dept.department_id } / ${ dept.department_name }
						</option>
					</c:forEach>
				</select>
				${dlist}
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>