package com.shinhan.day09.generic.practice;


public class GenericExample {

	public static void main(String[] args) {
		//Box 생성할 때 타입 파라미터 T대신 String을 대체
		Box<String> box = new Box<>();
		box.content = "안녕하세요";
		String str = box.content; //강제타입변환필요없이 "안녕하세요" 바로 얻음
		System.out.println(str);
		
		//Box생성할 때 타입 파라미터 T대신 Integer로 대체
		Box<Integer> box2 = new Box<>();
		box2.content = 100;
		Integer str2 = box2.content; //강제타입변환필요없이 100 바로 얻음
		System.out.println(str2);
	}

}
