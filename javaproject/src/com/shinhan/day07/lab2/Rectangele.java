package com.shinhan.day07.lab2;

public class Rectangele extends Shape implements Resizable  {
	double width;
	double height;
	public Rectangele(double width, double height) {
		super(4); //변 4개
		this.height = height;
		this.width = width;
	}
	
	@Override
	public void resize(double s) {
//		width = width * s;
//		height = height * s;
		width *= s;
		height *= s;
		
	}
	@Override
	public double getArea() {		
		return width * height;
	}
	@Override
	public double getPerimeter() {		
		return 2*(width+height);
	}
	
}
