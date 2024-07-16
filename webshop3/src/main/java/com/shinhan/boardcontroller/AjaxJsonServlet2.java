package com.shinhan.boardcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.dto.BoardDTO;
import com.shinhan.model.BoardService;

//==================================
//Java가 data를 JavaScript로 보내기
//JSON으로 보내면 JavaScript에서 파싱하여 data추출
//==================================

//자바와 자바스크립트 소통2 (자바->스크립트)
@WebServlet("/json2")
public class AjaxJsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//-------------자바스크립트 문법
		//board전부가져오기
		List<BoardDTO> blist =  new BoardService().selectAll();
		
		JSONObject boardlist = new JSONObject();
		JSONArray arr = new JSONArray();
		for(BoardDTO board:blist) {
			JSONObject obj = new JSONObject();
			//한 건을 배열에 넣는다.
			obj.put("bno", board.getBno());
			obj.put("title", board.getTitle());
			obj.put("content", board.getContent());
			arr.add(obj);
		}
		//배열을 집어 넣는다.
		boardlist.put("boardlist", arr); //{"boardlist":[{},{},{}]}

		String json = boardlist.toJSONString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(json);
		
		
	}
	
}
