package com.shinhan.day06;
//307p

class A {
	int score = 100;
	void print() {}
}
class B extends A{
	int score2 = 99;
	void print2() {}
}
class C extends A{
	int score2 = 88;
	void print2() {}
}
class D extends B{}
class E extends C{}

public class InheritenceTest5 {

	public static void main(String[] args) {
//		method1();
		method2();
	}
	
	private static void method2() {
		//A타입 이므로 변수의 타입을 따른다. (A타입인 것만 보임)
		A var1 = new B();
		
		System.out.println(var1.score);
//		System.out.println(var1.score2);	
		var1.print();
//		var1.print2(); ㅇ
		
		if(var1 instanceof C) {
			C var2 = (C)var1; //형변환
			System.out.println(var2.score2);
			var2.print2();
		}
	}
	
	private static void method1() {
		Object obj = new A();
		A a = new A();
		
		Object b1 = new B();
		B b2 = new B();
		A b3 = new B();
		
		Object d1 = new D();
		D d2 = new D();
		B d3 = new D();
		A d4 = new D();
	}
}
