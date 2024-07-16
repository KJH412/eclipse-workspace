package com.shinhan.controller3;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//URL패턴은 가상의 이름 (주소창에 "/jsp/scope"가상이름 입력하면 scope.jsp로 간다.)
//@WebServlet("/jsp/scope")
//@WebServlet("/jsp/scope/*")
@WebServlet("*.go")
//@WebServlet("/*")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		request.setAttribute("mydata", 100);
		session.setAttribute("mydata", 200);
		application.setAttribute("mydata", 300);
		
		request.setAttribute("mydata1", 10);
		session.setAttribute("mydata2", 20);
		application.setAttribute("mydata3", 30);
		
		// "/jsp/scope" 일때,
		//request.getRequestDispatcher("scope.jsp").forward(request, response);
		// "/jsp/scope/*" 일때,
		//request.getRequestDispatcher("../scope.jsp").forward(request, response);
		
		//절대 경로 사용하기
		String path = getServletContext().getContextPath();
		System.out.println(path); // => /webshop3
		request.getRequestDispatcher(path + "jsp/scope.jsp").forward(request, response);
		
		//서블릿의 default경로는 http://localhost:9090/webshop3
		//JSP, HTML, default경로는 http://localhost:9090
		
		
		
	}

	

}
