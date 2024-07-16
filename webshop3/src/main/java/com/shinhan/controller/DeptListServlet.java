package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;


@WebServlet("/dept/deptList.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		//리퀘스트에 저장
		request.setAttribute("deptlist", deptlist); //변수이름 같아도 됨.
		System.out.println("총 건수: " + deptlist.size());
		
		//페이지를 연결
		RequestDispatcher rd = request.getRequestDispatcher("deptList.jsp");
		rd.forward(request, response);
		
	}


}
