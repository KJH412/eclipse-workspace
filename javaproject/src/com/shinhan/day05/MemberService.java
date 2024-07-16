package com.shinhan.day05;

//교재 예제 챕터6 15번
public class MemberService {
	
	/*
	boolean login(String id, String password){
		if(id.equals("hong") && password.equals("12345"){ 
			return true;
		}
		return false;
	}
	*/
	//굳이 if안써도됨.
	//더 간단하게 작성.
	//login 메소드
	boolean login(String id, String password){
		return id.equals("hong") && password.equals("12345");
	}
	
	//logout메소드
	void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
