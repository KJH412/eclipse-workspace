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

//dept(폴더)밑에 depDetail
@WebServlet("/dept/deptDetail.do")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//input으로 입력한 값을 파라미터("input의name")로 받아오는데
		//그 정보값이 자바로 문자열json형태로 넘어가는데 
		//그 값을 다시 Integer로 parse해서 가져온다.
		
		//JSP가 서블릿으로 변환되어 실행
		
		 //.getParameter():String타입 메소드 -> 문자열
		String deptid = request.getParameter("deptid");
		//==> inputd의 name값을 파라미터로 요청해 가져온다.
		
		if(deptid == null) return; //없으면 리턴. 넘어가지X. 
		
		DeptService dservice = new DeptService();
		int i_deservice = Integer.parseInt(deptid); //deptid의 데이터 타입은 int임.(DTO확인)
		DeptDTO dept = dservice.selectById(i_deservice); 
		//==> selectById()안에 int만 받기 때문에 String타입으로 받았던 deptid를 int로 변환해서 넣어준다. 
		
		request.setAttribute("deptInfo", dept); //set(=수정,추가)
		
		System.out.println(dept);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("deptUpdate.jsp"); //get //주소를 매핑한 이름과 같을 필요는 없음
		rd.forward(request, response);
	}

	
}
