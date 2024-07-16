package com.shinhan.day02;

public class OperraterTest {

	public static void main(String[] args) {
		method12(0.0);
	 		
	}
	private static void method12(double y ) {
		double x = 5.0;
		//double y = 0.0;
		double z = 5 % y;

		System.out.println(x / y);
		System.out.println(x % y);

		if(Double.isNaN(x%y)) {
			System.out.println("0.0으로 나눈 나머지 불가");
		}
		if (Double.isInfinite(x / y)) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			double result = z + 10;
			System.out.println("결과: " + result);
		}

	}

	private static void method11() {
		int x = 10;
		int y = 5;
		System.out.println((x > 7) && (y <= 5));// true

		// ||는 앞이 참이면 뒤안함
		System.out.println((x % 3 == 2) || (++y % 2 != 1));
		System.out.println(y);

	}

	private static void method10() {
		int pencils = 534;
		int students = 30;
		// 학생 한 명이 가지는 연필 수
		int pencilsPerStudent = (pencils / students);
		System.out.println(pencilsPerStudent);
		// 남은 연필 수
		int pencilsLeft = (pencils - pencilsPerStudent * students);
		System.out.println(pencilsLeft);

	}

	private static void method9() {
		int score = 85;
		String result = (!(score > 90)) ? "가" : "나";
		System.out.println(result);
	}

	private static void method8() {
		int x = 10;
		int y = 20;
		int z = ++x + y--; // 후위연산자는 나중에 수행
		System.out.println(z);
		System.out.println(y);

	}

	private static void method7() {
		int var1 = 100;
		int var2 = 100;
		// 비교연산자가 논라연산자보다 우선순위가 높다
		// &&(단축)는 앞이 거짓이면 뒤를 수행안함
		// &는 앞의 결과와 무관하게 모두 수행
		// ||(단축)는 앞의 결과가 참이면 뒤를 수행안함
		// |는 앞의 결과와 무관하게 모두 수행
		// boolean result = var1>var2 && ++var1 < 100;
		boolean result2 = var1 >= var2 || ++var1 < 100;
		System.out.println(result2);
		System.out.println(!result2);
		System.out.println(var1);

	}

	private static void method6() {
		int var1 = 100;
		int var2 = 100;
		String str1 = "자바"; // 컴파일시점에 할당
		String str2 = "자바";
		String str3 = new String("자바"); // 기본형은 값을비교
		String str4 = new String("자바");

		// 문자열은 값 변경불가 , 주소가 달라짐
		str1 += "프로그램";
		str2 = str2 + "프로그램";

		System.out.println(var1 == var2);
		System.out.println(str1 == str2); // 객체는 주소비교(true)
		System.out.println(str3 == str4); // 객체는 주소비교(false)
		System.out.println(str3.equals(str4)); // 내용비교
		System.out.println(str1.equals(str4)); // 내용비교

		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));

	}

	private static void method5() {
		int i = 100;
		int j = 0;
		// 정수는 0으로 나누가 불가(Exception발생, 프로그램중단)
		// 프로그램중단막으려면 ?1.0이면 수행안하기 2.Exception처리
		if (j != 0) {
			System.out.println(100 / j);
		}

		System.out.print(j != 0 ? 100 / j : "");
		System.out.println(j == 0 ? "0으로나눌수없음" : "나누기가능");

		System.out.println(100 / 0.0);// Infinity(무한대)
		System.out.println(100 % 0.0); // NaN(Not a Number)

		System.out.println("-------------");

	}

	private static void method4() {
		int apple = 1;
		double pieceUnit = 0.1;
		int number = 7;
		double result = apple - pieceUnit * number;
		System.out.println(result);

	}

	private static void method3() {
		int a = Integer.MAX_VALUE;// 2147483647
		int b = Integer.MIN_VALUE;// -2147483648
		a++;
		a++;
		a++;
		b--;
		b--;
		b--;
		System.out.println(a);
		System.out.println(b);
	}

	private static void method2() {
		int a = 10;
		int b = 3;
		System.out.println("더하기:" + (a + b));
		System.out.println("빼기:" + (a - b));
		System.out.println("곱하기:" + a * b);
		System.out.println("몫:" + a / b);
		System.out.println("나머지:" + a % b);
	}

	private static void method1() {
		int var1 = 100;
		System.out.println(++var1);// 연산후 출력
		System.out.println(var1++);// 출력후 연산
		System.out.println(var1);// 출력
		var1++;
		++var1;
		System.out.println(var1);// 출력
	}

}
