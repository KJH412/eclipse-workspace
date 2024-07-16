package com.shinhan.day10;

public class HomeAgency implements Rentable<Home> {
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	public Home rent() {
		return new Home(); //rent를부르면 Home이 오고 Home의 메소드를 호출할 수 있다.
	}

	
}
