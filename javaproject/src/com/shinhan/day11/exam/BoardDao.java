package com.shinhan.day11.exam;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public List<Board> getBoardList() {
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(new Board("제목1", "내용1"));
		boardList.add(0,new Board("제목2", "내용2"));
		boardList.add(new Board("제목3", "내용3"));
        return boardList;
	}

}
//ArrayList쓰는이유?
//ArrayList 끝에 데이터를 추가할 떄 좋음. 중간에 넣는건 XXX
