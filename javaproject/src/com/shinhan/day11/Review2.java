package com.shinhan.day11;

//Process : 실행중인 하나의 프로그램. (하나의 프로세스안에 흐름이 여러개=멀티스레드)
//Thread : 프로그램에서 하나의 흐름
//MultiThread : 실행중인 하나의 프로그램의 흐름이 여러개
//1)Thread class상속
//2)Runnable interface구현

class MyThread1 extends Thread {//스레드상속받으면 멀티스레드로 쓸 수 있다.
	
	//String name; X
	
	MyThread1(String name){
		//this.name = name; X
		super(name);
	}
	
	//source>override>method>스레드가 갖고있는 run메소드 재정의한다.
	@Override
	public void run() {
		System.out.println(currentThread().getName());
	} 
	
}

class MyThread2 extends Object implements Runnable  {
	
	String name;

	MyThread2(String name){
		//super(name); 불가능
		//Thread. (이름을 주고싶은데 없음)
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + name);
	} 
	
}
public class Review2 {

	public static void main(String[] args) {
			f1();

	}

	private static void f1() {
		MyThread1 t1 = new MyThread1("신한1");
		Thread t2 = new MyThread1("신한2"); //MyTread는 Thread를 상속하니까 Thread타입으로 객체를 변수에 담을 수 있다.
		Thread t3 = new  Thread("신한3") {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		
		};
		MyThread2 myrunnable = new MyThread2("신한4"); //thread아니고 runnable구현 class
		Thread t4 = new  Thread(myrunnable);
		Thread t5 = new  Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable의 익명구현class");
			}
		});
		Thread t6 = new  Thread(()-> {
				System.out.println("Runnable의 익명구현class");
		});
		t1.start(); t2.start(); t3.start(); t4.start();t5.start();t6.start();

		System.out.println(Thread.currentThread().getName()+"thread END");		
	}

}