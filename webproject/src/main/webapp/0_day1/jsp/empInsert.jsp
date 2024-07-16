<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert</title>
<style type="text/css">
	body{
		background-color: lightblue;
	}
	
/* 
inline: content만큼만 자리차지, label, input
block : 한 라인 자리 차지.
inline-block: inline요소가 block특징을 가질 수 있음.
*/
	#container{
		background-color: #fff;
		text-align: center;
		border-radius: 30px;
		width: 400px;
		margin: 0 auto;
		padding:30px;
	}
	h1{
		text-align: center;
		color:#fff;
	}
	label{
		display:inline-block;
		text-align: left;
		width: 120px;
		height: 20px;
	    margin: 5px;
	    font-size: 14px;
	}
	input{
		border: 1px solid #ddd;
		border-radius: 10px;
		width: 200px;
   	    height: 20px;
    	text-align: center;
	}
	
	legend{
		text-align: left;
		background: #ddd;
    	border-radius: 20px;
    	color: #fff;
  		padding: 5px 15px;
	}

	fieldset{
		border:1px solid #ddd;
	    border-radius: 15px;
        text-align: center;
        margin: 10px 0;
	}
	.btn{
	    background-color: #333333;
	    color: #fff;
	    height: 35px;
	    width: 49%;
	}
	/* 속성 선택자 */
	/* input요소에 value속성이 존재하는가? */
	input[value]{
		background-color: yellow;
	}
	input[type="submit"],input[type="reset"]{
		background-color: lightpink;
	}
	.aa>label{
		background-color: skyblue;
	}
	input:focus{
		background-color: beige;
	}
	label:hover,input[type="submit"]:hover{
		background-color: green; 
	}
	
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
	//이메일 중복 체크
	$(function() {
	 $("#btnDupCheck").on("click", f_dupCheck);	
	});
	function f_dupCheck() {
		$.ajax({
			url:"/webproject/0_day8/emailCheck.jsp",
			type:"get",
			data: {email: $("input[name='email']").val()},
			success: function(responseText) {
				//alert(responseText);
				var message = "";
				if(responseText == 1){
					message = "이미존재한다.(사용불가)"
					
				}else{
					message = "사용가능";
				}
				console.log(responseText);
				$("#message").html(message);
			}
		});
	}
</script>
</head>
<body>
	<h1>신규 직원 등록</h1>
	<%-- 
		JSP주석 : JSP문서를 보는 사람을 위한 설명
	 --%>
	<!-- 
		HTML주석 : 개발자에게 코드를 설명하기 위함.
		method를 생략하면 get이다.
		method= "get" => 주소 창에 서버에 전달되는 파라미터가 노출된다.(주소창에서 읽음) 자동으로 인코딩된다.(한글)  (자리 수 제한이 있음. 4096byte)
		method= "post" =>주소 창에 서버에 전달되는 파라미터가 보이지 않는다. 요청문서의 body에 넘어간다.(body에서 읽음)
		submit버튼을 누르면 자동으로 form의 action으로 간다. (input을 action에 전달한다.)
		***input태그에 name을 전달한다.(name이 parameter이름이다.)
		
		name : 문서 내에서 같은 이름이 여러개 가능하다.
		id : 문서 내에서 유일.
		
	 -->
	 <div id="container">
		<form name="myFrm1" action="empDBInsert.jsp" method="post">
			<fieldset class="aa">
				<legend>필수 항목</legend>	
				
				<label>직원번호</label>
				<input type="number" name="employee_id" id="employee_id"><br>
				
				<label>last_name</label>
				<input type="text" name="last_name"><br>
				
				<label>email</label>
				<input type="email" name="email">
				<input id="btnDupCheck" type="button" value="중복체크">
				<span id="message"></span>
				<br>
				
				<label>hire_date</label>
				<input type="date" name="hire_date"><br>
				
				<label>job_id</label>
				<input type="text" name="job_id" value="IT_PROG"><br>
			</fieldset>
			<fieldset>
				<legend>선택 입력</legend>	
				
				<label>first_name</label>
				<input type="text" name="first_name"><br>
				
				<label>phone_number</label>
				<input type="text" name="phone_number"><br>
				
				<label>salary</label>
				<input type="number" name="salary" value="0"><br>
				
				<label>commission_pct</label>
				<input type="text" name="commission_pct" value="0.0"><br>
				
				<label>manager_id</label>
				<input type="number" name="manager_id" value="100"><br>
				
				<label>department_id</label>
				<input type="number" name="department_id" value="100"><br>
			</fieldset>
			<input class="btn" type="submit" value="DB입력">
			<input class="btn"  type="reset" value="초기화">
		</form>
	</div>
</body>
</html>







