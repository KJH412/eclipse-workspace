package com.shinhan.frontpattern;

import java.util.Map;

import com.shinhan.model.BoardService;

//interface의 메서드를 구현해야한다.
public class BoardListController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> dataMap) {
		BoardService service = new BoardService();
		//request가 없으므로 Map put으로 넣어 저장하면 된다.
		dataMap.put("boardlist", service.selectAll());
		
		
		return "/board/boardlist.jsp";
	}

}
