package com.shinhan.day08;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
		
		//f6();
		//f7();
		f8();
	}
	
	private static void f8() {
		
		Book b = new Book("A", 1, "a");
		//b.equals(null);//에러
		b.equals("aa");
		
		//제네릭스 : type을 제한한다. HashSet<>
		HashSet<Book> datas = new HashSet<Book>();
		datas.add(new Book("A", 1000,"김")); 
		datas.add(new Book("A", 1000,"김")); 
		datas.add(new Book("A", 1000,"김")); 
		datas.add(new Book("A", 1000,"김")); 
		
		System.out.println(datas.size());	
//		for(String s:datas) { //에러
		for(Book s:datas) { //에러x. 타입을 Book으로 제한 
			System.out.println(s);
		}
	}
	
	
	private static void f7() {
		//제네릭스 : type을 제한한다.
		HashSet<String> datas = new HashSet<String>();
		datas.add("월"); 
		datas.add("토"); 
		datas.add("토"); 
		datas.add("화"); 
		System.out.println(datas.size());	
		for(String s:datas) {
			System.out.println(s);
		}
	}
	
	private static void f6() {
		//6.HashSet : 순서가 없다. 중복이 안된다. Key로 사용된다.
		HashSet datas = new HashSet();
		datas.add(new Book("자바다",20000,"신")); //add(Object) : ()안에 모두 와도됨. 마우스대면 확인됨.
		
		//가져온다.
		for(Object obj:datas) {
			if(obj instanceof Integer) {
				
			}else if(obj instanceof String) {
				
			}else if(obj instanceof Book) {
				
			}
		}//--> 노가다여서 별로임.
	}
	
	private static void f5() {
		//5.Object 상속받아서 만든 Integer
		Book obj1 = new Book("자바다",20000,"신");
		Book obj2 = new Book("자바다",10000,"신"); 
		System.out.println(obj1 == obj2);; //주소비교
		System.out.println(obj1.equals(obj2));//주소비교를 내용비교override함. //Book클래스에서 equals를 재정의.
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
	
	private static void f4() {
		//4.Object 상속받아서 만든 Integer(기능을 추가해서 만든 warpper클래스.)
		Dice obj1 = new Dice(100);
		Dice obj2 = new Dice(200); 
		System.out.println(obj1 == obj2);; //주소비교
		System.out.println(obj1.equals(obj2));//주소비교를 내용비교override함. //Dice클래스에서 equals를 재정의.
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
	
	private static void f3() {
		//3.Object 상속받아서 만든 Integer(기능을 추가해서 만든 warpper클래스.)
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer(100); 
		System.out.println(obj1 == obj2);; //주소비교
		System.out.println(obj1.equals(obj2));//주소비교를 내용비교override함. (true)
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
	
	private static void f2() {
		//2.Object 상속받아서 만든 String 객체
		String obj1 = new String("자바");
		String obj2 = new String("자바"); //오브젝트는 주소비교하려고 구현한거임.
		System.out.println(obj1 == obj2);; //주소비교
		System.out.println(obj1.equals(obj2));//주소비교를 내용비교override함. (true)
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}
	
	private static void f1() {
		//1.Object는 모든 Object의 부모 class
		Object obj1 = new Object();
		Object obj2 = new Object(); //오브젝트는 주소비교하려고 구현한거임.
		System.out.println(obj1 == obj2);; //주소비교
		System.out.println(obj1.equals(obj2));//주소비교
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
	}

}
