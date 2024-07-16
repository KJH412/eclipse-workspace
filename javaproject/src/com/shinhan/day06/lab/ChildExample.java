package com.shinhan.day06.lab;

class Parent2 {

	public String nation;
	 
	public Parent2() {
		this("대한민국");
		System.out.println("2.Parent()  call"); //2
	}
	public Parent2(String nation) {
		//super();생략되어있음. Object가 생성된다.
		this.nation = nation;
		System.out.println("1.Patents(String nation) call"); //1
	}
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
	
}

class Child2 extends Parent2{
	public String name;

	public Child2() {
		//super();생략되어있음
		//System.out.println();  
		//1. default는 super();
		this("홍길동"); //자신의 class의 다른 생성자 호출, 중간 불가, ***첫줄만 가능. this();위에 코드가 있으면 오류뜸.
		System.out.println("4.Child() call"); //4.함수는 갔다가 돌아옴.
	}	
	
	public Child2(String name) {
		//super();
		this.name = name;
		System.out.println("3.Child(String name) call"); //3
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class ChildExample {
	public static void main(String[] args) {
		Child2 child = new Child2();
//		System.out.println(child.getNation() + " " + child.getName());
	}

}
