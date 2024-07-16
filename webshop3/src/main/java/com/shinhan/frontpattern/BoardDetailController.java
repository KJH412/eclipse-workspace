package com.shinhan.frontpattern;

import java.util.Map;

import com.shinhan.dto.BoardDTO;
import com.shinhan.model.BoardService;

public class BoardDetailController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> dataMap) { //dataMap이 get인지 post인지 알아야한다.
		String page = "boarddetail.jsp";
		
		String method = (String)dataMap.get("method");
		if(method.equals("get")) {
			int bno = (Integer)dataMap.get("bno");
			dataMap.put("board", new BoardService().selectById(bno));
			
		}else {
			BoardDTO board = (BoardDTO)dataMap.get("board");
			//DB에 저장
			int result = new BoardService().updateBoard(board);
			System.out.println(result  + " 건 수정");
			page = "redirect:selectAll.do";
		}
		return page;
	}

	
}
