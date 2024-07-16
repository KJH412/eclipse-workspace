<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 톰캣 태그 라이브러리 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript">
	//1)Javascript 백틱 문법 : JSP문법과 혼란...JSP에서 백틱은 \$를 사용한다.
	var myname ="jh";
	var bb = `나의이름 \${myname}`;
	console.log(bb);
	//2)jQuery문법
	$(function() { 
		$("tr th").css("backgroundColor", "orange");
	});
	//3)JSP의 EL(Expression Language)문법
	var aa = "${emplist}"; 
	<%--4)JSTL문법(Tag Library) : <c:forEach....>  --%>

	function f_insert() {
		location.href='empInsert.do';
	}

</script>
</head>
<body>
<%-- 계속 작성될 공통 내용이므로 페이지를 따로 만들어서 붙여줌. loginHeader.jsp
	<h1>${loginEmp.first_name}님 환영합니다.</h1>
	<a href="../auth/logout.do">로그아웃</a>
	
	<%@ include file="../common/loginHeader.jsp" %>
--%>	
	<%--include지시자 : JSP를 합쳐서 컴파일 한다.--%>
	<%--include액션태그: 각각 컴파일 해서 합친다.--%>
	<jsp:include page="../common/loginHeader.jsp"></jsp:include>
	
	<h2>접속인원:${total_user }</h2>
	<ul>
	  <c:forEach var="user" items="${user_list}">
	    <li>${user}</li>
	  </c:forEach>
	</ul>
	
	<%-- 
	<h1>세션에서 읽기: ${memberid}</h1>
	<h1>세션에서 읽기: ${memberpass}</h1>
	Session, ServletContext
	<h1>myinfo(다른 서블릿의 request를 접근불가): ${myinfo }</h1>
	<h1>myinfo2(같은 브라우저로 접근하면 session접근 가능): ${myinfo2}</h1>
	<h1>myinfo3(ServletContext는 모든 서블릿에서 접근 가능,모든 사용자가 공유): ${myinfo3}</h1>
	
	<p>다음은 주소창에 주소를 바꾸는 방법(재요청)</p>
	<a href="empInsert.do">신규직원등록</a> 주소가 변경된다.
	<a href="javascript:location.href='empInsert.do">신규직원등록</a> 주소가 변경된다.
	<button onclick="location.href='empInsert.do'">신규직원등록</button> 
	<button onclick="f_insert()">신규직원등록4</button> 

	<form action="empInsert.do">
		<input type="sumbit" value="신규직원등록5">
	</form>
	--%>
	<hr>
	<h1>직원 목록</h1>
	<a href="retrieve.do">조건조회</a>
	<table border="1">
		<thead>
			<tr>
				<th>직원번호</th>
				<th>이름</th>
				<th>성</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>직책</th>
				<th>급여</th>
				<th>부서</th>
				<th>매니저</th>
				<th>커미션</th>
				<th>입사일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<%-- 서블릿에서 setAttribute("emplist", empAll)에서 "이름"으로 get! 
			var는 1건의 값이 담길 변수명을 써주면 된다. --%>
			<c:forEach items="${emplist}" var="emp">
				<tr>
					<td>
						<a href="empDetail.do?empid=${emp.employee_id}">
							${emp.employee_id}
						</a>
					</td>
					<td>${emp.first_name}--(${fn:length(emp.first_name)})</td>
					<td>${emp.last_name}</td>
					<td>${emp.email}</td>
					<td>${emp.phone_number}</td>
					<td>${emp.job_id}</td>
					<td>
						<fmt:formatNumber value="${emp.salary}" groupingUsed="true" 
						type="currency" currencySymbol="\\" />
					</td>
					<td>${emp.department_id}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.commission_pct}</td>
					<td>
						<fmt:formatDate value="${emp.hire_date}" type="both" pattern="YYYY/MM/dd hh:mm:ss"/>
					</td>
					<td>
						<%-- 
							 empdelete.do로 가고 클릭한empid를 가져간다. 
							 location.href는 get방식.
						--%>
						<button onclick="location.href='empDelete.do?empid=${emp.employee_id}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>