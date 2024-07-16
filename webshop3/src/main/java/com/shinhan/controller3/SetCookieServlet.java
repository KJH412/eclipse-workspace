package com.shinhan.controller3;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jsp/cookieSet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//-----여러페이지로 이동시 특정 정보를 유지하기 위함이다.
	//쿠키를 만들어서 응답문서(response)에 실어서 보낸다.
	//브라우저에 저장된다.
	//재요청시 request에 담아서 간다.
	//쿠키를 확인할 수 있다.
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		Cookie c1 = new Cookie("myid", id); //"지정한 key이름",담을 값 
		Cookie c2 = new Cookie("mypass", pw); 
		Cookie c3 = new Cookie("myinfo", URLEncoder.encode("신한금융sw아카데미", "utf-8")); //한글로 인코딩
		
		//쿠키 유효기간 설정
		c1.setMaxAge(24*60*60); //하루동안
		c2.setMaxAge(60); //1분동안
		//c3은 유효시간을 설정하지 않아서 브라우저 종료시 지워진다.
		
		//생성된 쿠키를 브라우저로 전송한다.
		response.addCookie(c1); 
		response.addCookie(c2);
		response.addCookie(c3);
		
		request.getRequestDispatcher("cookie.jsp").forward(request,response);
		
	}

}
