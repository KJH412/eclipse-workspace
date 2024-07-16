package com.shinhan.day10.thread;

public class TransferThread extends Thread {
	
	ShareArea shareArea;
	
	TransferThread(ShareArea shareArea) {
		this.shareArea = shareArea; 
	}
	
	@Override
	public void run() {
		//12번 계좌 이체하기
		for(int i=1; i<=12; i++) {
			//synchronized block: 공유데이터를 하나의 스레드가 점유하고 있을 때 다른스레드가 접근불가.
//			synchronized (shareArea) {
//				int amount = shareArea.lee.withdraw(100); 
//				//여기서 100이출금. 읽히기전에 deposit()이 읽혀서 잔고가 2900이된다.(3천이 정상)
//				System.out.println("이몽룡계좌에 출금" + amount);
//				System.out.println("성춘향계좌로 입금" + amount);
//				shareArea.sung.deposit(amount); 
//			}
			
			shareArea.transfer(); //위 코드를 더 간단히(공유영역에 넣어서 호출)
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
