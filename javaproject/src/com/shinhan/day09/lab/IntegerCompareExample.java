package com.shinhan.day09.lab;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import com.shinhan.day09.ComputerVO;

public class IntegerCompareExample {
	
	public static void main(String[] args) throws ClassNotFoundException {
		//Class객체
		Class a = ComputerVO.class; // <-- 제일 간단한 방법.
		Class b = new ComputerVO().getClass();
		Class c = Class.forName("com.shinhan.day09.ComputerVO");
	}
	
	/* 확인문제 17
	 * 정규 표현식을 이용해 첫 번째는 알파벳으로 시작하고 두 번째부터 숫자와 알파벳으로 구성된  
	8~12자 사이의 ID 값인지 검사하고 싶습니다. 알파벳은 대소문자를 모두 허용한다고 할 때, 코드작성 
	*/
	// ^시작 
	//$끝
	//[^]제외
	public static void f5(String[] args) {
		String id = "5Angel1004s";
		//String regExp =  "^[0-9][0-9A-Za-z]{8,12}"; 
		String regExp =  "^[0-9]\\w{8,12}[^z]$";  
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}

	public static void f4(String[] args) { // 확인문제16
		// xxxx년 xx월 xx일 x요일 xx시 xx분 -> 오늘 날짜 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 mm월 dd일 E요일 hh시 mm분");
		Date d = new Date(); //util의 Date인데 sql로 import해서 오류났었음.
		System.out.println(sdf.format(d));
	}

	public static void f3(String[] args) { // 확인문제15
		// 올해 12월 31일까지 몇 일이 남았는지 구하는 코드 작성.
		LocalDateTime startDateTime = LocalDateTime.now();

		LocalDateTime endDateTime = LocalDateTime.of(startDateTime.getYear(), 12, 31, 0, 0, 0);

		LocalDateTime happyNew = LocalDateTime.of(startDateTime.getYear(), 1, 1, 0, 0, 0);

		long remainDay2 = startDateTime.until(startDateTime, ChronoUnit.DAYS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);

		System.out.println("남은 일자: " + remainDay);
		System.out.println("지난 일자: " + remainDay2);

	}

	public static void f2(String[] args) { // 확인문제14
		double d = Math.random();
		System.out.println(d);

		Random r = new Random();
		double d2 = r.nextDouble(10);
		System.out.println(d2);

		// 4번 Random의 nextInt(int n) 메소드는 0<= ... <=n 사이의 정수 난수를 리턴한다.(X)
		// 4번 Random의 nextInt(int n) 메소드는 0< ... <n 사이의 정수 난수를 리턴한다.(O)
		int i = r.nextInt(45);
		System.out.println(i);
	}

	public static void f(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;

		// == 주소비교한다고 생각하기.
		// 객체를 비교할 때 == 하면 안됨.(위험) 되는것도 있고 안돼는것도 있기 때문에
		System.out.println(obj1 == obj2); // 값비교 true
		System.out.println(obj3 == obj4); // 주소비교 false

		System.out.println(obj1.equals(obj2)); // true
		System.out.println(obj3.equals(obj4)); // true

		System.out.println(Math.ceil(5.3));
		System.out.println(Math.floor(5.3));
		System.out.println(Math.max(5.3, 2.5));
		System.out.println(Math.round(5.7)); // 6.0(X) 6(O)
	}
}
