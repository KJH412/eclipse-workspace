package com.shinhan.day06.lab;

public class TestShape {
	public static void main(String args[]) {
		//배열생성
		Shape[] s = new Shape[3];
		
		s[0] = new Circle("BLUE", 10); //Circle인데 Shape에 어떻게 넣을수있는지? 상속관계생각하면됨. 
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);
		
		for(int i = 0; i < 3; i++) {
			{
				print(s[i], i);
			}
		}
		
//		for (int i = 0; i < 3; i++) {
//			if (s[i] instanceof Circle cir) {
//				System.out.println("Shape " + i + " is a " + s[i] + " with an area of " + s[i].calculateArea()
//						+ ", a radius of " 
//						+ ((Circle) s[i]).getRadius() 
//						+ cir.getRadius()
//						+ ",   and   a   perimeter   of   "
//						+ s[i].calculatePerimeter());
//			} else if (s[i] instanceof Rectangle) {
//				System.out.println("Shape " + i + " is a " + s[i] 
//						+ " with an area of " + s[i].calculateArea()
//						+ "   and   a   perimeter   of   " + s[i].calculatePerimeter());
//			}
//		}
	}

	private static void print(Shape s, int i) {
			String result = (s instanceof Circle cir)?cir.getRadius()+"":"";
			System.out.println("Shape " + i + " is a " + s
					+ " with an area of " + s.calculateArea()
					+ ", a radius of  "+ result
					+ ",   and   a   perimeter   of   "
					+ s.calculatePerimeter());
		
	}
	
}

//추상 클래스(abstract method): 추상메서드가 1개이상 있는 class다.
//abstract class : 정의는 있고 구현은 상속받은 자식이 한다.
abstract class Shape { //public붙으면 안됨. class안에 main에 public은 하나여야 하나?
	private String color;
	private String type;

	public Shape() {
		
	}

	public Shape(String color, String type) {
		this.color = color;
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	//컴파일러가 해석을 하는 주석. Annotation
	@Override
	public String toString() {
		return color + " " + type;
	}
}
