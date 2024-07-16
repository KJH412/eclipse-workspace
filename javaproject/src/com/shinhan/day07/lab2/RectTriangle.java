package com.shinhan.day07.lab2;

public class RectTriangle extends Shape {
	int width ;
	int height;
	
	public RectTriangle(int width,int height){
		super(3);
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		return width*height/2;
	}

	@Override
	public double getPerimeter() {
		return width + height + Math.sqrt(height*height+width*width);
	}
}
