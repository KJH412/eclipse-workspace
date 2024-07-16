package day04;

public class KoreanTest {

	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		//1.객체참조변수선언
		
		/* 2.객체생성 */
		//Korean k1 = new Korean(); --> aurgument가 없는 default생성자가 없어서 오류남.
		//여기서 default생성자는 Korean.java의 Korean(){}
		Korean k1 = new Korean("신현상" , "12345");	
		
		//3.객체사용
		//System.out.println(k1.nation); <-- 별로인 접근방법
		k1.print(); //Korean에 접근해서 함수를 씀.
	}

}
