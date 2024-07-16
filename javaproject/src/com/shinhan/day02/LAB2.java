package com.shinhan.day02;

import java.util.Scanner;

public class LAB2 {
	public static void main(String[] args) {
		System.out.println("===main start====");
		int month=2;
		if(month>12) {
			System.out.println(month + "월은 존재하지 않습니다. 다시 입력하세요.");
		}else {
			int result = numsDay(2024, month);
			System.out.println("말일은 " + result);	
		}
		System.out.println("===main end====");
	}

	// 매개변수, 파라메터, argument
	private static int numsDay(int year, int month) {
		int day;      
		switch (month) {
			case 2 -> {
				if (year % 4 == 0) {
					if (year % 400 == 0 || year % 100 != 0) {
						day = 29; // 윤년
					} else {
						day = 28; // 평년
					}
				} else {
					day = 28;// 평년
				}
			}
			case 4, 6, 9, 11 -> {
				day = 30;
			}
			default -> {
				day = 31;
			}
		}
		return day;

	}

	private static void method9() {
		/*
		 * 주어진 년도의 월에 해당하는 말일을 계산하는 프로그램을 완성하시오. 윤년인 경우에는 다음과 같은 조건에 의해 처리합니다. [윤년의 조건]
		 * 1) 4의 배수인 해는 윤년. 2) 4의 배수이면서 100의 배수인 해는 윤년이 아님. 3) 100의 배수이면서 400의 배수인 해는
		 * 윤년.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("해를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.print("달을 입력하세요 : ");
		int month = sc.nextInt();
		sc.close();

		int day;

		switch (month) {
		case 2 -> {
			if (year % 4 == 0) {
				if (year % 400 == 0 || year % 100 != 0) {
					day = 29; // 윤년
				} else {
					day = 28; // 평년
				}
			} else {
				day = 28;// 평년
			}
		}
		case 4, 6, 9, 11 -> {
			day = 30;
		}
		default -> {
			day = 31;
		}
		}
		System.out.printf("%d년 %d월의 말일은 %d일 입니다.", year, month, day);
	}

	private static void method8() {
		/*
		 * 수열 규칙 : 1부터 시작해서 두 항의 차이가 1씩 증가 예 시 : 1 + 2 + 4 + 7 + 11 + 16 + 22 + ………… 위의
		 * 수열에서 15번째 항까지의 합을 구하는 프로그램을 작성하십시오
		 */

		int step = 0;
		int num = 15;

		int sum = 0;

		for (int i = 1; step < num; i += step) {
			sum += i;
			step++;
			System.out.printf("%d .... %d \n", i, step);
		}
		System.out.printf("%d번째까지의 합 :%d\n", num, sum);
	}

	private static void method7() {
		/*
		 * 문제4. 임의의 정수를 입력 받아서, 1부터 1,000까지의 수 중에서 입력 받은 정수의 배수의 개수와 배수들의 합을 계산하십시오.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		sc.close();

		int sum = 0;
		int cnt = 0;

		for (int i = num; i <= 1000; i += num) {
			sum += i;
			cnt++;
		}
		System.out.printf("%d의 배수 개수 = %d , %d \n", num, 1000 / num, cnt);
		System.out.printf("%d의 배수 합 = %d\n", num, sum);
	}

	private static void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요:");
		int num = sc.nextInt();

		int fact = 1;

		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다");
		} else {
			for (int i = 1; i <= num; i++) {
				fact *= i;
				System.out.printf("%d ", i);
				System.out.printf(i == num ? "=" : "*");
			}
			System.out.printf("%d\n", fact);
		}
		sc.close();
	}

	private static void method6() {
		// 1~100사이의 소수를 출력하기
		for (int su = 2; su <= 100; su++) {
			boolean isPrime = true;
			for (int i = 2; i < su; i++) {
				if (su % i == 0) {
					isPrime = false;
					break;
				}
			}
			System.out.println(isPrime ? su + "는(은) 소수입니다." : su + "는(은) 소수아님");
		}
	}

	private static void method5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("2 ~ 100사이의 정수를 입력하세요. :");
		int su = sc.nextInt();
		boolean isPrime = true;
		for (int i = 2; i < su; i++) {
			if (su % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.println(isPrime ? su + "는(은) 소수입니다." : su + "는(은) 소수아님");
		sc.close();
		/*
		 * 문제2. 소수란 자신과 1외의 다른 수로는 나누어 떨어지지 않는 정수입니다. 아래와 같이 2~100 사이의 숫자를 입력하면 소수인지 여부를
		 * 판별하는 프로그램을 작성하십시오.
		 * 
		 * 실행 예 1) 2 ~ 100사이의 정수를 입력하세요. : 47 47는(은) 소수입니다.
		 * 
		 */

	}

	private static void method4() {
		for (int i = 1; i <= 5; i++) {
			// if(i==3) break ;
			if (i == 3)
				continue;
			System.out.println(i);
		}

	}

	private static void method3() {
		// 구구단......2단부터 9단까지 모두 출력하기
		aa: for (int gop = 1; gop <= 9; gop++) {
			// if (gop == 4) continue; // loop안에 있는 아래문장들을 무시, 조건문으로 이동
			for (int dan = 2; dan <= 9; dan++) {
				// if(dan==5) continue; //loop안에 있는 아래문장들을 무시, 가장가까운 반복문의 조건문으로 이동
				if (dan == 5)
					continue aa;
				System.out.printf("%2d*%2d=%2d ", dan, gop, dan * gop);
			}
			System.out.println();
		}
		System.out.println("*********");

	}

	private static void method2() {
		// 구구단......2단부터 9단까지 모두 출력하기
		aa: for (int gop = 1; gop <= 9; gop++) {
			// if(gop==4) break;
			for (int dan = 2; dan <= 9; dan++) {
				// if(dan==5) break; //가장 가까운 반복문 빠지기
				if (dan == 5)
					break aa; // 원하는 반복문 빠지기(label부여)
				System.out.printf("%2d*%2d=%2d ", dan, gop, dan * gop);
			}
			System.out.println();
		}

	}

	private static void method1() {

		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. :");
		int dan = sc.nextInt();
		if (dan < 2 || dan > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			sc.close();
			// System.exit(0);//프로그램을 당장 종료...좋은방법은 아니다.
			return; // 함수끝내고 호출한 곳으로 돌아간다.
		}
		// 구구단......
		for (int gop = 1; gop <= 9; gop++) {
			System.out.printf("%d * %d = %d\n", dan, gop, dan * gop);
		}
		sc.close();
		/*
		 * 문제1. 1보다 크고 10보다 작은 정수를 입력 받아서 아래와 같은 실행 결과가 나타나도록 Prob1 클래스의 main 메소드를
		 * 완성하십시오. 입력 받은 숫자에 해당하는 구구단을 완성시키는 프로그램입니다. 2보다 작거나 9보다 큰 정수가 입력될 경우에는 “잘못된
		 * 숫자가 입력되었습니다.”라는 경고 메시지를 출력하고 프로그램을 종료합니다.
		 */

	}

}
