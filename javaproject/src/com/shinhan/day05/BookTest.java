package com.shinhan.day05;

public class BookTest {

	public static void main(String[] args) {

//		method1();
		method2();
		method3();
	}

	private static void method3() {
		int a = Integer.MAX_VALUE;
		
		System.out.println(a);
		
		int b = Integer.compare(10,30); //compare : 앞값이 작으면 음수-1,뒤값이 크면양수1
		System.out.println(b);
		
		int score = 10, score2=20;
		int c = Integer.max(score, score2);
		System.out.println(c); //score 값이 더 작아서 -1음수 출력.
		System.out.println(score>score2 ? score : score2);

		
	}

	private static void method2() {
		//상수는 변경불가 , 객체를 생성하지 않고 사용
		//Book.ISBN = "8888"; 
		System.out.println(Book.ISBN); //Book.ISBN : ISBN이 static이니까 class것(Book)이다.
		System.out.println(Book.ISBN2);
		
		//올바른 사용은 아니다.
		Book b1 = new Book();
		System.out.println(b1.ISBN); 
		System.out.println(b1.ISBN2); 
	}

	private static void method1() {
		System.out.println(Book.bookCount);
		Book b1 = new Book(); //default생성자 없음. Book에서 정의해주기
//		
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);
	}

}
