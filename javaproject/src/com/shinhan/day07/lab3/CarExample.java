package com.shinhan.day07.lab3;

public class CarExample {

	public static void main(String[] args) {
		Car mycar= new Car();
		//instance inner class
		Car.Tire tire = mycar.new Tire();
		//static inner class
		Car.Engine engine = new Car.Engine();
		
		//local class는 매소드내에서 접근, 외부접근불가
		mycar.method();

	}

}
