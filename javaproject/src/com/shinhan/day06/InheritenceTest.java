package com.shinhan.day06;

class Parent extends Object { //extends Object도 자동으로 만들어짐. 부모도 자동으로(Object.class)로 만들어짐.
	String title = "부모에서 정의함";
	private String title2 = "부모에서 정의함";
	
	Parent(){
		//super(); 자동으로 부모의 default 생성자를 호출
		System.out.println("부모의 default 생성자");
	}
	void show() {
		System.out.println("부모에서 정의한 show메서드...title"+ title);
		System.out.println("부모에서 정의한 show메서드...title2"+ title2);
	}
	private void print() {
		System.out.println("부모에서 정의한 print메서드...title2:"+ title2);
	}
}
class Child extends Parent {
	int title = 200; //String이 아닌건 
	int score = 100;
	Child(){
		//super(); 호출하지않아도 자동으로 부모의 default 생성자를 호출한다. super는 부모를 뜻함.
		System.out.println("자식의 default 생성자");
	}
	void show2() { //자식
		System.out.println("자식에서 정의한 show2메서드");
		System.out.println("자식출력...title: "+ title);
//		System.out.println("private로 정의된 field 접근불가: "+ title2); //private여서 불가능.
//		print(); //private라서 불가능.부를수 없다.
		show(); //가능. 부모의 void show(){}로 올라감
	}
}

public class InheritenceTest { //연습용. 자식아님.
	public static void main(String[] args) {
		f1();
	}

	private static void f1() { //여기서 사용해보기.
		Child ch1 = new Child();
		System.out.println(ch1.score);
		System.out.println("InheritenceTest title: "+ ch1.title);
		ch1.show();
		ch1.show2();
	}
	//print메서드 어디서 출력?
}
