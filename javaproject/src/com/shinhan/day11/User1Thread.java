package com.shinhan.day11;

//User1Thread를 스레드로 만들기 위해 상속받기.
public class User1Thread extends Thread{
	private Calculator calculator;
	
	public User1Thread(){
		setName("User1쓰레드"); //스레드이름변경
	}

	public void setCalculator(Calculator calculator) { //setter를 이용한 초기화,외부공유객체인 Calculator를 받아 필드에 저장.
		this.calculator = calculator;   
	}


	@Override
	public void run() {
		calculator.setMemory(100);	//동기화 메소드 호출
	}
	
	
	
}
