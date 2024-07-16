package com.shinhan.day10.exam;

import lombok.Getter;

@Getter
public class Container2<A, B> {
	A key;
	B value;
	
	void set(A key, B value){
		this.key = key;
		this.value = value;
	}

}
