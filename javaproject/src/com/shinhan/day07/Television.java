package com.shinhan.day07;

/*
 * implements 클래스명?
 * interface를 구현한 (추상메서드)구현class
 * 추상메서드를 반드시 구현할 의무가 있다.
 * 
 * 인터페이스 구현클래스에서 private접근 못함, static접근 못함.
 * 
 * */
//다중 상속이 되지 않기 때문에 interface를 통해 다중 상속을 구현하기도 한다.
// implements : 구현한다
public class Television implements RemoteControler { //Television마우스 대면 method생성가능

	@Override
	public void method1() { //접근제한자는 같거나 더 넓어야 하니까 public이 생략되면 안됨. 왜? 추상메서드는 "public"abstract 가 생략 되어 있기 떄문이다.
		System.out.println(getClass().getSimpleName() + "method1()");
	}

	@Override
	public void method2() {
		System.out.println(getClass().getSimpleName() + "method2()");
	}

	@Override
	public void turnOn() {
		System.out.println(getClass().getSimpleName() + "전원 켜기");
	}

	@Override
	public void turnOff() {
		System.out.println(getClass().getSimpleName() + "전원 끄기");
	}
	
	
	//default메서드는 재정의 가능
	@Override
	public void method3() {
		RemoteControler.super.method3(); //부모것도 호출함.
		System.out.println("default메서드 재정의함");
	}
	
//	@Override //오버라이드 된게 아닌걸 확인.
	void method4() {  //Television클래스 것.
		
		RemoteControler.method4();
		
		System.out.println("method4 메서드 추가 ");
		
	}
	
	



}
