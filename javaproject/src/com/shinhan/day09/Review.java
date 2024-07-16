package com.shinhan.day09;
//예외처리 복습
import java.io.FileNotFoundException;
import java.io.IOException;

//람다식 @FunctionalInterface 불가. (1개이상이라)

//정의는 있고 구현은 없다.
interface MyInterface{ //인터페이스안에있는건 추상메서드. {}구현이없다.
	//3개가 있어서 람다식(1개)은 불가능하고 익명구현은 가능.
	public abstract void method1();
	void method2() throws IOException;
	void method3() throws Exception;
}

//구현class 
//1.부모의 throws Exception이 존재하지 않은 경우 : 없거너 RuntimeException 가능.
//2.자식은 부모의 Exeption보다 하위이어야한다.
class MyClassImpl implements MyInterface {
	//추상메서드 전부 재정의
	@Override
	public void method1() throws RuntimeException {
		System.out.println();
	}

	@Override
	public void method2() throws FileNotFoundException /*throws IOException*/ { //범위를 넘어서지만 않으면 된다.
		
	}

	@Override
	public void method3() throws Exception {
		
	}
	
}

public class Review {
	//1.field
	MyInterface a = new MyClassImpl(); //구현클래스는 구현클래스타입으로 넣을 수 있다. 
	MyInterface a2 = new MyClassImpl() { 	//인터페이스는원래 생성이 안돼지만 구현은 가능.
		public void method1() {};
		public void method2() {};
		public void method3() {};
	};
	
	
	public static void main(String[] args) {
		//2.local 변수
		MyInterface b = new MyClassImpl();
		MyInterface b2 = new MyClassImpl() {
			public void method1() {};
			public void method2() {};
			public void method3() {};
		};
				
		
		call(new MyClassImpl()); //구현클래스썼을 때 사용
		call(new MyInterface() {
			public void method1() {};
			public void method2() {};
			public void method3() {};
		});
	}

	private static void call(MyInterface c) { //구현클래스썼을 때 사용
		// TODO Auto-generated method stub
		
	}

}
