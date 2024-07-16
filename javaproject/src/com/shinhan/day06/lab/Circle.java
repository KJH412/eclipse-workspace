package com.shinhan.day06.lab;

public class Circle extends Shape {
	double radius;
	double circumference; //면적
	
	public Circle(String color, double radius) { //자동완성안하고 직접작성함. radius가 자동형변환됨.
//		color를 초기화하는 생성자Shpap 부모부르기.
		super(color, "Circle");
		this.radius = radius; //초기화
	}
	
	public double getRadius() { //반지름 받는 getter
		return radius;
	}
	
	
	//추상 구현
	@Override
	public double calculateArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public double calculatePerimeter() {
		circumference = 2 * Math.PI * radius;
		return circumference;
	}

}
