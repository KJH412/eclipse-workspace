package com.shinhan.day05;

//챕터6 16,17번문제
public class Printer {

	//이름은 같지만 매개변수가 다르다.
	//static을 붙이면 객체생성 없이 바로 호출된다.
	static void println(int value) {
		System.out.println(value);
	}
	static void println(boolean value) {
		System.out.println(value);
	}
	static void println(double value) {
		System.out.println(value);
	}
	static void println(String value) {
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		
		//Printer println = new Printer();
		
		// 메소드 앞에 static 붙이면 객체를 생성하지 않고 사용 가능
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
		
		System.out.println();
		
	}

}
