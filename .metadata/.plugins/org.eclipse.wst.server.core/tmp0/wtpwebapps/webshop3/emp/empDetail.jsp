<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empDetail</title>
</head>
<body>
	<!-- include지시자는 파일을 합쳐서 컴파일한다. -->
	<%@ include file="../common/loginHeader.jsp" %>
	<h1>직원 상세보기</h1>
	<%-- .getEmployee_id와 같음.
	<p>${empInfo.employee_id}</p>
	<p>${empInfo.first_name}</p>
	<p>${empInfo.salary}</p>
	 --%>
	 
<%-- ------------
	emplist.do주소의 페이지에서 선택한 '직원번호'에 해당하는 '회원 정보'를 input의 value로 받아(get) 보여준다. 
	empInsert.do의 form을 복사해왔음. -> 바로 수정 가능하도록 insert폼과 같음.
------------ --%>
 	<form action="empDetail.do" method="post">
		<div class="mb-3 mt-3">
			<label for="employee_id">직원 번호 : </label>
			<input type="number" class="form-control" id="employee_id" 
			placeholder="Enter number" name="employee_id" value="${empInfo.employee_id}">
		</div>
		<div class="mb-3 mt-3">
			<label for="first_name">이름 : </label>
			<input type="text" class="form-control" id="first_name"
			 placeholder="Enter first_name" name="first_name" value="${empInfo.first_name}">
		</div>
		<div class="mb-3 mt-3">
			<label for="last_name">last_name : </label>
			<input type="text" class="form-control" id="last_name"
			 placeholder="Enter last_name" name="last_name"  value="${empInfo.last_name}">
		</div>
		<div class="mb-3 mt-3">
			<label for="email">email : </label>
			<input type="text" class="form-control" id="email" 
			placeholder="Enter email" name="email"  value="${empInfo.email}">
		</div>
		<div class="mb-3 mt-3">
			<label for="phone_number">전화번호 : </label>
			<input type="text" class="form-control" id="phone_number" 
			placeholder="Enter number" name="phone_number" value="${empInfo.phone_number}">
		</div>
		<div class="mb-3 mt-3">
			<label for="hire_date">입사일 : </label>
			<input type="date" class="form-control" id="hire_date" 
			placeholder="Enter date" name="hire_date" value="${empInfo.hire_date}">
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
					<option value="${job.job_id}" ${empInfo.job_id==job.job_id?"selected":""} >
						<%-- ${job.job_title} --%>
						<%-- empInfo에 있는 job_id와 foreac속 job의 job_id가 같은지?true:false => 삼항연산자 --%>
						${job.job_id}/${job.job_title}
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3 mt-3">
			<label for="salary">급여 : </label>
			<input type="number" class="form-control" id="salary" 
			placeholder="Enter salary" name="salary" value="${empInfo.salary}">
		</div>
		<div class="mb-3 mt-3">
			<label for="commission_pct">커미션 : </label>
			<input type="text" class="form-control" id="commission_pct" 
			placeholder="Enter commission_pct" name="commission_pct" value="${empInfo.commission_pct}">
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
			<c:forEach var="manager" items="${mlist}" > <%-- get : 값을 꺼내옴 --%>
				<option value="${manager.employee_id}"
				${empInfo.manager_id == manager.employee_id?"selected":""}>
					${manager.employee_id} / ${manager.fullname}
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
		</div>
		<input type="submit" class="btn btn-primary" value="수정하기">
	</form>
</body>
</html>