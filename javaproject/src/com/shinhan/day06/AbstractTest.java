package com.shinhan.day06;

abstract class Animal{
	abstract void sound();	// 무슨 소리를 낼지 아직 모름, 어차피 자식이 구현 하기 때문에(재정의) 구현할 필요 X
	// 추상 메서드 + 일반 메서드	
	void sound2() {
		System.out.println("일반 메서드도 가능");
	}
}


class Cat extends Animal{
	//@Override // 생략 가능
	void sound() {
		System.out.println("야옹");
	}
}
class Dog extends Animal{
	
	@Override
	void sound() {
			System.out.println("멍멍");
	}
}
public class AbstractTest {

	public static void main(String[] args) {
		call(new Cat());
		call(new Dog()); //함수를 새로 만들지 않고 new에 Cat과 Dog를 부르고 싶다면 부모를 부른다.
	}

	private static void call(Animal ani) {// Cat, Dog 둘 다 들어올 수 있음
		//field(변수)나 method(함수)는 타입을 따른다.
		ani.sound();
	}

}
