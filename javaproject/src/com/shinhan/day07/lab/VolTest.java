package com.shinhan.day07.lab;

public class VolTest {
	public static void main(String args[]) {
		//Volume은 interface이거나 추상class로 만들 수 있다.
		//추상class이었다면? 상속받아서 Speaker,Radio,TV만들어야함.
		//interface였다면? implements
		//volumeUp,volumeDown함수 구현하기
		Volum[] v = new Volum[3];
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();
		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j <= 3; j++) {
				v[i].volumUp(200);
			}
			for (int j = 1; j <= 3; j++) {
				v[i].volumDown(300);
			}
		}
	}

}

/*
실행결과]
speak볼륨 올립니다.100
speak볼륨 올립니다.100
speak볼륨 올립니다.100
speak볼륨 내립니다.0
speak볼륨 내립니다.0
speak볼륨 내립니다.0
Radio볼륨 올립니다.200
Radio볼륨 올립니다.400
Radio볼륨 올립니다.600
Radio볼륨 내립니다.300
Radio볼륨 내립니다.0
Radio볼륨 내립니다.-300
TV볼륨 올립니다.200
TV볼륨 올립니다.400
TV볼륨 올립니다.600
TV볼륨 내립니다.300
TV볼륨 내립니다.0
TV볼륨 내립니다.0

*/
