package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jsp/setSession")
public class SetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getSession() : true
		HttpSession session = request.getSession(); 
		System.out.println("신규?" + session.isNew());
		System.out.println("getCreationTime: "+ session.getCreationTime());
		System.out.println("getLastAccessedTime: "+ session.getLastAccessedTime());
		System.out.println("getLastAccessedTime: "+ session.getMaxInactiveInterval());
		System.out.println("getId: " + session.getId());
		
		//파라미터 읽어서 세션에 저장
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpw");
		session.setAttribute("memberId", id);
		session.setAttribute("memberPass", pass);
	}


}
