package com.shinhan.day11;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}
	
	
	//동기화 메서드 사용
	public synchronized void setMemory(int memory) {  //메서드 전체에 잠금 걸기
		this.memory = memory; //메모리값 저장
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+ this.memory); //this.memory : 메모리값읽기
	}
	
	
	//동기화 블럭 사용 (특정영역만)
	public void setMemory2(int memory) { 
		
		synchronized (this) { //잠금 synchronized
			this.memory = memory; //메모리값 저장
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+ this.memory); //this.memory : 메모리값읽기
		}
	}
	
	
	//동기화 처리 안한 상태
	public void setMemory1(int memory) { //롬복 사용X 직접작성해야함.
		this.memory = memory; //메모리값 저장
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+ this.memory); //this.memory : Calculator의 memory추가
		//this.memory : 메모리값읽기
	}
	
	
	
}
