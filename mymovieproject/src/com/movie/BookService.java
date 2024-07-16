package com.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.movie.dao.BookDAO;
import com.util.DBUtil;

public class BookService {
	
	BookDAO bookDAO = new BookDAO();

	//예매하기
	public int bookMovie(BookDTO book) {
		return bookDAO.bookMovie(book);
	}
	//예매 내역 확인
	public List<BookDTO> myBookList(String userid) {
		return bookDAO.myBookList(userid);
	}
	
	//예매 취소 (상태 Y->N으로 변경)
	public int bookCancle(BookDTO cancle) {
		return bookDAO.bookCancle(cancle) ;
	}
		
}
