package com.shinhan.day05;

public class Calculator {
	//1.static field
	static double pi = 3.141592;
	static String company = "퍼스트존";
	static String company2; //초기화안한것. 하고싶으면 block을 씀.
	
	static String color;
	
	//2.static block
	static {
		System.out.println("class load시에 1회 수행된다.");
		company2 = "상공회의소";
	}
	//3.static method
	static double plus(int a, int b){
		
		Calculator cal = new Calculator();
		cal.color = "red";
		return a+b+pi; //정수+정수+실수 int plus는 계산안됨. double plus로 수정
	} 
	double minus(int a, int b){
		color = "red";
		return a - b + pi;
		
	}
	
}
