package com.shinhan.day05;


/* 접근지정자(Modifier)
 1.public : 모든 패키지에서 접근 가능.
 2.protected
 3.생략 : 같은패키지에서 접근가능. 다른패키지인 경우 상속받으면 접근가능.
 4.private :같은 class내에서 접근가능. (정보은닉, 캡슐화)
*/
//class 접근지정자는 public, 생략 둘 중 하나다.
public class Computer {
	private String model;
	protected int price; 
	
	public Computer(){ //생성자
		 System.out.println("default생성자 정의함");
	 }
	public void setModel(String model){ //set이기 때문에 return을 못함. void붙인다.
		this.model = model;
	}
}
