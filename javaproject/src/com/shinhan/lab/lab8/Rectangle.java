package com.shinhan.lab.lab8;

//Rectangle(직사각형) 클래스
public class Rectangle extends Shape implements Resizable {
	double width;
	double height;

	public Rectangle(double width, double height) {
		super(4);
		this.height = height;
		this.width = width;
	}

	//기존 width와 height를 해당 인자를 곱한 값으로 변경
	@Override
	public void resize(double s) {
//		width *= s;
//		height *= s;
		width = width * s;
		height = height * s;
	}

	@Override
	public double getArea() { // 넓이
		return  width * height;
	}

	@Override
	public double getPerimeter() { // 둘레
		return (width+height)*2;
	}

}
