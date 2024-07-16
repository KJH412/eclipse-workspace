package com.shinhan.day05;

//java.lang 아래 있는 class는 import없이 사용가능.
//그 외에는 반드시 import.
//다른 패키지package에 있는 class를 이용하는 경우 반드시 import하고 사용한다.

public class Book {
	//1.field
	
	//class 변수
	static int bookCount; //class Book이 공유하는 클래스변수.
	
	//instance 변수
	String title;
	int price; 
	
	//final(최종) : 1회만 값을 할당하고 수정은 불가.  3가지방법으로 값을 초기화할 수 있다.
	//①선언시초기화, ②생성자로 초기화, ③instance로 초기화
	final String publish = "한빛미디어"; //① final 선언 초기화
	final String publish2;
	final String publish3;
	
	
	//상수(불변) : 값을 처음부터 갖고있고 바꿀 수 없음. 이름은 대문자로 선언
	/* 1.선언시 초기화 2.static block초기화 */
	static final String ISBN ="1234/5678"; //static final 순서 상관없음. class꺼란 뜻
	static final String ISBN2;
	static {
		ISBN2 = "8888-9999";
	}
	
	//2.constructor : class이름과 똑같이
	Book(){
		System.out.println("default생성자를 정의함.");
		this.publish2 = "default생성자에서 초기화"; //아래에 publish2가 존재해서 초기화따로해줘야한다. 에러남.
	}
	Book(String publish2){ 
		this.publish2 = publish2; //②final 생성자로 초기화함.
	}
	{
		publish3 = "한빛미디어3"; //③final instance로 초기화
	}
	//3.method
	void test1() {
		//publish = "한빛미디어2"; //이미 위에서 final로 값을 한번 할당했기 때문에 수정 불가
//		publish2 = "한빛미디어2"; 불가
//		publish3 = "한빛미디어2"; 불가
	}
	//4.block
	//5.inner class
}
