package com.shinhan.day07.lab2;

public abstract class Shape {
	int numSides; //변의 수
	
	Shape(int numSides){ //return없으니 생성자.
		this.numSides = numSides;
	} 
	int getNumSides(){ //get이라 return
		return numSides;
	}
	//B.getArea 메쏘드와 getPerimeter 메쏘드의 리턴 타입은 double 형
	//추상 (abstract앞에 public생략되어있음.)
	public abstract double getArea(); 
	public abstract double getPerimeter();
	
		
}
