package com.shinhan.day07;

public class Cupusing {

	//여기서 필드로 사용 가능.
	
	public static void main(String[] args) {
		//CoffeeCup cup = new CoffeeCup();  지역변수로 사용
		//WaterCup cup2 = new WaterCup();
		print(new CoffeeCup()); //매개변수로 사용
		print(new WaterCup());
		print(new Cup() { //익명구현객체?
			@Override
			public void use() {
				System.out.println("익명 구현class");
			}
		});
		print(()->System.out.println("람다표현식으로 구현class만들기"));
	}
	static void print(Cup cup) {
		cup.use();
	}

}
