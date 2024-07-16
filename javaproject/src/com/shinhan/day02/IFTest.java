package com.shinhan.day02;

public class IFTest {

	public static void main(String[] args) {
		method6();

	}

	private static void method6() {
		//Wrapper class=>기본형 + 기능추가
		// Character     char
		char grade = 'A'; //'A','a','B','b'
		String message;
		
		grade = Character.toLowerCase(grade);
		switch(grade) {
		case 'a'->{message = "우수 회원";}
		case 'b'->{message = "일반 회원";}
		default->{message="손님";}
		}
		System.out.printf("switch사용==>%s 입니다.", message);
		
		if(grade=='a') {
			message = "우수 회원";
		}else if(grade=='a') {
			message = "일반 회원";
		}else {
			message="손님";
		}
		System.out.printf("\nIF사용===>%s 입니다.", message);
		
	}

	private static void method5() {
		char grade = 'A';
		String message;
		
		if(grade=='A' || grade == 'a') {
			message = "우수 회원";
		}else if(grade=='B' || grade == 'b') {
			message = "일반 회원";
		}else {
			message = "손님";
		}
		System.out.printf("%s 입니다.", message);
		
		switch(grade) {
		case 'A':
		case 'a':{
			int point=100;
			message = "우수 회원" + point;
			break; 
		}
		case 'B':
		case 'b':{
			String point="good";
			message = "일반 회원"+point;
			break;
		}
		default:message = "손님";
		}
		System.out.printf("\n%s 입니다.", message);
		
		//12버젼부터 지원
		switch(grade) {
		case 'A','a'->{message = "우수 회원";}//break자동
		case 'B','b'->{message = "일반 회원";}
		default->{message = "손님";}
		}
		System.out.printf("\n%s 입니다.", message);
	}

	private static void method4() {
		//Math : 수학공식들을 유용하게 사용하기 위한 기능들이 들어있다.
		double su = Math.random(); //0<=   <1
		                           //1<=   <=45
		int result = (int)(su*45) + 1;
		System.out.println(su);
		System.out.println(result);
		
		
		
		
	}

	private static void method3() {
		int score = 80;
		String grade;
		//break는 switch빠지기 , break가 없으면 무조건 아래로 흐른다. 
		//17버젼은 ,가능 ===> case 10,9:
		//8, 11버젼은 불가 
		if(score>100) {
			System.out.println("점수오류");
			return;
		}
		switch(score/10) {
		case 10:
		case 9:grade="A";break; 
		case 8:grade="B";break;
		case 7:grade="C";break;
		case 6:grade="D";break;
		default:grade="F";
		}
		System.out.printf("%s 학점!!!!\n", grade);
		System.out.println("===switch end====");
	}

	private static void method2() {
		int score = 80;
		String grade;
		if(score>=90) {
			grade="A";
		}else if(score>=80) {
			grade="B";
		}else if(score>=70) {
			grade="C";
		}else if(score>=60) {
			grade="D";
		}else {
			grade="F";
		}
		System.out.printf("%s 학점!!!!", grade);
		System.out.println("=======");
		
	}

	private static void method1() {
		int score = 80;
		if (score >= 90) {
			System.out.println("합격");
			System.out.println("$$$$$$$$");

		} else {
			System.out.println("불합격");
			System.out.println("------------");
		}
		System.out.println("if끝");

	}

}
