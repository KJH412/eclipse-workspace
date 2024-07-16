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
	<%-- 절대경로 저장  c:set = setAttribute, ${path}로 확인 해보기 --%>
	<c:set var="path" value="${pageContext.request.servletContext.contextPath}/board" ></c:set>
	<c:set var="cpath" value="${pageContext.request.servletContext.contextPath}" ></c:set>
	
	<%-- 특수문자 출력 조작 --%>
	<%--
	&lt<br>
	<c:out value="&lt;" escapeXml="true"></c:out><br>
	<c:out value="&amp;" escapeXml="true"></c:out><br>
	<c:out value="&amp;" escapeXml="false"></c:out><br>
	<c:out value="&lt;" escapeXml="false"></c:out><br>
	 --%>
	 <script src="${cpath}/static/js/jquery-3.7.1.min.js"></script>
	 <script>
		$(function() {
			$("#btnJSON").on("click", f_jsonCall);
			$("#btnJSON2").on("click", f_jsonCall2);
		});
		
		function f_jsonCall2() {
			var output = "<ul>"
			$.ajax({
				url: "${cpath}/json2",
				type:"get",
				success:function(responseData){//받음
					console.log(responseData);
					var obj = JSON.parse(responseData);
					var boardlist = obj["boardlist"];// 자바스크립트에서 객체의 속성 읽어오기
					
					$.each(boardlist, function(index, item){
						console.log(item);
						output += "<li>"+item.title+"</li>"
					});
					output += "</ul>"
					$("#here").html(output);
				},
				error:function(err){
					alert(err);
				}
			});
		}
		
		function f_jsonCall() {
			//json아님 javascript오브젝트임. 
			var boardObj = {bno:100, title:"커피", content:"제일 맛있는 집", writer:"익명"};
			//js오브젝트를 json으로 만들기
			var boardStr = JSON.stringify(boardObj); //문자열
			
			console.log(boardObj);
			console.log(boardObj.title);
			console.log(boardStr); //json-string확인
			
			$.ajax({
				/*
				url:"/webshop3/json"  => html확인
 				(jsp el문법인 ${cpath}는 서버에서 해석된다.)
				*/
				url:"${cpath}/json", //AjaxJsonServlet.java
				type:"get",
				data: {"jsonInfo" : boardStr},
				success:function(responseData){
					console.log(responseData);
				},
				error:function(errorInfo){
					alert(errorInfo);
				}
				
			});
		}
	</script>
	 <button id="btnJSON">JSON보내기(JS->자바서버)</button>
	 <button id="btnJSON2">JSON받기(자바서버->JS)</button>
	 <div id="here"></div>
	 
	<a href="${path}/boardInsert.do">게시글 등록</a>
	
	<h1>Board목록</h1>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>pic</th>
			<th>작성일</th>
		</tr>
		<%-- 서블릿에서 가져온 것 : ${boardlist}을 var변수에 담는다. --%>
		<c:forEach var="board" items="${boardlist}">
			<tr>
			<%-- DTO이름을 쓰면 된다. --%>
				<td>
					<a href="${path}/boardDetail.do?bno=${board.bno}">${board.bno}</a>	<%--a태그 GET방식 --%>
				</td>
				<td>${board.title}</td>
				<td>${board.content}</td>
				<td>${board.writer}</td>
				<td>${board.pic}
				<%-- DB에는 이미지 경로만 넣어 놓고 작성 --%>
					<img alt="${board.title}" 
						 src="${cpath}/upload/${board.pic}" width="50" height="50">
					<a href="${cpath}/download.do?fileName=${board.pic}">내려받기</a>
				</td>
				<td>${board.create_date}</td>
				<td>
					<button onclick="location.href='${path}/boardDelete.do?bno=${board.bno}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>