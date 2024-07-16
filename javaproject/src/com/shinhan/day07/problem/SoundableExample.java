package com.shinhan.day07.problem;

//확인문제5. 각 동물의 소리를 출력.


public class SoundableExample {
	
	public static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		printSound(new Cat());	//매개변수로 사용
		printSound(new Dog()); 
	}


}
