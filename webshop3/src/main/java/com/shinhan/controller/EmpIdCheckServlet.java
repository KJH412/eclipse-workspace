package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;


@WebServlet("/emp/empIdCheck.do")
public class EmpIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		//이미 존재하는 직원id
		EmpDTO emp = service.selectById(empid);
		String message = "1";
		
		if(emp == null) { //null이면 없는 아이디라 사용가능
			message = "0";
		}
		
		//response.setCharacterEncoding("utf-8");
		//문자열(message)이 응답으로 간다. jsp에서 ajax사용
		response.getWriter().append(message); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
