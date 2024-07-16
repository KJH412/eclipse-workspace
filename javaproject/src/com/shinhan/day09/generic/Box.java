package com.shinhan.day09.generic;
//제너릭<T>
public class Box<A,B> { //보통<T>라고 준다. 사용하는 곳에서 타입을 결정한다.
	
	A code;
	B size;
	
	
	public Box() {
	}
	public Box(A code, B size) {
		this.code = code;
		this.size = size;
	}
	public A getCode() {
		return code;
	}
	public void setCode(A code) {
		this.code = code;
	}
	public B getSize() {
		return size;
	}
	public void setSize(B size) {
		this.size = size;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Box [code=");
		builder.append(code);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
