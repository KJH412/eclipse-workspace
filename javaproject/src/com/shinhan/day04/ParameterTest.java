package day04;

public class ParameterTest {

	public static void main(String[] args) {
		sum(10,20);
		sum(10,20,30); //자동형변환 ==> 실수3으로 간다.
		sum(10,20,30,40);
		sum(10,20,30,40,50);
		sum(1,2,3,4,5,6,7,8,9,10);
		int[] values = {1,2,3,4,5,6,7,8,9,10};
		sum(values); //배열사용		
		sum(new int[]{1,2,3,4,5,6,7,8,9,10});//배열새로만들기
		sum("자바","프로그램");
		sum(3.14, 10.6, 20.5);
	}
	
	private static void sum(double d, double e, double f) {
		System.out.println("실수3:" + (d+e+f));
	}

	private static void sum(String s1, String s2) {
		System.out.println("문자2:"+s1+s2);
		
	}
	//메서드 오버로딩 : 메서드이름은 같고 매개변수 사양이 다르다.
	private static void sum(int...datas) {
		int total = 0;
		for(int data:datas) {
			total += data;
		}
		System.out.println("가변길이 매개변수:"+ total);
	}
	
	
//	private static void sum(int i, int j) {
//		System.out.println("정수합:" + (i+j));
//	}
	
	//멤버메서드(non-static) : 객체생성 후 호출가능하다.
	//static은 static에서만 호출 가능.
	static void sum(int i, int j) {
		System.out.println("정수합:" + (i+j));
	}
	
	void print() {
		
	}
	

}
