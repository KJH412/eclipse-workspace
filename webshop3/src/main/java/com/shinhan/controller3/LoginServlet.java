package com.shinhan.controller3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.filter.MySessionListener;

//같은 코드를 넣기 보다 Filter를 통해서 원하는 곳에 넣어준다.

//@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	List<String> user_list = new ArrayList<>();
	
	
	//GET 페이지만 보여줌.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login 창 보여주기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp"); //login서블릿과 같은경로 auth/...
		rd.forward(request, response);
	}

	//POST 입력한 값에 따라 조건, 세션에 저장-업무 수행 , 결과페이지 보여줌.
	//버튼 클릭했을 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 입력한 ID, Password 검사
		ServletContext app = getServletContext();
		EmpService service = new EmpService();
		
		String email = request.getParameter("email");
		String phone = request.getParameter("pswd");
		
		EmpDTO emp = service.loginCheck(email, phone);
		
		if(emp==null || emp.getEmployee_id() == -1) {
			//존재하지 않는 직원
			request.setAttribute("message", "존재하지 않는 직원");
		}else if(emp.getEmployee_id() == -2) {
			//비밀번호 오류
			request.setAttribute("message", "비밀번호 오류");
		}else {
			//로그인 성공
			HttpSession session = request.getSession();
			MySessionListener loginUser = new MySessionListener(email, phone);
			
			System.out.println("새로운 세션인가?" + session.isNew());
			
			session.setAttribute("loginUser", loginUser);
			user_list.add(email);
			app.setAttribute("user_list", user_list);
			app.setAttribute("total_user", MySessionListener.getTotal_user());
			
			
			//로그인 정보 담음.
			session.setAttribute("loginEmp", emp); 
			String remember =request.getParameter("remember");
			//System.out.println(remember);
			session.setAttribute("kind", remember);
			
			
			String lastAddress = (String)session.getAttribute("lastRequest");
			if(lastAddress==null || lastAddress.length()==0) {
				lastAddress = getServletContext().getContextPath();
			}else {
				return "redirect:";
			}
			response.sendRedirect(lastAddress);
			return "redirect:" + lastAddress;
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request,response);
	}

}
