package com.shinhan.day05;

import java.lang.reflect.Method;

public class CarTest {

	public static void main(String[] args) {
		method1();
		method3();

	}
	
	private static void method3() {
		System.out.println("Car 대수: "+ Car.carCount);
		System.out.println("Car company: "+ Car.company);
		
		//배열변수선언 + 생성
		Car[] arr = new Car[5]; //Car[]는 배열이라는 선언임. Car[5] arr 이러면 X
		
		//객체 참조 변수 선언 + 생성, 사용
		//Car car1; //선언
		//Car car1 = new Car(); //생성
		//But Car클래스 안에 Car(){}기본타입 생성자가 없어서 위처럼 만들 수 없음.
		Car car1 = new Car("A모델", 1000); //클래스변수car1
		Car car2 = new Car("B모델", 2000);
		Car car3 = new Car("C모델", 3000);
		Car car4 = new Car("D모델");
		Car car5 = new Car(5000);
		System.out.println("생성후 Car 대수 : " + Car.carCount);
		
		for(Car cc:arr) {
			cc.carInfoPrint("-------------------------------------");
		}
		
		
	}

	private static void method1() {
		//static은 class소유이므로 object생성과 관계없다.
		System.out.println("Car 대수: "+ Car.carCount);
		System.out.println("Car company: "+ Car.company);
		Car.carInfoPrint2("***********");
		int a =100;
		method2(); //void method2() : void는 리턴이 없어서 호출해야함.
	}

	private static void method2() {
		System.out.println("-----------------");
	}
}
