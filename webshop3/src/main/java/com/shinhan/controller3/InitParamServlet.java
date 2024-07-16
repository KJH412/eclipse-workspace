package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
@WebServlet(
		urlPatterns = { 
				"/InitParamServlet", 
				"/init", "/init2"
		}, 
		initParams = { 
				@WebInitParam(name = "myname", value = "jung"), 
				@WebInitParam(name = "email", value = "email@naver.com"),
				@WebInitParam(name = "phone", value = "010-1234-5678")
		})
*/
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public InitParamServlet() {
		System.out.println("InitParamServlet 생성자");
	}
	@Override
	public void destroy() {
		System.out.println("InitParamServlet 소멸자");
	}

	
	@Override
	public void init() throws ServletException {
		System.out.println("InitParamServlet 초기화");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = getInitParameter("myname");
		String b = getInitParameter("email");
		String c = getInitParameter("phone");
		System.out.println(a+":"+b+":"+c);
	}

}