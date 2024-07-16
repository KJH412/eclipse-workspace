package chapter13.rentable;

public class GenericExample {

	public static void main(String[] args) {
		
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent(); //rent()메서드 호출. home를 대여받고
		home.turnOnLight();//사용(호출)
		
		CarAgency carAgency = new CarAgency(); //에이전시 객체 만든다.
		Car car = carAgency.rent(); //rent()메서드 호출. car를 대여받고
		car.run(); //사용(호출)
	}

}
