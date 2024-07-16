package com.shinhan.day07;

import com.shinhan.day07.lab.Audio;

//RemoteControler의 추상메소드4개와 Searchable의 추상메소드 5개가 들어옴. unimplement
//다중인터페이스를 다룰 수 있다.
public class SmartTelevison implements RemoteControler, Searchable {
	
	public static void main(String[] args) {
//		f4();
		f6();
	}

	private static void f6() {
		//String , Integer class는 Compareable interface구현하였다.
		//Comparable interface : 추상메서드 public abstract compareTo();
		//String class가 Comparable interface구현...compareTo()재정의
		String s1 = "A";
		String s2 = "C";
		Integer i1 = 100;
		Integer i2 = 105;
		
		int result = s1.compareTo(s2); //s1과 s2를 비교
		System.out.println(result); //-2만큼 떨어져있다.
		
		result = i1.compareTo(i2); //Integer은 앞의 값에 따라서 -1,0,1로 출력됨.
		System.out.println(result); //100이 105보다 작기 때문에 -1이 출력된다.
	}

	private static void f4() {
		//타입을 따른다.
		SmartTelevison a = new SmartTelevison(); //a
		RemoteControler b = new SmartTelevison();
		Searchable c = new SmartTelevison();
		Object d = new SmartTelevison();
				
		f5(a);
		f5(b);
		f5(c);
		f5(d);
		f5(new Audio()); //컴파일에러는 안남. 실행 시 오류 ClassCastException
		
	}

	//RemoteControler가 SmaratTelevison보다 상위이기 때문에 a만 들어갈 수 있다. 왜? a의 타입이 SmartTelevison이라서.
//	private static void f5(SmartTelevison a) {
	private static void f5(Object smart) {	
		((SmartTelevison)smart).search("http://youtube");
		if(smart instanceof SmartTelevison ss) ss.search("http://youtube");
	}

	@Override
	public void search(String url) {
		System.out.println(url + "SmartTelevision search");
	}

	@Override
	public void method1() {
		System.out.println( "SmartTelevision... method1");
	}

	@Override
	public void method2() {
		System.out.println( "SmartTelevision... method2");
		
	}

	@Override
	public void turnOn() {
		System.out.println("SmartTelevision turnOn");
		
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTelevision turnOff");
		
	}

}
