package com.shinhan.day07.lab;

import com.shinhan.day07.RemoteControler;

public class Audio implements RemoteControler {

	int a = 100;
	static int b = 200;
	public Audio() {
		System.out.println("Audio default 생성자");
	}
	
	void show() {
		System.out.println("Audio의 Show메서드");
	}
	
	
	//추상메서드를 구현한것
	@Override
	public void method1() {
		System.out.println("Audio method1()구현");
	}

	@Override
	public void method2() {
		System.out.println("Audio method2()구현");
	}

	@Override
	public void turnOn() {
		System.out.println("Audio turnOn()구현");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio turnOff()구현");
	}

}
