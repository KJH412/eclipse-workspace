package com.shinhan.controller2;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.util.DateUtil;

@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//empid는 파라미터request로 넘어온다.
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		
		//새로운 요청으로 보내기...주소창의 주소가 바뀐다. (sendRedirect)
		//브라우저로 내려갔다가 다시 서버에 새로운 요청을 한다.
		
		//1)
		response.sendRedirect("emplist.do");
		//삭제하고 조회페이지로 이동됐을 때 주소창에 삭제주소가 그대로 남아있게 된다. X
		//request.getRequestDispatcher("emplist.do").forward(request, response);
		
		//2)
		//response.addHeader("Refresh", "3;emplist.do"); //jsp meta태그에 쓴 것과 같음. 
		
		//3)
		//forward는 받은 요청을 다른 페이지에 위임한다. 주소가 바뀌지 않는다.
		//request.setAttribute("message", result + "건 삭제됨.");
		//request.getRequestDispatcher("result.jsp").forward(request, response);//지정한 jsp페이지로 forward 한다.
		
	
	}
	

}
