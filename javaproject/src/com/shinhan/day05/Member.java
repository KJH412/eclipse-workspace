package com.shinhan.day05;

//교재 예제 챕터6 14번
public class Member {
	//필드
	private String name = "홍길동"; 
	private String id = "hong";
	private String password;
	private int age;
	
	//생성자
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	} 
	
	//메소드
	public void setName(String name) {} 
	
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
	}
	
	
}
