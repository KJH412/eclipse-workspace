package com.shinhan.boardcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.shinhan.dto.BoardDTO;
import com.shinhan.model.BoardService;

//자바와 자바스크립트 소통1
@WebServlet("/json")
public class AjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonInfo = request.getParameter("jsonInfo");
		System.out.println(jsonInfo);
		
		//JSONParser객체 생성 
		//parse()메서드를 통해 JSONObject를 가져오고 JSON데이터의 속성으로 값을 출력할 수 있다.
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject)parser.parse(jsonInfo);
		
			
			//System.out.println(bno); //bno타입이 long->int로 바꿔줌.
			Long bno = (Long)jsonObj.get("bno");
			int i_bno = bno.intValue();
			String title = (String)jsonObj.get("title");
			String content = (String)jsonObj.get("content");
			String writer = (String)jsonObj.get("writer");
			
			BoardDTO board = new BoardDTO(i_bno, title, content, writer, "cup-1.png", null);
			System.out.println(board);
			
			int result = new BoardService().insertBoard(board);
			//response.sendRedirect("selectAll.do");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


}
