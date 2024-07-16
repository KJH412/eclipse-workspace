package com.shinhan.day10.thread;

//Runnable인터페이스를 implements받아서 구현해야함.
public class PrintThread implements Runnable {

	ShareArea shareArea;
	
	PrintThread(ShareArea shareArea){
		this.shareArea = shareArea;
	}
	@Override
	public void run() {
		for(int i=1; i<=3; i++) {
			
//			synchronized (shareArea) {
//				int lee = shareArea.lee.balance; //이몽룡 잔고 얻기
//				int sung = shareArea.sung.balance; //성춘향 잔고 얻기
//				System.out.println("잔고의 합: "+ (lee+sung));
//			}
			
			shareArea.print(); //위 코드를 더 간단히(공유영역에 넣어서 호출)
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		}
	}

}
