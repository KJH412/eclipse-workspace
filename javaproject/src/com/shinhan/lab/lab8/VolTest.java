package com.shinhan.lab.lab8;


//8장 lab1 인터페이스
interface Volume{
	public abstract void volumeUP(int level);
	public abstract void volumeDown(int level);
}

class TV implements Volume{
	//VolLevel 을 주어진 level 만큼 증가, 메시지 출력
	//VolLevel 을 주어진 level 만큼 감소, 메시지 출력, 값이 0보다 작으면 0으로 설정
	int volLevel;
	
	@Override
	public void volumeUP(int level) {
		volLevel += level;
		System.out.println("TV볼륨을"+volLevel+"올립니다.");
	}
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel<0) volLevel = 0;
		System.out.println("TV볼륨을"+volLevel+"내립니다.");
	}
	
}

class Speaker implements Volume{
	//VolLevel 을 주어진 level 만큼 증가, 메시지 출력, 100보다 크면 100으로 설정
	//VolLevel 을 주어진 level 만큼 감소, 메시지 출력, 값이 0보다 작으면 0으로 설정
	int volLevel;
	
	@Override
	public void volumeUP(int level) {
		volLevel += level;
		if(volLevel>=100) volLevel = 100;
		//if(volLevel==100) volLevel=100; 
		System.out.println("Speaker볼륨"+volLevel+"올립니다.");
	}
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		if(volLevel<0) volLevel = 0;
		System.out.println("Speaker볼륨을" +volLevel+" 내립니다.");
	}
	
	
}

class Radio implements Volume{
	//VolLevel  을 주어진  level  만큼 증가, 메시지 출력
	//VolLevel 을 주어진 level 만큼 감소, 메시지 출력
	int volLevel;
	
	@Override
	public void volumeUP(int level) {
		volLevel += level;
		System.out.println("Radio 볼륨을"+ volLevel + "올립니다.");
	}
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println("Radio볼륨을"+ volLevel + "내립니다.");
	}
	
	
}


public class VolTest {
	public static void main(String[] args) {
		//Volume 의 배열을 생성하고 각 배열의 원소에는 TV 와 Speaker 와 Radio 클래스를 넣습니다
		Volume[] v = new Volume[3]; 
		//Volume 타입의 배열을 통해 서로 다른 객체의 동일한 메소드를 호출.
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();
		for (int i = 0; i < v.length; i++) { //배열 길이만큼 반복시킨다.
			for (int j = 1; j <= 3; j++) { // 200볼륨 3번반복 증가
				v[i].volumeUP(200);
			}
			for (int j = 1; j <= 3; j++) { //300볼륨 3번반복 감소
				v[i].volumeDown(300);
			}
		}
	}

}
/*
 [실행결과]
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


















