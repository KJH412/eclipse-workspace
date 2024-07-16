package com.shinhan.day06.lab;
//8.확인문제
class Tire {
	 public void run() {
		 System.out.println("일반 타이어가 굴러갑니다.");
	 }
	 public void run2() {
		 System.out.println("2일반 타이어가 굴러간다.");
	 }
}
class SnowTire extends Tire{
	SnowTire(){
		
	}
	@Override
	public void run() {
		System.out.println("1.스노우 타이어가 굴러갑니다.");
	}
	public void run3() {
		System.out.println("3스노우 타이어가 굴러간다.");
	}
}

//실행
public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		
		//자동형변환
		Tire tire = snowTire;
		
//		snowTire.run();
//		snowTire.run2();
		
		//메서드는 타입을 따른다. Override되어있다면 재정의된 메서드가 재정의됨.
		tire.run();
		tire.run2();
		//(불가능) tire.run3(); //오류. 왜? 타입이 다르기 떄문. tire은 Tire타입인데, run3은 SnowTire타입의 메소드이다.
		
		//강제형변환
		
		((SnowTire)tire).run3();  //(가능)
		
		if(tire instanceof SnowTire snow) snow.run3(); //(가능) tire가 SnowTire의 인스턴스인지 체크
			
		
		//10.확인문제 예시) 2번이 틀림.
		Tire tire2 = new Tire();
		SnowTire ss = (SnowTire)tire2; //ClassCastException 에러. Tire가 SnowTire로 캐스팅(타입변환) 될 수 없다.
		
	}

}
