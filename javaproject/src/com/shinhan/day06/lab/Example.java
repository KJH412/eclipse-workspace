package com.shinhan.day06.lab;

class A1 {
	public void method1() {
		System.out.println("A-method1()");
	}
}
class B1 extends A1 {
	public void method1() {
		System.out.println("B-method1()");
	}
}
class C1 extends A1{
	public void method1() {
		System.out.println("C-method1()");
	}
	public void method2() {
		System.out.println("C-method2()");
	}
}

public class Example {
	public static void action(A1 a) { 
	a.method1();
	if(a instanceof C1 c) { //변수 a가 C1의 인스턴스인가? 
		c.method2();
	}
	
	//instansof로 타입 체크를 안하고 한 경우
	//((C1)a).method2(); //ClassCastException 캐스팅에러  
}
	public static void main(String[] args) {
		action(new A1());
		action(new B1());
		action(new C1());
	}
}
