package com.shinhan.day11;

public class WorkThread extends Thread{
	
	boolean work = true;
	
	public WorkThread(String name) {
		//setName(name);(가능) 
		super(name); //(가능) Thread안에 있는 생성자
	}

	@Override
	public void run() {
		while(true) { //무한반복
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(work) {
				System.out.println(getName() + " :작업처리"); //getName():스레드이름
			}else {
				Thread.yield(); //양보
			}
		}
	}
	
	

}
