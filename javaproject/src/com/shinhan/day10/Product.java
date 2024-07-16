package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor //<==자바빈즈기술은 private필드랑 이걸 쓴다. AllArgsConstructor말고
@AllArgsConstructor
public class Product<K,V> { //보통 K:key V:vlaue라고 보는데 정해진건 없음.
	private K kind; 
	private V model;
}

//데이터 저장,읽기,쓰기 만 들어있다. 
//DTO(Data Transfer Object)
//VO(Value Object)
//JavaBeans (JspServlet, Spring, Mybatis) : NoArgsConstructor 반드시,getter/setter
