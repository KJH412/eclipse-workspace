package com.shinhan.day07.lab2;

import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.Rect;

public class ShapeTest {

	public static void main(String[] args) {
		//interface는 인스턴스 생성불가
		//Resizeable aa = new Resizable();
		//Sahpe aa = new Shape();
		
//		f1(new Rectangle(6,2)); 
		
		
		
		Shape[] arr = new Shape[2]; //배열길이2개인 Shape배열 객체
		arr[0] = new Rectangele(5,6);
		arr[1] = new RectTriangle(6, 2);
		
		for(Shape shape:arr) {
			System.out.println("area" + shape.getArea()); //출력결과 area: 30.0
			System.out.println("perimeter" + shape.getPerimeter());//perimeter:22.0
			if(shape instanceof Resizable rr) {
				rr.resize(0.5);
				System.out.println("new area" + shape.getArea()); 
				System.out.println("new perimeter" + shape.getPerimeter());
			}
		}
	}

}
