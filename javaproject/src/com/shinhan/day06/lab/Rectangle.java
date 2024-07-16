package com.shinhan.day06.lab;

public class Rectangle extends Shape {

	double length, width;
	
	public Rectangle(String color, double length, double width) {
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}

	//추상 구현
	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 2*(length+width);
	}

}
