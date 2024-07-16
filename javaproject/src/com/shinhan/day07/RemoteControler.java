package com.shinhan.day07;

/*
 * interface 인터페이스
 * 두 객체를 연결하는 역할
 * 정의는 있고 구현은 없다.(default메서드구현가능) (규격서)
 * interface를 구현한 class를 만들어 함수를 구현한다.
 * 
 * 교재(이것이자바다) 8.4추상메소드의 리모콘 그림 참고
 *  
*/
//public 예약어(인터페이스,default,클래스...등) 클래스명 {}
public interface RemoteControler {
	/*
	 * 인터페이스가 갖는 메서드 5개.
	 * 1.상수(바뀌지않는값)
	 * 2.추상메서드(public abstract 생략가능) 정의는 있지만 구현{}은없음.
	 * 3.default메서드(구현class가 공통적으로 가지는 기능을 구현, 재정의 가능)
	 * 4.static메서드(interface가 가지는 기능, 구현class가 재정의 불가능)
	 * 5.private메서드(interface내에서 모듈화 또는 재사용을 위해 사용)
	 * 
	 * 일반메서드 불가 , 생성자 불가
	 * void method();
	 * 
	 * */

	//1.상수
	int CHANNEL = 0;
	public static final int CANNEL2 = 10; //public static final 생략가능
	//int a; (X) int a = 1; (O)	
	
	//2.추상메서드 (public abstract 생략가능)
	void method1();
	public void method2();
	void turnOn();
	void turnOff();
	
	//**공통된 기능을 인터페이스에 구현을 해놓는데, 기능이 다르면 구현클래스에서 재정의해서 기능내용을 바꾸면 된다. 
	// 3.default메서드 
	default void method3() {
		System.out.println("default method...재정의 가능");
		method5();
	}
	
	//**static은 다른 클래스에서 고칠 수 없는 리모트컨트롤러에만 있는 기능인 것이다. 
	//사용할때 RemoteControler.~으로사용해야한다. 인터페이스로 접근해야함.
	//4.static메서드
	static void method4() { //static이붙었음->클래스것이아니라 인터페이스의 것.
		System.out.println("static method4...재정의 불가능");
		//method5(); //부를 수 없다.
	}
	//5.private메서드
	private void method5() { //접근제한자(private)를 안쓰면 일반메서드가 되기 때문에 꼭 써준다.
		System.out.println("private method5...외부 접근 불가, default메서드가 호출함");
	}
	

}

