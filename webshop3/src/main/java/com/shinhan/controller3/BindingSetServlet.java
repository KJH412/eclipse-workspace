package com.shinhan.controller3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/jsp/set")
public class BindingSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==============setting================");
		
		//request.setAttribute("myinfo", request.getParameter("myname")); //값을 읽어옴. 
		//--> 넘어오는 값의 이름이 myname이고 내가 값을 저정한 이름은 myinfo (index.html)
		//ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		
		
		String myname = request.getParameter("myname");
		request.setAttribute("myinfo", myname);
		session.setAttribute("myinfo2", myname);
		context.setAttribute("myinfo3", myname);
		String my = (String)context.getAttribute("myinfo3");
		System.out.println("ServletContext저장된 myinfo3" + my);
		
		//web.xml 등록된 파라미터 읽어옴.
		String menu_member = context.getInitParameter("menu_member"); //getInitParameter:문자
		String menu_order = context.getInitParameter("menu_order"); 
		System.out.println("menu_member: " + menu_member);
		System.out.println("menu_order: " + menu_order);
		
		//[예제292p]리소스 읽기 
		InputStream is = context.getResourceAsStream("WEB-INF/config/init.txt");
		//한 줄 씩 읽음 (stream(1바이트)>Reader(2바이트 읽음)>BufferdReader(한 줄 읽음)
		BufferedReader br = new BufferedReader(new InputStreamReader(is)); //reader는2바이트처리, stream은1바이트처리
		String line = null;
		while((line = br.readLine()) !=null){
			System.out.println(line);
		}
		
		
		
		
		
		//화면에 보여지는 jsp
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("get.jsp"); 
		rd.forward(request, response);
		
		
	}


}
