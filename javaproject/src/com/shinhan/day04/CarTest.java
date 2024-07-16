package day04;

public class CarTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		// TODO Auto-generated method stub
		Car c1 = new Car("ABC모델", "black", 300);
		System.out.println(c1);
	}

	private static void method1() {
		Car c1 = new Car("ABC모델", "black", 300);
		String result = c1.carInfoPrint("****");
		System.out.println(result);
		
		c1.powerOn();  //c1. 객체참조해서 함수를 부를 수 있음.
	}

}
