package com.shinhan.day10.thread;

//공유영역
public class BathRoom {
	
	//synchronized를 써야 엉망으로 출력되지않음.
	//하나의 thread가 이 메서드 수행중 Lokc건다.
	//즉, 다른 Thread가 접근불가 , 하나의 thread가 메서드 벗어나면 대기thread가 들어온다.
	
	boolean isFirst = true;
	
	//동기화 메서드
	//********wait()와 notify()는 동기화메소드 또는 블록에서만 호출할 수 있다.
	synchronized void use(String name) {
		
		if(isFirst && name.equals("김")) {
				isFirst = false;
			try {
				wait(); //wait() 여기들어오면 일시정지 상태. 다른Thread가 들어올 수 있다.
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
//			isFirst = false; 여기서 바꿔도 됨
			
			System.out.println(name + "입장");
			System.out.println(name + "사용중");
			System.out.println(name + "퇴장");
			System.out.println("--------------");
			
			notifyAll(); //wait()상태의 쓰레드를 실행대기상태로 만든다.
		}
		
	}
	void use2(String name) {
		//동기화 block
		synchronized (this) { //공유데이터가 들어오면 LOCK //this는 현제객체. 여기서this는 BathRoom객체.
			System.out.println(name + "입장");
			System.out.println(name + "사용중");
			System.out.println(name + "퇴장");
			System.out.println("--------------");
		}
		
	}
	
	/*
	void use(String name) {
		System.out.println(name + "입장");
		System.out.println(name + "사용중");
		System.out.println(name + "퇴장");
		System.out.println("--------------");
	}
	*/
}
