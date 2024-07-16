package chapter13.rentable;

import com.shinhan.day10.Rentable;
//집을 렌트해주는 대리점 클래스
public class HomeAgency implements Rentable<Home> {

	@Override
	public Home rent() { //리턴타입 꼭 Home으로 바꿔서 추상메서드 재정의 
		// TODO Auto-generated method stub
		return new Home();
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
	} 
	
}
