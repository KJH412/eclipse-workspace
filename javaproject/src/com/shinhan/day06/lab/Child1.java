package com.shinhan.day06.lab;
//6. 확인문제 
public class Child1 extends Parent{
	private int studentNo;

	public Child1(String name, int studentNo) {
		//default는 부모의 생성자를 호출한다.
		//1.부모가 default생성자 가진다.
		//super();
		//2.명시적으로 부모의 생성자를 호출한다.
		//public Parent(){}
		super(name); 
		this.studentNo = studentNo;
	}
}
