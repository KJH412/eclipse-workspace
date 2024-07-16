package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.emp.JobDTO;
import com.shinhan.util.DateUtil;


@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	//GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//부서 조회
		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		request.setAttribute("deptlist", dlist); //"deptlist"를 읽어옴.
		
		//전체 매니저 조회
		EmpService eservice = new EmpService();
		List<HashMap<String,Object>> mlist = eservice.selectAllManager();
		request.setAttribute("mlist", mlist); 
		
		//전체 JOB_ID
		List<JobDTO> joblist = eservice.selectAllJob();
		request.setAttribute("jlist", joblist); 
		
		//JSP로 forward
		RequestDispatcher rd= request.getRequestDispatcher("empInsert.jsp"); //"./empInsert.jsp"
		rd.forward(request, response); 
	}
	//POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식 인코딩 필요.
		//요청문서에 내용을 담아서 온다. 자동 encoding 안됨.
		/*
		 * request.setCharacterEncoding("utf-8"); //1문자가 3byte임을 설정.
		 * =>Filter로 처리 대체
		 */
		
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empInsert(emp);
		System.out.println(result + "건 입력됨");
		
		request.setAttribute("message", result + "건 입력됨");
		
		//1)JSP에 응답을 위임하는 경우 (MVC2모델)
		RequestDispatcher rd= request.getRequestDispatcher("result.jsp"); 
		rd.forward(request, response); 
		
		//2)서블릿이 직접 응답을 하는 경우 (응답문서만들기)
		//response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter(); 
		//out.write("<h1>서블릿이 직접 응답을 하는 경우</h1>");
	}

	private EmpDTO makeEmp(HttpServletRequest request) {
		//Enumeration: 한정된 값의 나열을 의미.
		Enumeration<String> colnames = request.getParameterNames();//여러개를 읽음.
		while(colnames.hasMoreElements()) {
			String col = colnames.nextElement();
			System.out.println(col + "=>" + request.getParameter(col));
		}
		
		EmpDTO emp = new EmpDTO();
		//int empid = request.getParameter("employee_id"); 
		//파라미터로 넘어옴. 파라미터 String으로 들어오는 정수 변수는 int로 변환
		int empid = convertInt(request.getParameter("employee_id"));
		int salary = convertInt(request.getParameter("salary"));
		int did = convertInt(request.getParameter("department_id"));
		int mid =  convertInt(request.getParameter("manager_id"));
		double commission = convertDouble(request.getParameter("commission_pct"));
		Date hdate =DateUtil.getSQLDate(request.getParameter("hire_date"));
		String jobid = request.getParameter("job_id");
		String phone = request.getParameter("phone_number");
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		
		emp.setEmployee_id(empid);
		emp.setEmail(email);
		emp.setJob_id(jobid);
		emp.setCommission_pct(commission);
		emp.setDepartment_id(did);
		emp.setManager_id(mid);
		emp.setSalary(salary);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);;
		emp.setPhone_number(phone);
		emp.setHire_date(hdate);
		return emp;
	}
	//double타입 변환
	private double convertDouble(String parameter) {
		if(parameter == "") return 0;
		return Double.parseDouble(parameter);
	}
	//int타입으로 변환
	private int convertInt(String parameter) {
		if(parameter == "") return 0;
		return Integer.parseInt(parameter);
	}

}
