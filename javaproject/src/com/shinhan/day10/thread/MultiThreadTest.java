package com.shinhan.day10.thread;

//process : 실행중인 하나의 프로그램.
//thread : 하나의 process내의 프로그램의 흐름.
//thread class이용하면 MultiTread프로그램이 가능.
public class MultiThreadTest {
	//자바는 main부터 실행된다. main스레드라고 함.
	public static void main(String[] args) {
		//static이라서 new안하고 바로 호출 가능 : Thread.currentThread()
		System.out.println(Thread.currentThread().getName() + "main thread시작....");
		
		//1)구현class로 만들기 (extends Thread)
//		Thread t1 = new UppercaseThread();

		//3)Runnable interface를 구현하기 (implements Runnable)
		Thread t1 = new Thread(UppercaseThread());
		
		//2)익명구현class만들기
		Thread t2 = new Thread() { //익명으로 만듦.
			@Override
			public void run() {
				for(char i='a'; i<='z' ; i++) {
					System.out.println(Thread.currentThread().getName()+ " i= "+ i);
				}
			}
		};
		//4)interface로 익명구현class만들기
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=1; i<=26; i++) {
					try {
						Thread.sleep(20); //주어진 시간동안 잠깐 일시정지 후 실행대기.
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("졸지말자~~~"+ i);
				}
			}
		});
		Thread t4 = new Thread(()-> { //람다표현식
			for(int i=1; i<=26; i++) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("열공~~~~"+ i);
			}
		});
		
		t1.start(); //실행흐름(3개) 만들고 run()호출.
		t2.start(); //실행흐름 만들고 run()호출.
		t3.start();
		t4.start();
		
		
		
		//1.영문자 대문자 출력
//		for(char i='A'; i<='Z' ; i++) {
//			System.out.println(Thread.currentThread().getName()+ "i= "+ i);
//		}
		//2.영문자 소문자 출력
//		for(char i='a'; i<='z' ; i++) {
//			System.out.println(Thread.currentThread().getName()+ "i= "+ i);
//		}
		//3.숫자 1~26 출력
//		for(int i=1; i<=26 ; i++) {
//			System.out.println(Thread.currentThread().getName()+ " i= "+ i);
//		}
		
		System.out.println(Thread.currentThread().getName()+"main thread끝.....");
	}

	private static Runnable UppercaseThread() {
		// TODO Auto-generated method stub
		return null;
	}

}
