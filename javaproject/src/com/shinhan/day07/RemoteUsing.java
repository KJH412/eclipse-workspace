package com.shinhan.day07;

import com.shinhan.day07.lab.Audio;

public class RemoteUsing {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f7();
	}
	
	//?
	private static void f7() {
		Television a = new Television();
//		RemoteControler a = new Audio();
//		Audio a = new Audio(); X
		RemoteControler b = new Television();
		a.method1();
//		a.method4();
		
	}

	private static void f3() {
		action(new Television());
		action(new Audio());
		
	}

	//(RemoteControler remote)Television와 Audio의 공통 implements 인터페이스
	private static void action(RemoteControler remote) {
		//사용할 변수, 메서드는 타입을 따른다
		
		//상수접근
		System.out.println(remote.CHANNEL);
		
		//추상 abstract
		remote.turnOn();
		remote.turnOff();
		remote.method1();
		remote.method2();
		
		//default
		remote.method3();
		
		//static
		RemoteControler.method4();
	}

	private static void f2() {
		Audio audio = new Audio();
		audio.method1();
		audio.method2();
		audio.method3();//부모의 default메소드인 method3이 실행됨. 자식에 method3이 없어서.
		audio.turnOn();
		audio.turnOff();
		RemoteControler.method4();
	}

	private static void f1() {
		Television t1 = new Television();
		
//		t1.method1();//추상구현
//		t1.method2();//추상구현
//		t1.method3();//default재정의
		t1.method4();//class에서 추가한 메서드 (인터페이스랑 무관함)
		
		RemoteControler.method4(); //부모인 interface의 method4가 뜬다.
		
//		System.out.println(t.CANNEL); //별로임.
		System.out.println(RemoteControler.CANNEL2); //상수부름. 이런식으로 작성하면됨.
	}

}
