package com.shinhan.day05;

public class SingleToneTest {

	public static void main(String[] args) {
		//a,b,String[] args는 클래스변수가 아니라 로컬변수이다.
		SingleToneClass a = SingleToneClass.getInstance();
		SingleToneClass b = SingleToneClass.getInstance();
		
		System.out.println(a==b);
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		
		//오버로딩
		//같은 매개변수 사양인데 리턴만 같은것은 안됨. 오버로딩불가
		/*
		public static void method1(int a , int b) {
			return 100;
		}
		public static int method1(int a , int b) {
			return 100;
		}
		*/
	}

}
