package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/SecondServlet", "/second2"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기본)response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request : 요청
		String method = request.getMethod(); //요청 방식
		String addr = request.getRemoteAddr(); //요청 주소
		String cpath = request.getServletContext().getContextPath(); 
		String path = request.getServletContext().getRealPath("."); //현재 경로
		
		//response.getWriter() : 응답 문서
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//자바에서 html 적는 중(권장X)
		out.print("<h1>응답문서</h1>");
		out.printf("<p>method:%s</p>", method);
		out.printf("<p>addr:%s</p>", addr);
		out.printf("<p>cpath:%s</p>", cpath);
		out.printf("<p>path:%s</p>", path);
		//서블릿 : 서버에서 실행되는 자바프로그램 (Java!!! + HTML)
		//JSP: 서버에서 실행되는 자바프로그램 (Java + HTML!!!)
		
	}

}
