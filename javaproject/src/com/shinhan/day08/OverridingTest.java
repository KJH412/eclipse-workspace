package com.shinhan.day08;

import java.util.Objects;

/*
 * 조건1: main 메소드에서 MySum 객체를 출력하면 객체 생성시에 전달한 두 정수의 덧셈 결과를 출력하도록 
toString 메소드를 오버라이딩합니다.
예) 
MySum ms1 = new MySum(i, j);
System.out.println(ms1);
호출시에 출력값은 i 와 j 의 산술 연산 덧셈 결과입니다.
(참고 : String.valueOf 메소드는 int 를 String 으로 변경합니다)


조건2: main 메소드에서 MySum 클래스의 equals 메소드 호출시 
전달하는 매개변수가 MySum 객체를 참조하고 현재 객체의 
toString 메소드와 전달 객체의 toString 메소드 내용이 동일하면 
true 를 리턴하고 나머지 경우에는 false 를 리턴하도록 
equals 메소드를 오버라이딩합니다.
예) 
MySum ms1 = new MySum(i, j);
MySum ms2 = new MySum(j, i);
String s1 = new String("30");
ms1.equals(ms2) 호출 결과는 true 입니다.
ms1.equals(s1) 호출 결과는 false 입니다.

<출력결과>
30
30
ms1 과 ms2 의 합계는 동일합니다.
ms1 과 s1 의 값은 동일하지 않습니다.
 * */
public class OverridingTest {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);
		String s1 = new String("30");
		
		System.out.println(ms1);
		System.out.println(ms2);
		
		if (ms1.equals(ms2))
			System.out.println("ms1 과 ms2 의 합계는 동일합니다.");
		else 
			System.out.println("ms1 과 ms2 의 합계는 동일하지 않다.");
		
		if(ms1.equals(s1))
			System.out.println("s1 과 s2 의 합계는 동일합니다.");
		else 
			System.out.println("s1 과 s2  의 합계는 동일하지 않다.");
	}
}

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	
	/* 조건1 */

	@Override
	public String toString() { //내용 틀렸음.
		//return  first + second + ""; //되긴하는데 X
		return String.valueOf(first + second); //30
	}
	
	/* 조건2 */
	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MySum)) return false;
		MySum my = (MySum)obj;
		return this.toString().equals(my.toString()); 
		//실수 하는 경우1
		//return this.equals(my); //equals를 또 부른거라 스택오버플로우 에러.
		
		/* 자동완성
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MySum other = (MySum) obj;
		return first == other.first && second == other.second;
		*/
	}
	

	
}
