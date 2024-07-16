package com.shinhan.day10.thread;

public class MultiThreadTest2 {
	
	public static void main(String[] args) {
		//공유데이터
		BathRoom room = new BathRoom();
		
		//흐름3개 만듦. 멀티스레드
		BathroomThread t1 = new BathroomThread(room, "김");
		BathroomThread t2 =new BathroomThread(room, "박");
		BathroomThread t3 =new BathroomThread(room, "양");
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void f2(String[] args) {
		ShareArea shareArea = new ShareArea(
				new Account("112", "이몽룡", 2000),
				new Account("113", "성춘향", 1000)
				);
		Thread t1 = new TransferThread(shareArea);
		Thread t2 = new Thread(new PrintThread(shareArea));
		t1.start();
		t2.start();
	}
	
	public static void f1(String[] args) {
		System.out.println(Thread.currentThread().getName() + "시작");
		
		//자식이 부모에 담겼다.
		Thread t1 = new UppercaseThread2();
		Thread t2 = new Thread(UppercaseThread()); //<--이건 스레드아님. Runnable인터페이스 구현한것임. Thread()안에 넣어준다.
		Thread t3 = new UppercaseThread2();
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(Thread.currentThread().getName() + "끝");
		
	}

	private static Runnable UppercaseThread() {
		// TODO Auto-generated method stub
		return null;
	}
}
