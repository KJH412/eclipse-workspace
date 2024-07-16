<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조건 조회</title>
<script src="${pageContext.request.servletContext.contextPath}/static/js/jquery-3.7.1.min.js"></script>
<%-- 
pageContext(현재페이지)에 어떻게 요청(request)이 들어오는지 확인. contextPath:/webshop3 
${pageContext.request.servletContext.contextPath}
--%>
<script>
	$(function() {
		$("#btn1").on("click", f1);
	});
	function f1() {
		var job_id = $("#job_id").val();
		var dept_id = $("#dept_id").val();
		var salary = $("#salary").val();
		var hiredate = $("#hiredate").val();
		
		//---
		//조건 결과를 Ajax로 데이터를 현재 페이지 #here로 가져오기.
		//---
		$.ajax({
			url:"retrieve.do", //url의 post로 간다.
			type:"post",
			//▼ js오브젝트임.(json아님) 파라미터로 넘어가서 request.getParameter()로 읽는다.
			//=> retrieve.do?job_id=~~이런식으로 쓰는 것 대신 데이터가 파라미터 key:value로 간다.
			data:{"job_id":job_id, "dept_id":dept_id, "salary":salary, "hiredate":hiredate},
			success:function(responseData){//(responseData)에 실패,성공이 올 수 있음.
				//입력성공,입력실패는 이곳.
				$("#here").html(responseData);
			},
			error:function(xhr, status, error){
				alert(error); //Ajax가 실패(보안실패,주소오류 등)
			}
		})
	};
	function call(empid){ //파라미터로 직원id를 받음.
		//ajax로 empid를 데이터 서버(empDetail.do)로 보냄.
		$.ajax({
			url:"empDetail.do",
			type:"get",
			data:{"empid":empid},
			success: function(responseData){ //empDetail.jsp가 넘어옴.
				$("#here2").html(responseData);
			}
		})
	}
</script>
</head>
<body>
	<h1>직책 목록</h1>
	직책선택:
	<select id="job_id">
		<%-- 서블릿에서 set어트리뷰트한 이름을 get기능인 ${}문법 안에 써준다. --%>
		<c:forEach var="job" items="${job_datas}">
			<option value="${job.job_id}" ${job.job_id=='IT_PROG'?"selected":""} >${job.job_id} / ${job.job_title}</option>
		</c:forEach>
	</select>
	부서선택:
	<select id="dept_id">
		<%-- 서블릿에서 set어트리뷰트한 이름을 get기능인 ${}문법 안에 써준다. --%>
		<c:forEach var="dept" items="${dept_datas}">
			<option value="${dept.department_id}" ${dept.department_id=='60'?"selected":""} >${dept.department_id} / ${dept.department_name}</option>
		</c:forEach>
	</select>
	급여(이상):<input type="number" id="salary" value="1000">
	입사일(이후):<input type="date" id="hiredate" value="2005-01-01">
	<button id="btn1">조건조회</button>
	<hr>
	<div id="here">여기</div>
	<div id="here2">여기2</div>
</body>
</html>