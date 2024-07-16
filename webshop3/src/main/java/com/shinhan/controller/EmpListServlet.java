package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		//EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");
		//이 조건을 만족하지 않으면 로그인x. 비즈니스 로직 수행x
		//if(emp == null) {
			//로그인 되어 있지 않으면 브라우저로 내려가서 로그인 창으로 재요청(sendRedirect)
			//response.sendRedirect("../auth/login.do");
			//return; 
		//}
		
		//비즈니스로직		
		EmpService eService = new EmpService();
		List<EmpDTO> empAll = eService.selectAll();
		System.out.println(empAll.size() + "건 조회됨");
		
		//내가 받은 요청에 추가함. (request에 저장.)
		//=> 요청문서에 추가로 저장함
		request.setAttribute("emplist", empAll); //"emplist"->이 이름으로 추가 저장한다. (jsp에서 ${emplist}로 getter할 수 있다.)
		
		//페이지를 연결
		//Dispatcher : 위임. 요청은 서블릿이 받았는데 응답은 JSP가 한다.
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response); //요청과 응답을 넘긴다. 
		//response가 전달되었다는 것은 '서블릿 대신 JSP가 응답한다'의 의미다.
		//response해야 document에 보여줌.(사용자가 볼 수 있음)
		//(내가 적은 주소(매핑한이름)는 주소창에 그대로 있고, 내용은 다른 내용이면 forward한 것이다.)
	}


}
