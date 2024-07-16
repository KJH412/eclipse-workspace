package chapter13.rentable;

import com.shinhan.day10.Rentable;

//자동차을 렌트해주는 대리점 클래스
public class CarAgency implements Rentable<Car>{ //파라미터P를 Car로 대체

	@Override
	public Car rent() {  //리턴타입 반드시 Car 추상메서드 재정의 
		// TODO Auto-generated method stub
		return new Car();
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub		
	}

}
