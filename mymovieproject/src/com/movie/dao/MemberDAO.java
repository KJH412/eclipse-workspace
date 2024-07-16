package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.MemberDTO;
import com.util.DBUtil;

public class MemberDAO {
	Connection conn; 		//DB연결
	Statement st; 			//sql문장받음
	ResultSet rs; 			//결과보냄
	PreparedStatement pst; 
	

	public int deleteMember(String userid, String userpw) {
		
		int result = 0;
		
		String sql = ""; 
		
		conn =  DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			pst.setString(2, userpw); 	
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		
		return result;
	}	
	
	//회원정보 수정
	public int myChangeInfo(String userid, String userpw) {
		int result = 0;
		String sql = "update member set user_id= ? ,user_pw = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			pst.setString(2, userpw); 	
			
			result = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	//아이디 조회
	public int memIdCheck(String userid) {
		int result = 0;
		String sql = "select user_id from member";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			
			rs = pst.executeQuery();
			if(rs.next()) {
				String memid = rs.getString("user_id");
				if(memid.equals(userid)) {
					return 1; 
				}
			}else {
				return 0; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		
		return result;
	}
	
	
	//로그인(비밀번호가 해당 id가 있는 행에 있으면 로그인 성공)
	public int memberLogin(String userid, String userpw) {
		int result = 0;
		String sql = "select user_pw from member where user_id = ? ";  
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid); 	 
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString("user_pw"); //칼럼가져옴
				if(password.equals(userpw)) {
					return 1;  //로그인 성공
				}
			}else {
				return -1;  //해당 아이디 없음
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//회원가입 정보 입력
	public  int memberInsert(MemberDTO mem) {
		int result = 0;
		
		//회원코드 시퀀스 자동 번호
		String sql = "INSERT INTO  MEMBER(MCODE, USER_ID, USER_PW, PHONE, USER_NAME, USER_AGE) VALUES(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?)"; 
		conn =  DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, mem.getUser_id());
			pst.setString(2, mem.getUser_pw());
			pst.setString(3, mem.getPhone());
			pst.setString(4, mem.getUser_name());
			pst.setString(5, mem.getUser_age());
			
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

}
