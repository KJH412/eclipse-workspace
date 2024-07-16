package com.shinhan.boardcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.BoardService;


//@WebServlet("/board/selectAll.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	//조회 GET방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		//service.selectAll(); 전체 조회를 blist속성 안에 담는다.
		request.setAttribute("boardlist", service.selectAll());
		
		//getRequestDispatcher()페이지를 주고, forward 넘김.
		request.getRequestDispatcher("boardlist.jsp").forward(request, response);
		
	}


}
