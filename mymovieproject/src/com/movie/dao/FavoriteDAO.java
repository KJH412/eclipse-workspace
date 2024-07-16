package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.FavoriteDTO;
import com.util.DBUtil;

public class FavoriteDAO {
	Connection conn; 		//DB연결
	Statement st; 			//sql문 받기
	ResultSet rs; 			//결과보냄
	PreparedStatement pst; 
	
	//즐겨찾기 영화 중복 체크
	public int checkFavoriteMovie(int num, String userid) {
		int result = 0;
		
		String sql= "select count(*) from favorite f "
				+ "                join member m on(f.mcode = m.mcode) "
				+ "where user_id=? and f.movie_id=? ";
		conn =  DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setInt(2, num);
			
			rs = pst.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//즐겨찾기 내역 조회
	public List<FavoriteDTO> favoriteMyMovie(String userid) {
		List<FavoriteDTO> flist = new ArrayList<FavoriteDTO>();
		String sql= "select f.F_ID, m.movie_title "
				+ "from favorite f join movie m on (f.movie_id=m.movie_id) "
				+ "                join member b on (f.mcode = b.mcode)"
				+ "where b.user_id=?";
		
		conn =  DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 
			
			rs = pst.executeQuery();
			while(rs.next()) {
				FavoriteDTO fav = makeFavorite(rs);
				flist.add(fav);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		} 
		
		
		return flist;
	}
	private FavoriteDTO makeFavorite(ResultSet rs) throws SQLException {
		FavoriteDTO fav = new FavoriteDTO();
		fav.setF_id(rs.getInt("f_id"));
		fav.setMovie_title(rs.getString("movie_title"));
		
		return fav;
	}
	//즐겨찾기
	public int favoriteMovie(int num, String userid) {
		
		int result = 0;
		
		String sql = "INSERT INTO favorite "
				+ "VALUES(F_seq.NEXTVAL, ?, (SELECT MCODE FROM MEMBER WHERE user_id = ?)) ";
		
		conn =  DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, num); 	 
			pst.setString(2, userid); 	
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		
		return result;
	}
	public int deleteChoose(int choose, String userid) {
		
		int result = 0;
		String sql = "DELETE FROM favorite  "
				+ "WHERE F_ID  = (SELECT F_ID "
				+ "              FROM favorite f JOIN MEMBER M ON (f.mcode = M.mcode) "
				+ "              WHERE F_ID = ? AND M.USER_ID = ?)";
		conn =  DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, choose); 	 
			pst.setString(2, userid); 
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		//System.out.println(result + "확인");
		
		return result;
	}
	
}












