package com.shinhan.day07.lab;
//?
public class Radio implements Volum {
	int volLevel;
	
	@Override
	public void volumUp(int vol) {
		//VolLevel  을 주어진  level  만큼 증가, 메시지 출력
		volLevel += vol;		
		System.out.println(getClass().getSimpleName() + "볼륨을 올립니다."+ volLevel);
	}

	@Override
	public void volumDown(int vol) {
		//VolLevel 을 주어진 level 만큼 감소, 메시지출력
		volLevel -= vol;
		System.out.println(getClass().getSimpleName() + "볼륨을 내립니다."+ volLevel);

	}

}
