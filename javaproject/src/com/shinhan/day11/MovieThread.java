package com.shinhan.day11;

public class MovieThread extends Thread {

	@Override
	public void run() {

		synchronized (this) {
			try {
				while (true) {
					System.out.println("동영상을 재생합니다.");
					// 1)
//					if(this.isInterrupted()) break; 가능
					// 2)
					sleep(1);
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("자원(리소스) 정리");
			System.out.println("안전 종료");
		}

	}

}
