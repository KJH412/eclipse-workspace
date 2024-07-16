package com.shinhan.day10;

import java.io.FileNotFoundException;

//변수(data)+기능(메서드)
class Machine extends Object{ //Object:자바의 오브젝트
	Machine(){
		super(); //super는 명식적으로 적을때 첫번째줄만 가능함. (아래에 쓰면 부모 두번호출)
		System.out.println("Machine 기본생성자");
	}
}
//다중상속은 안돼지만 인터페이스 여러개를 구현할 수 있음.
//규격서 : 상수+추상메서드(기본)+default,static,private메서드
interface MyInterface{ //비슷한기능은 인터페이스로 정의.
	public abstract void method1(); //public abstract생략되어있음. 추상메서드. 구현이 안되어있다.
}

//상속(부모의 private제외한 모든변수(data) + 기능(메서드) 접근가능, 수정(override), 추가가능
//수정(override), 추가기능(이름같고 매개변수가 다르다면 Overloading), 추가(이름다름)
class CoffeeMachine extends Machine implements MyInterface, AutoCloseable{//implements: 인터페이스의 추상메서드를 구현한다.
																		  //AutoCloseable(자동닫기)는 자바의 인터페이스임. 
	
	CoffeeMachine(){
		super(); //부모의 default생성자 호출
		System.out.println("CoffeeMachine기본생성자");
	}
	
	@Override
	public void close() throws Exception { //예외 던짐. 
		System.out.println("AutoCloseable interface의 close() 재정의");
	}

	@Override
	public void method1() {
		System.out.println("method1.....구현class가 interface에서 정의한 추상메서드를 구현");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeMachine [.....]...field가 있다면 이용해서 정보를 문자열로 만들기");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return "Coffee".hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return "Coffee".equals("Coffee"); //true라고 내가 정의한 것.
	}
	
}

public class Review {
	
	public static void main(String[] args) {

		try(CoffeeMachine coffee1 = new CoffeeMachine();
			CoffeeMachine coffee2 = new CoffeeMachine();
			) { //자동으로 close를 불러준다.
			coffee1.method1();
			coffee2.method1();
			System.out.println(coffee1); //toString()호출:com.shinhan.day10.CoffeeMachine@626b2d4a(재정의필요)
			System.out.println(coffee2); //toString()호출
			System.out.println(coffee1==coffee2); //== :주소비교(재정의필요)
			System.out.println(coffee1.equals(coffee2)); //주소비교
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		/*
		//CoffeeMachine coffee1 = new CoffeeMachine();
		try(CoffeeMachine coffee1 = new CoffeeMachine()) { //객체생성은 ()안에 생성하면 자동으로 colse닫힌다.
			coffee1.method1();
			//coffee1.close();  //호출. close가 던진 예외 처리한다.
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		try() {
			CoffeeMachine coffee1 = new CoffeeMachine()
			coffee1.method1();
			//coffee1.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		*/
		
		
	}
}


