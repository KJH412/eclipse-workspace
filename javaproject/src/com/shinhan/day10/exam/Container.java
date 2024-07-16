package com.shinhan.day10.exam;

//게터세터 x 직접 써준다. container1.set("홍길동");
public class Container<T> {
	T data;
	
	void set(T data) {
		this.data = data;
	}
	T get() {
		return data;
	}
}
