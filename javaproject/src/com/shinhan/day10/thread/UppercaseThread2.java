package com.shinhan.day10.thread;

//멀티스레드 : 
//A 1)Thread를 상속 2)run()메서드 재정의 3)new객체생성후 start()...run()수행됨
//B. 이미 상속받은 부모가 있다면 자바는 멀티상속불가하므로 Runnable interface구현

public class UppercaseThread2 extends Thread{  //스레드를 상속받음.
	
	@Override
	public void run() {
		//1.영문자 대문자 출력
		for(char i='A'; i<='Z' ; i++) {
			try {
				sleep(10);//Thread에 있는 메소드라 그냥 바로 사용.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName()+ " i= "+ i);
		}
	}
}
