package com.shinhan.day06.lab;

public class Child extends Parent{
	public String name;

	public Child() {
		this("홍길동");
		System.out.println("4.Child() call");
	}	
	
	public Child(String name) {
		this.name = name;
		System.out.println("3.Child(String name) call");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
