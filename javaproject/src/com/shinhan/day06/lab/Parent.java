package com.shinhan.day06.lab;
//6. 확인문제 
//default생성자가 없어서 오류가 난다.

public class Parent {
	public String name;
	
	 public Parent(){
		  
	 }
		 
	
	/*
	 * public Parent(){
	 * 
	 * }
	 * 
	 * */

	public Parent(String name) {
		this.name = name;
	}
}
