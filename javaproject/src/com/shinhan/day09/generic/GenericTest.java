package com.shinhan.day09.generic;
//제네릭스<> : 사용할 때 타입을 결정한다.
import java.util.ArrayList;
/*
 * 제네릭(Generic)이란 결정되지 않은 타입을 파라미터로 처리 -> 실제 사용할 때 파라미터를 구체적인 타입으로 대체시키는 기능.
 * 타입파라미터를 대체하는 타입은 클래스 및 인터페이스
 * 
 * 
 */
public class GenericTest {

	public static void main(String[] args) {
		//f1();
		f2();
	}

	private static void f2() {
		//ArrayList : 동적배열 (개수가 정해져 있지 않고 계속 늘어날 수 있다.)
		//List : 순서있고 중복가능
		ArrayList<String> alist = new ArrayList<>();
		alist.add("월");
		alist.add("화");
		alist.add("토");
		alist.add("토");
		alist.add("토");
		
		for(String s:alist) {
			System.out.println(s);
//			System.out.println(((String)s).length());
		}
	}

	private static void f1() {
		//변수선언할 때 동일한 타입으로 호출하고 싶다면 생성자호출 시 타입명시 안하고 <>만 붙일 수 있다.
		//Box<String, Integer> box1 = new Box<String, Integer>(null, null); new 생성때 <>생략가능.
		//타입을 기본형으로 쓸 때 wrapper클래스로 써야한다.
		Box<String, Integer> box1 = new Box<>("컴퓨터", 100);
		//new Box() -> 생성자를 부르는건데, argument가 없으면 기본생성자가 필요하고
		//여기서는 argument두개가 있으니까 
		//Box에 public Box(A code, B size){} argument두개있는 생성자가 필요하다.
		System.out.println(box1);
		
		Box<Integer, String> box2 = new Box<>(123, "Large");
		System.out.println(box2);
		
		
	}

}
