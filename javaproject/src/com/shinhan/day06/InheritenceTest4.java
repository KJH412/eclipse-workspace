package com.shinhan.day06;


//구현 : {}
//추상(abstract): 정의는 있고 구현은 없다. 구현은 자식class가 한다.
//abstract method : 정의는 있고 구현은 없다.
//abstract class : class안에 추상메서드가 하나라도 있다.
//  				객체생성불가
//추상메서드를 상속받은 자식은 반드시 추상메서드를 구현할 의무가 있다.


//1
abstract class Vehicle { //추상클래스
	abstract void run(); // {}중괄호안씀. 구현이 없으면 추상메소드
	void print() {
		System.out.println("일반메서드");
	}
//	void run() {
//		System.out.println("부모의 run메소드");
//	}
}

abstract class Truck extends Vehicle{//추상클래스
	abstract void run();
	void print2() {
		System.out.println("구현메서드");
	}
}
class Truck2 extends Truck{ //일반클래스는 추상메소드를 반드시 구현해야한다.
	void run(){
		System.out.println("추상메서드 반드시 자식이 구현할 의무가 있다.");
	}
}

class Bus extends Vehicle{
	void run() {
		System.out.println("(Bus)자식override.. run메소드");
	}
}
class Taxi extends Vehicle{
	void run() {
		System.out.println("(Taxi)자식override.. run메소드");
	}
}
class Driver{
	void drive(Vehicle vv) { //메서드에 매개변수
		vv.run(); 
	}
}

//2
class Tire{
	void roll() {
		System.out.println("부모가 정의 roll()");
	}
}

class HankookTire extends Tire{
	void roll() {
		System.out.println("한국타이어 정의 roll()");
	}
}

class KumhoTire extends Tire{
	void roll() {
		System.out.println("금호타이어 정의 roll()");
	}
}

class Car {
	Tire tire;
	Car(Tire tire){
		this.tire = tire;
	}
	void go() {
		tire.roll();
	}
}


public class InheritenceTest4 { //같은동작을 하는데 결과가 다름.
	public static void main(String[] args) {
		System.out.println("------매개변수의 다형성------");
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Taxi());
//		driver.drive(new Vehicle()); 불가능. new를 못함.
		
		
		System.out.println("------field의 다형성------");
		Car car1 = new Car(new HankookTire());
		Car car2 = new Car(new KumhoTire());
		
		car1.go();
		car2.go();
	}
}
