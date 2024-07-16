package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBUtil;


public class SeatDAO {
	Connection conn; 
	Statement st; 
	ResultSet rs; 
	PreparedStatement pst;
	
	//좌석 예매 가능 상태 조회  (아이디,좌석행번호로 체크해서 Y 또는 N)
	public boolean seatCheck(String srow, int snum, int movieid) {
		boolean seatCheck = true;
		int count = 0;
	    String sql = "SELECT count(*) as count "
	    		+ "from BOOK A "
	    		+ "join MOVIE B on A.MOVIE_ID = B.MOVIE_ID "
	    		+ "join seats C on A.book_id = C.book_id "
	    		+ "where 1=1 "
	    		+ "and B.MOVIE_ID = ? "
	    		+ "and C.s_row = ? "
	    		+ "and C.s_num = ?"
	    		+ "and C.s_check != 'Y' "; 
	    conn = DBUtil.dbConnection();
	    try{
	    	pst = conn.prepareStatement(sql);
	    	pst.setInt(1, movieid);
	    	pst.setString(2, srow);
	    	pst.setInt(3, snum);
	    	
	    	rs = pst.executeQuery();
            if (rs.next()) {
            	count = rs.getInt("count");
                return seatCheck = ( 0 == count)? true : false;
            }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
	    
	    return seatCheck;
	}
}
