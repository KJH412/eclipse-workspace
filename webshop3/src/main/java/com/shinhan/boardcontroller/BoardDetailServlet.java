package com.shinhan.boardcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dto.BoardDTO;
import com.shinhan.model.BoardService;

//@WebServlet("/board/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt( request.getParameter("bno"));
		
		//보드번호에 해당하는 상세보기 "board"에 저장
		request.setAttribute("board", new BoardService().selectById(bno));
		
		request.getRequestDispatcher("boarddetail.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pic = request.getParameter("pic");
		
		BoardDTO board = new BoardDTO(bno, title, content, null, pic, null);
		int result = new BoardService().updateBoard(board);
		System.out.println(result  + " 건 수정");
		
		//조회 다시 보냄 (현재 detail파일 주소가 /board이라 생략)
		response.sendRedirect("selectAll.do");
	}


}
