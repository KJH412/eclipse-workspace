package com.shinhan.frontpattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDTO;

//서블릿

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqAddress = request.getRequestURI();
		String path = getServletContext().getContextPath();
		String method =  request.getMethod().toLowerCase(); //메소드(get,post)
		//session
		HttpSession session = request.getSession();
		
		int pathLength = path.length();
		reqAddress = reqAddress.substring(pathLength);
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("method", method);
		
		CommonControllerInterface controller = null;
		
		switch(reqAddress) {
			//상세보기 수정
			case "/board/boardDetail.do" -> {
				//서블릿 아니고 컨트롤러 자바파일
				
				// get, post 다르기 때문에 파라미터 값을 무조건 줄 수 없음
				if (method.equals("get")) {
					dataMap.put("bno", Integer.parseInt(request.getParameter("bno")));
					
				} else {
					int bno = Integer.parseInt(request.getParameter("bno"));
					String title = request.getParameter("title");
					String content = request.getParameter("content");
					String pic = request.getParameter("pic");
					
					BoardDTO board = new BoardDTO(bno, title, content, null, pic, null);
					dataMap.put("board", board);
				}
				controller = new BoardDetailController();
			}
			//조회
			case "/board/selectAll.do" ->{
				controller = new BoardListController();
				
			}
			//삭제
			case "/board/boardDelete.do" ->{
				dataMap.put("bno", Integer.parseInt(request.getParameter("bno")));
				controller = new BoardDeleteController();
			}
			//추가
			case "/board/boardInsert.do" ->{
				if(method.equals("post")) {
					
					//로그인 유저
					EmpDTO loginEmp = (EmpDTO)session.getAttribute("loginEmp");
					dataMap.put("request", request); //request
					dataMap.put("loginEmp", loginEmp); //로그인 유저 정보(세션에 저장한 것)
				}
				controller = new BoardInsertController();
			}
			//로그인
			case "/auth/login.do" ->{
				if(method.equals("post")) {
					dataMap.put("email", request.getParameter("email"));
					dataMap.put("pswd", request.getParameter("pswd"));
					dataMap.put("session", session);
				}
				controller = new LoginController();
			}
		default -> {}
		}
		String page = controller.execute(dataMap);//DB에 입력
		//Map이기 때문에 key값을 받아서 저장.
		for(String key:dataMap.keySet()) {
			request.setAttribute(key, dataMap.get(key));
		}
		
		
		if(reqAddress.equals("/auth/login.do") && method.equals("post")) {
			
			//로그인 성공,실패인지?
			session.setAttribute("loginEmp", dataMap.get("loginEmp"));
		}
		
		if(page.startsWith("redirect:")) {
			//재요청(주소창이 바뀐다.)
			String page2 = page.substring(9); //9번째부터 끝까지 자르고 나머지
			//마지막 페이지 얻기
			
			//redirec: 으로 오면 재요청한다.
			//login하지 않고 다른 요청을 했을 때  요청 주소를 lastRequest에 저장하고 로그인 후 
			//그 페이지로 redirect한다.
			if(page2.equals("")) {
				response.sendRedirect(path);
			}else {
				//response.sendRedirect(page2);
				response.sendRedirect(page.substring(9));
				
			}
			
		}else {
			//요청 위임하기(주소 바뀌지 않는다.)
			//서블릿은 default주소 : http://localhost:9090/webshop
			System.out.println("forward주소: " + page);
  			request.getRequestDispatcher(page).forward(request, response);
		}
		
		System.out.println("path : " + path);
		System.out.println("주소=> " + reqAddress.substring(pathLength));
		
	
	}
	

}