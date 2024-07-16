package com.shinhan.day10;

//~able:인터페이스 이름
//타입파라메터는 영문자 대문자 아무거나 <A>
public interface Rentable<P> {
	void method1();
	P rent(); //타입파라미터P를 리턴타입으로 사용
				//P에는 Home,Car 등이 올 수 있다.
}
