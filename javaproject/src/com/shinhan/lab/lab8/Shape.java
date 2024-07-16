package com.shinhan.lab.lab8;
//Shape::Abstract Class
public abstract class Shape {

	int numSides;
	
	Shape(int numSides){
		this.numSides = numSides;
	}

	int getNumSides(){
		return numSides;
	};

	public abstract double  getArea(); // 넓이

	public abstract double  getPerimeter(); // 둘레 길이

}
