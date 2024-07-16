package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;


@WebServlet("/dept/deptInsert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
	}

	//POST (실제로 DB입력)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//부서 이름 등 문자에 한글이 들어 올 수 있기 때문에 인코딩.
		request.setCharacterEncoding("utf-8"); 
		//입력값으로 들어오는 input의 name을 파라미터로 읽는다.
		//int정수 타입으로 변환Integer.parseInt()
		
		int deptid = Integer.parseInt(request.getParameter("department_id")); 
		String deptname = request.getParameter("department_name");
		int mid =  Integer.parseInt(request.getParameter("manager_id"));
		int loc =  Integer.parseInt(request.getParameter("location_id"));

		//주의!!!!!DTO의 필드변수 생성자의 파라미터 순서랑 똑같이 new객체()에 넣어줘야 한다.
		DeptDTO dept = new DeptDTO(deptid, deptname, mid, loc);
		
		DeptService service = new DeptService();
		int result = service.deptInsert(dept); // insert 된 결과 건 수 => int로 return
		
		System.out.println(result + "건 입력됨.");
		
		/*
		 * //text/html;charset=utf-8 : html타입 인 것을 알려준다.
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>" + result + "건 입력됨</h1>");
		
		=>JSP로 응답을 보내는 것이다. request로 JSP로 변환하는 것(RequestDispatcher)과 동시에 쓸 수없음!! 
			response.getWriter()를 사용하면 html을 직접 다 작성해서 붙여야하기 때문에 권장x.
		***응답은 한 개만 존재함.
		*
		 */
		
		//message
		request.setAttribute("message", result); //jsp에서 ${message}로 값이 수정 출력됨.
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
				
		//===> 요청은 서블릿, 응답은 JSP로 한다.	
	}

}
