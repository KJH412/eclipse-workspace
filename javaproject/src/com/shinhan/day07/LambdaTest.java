package com.shinhan.day07;

public class LambdaTest {

	public static void main(String[] args) {
		//1.익명
		int result = (new Calculator() {
			
			@Override
			public int sum(int a, int b) {
				System.out.println("익명구현class");
				return a+b+100;
			}
			
		}).sum(1,2);
		System.out.println(result);
		
		//2.람다표현식
		//Calculator cal = (x,y)-> x+y+200; //로직이 1개일때 
		Calculator cal = (x,y)-> { //로직이 두줄이상이면 return
			System.out.println("람다표현식");
			return x+y+200;
		};
		result = cal.sum(10, 20);
		System.out.println(result);
	}

}
