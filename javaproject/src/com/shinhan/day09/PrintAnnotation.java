package com.shinhan.day09;
//직접 만든 어노테이션
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//{}:배열
@Target({ElementType.METHOD}) //메소드에서만 쓰겠다.
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintAnnotation {
	String value() default "-"; 
	int number() default 7; 
	String subject() default "자바";
	/*
	 * 만약에 @PrintAnnotation 만 썼으면 value의 디폴트 값 "-"가 들어가는거고
	 * @PrintAnnotation("*")이면 value가 *로 들어간다.
	 * @PrintAnnotation(value = "#", number = 20) 면 디폴트값이 아니고 #,20이 들어가는것임.
	 * 
	*/
}

//스프링 등 프레임워크 쓸 때 거의 어노테이션 사용함.