package com.shinhan.day05;

public class ComputerTest {

	public static void main(String[] args) {
		Computer com1;
		com1 = new Computer();
//		com1.model = "AA";
		com1.setModel("AA"); //같은패키지 안에 Computer클래스에서 setModel접근가능.
		
		com1.price = 200; //protected int price 같은패키지라 접근가능.
	}

}
