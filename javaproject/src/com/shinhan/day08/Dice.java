package com.shinhan.day08;

public class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1; //1~8
		return number;
	}

	//equals 재정의
	@Override
	public boolean equals(Object obj) {
		//f4()메소드>obj1.equals(obj2)괄호에 null이나 "스트링"이 오면 안되니까.
		if(!(obj instanceof Dice)) return false; 
		Dice d = (Dice)obj; //obj가 Dice가 아니라서 형변환 해주고 비교.
		if(size == d.size) return true;
		return false;
	}
	
}
