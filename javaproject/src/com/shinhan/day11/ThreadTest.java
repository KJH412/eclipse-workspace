package com.shinhan.day11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.shinhan.day10.thread.BathRoom;
import com.shinhan.day10.thread.BathroomThread;

public class ThreadTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
		f9();
		System.out.println("메인 END");
	}

	private static void f9() {
		BathRoom room = new BathRoom();
		BathroomThread t1 = new BathroomThread(room, "김");
		BathroomThread t2 =new BathroomThread(room, "박");
		BathroomThread t3 =new BathroomThread(room, "양");
		t1.start();t2.start();t3.start();
	}

	private static void f8() {
		MovieThread thread = new MovieThread();
		thread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
	}

	private static void f7() {
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		for(int i=1; i<=100; i++) {
			int end = i;
			Future<Integer> result = service.submit(new Callable<Integer>() { //내부클래스 //Callable : return있을 때

				@Override
				public Integer call() throws Exception {
					//합계 계산
					int sum = 0;
					for(int j=1; j<=end; j++) { //i로 바로 사용 불가(final)
						sum += j;
					}
					System.out.println(Thread.currentThread().getName()+ ":" + end + "까지 합 ==> " + sum);
					return sum;
				}
			});//반복중
			try {
				Integer a = result.get();//예외발생
				System.out.println("a= " + a);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		service.shutdown();
	}

	//익명구현클래스 로컬변수final (final이 생략되어있음)
	private static void f6() {
		String s = "JAVA"; //final임. LocalClass의 메소드에서 사용된 로컬변수라서
		int score = 100;
		class LocalClass{
			void method1() {
//				s += "프로그램";
//				System.out.println(score); 쓸 수 없음. final로컬변수라 값변경 안됨.
				System.out.println(s);
			}
		}
		score= 200;
		
		Runnable r  = new Runnable() {
			
			@Override
			public void run() {
//				System.out.println(score); 쓸 수 없음.
				System.out.println(s);
			}
		};
	}

	private static void f5() {
		String[][] mails = new String[1000][3];//메일이 1000개 (2차원배열)
		int i = 1; //향상된for문에는 index가 없어서 선언.
		for(String[] arr:mails) { //(1차원배열에담음)
			arr[0] = "admin@my.com"; //누가
			arr[1] = "member"+ i + "@my.com"; //누구에ㅔㄱ
			arr[1] = "신상품 입고되었습니다"; //누구에ㅔㄱ
			i++;
		}
		//MultiThread(5개)로 1000명의 이메일을 보내기
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		//내부class에서 지역(로컬)변수 접근 -> *지역변수는 무조건 final이다.
		//idex가 로컬변수로 final이다.
		for(int index=0; index<1000; index++) { //배열은 0~999
			int seq = index; //값을 복사
			service.execute(new Runnable() { //Runnable인터페이스를 구현한 익명구현클래스만듦.new Runnable(){구현클래스내용}
											 //execute
				@Override
				public void run() { //메서드 안의 메서드
					String messege = "쓰레드이름: " + Thread.currentThread().getName()
							+ "\n from" + mails[seq][0]  //[index]는 상수라 변경이 x
							+ "\n To:" + mails[seq][1]
							+ "\n 내용:" + mails[seq][2];	
					System.out.println(messege);
				}
			});
		}
	}

	private static void f4() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); //데몬이 끝나면 main 끝남.
		t1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void f3() {
		PrintThread t1 = new PrintThread();
		t1.start(); //무한 루프중
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		t1.setStop(true); 
//		비추천 t1.stop();
		
		t1.interrupt();
		
	}

	private static void f2() {
		//공유데이터 만들기 calculator
		Calculator calculator = new Calculator();
		
		User1Thread t1 = new User1Thread();
		t1.setCalculator(calculator);
		
		User2Thread t2 = new User2Thread();
		t2.setCalculator(calculator);
		
		t1.start(); t2.start(); //쓰레드시작->실행대기상태->차례가되면수행(지금은 우선순위가 없음)
		//하나의 변수calculator에 t1,t2가 사용해서 
		
	}

	private static void f1() {
		//WorkThread하나의 스레드로 두개의 흐름을 만듦.t1,t2
		//Thread 상위를 따르는게 나음.
		WorkThread /*Thread*/ t1 = new WorkThread("WorkThread1");
		WorkThread t2 = new WorkThread("WorkThread2");
		
		t1.start(); t2.start();//시작
		try {
			Thread.sleep(5000);//5초대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		//t1이 false가 되면서 yeld()메소드로 실행이 t2에게 양보된다.
		t1.work = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
