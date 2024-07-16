package com.shinhan.day09;

import java.lang.annotation.ElementType;

public class Service {
	
	@PrintAnnotation  //@Target({ElementType.METHOD})
	public void method1() {
		System.out.println("method1....");
	}
	@PrintAnnotation("*")  //무조건 이 값은 value값이다.(기본 "-"로 준 것을 *로 들어감)
	public void method2() {
		System.out.println("method2....");
	}
	@PrintAnnotation(value = "#", number = 20) //여러속성인 경우 생략불가. 속성(value,number)에 값주기. 문자#을20개찍는다.
	public void method3() {
		System.out.println("method3....");
	}
	@PrintAnnotation(value = "#", number = 20, subject = "java")
	public void method4() {
		System.out.println("method4....");
	}
	
	
	//실제로 값이 안에 들어갔는지 리플렉션으로 이용해서 테스트.
}
