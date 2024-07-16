package com.shinhan.day05;

//SingleTone : 객체가 1번만 생성된다.
public class SingleToneClass {

	private static SingleToneClass single;
	//여기서 new한 객체를 SingleToneTest클래스에서 사용한다.
	
	//싱글톤의 핵심은 생성자를 private 외부접근막아서 new연산자로 생성자호출할 수 없도록함.
	
	private SingleToneClass(){ //private 외부에서 생성못하게 제한.
		 
	}
	public static SingleToneClass getInstance() { //static붙어야 객체생성없이 접근가능. public 외부에서 접근 가능.
		if(single == null) {
			single = new SingleToneClass();			
		}
		return single; //null이 아닐 경우에는 조건문 바깥 return 실행.
	}
}
