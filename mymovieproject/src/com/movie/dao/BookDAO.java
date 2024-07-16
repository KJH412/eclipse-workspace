package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.BookDTO;
import com.util.DBUtil;

public class BookDAO {
	Connection conn; 
	Statement st; 
	ResultSet rs; 
	PreparedStatement pst;
	
	
	//예매 취소하기(좌석 예매 가능 여부 변경 Y->N)
	public int bookCancle(BookDTO cancle){
		int result = 0;
		//System.out.println("cancle:" + cancle);
		
		String sql = "UPDATE SEATS "
				+ "SET s_check = 'N' "
				+ "WHERE BOOK_ID IN ( "
				+ "            SELECT B.BOOK_ID "
				+ "            FROM BOOK B  "
				+ "            JOIN SEATS S ON B.BOOK_ID = S.BOOK_ID "
				+ "            JOIN MEMBER M ON B.MCODE = M.MCODE "
				+ "            WHERE M.USER_ID = ? AND S.S_ROW = ? AND S.S_NUM = ? AND B.BOOK_ID= ? AND S.S_CHECK = 'Y'  "
				+ ")"; 
	     
		  conn = DBUtil.dbConnection();
		  
		  try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, cancle.getUser_id()); //회원아이디
			pst.setString(2, cancle.getS_row());  //좌석
			pst.setInt(3, cancle.getS_num());
			pst.setInt(4,  cancle.getBook_id());
			
			result = pst.executeUpdate();		
			 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
	  
		  return result;
	}
	
	//예매 내역 확인
	public List<BookDTO> myBookList(String userid) {
		 List<BookDTO> booklist = new ArrayList<BookDTO>();
		
		 String sql= "SELECT a.book_id, a.book_time, b.movie_title, c.s_row, c.s_num, c.s_check, b.cinema, b.m_start, b.running_time "
		 		+ "from BOOK A  "
		 		+ "join MOVIE B on A.MOVIE_ID =  B.MOVIE_ID "
		 		+ "join seats C on A.book_id = C.book_id "
		 		+ "join member M on a.mcode = M.mcode "
		 		+ "where  user_id = ? "
		 		+ "and s_check = 'Y' ";
		 
		 conn = DBUtil.dbConnection(); 
		 try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				BookDTO book = new BookDTO(); 
				book.setBook_id(rs.getInt("book_id")); //예약번호
				book.setBook_time(rs.getDate("book_time"));
				book.setMovie_title(rs.getString("movie_title")); //movieDTO
				book.setS_row(rs.getString("s_row"));
				book.setS_num(rs.getInt("s_num"));
				book.setS_check(rs.getString("s_check"));
				book.setCinema(rs.getString("cinema"));
				book.setM_start(rs.getString("m_start"));
				book.setRunning_time(rs.getInt("running_time"));
				booklist.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		 
		 return booklist;
		 
	}
	
	//예매 내역 넣기
	public int bookMovie(BookDTO book){
		int result = 0;
		
		String seq = "select BOOK_SEQ.NEXTVAL as bookSeq from dual ";
		
		String sql1 = "INSERT INTO BOOK(book_id, book_time, movie_id, mcode ) "
				+ "VALUES (?, sysdate , ? , (select mcode from  member where user_id = ?) ) "; 
		
		String sql2 = "INSERT INTO SEATS(s_row,s_num,book_id,s_date,s_check ) VALUES(? , ?, ?, sysdate, 'Y' )"; 
     
		conn = DBUtil.dbConnection(); 
		try {
            conn.setAutoCommit(false);
			pst = conn.prepareStatement(seq);
			rs=pst.executeQuery();
			if(rs.next()) {
				book.setBook_id(rs.getInt("bookSeq")); 
			}
	
			//book insert
			pst = conn.prepareStatement(sql1);
			pst.setInt(1, book.getBook_id());
			pst.setInt(2, book.getMovie_id());
			pst.setString(3, book.getUserId());
			result = pst.executeUpdate();
			
			//좌석 insert
			pst = conn.prepareStatement(sql2);
			pst.setString(1, book.getS_row());
			pst.setInt(2, book.getS_num()); 
			pst.setInt(3, book.getBook_id());
			result = pst.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				 
			}
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}

}
