<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@page import="com.shinhan.dept.DeptDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--  isELIgnored 안쓰면 기본 false이다. --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어</title>
</head>
<body>
<h1>EL연습</h1>
<%
Integer a = 100;
String b = String.valueOf(100);
request.setAttribute("score", 100);
int score2 = 300;
request.setAttribute("greeting","hello");
request.setAttribute("dept", new DeptDTO(10,"개발",100,1700)); //dept에 값이 들어감(저장됨)

//pageContext > request > session > application : 이름이 같을 때 순서
pageContext.setAttribute("data1", 10);
request.setAttribute("data1", 20);
session.setAttribute("data1", 30);
application.setAttribute("data1", 40);

String p1 = request.getParameter("a");
String p2 = request.getParameter("b");

/* 실제로 여기서 하진 않음. 서블릿에서 했다고 생각 */
DeptService service = new DeptService();
List<DeptDTO> deptlist = service.selectAll();
request.setAttribute("deptlist", deptlist);

HashMap<String,Integer> cart = new HashMap<>();
cart.put("아메리카노", 10);
cart.put("latte", 20);
request.setAttribute("cart", cart);

/* 안에 들어 있는 값도 객체일 때 */
HashMap<String, List<DeptDTO>> cart2 = new HashMap<>();
cart2.put("부서", deptlist);
request.setAttribute("cart2", cart2);


%>
<pre>
1. boolean : ${10>20}
2. string: ${"Hello"} 100
3. null: ${null+100}
4. score: ${score+200} ....."${score2}"
5. score2 : <%=score2%>
6. 나누기: ${10/3}
<%-- 6. 나누기: ${10 div 3} --%>
6. 나누기: ${10 mod 3}
7. 비교: ${"hello"==greeting} ....${greeting}
7. 비교 : ${"hello" eq greeting}
8. 논리 : ${score>=100 && greeting != "hello" }
8. 논리 : ${score>=100 || greeting != "hello" }
8. 논리 : ${score>=100 != greeting != "hello" }
9. dept toString() : ${dept}
9. dept getter호출됨 : ${dept.department_name}
9. dept empty : ${empty dept}
9. dept not empty : ${not empty dept}
10. scope : ${data1}
10. pageScope : ${pageScope.data1}
10. requestScope : ${requestScope.data1}
10. sessionScope : ${sessionScope.data1}
10. applicationScope : ${applicationScope.data1}
11. param : ${param.a } ....<%=p1 %>
11. param : ${param.b } ....<%=p2 %>
12. Collection 읽기 : ${deptlist[0].department_name}
12. Collection 읽기 : ${deptlist[1].department_name}
13. map 읽기: ${cart["아메리카노"]}
13. map 읽기: ${cart.latte}
14. map안에 list 접근 : ${cart2["부서"][0].department_name}


</pre>
<ul>
	<p>키와 값▼</p>
	<c:forEach items="${cart}" var="mycart">
		<li>${mycart.key}</li>
	</c:forEach>
</ul>
<ul>
	<p>부서 개수 만큼 loop 돌면서 찍음▼</p>
	<c:forEach items="${deptlist}" var="dept">
		<li>${dept}</li>
	</c:forEach>
</ul>
</body>
</html>