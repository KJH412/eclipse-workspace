package com.shinhan.day06;

//클래스
//class Parent2{ // 아무것도 안쓰여있어도 extends Object가 숨어있음. Object가 최상위 클래스임.
class Parent2 extends Object{
	int score = 100;
	void show() {
		System.out.println("3.부모에서 score 접근: " + score); //얘가 갖고있는 100을 찍는다.
	}
}
class Child2 extends Parent2{
	
	String score = "A학점";
	
	//override(덮어쓰기) : 이름,매개변수,return,moditier★
	void show() {
		System.out.println("2.!!!!자식에서 score 접근: " + score); 
	}
	
	//overloading(추가) : 이름은 같고 매개변수 사양이 다르다.★
	void show(String a) {
		System.out.println("1.==============");
		show(); //자신의 class에 재정의 되어있으면 메서드수행
		//super는 부모를 의미. 자기가 show를 갖고있더라도 부모것을 수행.
		super.show(); //부모것(가까운것)쓰려면 super쓰면됨.
		System.out.println("4.!자식에서 score 접근: " + score); 
	}
	void print() {
		System.out.println("자식이 score접근: "+ score);
		show(); //extends 해서 부모Parent2에 접근 가능.
	}
}
public class InheritenceTest2 {

	public static void main(String[] args) {
		Child2 aa = new Child2(); //Object생성, Parent2생성,Child2생성
		
		System.out.println(aa.score);
		aa.print(); //Child2안의 void print() {}가 출력됨.
		aa.show(); //Child2가 Parent2상속을 받아서 show에 접근가능.
		
		aa.show("*******");
	}

}
