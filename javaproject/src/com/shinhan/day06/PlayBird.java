package com.shinhan.day06;

public class PlayBird {

	public static void main(String[] args) {
		Duck d1 = new Duck(2, 15);
		d1.setName("꽥꽥이");
		Sparrow s1 = new Sparrow(2, 10);
		s1.setName("짹짹");
		
		d1.fly();
		d1.sing();
//		System.out.println();
		
		s1.fly();
		s1.sing();
//		System.out.println(s1);
	}


}