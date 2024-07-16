package com.shinhan.day11;

import com.shinhan.day10.thread.Account;

//제네릭: 구체적인 타입은 사용할 때 결정, 컴파일 시에 강한 타입체크, Object사용한다면 강제형변환필요
class Box<T>{//<T>제네릭 타입
	private T content; //content에는 사용할 때 구체적인 타입을 주겠다. <Object>으로 주면 무슨 타입(객체,기본포장형 ...)이든 다 들어 올 순 있지만 형변환이 필요하다.
				//content변수에 타입이 다양하게 들어 올 수 있음. 형변환하지않게 T라는 제네릭타입을 줘서 사용할 때 타입을 결정한다.

	//기본생성자
	public Box() {
		this.content = content;
	}
	//content가 들어간 생성자
	public Box(T content) {
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}
}

class BigBox<T,E> extends Box<T>{ //BigBox가 부모Box의<T>타입파라미터를 물려받음. T는 물려받고 E만 추가된것.
	E size;

	public BigBox(T content, E size) { //부모타입<T>을 포함한 생성자 생성.
		super(content);
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BigBox [size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}
	
	
}

class AccountChild extends Account{

	
}

public class Review {
	
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
		f5();
	}
	private static void f5() {
		//배열은 실행시 만들어진다.
		String[] arr = {"A","B","C"}; //기본형아니고 클래스?
		Object[] arr2;
		arr2 = arr;
		arr2[0] = 10; //숫자가 들어갔는데 컴파일에러가 안남. 
		
		//제네릭은 배열생성이 불가
//		Box<Account>[] b3 = new Box<Account>[10]; (X) 
		
		
	}
	private static void f4() {
//		Box<Account> box1 = call3(3.14);
		Box<AccountChild> box2 = call3(new AccountChild());
		Box<Account> box3 = call3(new Account("123","j", 100));
//		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3); 
	}
//	private static <T super Account> Box<T> call4(T data) { 
//		return new Box<T>(data);
//	}
	private static <T extends Account> Box<T> call3(T data) { 
		return new Box<T>(data);
	}
	
	private static void f3() {
		Box<Double> box1 = call2(3.14);
		Box<Integer> box2 = call2(100);
		Box<Long> box3 = call2(1234567890000000L);
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3); //Long값을 넣음
		
	}

	private static <T> Box<T> call2(T data) { 
		return new Box<T>(data);
	}

	private static void f2() {
//		Box<String> box1 = call(); call(T t)형태로 줘야하는데 아니라서 컴파일 에러남.
		Box<String> box1 = call("문자");
		Box<Integer> box2 = call(100);
		Box<Account> box3 = call(new Account("123","j", 100));
		System.out.println(box1);
		System.out.println(box2);
		System.out.println(box3);
	}
	
//	private static Box<Integer> call(int i) { 
	
	private static <T> Box<T> call(T t) { //함수선언부, <T>는 제네릭타입이다. 앞에 제네릭타입을 안써주면 Box<T>()썼을 때 java안에 T타입이 있는지 찾기 때문에 에러가 난다.
//		return new Box<T>(); 기본 생성자가 필요.
		return new Box<T>(t); //사용할 때 이런모양의 생성자가 필요.
							 //argument있는형태로 생성자 만들 수 있다.
	}
	
	
	//제네릭타입
	private static void f1() {
		Box<String> box1 = new Box<>(); //class Box<T>를 쓸 때 타입 결정. =>기본생성자를 이용해 만들어서 setter필요
		Box<String> box2 = new Box<>(); 
		Box<Integer> box3 = new Box<>(); 
		Box<Account> box4 = new Box<>(); 
		
		/*
		box1.content = "String";
		box2.content = "String";
		box3.content = 100; //100이 int타입이니까 box3.content는 Integer타입이다.(형변환필요x)
		Integer a = box3.content; //<=
		Account acc = box4.content;
	
		new Account(null, null, 0).deposit(1000); //(접근지정자 확인) deposit이 public이여야 가능.
		*/
		
		Box<String> b1 = new Box<>("문자");
		Box<String> b2 = new Box<>("문자"); 
		Box<Integer> b3 = new Box<>(100); 
		Box<Account> b4 = new Box<>(); 
		
		Box<Account> b5 = new Box<>();
		b5.setContent(new Account("112", "A", 100)); //값집어넣기
		
		//생성할 때 부터 값을 집어 넣을 수 있다.
		Box<Account> b6 = new Box<>(new Account("112", "A", 100)); //생성자에서 초기화
		
		System.out.println(b1.getContent()); //content만 나옴
		System.out.println(b2); //toString()
		System.out.println(b3); //toString()
		System.out.println(b4); //toString()
		System.out.println(b5); //toString()
		System.out.println(b6); //toString()
	}
}
