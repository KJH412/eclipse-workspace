package com.shinhan.lab.lab8;

//RectTriangle(직각삼각형) 클래스
//직각삼각형의 둘레를 구하기 위해 피타고라스의 정리를 사용할 때 Math 클래스를 이용
public class RectTriangle extends Shape  {
	double width;
	double height;
	
	RectTriangle(double width, double height) {
		super(3);
		this.height = height;
		this.width = width;
	}

	@Override
	public double getArea() {
		// 넓이
		return width * height/2;
	}

	@Override
	public double getPerimeter() {
		// 둘레(피타고라스의 정리)
		return width + height + Math.sqrt(height*height+width*width);
	}

	
	
}
