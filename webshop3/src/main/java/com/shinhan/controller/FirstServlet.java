package com.shinhan.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @WebServlet : 주소창에 요청시 Mapping 주소 (서블릿 매핑 작업)
 * 서블릿의 기본 주소: http://192.168.0.151:9090/webshop
 */
@WebServlet({ "/FirstServlet", "/first", "/first2" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *  생성자
     */
    public FirstServlet() {
    	System.out.println("FirstServlet 생성자");
    }

	/**
	 * init(초기화)
	 */
	public void init(ServletConfig config) throws ServletException {
    	System.out.println("FirstServlet init(초기화)");
	}

	/**
	 *   destroy() : 종료, 마무리작업
	 */
	public void destroy() {
		System.out.println("FirstServlet destroy(소멸자)");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//주소창에서 오면 get 요청이다.
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet get요청" + addr);
		
		System.out.println("userid:" + request.getParameter("userid"));
		//응답문서 만들어서 append
		response.getWriter().append("<h1>Served at: ")
							.append(addr)
							.append(request.getContextPath() + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet Post요청" + addr);
		response.getWriter().append("<h1>Served(post): ")
							.append(addr)
							.append(request.getContextPath() + "</h1>");
	}
	//service서비스 재정의
	/* 
	 * doGet, doPost()코드를 모두 해야하는 경우에 재정의한다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("===========service=============");
			//index.html에서 a태그와 form>input태그의 요청 콘솔에서 확인해보기
			System.out.println(req.getMethod() + "요청");
			//doGet, doPost()코드를 모두 해야하는 경우
	}
	 */
}
