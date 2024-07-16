package com.shinhan.day10.thread;

//멀티스레드 : 
//A 1)Thread를 상속 2)run()메서드 재정의 3)new객체생성후 start()...run()수행됨
//B. 이미 상속받은 부모가 있다면 자바는 멀티상속불가하므로 Runnable interface구현

class Parent{
	
}
//스레드를 상속받은건 아님.
//Runnable이라는 인터페이스를 구현하고있는 클래스다.
//Thread.currentThread().getName() : 스레드를 얻는 방법 Thread.~~
public class UppercaseThread extends Parent implements Runnable{ 
							//=> Parent를 상속받고 있다. 스레드가 X.. Run
/*public class UppercaseThread extends Thread{*/

	@Override
	public void run() {
		//1.영문자 대문자 출력
		for(char i='A'; i<='Z' ; i++) {
			try {
				Thread.sleep(10);//Thread.sleep() : UppercaseThread가 스레드를 상속하고 있지 않아서
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName()+ " i= "+ i);
		}
	}
	
	//Thread.currentThread().getName() : 현재 스레드 이름을 얻는다.
	
}
