package com.shinhan.controller5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//jsp폴더 밑에 있는 것처럼 가상의 이름을 지어줌. (order.jsp와 같은 위치)
@WebServlet("/jsp/order.go")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 보여주기
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//input의 value 값인 한글이 깨지기 때문에 인코딩 필요
		request.setCharacterEncoding("utf-8");
		
		//input value값으로 파라미터 읽어오기.
		String menuName = request.getParameter("lunch");
		Integer count = Integer.parseInt(request.getParameter("count"));
		System.out.println(menuName + "==>" + count);
		
		//request? 요청시마다 값이 다르다.
		//session?Browser당 하나(OK)
		//application?다른사람과 공유(X)
		
		HttpSession session = request.getSession();
		Map<String,Integer> cart = (Map<String, Integer>) session.getAttribute("cart"); //키(문자열),값(숫자)
		if(cart == null) {
			cart = new HashMap<String, Integer>();
			cart.put(menuName,count);
			//세션에 저장 (리퀘스트에 저장했다면? 페이지 바뀌면 값 유지안되고 사라짐)
			session.setAttribute("cart", cart);
		}else{
			//cart 수정
			if(cart.containsKey(menuName)){ //메뉴이름이 있는지?
				cart.put(menuName, cart.get(menuName) + count);
			}else {
				cart.put(menuName, count);
			}
		}
		
		//결과 페이지
		request.getRequestDispatcher("orderResult.jsp").forward(request, response);
	}
}
