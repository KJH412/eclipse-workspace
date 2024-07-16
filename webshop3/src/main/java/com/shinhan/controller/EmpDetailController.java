package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
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

/**
 * http://ip:post/contextpath/emp/empDetail
 */
//@WebServlet("/empDetail") //고칠게 많아짐. 경로 주소
//emp현재폴더/empDetail파일 -> jsp로 forward할 때 empDetail.js 파일 이름만 쓰면 됨.

@WebServlet("/emp/empDetail.do") 
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /*
     * 404:page가 존재하지 않는다. 주소 확인하기 
     * 405:요청방식을 지원하지 않는다. get/post 확인
     * 500:서버오류. 프로그램실행오류이므로 console창 확인
     * 200:성공
     */
	
    //doGet(). doPost()코드가 같다면 service()메소드에서 코드한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===========get요청=============");
		
		EmpService eservice = new EmpService();
		String empid = request.getParameter("empid");
		if(empid == null) return;
		
		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = eservice.selectById(i_empid); //직원 조회
		System.out.println(emp);
		
		//저장-set
		//요청 문서에 data를 저장한다.
		request.setAttribute("empInfo", emp);//직원번호 "empInfo"에 저장해놓음.
		
		//-------직원 정보들
		//모든 부서
		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		request.setAttribute("deptlist", dlist); 
		//모든 매니저
		List<HashMap<String,Object>> mlist = eservice.selectAllManager();
		request.setAttribute("mlist", mlist); 
		//모든 JOB
		List<JobDTO> joblist = eservice.selectAllJob();
		request.setAttribute("jlist", joblist); 
		
		//Java code는 Servlet담당.....비지니스 로직을 수행 후
		//View(HTML)는 JSP담당   .....JSP에 넘긴다.
		
		//Browser가 요청 -> 서블릿이 받음 -> JSP에게 위임 (forward)
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp"); //jsp로 넘긴다.
		rd.forward(request, response);//요청할 때 온 정보, 응답
	}
	
	
	//get:상세보기 할 때 사용
	//post:수정할 때 사용 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		/*
		 * request.setCharacterEncoding("utf-8"); 
		 * =>Filter로 처리 대체
		 */
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp); //empUpdate
		System.out.println(result + "건 수정됨");
		
		request.setAttribute("message", result + "건 수정됨");
		
		RequestDispatcher rd= request.getRequestDispatcher("result.jsp"); 
		rd.forward(request, response); 
	}

	private EmpDTO makeEmp(HttpServletRequest request) {
		
		EmpDTO emp = new EmpDTO();
		
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
