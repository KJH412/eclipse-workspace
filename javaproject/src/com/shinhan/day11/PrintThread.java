package com.shinhan.day11;

//조건문 이용하여 안전하게 쓰레드 종료
public class PrintThread extends Thread	{
	
	private boolean stop; //false
	
	public void setStop(boolean stop) { //외부에서 stop필드값 변경할 수 있도록 Setter선언
		this.stop = stop;
	}
	
	//2.intterupt()매서드로 Exception을 발생시켜서 안전하게 쓰레드 종료하기
	public void run() {
		try {
			while(true) { 
				System.out.println("실행중....");
				sleep(1);//일시정지상태.....main에서 t1.interrupt()로 Exception발생시킴.(안전한종료)
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("리소스 정리");
		System.out.println("정상적으로 쓰레드 종료");
	}
	
	//1.조건문을 이용하여 안전하게 쓰레드 종료하기
	public void run2() {

	 while(!stop) { 
		System.out.println("실행중....");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//리소스 정리
	System.out.println("리소스 정리");
	System.out.println("정상적으로 쓰레드 종료");
	}
}
	

