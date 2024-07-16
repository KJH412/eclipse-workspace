<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container mt-3">
		<h2>Stacked form</h2>
		<form action="login.do" method="post">
			<div class="mb-3 mt-3">
				<label for="email">Email:</label> 
				<input type="text" class="form-control" id="email" name="email"> <%--value="SKING" 아이디 --%>
			</div>
			<div class="mb-3">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" id="pwd"
					name="pswd"> <%-- value="515.123.4567" 비밀번호 --%>
			</div>
			<div class="form-check mb-3">
				<label class="form-check-label"> 
				<input class="form-check-input" type="checkbox" id="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<script src="../static/js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("form").on("submit", f);
			$("#email").val(localStorage.getItem("email"));
			$("#pwd").val(localStorage.getItem("pwd"));
			var checkStatus = localStorage.getItem("checkStatus");
			if(checkStatus == 1){
				$("#remember").prop("checked", true);
			}
		});
		function f() {
			var check = $("#remember").prop("checked");
			if(check){ //true
				localStorage.setItem("email", $("#email").val() );
				localStorage.setItem("pwd", $("#pwd").val() );
				localStorage.setItem("checkStatus", 1 );
			}else{
				localStorage.removeItem("email");
				localStorage.removeItem("pwd");				
				localStorage.removeItem("checkStatus");				
			}
		}
	</script>
</body>
</html>
