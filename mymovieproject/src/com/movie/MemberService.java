package com.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.movie.dao.MemberDAO;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	
	//회원 정보 입력
	public int memberInsert(MemberDTO mem) {
		return memberDAO.memberInsert(mem);
	}
	//로그인 
	public int memberLogin(String userid, String userpw) {
		return memberDAO.memberLogin(userid, userpw);
	}
	//아이디 체크
	public int memIdCheck(String userid) {
		return memberDAO.memIdCheck(userid);
	}
	
	//
	public int myChangeInfo(String userid, String userpw) {
		return memberDAO.myChangeInfo(userid, userpw);
	}
	
	
}
