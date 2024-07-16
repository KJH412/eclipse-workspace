package com.shinhan.day06;

import com.shinhan.day05.Computer; //import 

public class ModifierTest extends Computer {
	
	void print() {
		System.out.println(price); //상속
	}

	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		Computer com1;
		com1 = new Computer();
//		com1.mode = "AA";
		com1.setModel("AA");//setModel이 public이여야 접근 가능.
		//com1.price = 200; //protected int price 사용불가. 사용하려면 상속 extends
	}

}
