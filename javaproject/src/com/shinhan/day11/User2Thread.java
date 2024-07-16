package com.shinhan.day11;

//User1Thread를 스레드로 만들기 위해 상속받기.
public class User2Thread extends Thread{
	private Calculator calculator;
	
	public User2Thread(){
		setName("User2쓰레드"); //스레드이름변경
	}

	public void setCalculator(Calculator calculator) { 
		this.calculator = calculator;   
	}

	@Override
	public void run() {
		calculator.setMemory(50);	//동기화 블록을 가진 메소드 호출
	}
	
	
	
}
