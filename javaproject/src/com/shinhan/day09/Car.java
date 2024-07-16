package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//class Car안에 생성자,getter..등 import로 부를 수 있음.
//@쓰고 Ctrl+Enter로 자동완성시키고 Ctrl+Shift+O로 import
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	String model;
	int price; //다른패키지에서 접근이 안될때 getter,setter사용
	
}

