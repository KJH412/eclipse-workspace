package com.shinhan.day03;

public class Review {
	public static void main(String[] aa) {
		call(100);
		call(55);
		call2(10);
		call3(10);
		call4(10);
		call5(10);
	}
	private static void call5(int a) {
		//반복문 do while  : 1~a까지 합계구하기
		int total = 0;
		int i=1;
		do {
			if(i==1) break;
			total += i++;
			//i++;
		}while(i<=a);
		System.out.println("do while이용..합계:" + total);
	}
	
	private static void call4(int a) {
		//반복문while  : 1~a까지 합계구하기
		int total = 0;
		int i=1;
		while(i<=a) {
			total += i++;
			//i++;
		}
		System.out.println("while이용..합계:" + total);
	}
	
	private static void call3(int a) {
		//반복문for  : 1~a까지 합계구하기
		int total = 0;
		for(int i=1;i<=a;i++) {
			total += i;
		}
		System.out.println("합계:" + total);
	}
	
	private static void call2(int a) {
		//조건문 switch
		switch(a%2) {
		case 0:System.out.println(a+" 짝수");break;
		case 1:System.out.println(a+" 홀수");
		}
	}
	//반복사용을 위해 메서드를 만든다.
	private static void call(int a) {
		//조건문 if
		if(a%2==0) {
			System.out.println(a+" 짝수");
		}else {
			System.out.println(a+" 홀수");
		}
		//3항연산자
		System.out.println(a%2==0?a+" 짝수!!":a+" 홀수!!");
	}
}
