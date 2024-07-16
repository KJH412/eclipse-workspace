package com.shinhan.controller2;

import java.io.IOException;
import java.sql.Date;
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

import oracle.net.aso.e;


@WebServlet("/emp/retrieve.do")
public class EmpConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//모든 Job 조회
		//1.객체 생성 why? 인스턴스메서드 호출하기 위해 객체 생성, 만약 static 메서드였으면 생성없이 호출.
		EmpService eservice = new EmpService();
		//비지니스 로직을 수행한다.
		List<JobDTO> joblist = eservice.selectAllJob(); 
		//--> 지역변수 joblist를 JSP에 넘겨줘야하는데, jobAll.jsp는 지역변수를 알 수 없기 때문에  
		//JSP가 알 수 있도록 request에 저장(set)한다.
		
		DeptService dService = new DeptService();
		List<DeptDTO> deptlist = dService.selectAll();
		
		//요청문서에 data를 저장한다. JSP가 사용하기 위해.
		request.setAttribute("job_datas", joblist);
		request.setAttribute("dept_datas", deptlist);
		
		
		//Servlet받은 요청과 응답을 JSP(View담당)에 위임한다.
		//메핑주소이름이 "/joblist.do"였으면, jsp경로는 "job/jobAll.jsp"
		RequestDispatcher rd = request.getRequestDispatcher("retrieve.jsp");
		rd.forward(request, response); 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jobid = req.getParameter("job_id");
		int deptid = Integer.parseInt(req.getParameter("dept_id"));
		Date hiredate = DateUtil.getSQLDate(req.getParameter("hiredate"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		
		//조건(deptid, jobid, hiredate, salary)에 맞는 직원 조회
		EmpService service = new EmpService();
		service.selectByCondition(deptid, jobid, hiredate, salary);//DAO-DB접근, 파라미터 순서 주의
		List<EmpDTO> emplist = service.selectByCondition(deptid, jobid, hiredate, salary);
		
		//JSP에서 사용할 data 저장
		req.setAttribute("emplist", emplist);
		
		//jsp 페이지 연결
		RequestDispatcher rd = req.getRequestDispatcher("emplist2.jsp");
		//jsp에게 응답 위임
		rd.forward(req, resp);
		
	}

	
}
