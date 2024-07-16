package com.shinhan.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpService;


@WebServlet("/emp/empByDept.do")
public class EmpByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//요청(request)에 포함된 정보를 set(추가하거나 수정 등 변경)해서 다른 서블릿이나 jsp에 공유
		//DeptService ds = new DeptService(); 
		request.setAttribute("deptlist", new DeptService().selectAll());//new DeptService().selectAll()
		
		//jsp페이지로 요청과 응답 보내기
		request.getRequestDispatcher("empByDept.jsp").forward(request, response);
		
		//forward: 화면에 보여지는 것은 jsp페이지이고, 주소 창은 바뀌지 않음.(페이지 정보 알 수 없음)
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 부서의 직원들을 조회하기
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		
		request.setAttribute("emplist", new EmpService().selectByDeptId(deptid) );
		request.getRequestDispatcher("empByDept2.jsp").forward(request, response);
	}

}
