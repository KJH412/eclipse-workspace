package com.shinhan.day07.lab;

public class Speaker implements Volum {
	int volLevel;
	
	@Override
	public void volumUp(int vol) {
		//VolLevel을 주어진 level만큼증가,메세지출력,100보다크면 100으로설정.
		volLevel += vol;
		if(volLevel==100) volLevel=100; //최대가 100
		
		System.out.println(getClass().getSimpleName() + "볼륨을 올립니다."+ volLevel);
	}

	@Override
	public void volumDown(int vol) {
		//VolLevel 을 주어진 level 만큼 감소, 메시지출력, 값이 0보다 작으면 0으로 설정
		volLevel -= vol;
		if(volLevel<0) volLevel=0;
		System.out.println(getClass().getSimpleName() + "볼륨을 내립니다."+ volLevel);

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