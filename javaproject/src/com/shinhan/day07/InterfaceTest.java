package com.shinhan.day07;

interface AInterface{
	void method1(); //추상 (public abstract생략된 상태.)
}
//interface도 상속이 가능.
interface BInterface extends AInterface{
	void method2(); //추상
}
class MyClass implements BInterface {	
//	void method1() {}; 오류. public을 써줘야 한다.
	public void method1() {};
	public void method2() {};
}
public class InterfaceTest {
	public static void main(String[] args) {
		//?
		MyClass a = new MyClass();
		a.method1();
	}
}
