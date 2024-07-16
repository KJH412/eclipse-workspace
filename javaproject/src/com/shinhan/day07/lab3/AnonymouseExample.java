package com.shinhan.day07.lab3;

interface Vehicle {
	public void run();
}

class Anonymouse {
	// 1.익명구현클래스를 field로 사용.
	Vehicle field = new Vehicle() {
		
		public void run() {
			System.out.println("자전거가 달립니다.");
		}
	};

	Vehicle field2 = () -> System.out.println("자전거가 달립니다. 람다식");

	void method1() {
		// 2.익명구현클래스를 지역변수로 사용하기. (매소드 내부)
		Vehicle localVar = new Vehicle() {
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		Vehicle localVar2 = () -> System.out.println("승용차가 달립니다.");
		
		localVar.run();
		localVar2.run();
	}

	void method2(Vehicle v) {
		v.run();
	}
}

public class AnonymouseExample {

	public static void main(String[] args) {
		Anonymouse anony = new Anonymouse();
		 anony.field.run();
		 anony.method1();
		 //3.익명 구현 class를 파라메터로 사용하기 
		 anony.method2(new Vehicle() {
			
			 @Override
			public void run() {
				System.out.println("트럭이 달립니다");
				
			}
		} );
		anony.method2(()->System.out.println("트럭이 달립니다"));
	}
}
