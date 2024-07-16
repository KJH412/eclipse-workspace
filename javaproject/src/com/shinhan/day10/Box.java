package com.shinhan.day10;
//제네릭 : 자바API읽음.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//롬복 어노테이션 이용: 자동으로 컴파일 타입 만듦.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Box<T> { //타입은 사용할 때 결정한다. 결정되지않은타입<T>로 정의.
	private T content;


	
	
}
