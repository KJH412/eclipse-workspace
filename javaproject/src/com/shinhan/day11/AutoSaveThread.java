package com.shinhan.day11;


//데몬 스레드
//주 쓰레드를 도와주는 쓰레드
//주가 끝나면 같이 끝난다.
public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업내용을 저장한다.");
	}
	
	public void run() { //스레드 실행 메소드 run()
		while(true) {
			try {
				sleep(1000);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			save();
		}
	}
}
