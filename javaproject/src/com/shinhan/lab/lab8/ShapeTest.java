package com.shinhan.lab.lab8;

import java.util.Arrays;

/*
 	화면 출력(ShpeTest 실행):
	area: 30.0
	perimeter: 22.0
	new area: 7.5
	new perimeter: 11.0
	area: 6.0
	perimeter: 14.32455532033676

 */
public class ShapeTest {

	public static void main(String[] args) {
		
		Rectangle rec = new Rectangle(5, 6);
		RectTriangle rectriangle = new RectTriangle(6, 2);
		//2가지 Object를 배열에 추가
		Shape[] arr = new Shape[2];
		arr[0] = rec;
		arr[1] = rectriangle;
//		arr[0] = new Rectangle(5, 6); 한번에 배열 객체로 생성 가능
//		arr[1] = new RectTriangle(6, 2);
		
		//순환문을 사용해서 배열에 들어 있는 각 Shape들의 area와 perimeter를 출력합니다. 
		for(Shape shape:arr) {
			System.out.println("area:" + shape.getArea());
			System.out.println("perimeter:" + shape.getPerimeter());
			//만일 해당 Shpae가 Resizable 하다면,0.5 만큼 resize한 후 새로운 area와 perimeter를 출력합니다.
			//(new area / new perimeter)
			if(shape instanceof Resizable rr) {
				rr.resize(0.5); //public void resize(double s) s에 0.5가 들어가서 연산됨
				System.out.println("new area:" + shape.getArea());
				System.out.println("new perimeter:"+ shape.getPerimeter());
			}
		}
		
	}

}
