package com.shinhan.day03;

import java.util.Scanner;

public class SwitchExpressionTest {

	public static void main(String[] args) {
		call();
		call2();
		call3();
		call4(6);
		call5();
		call6(7);
		call8();
	}

	private static void call8() {

		Scanner sc = new Scanner(System.in);
		int amount = 0, balance = 0;
		boolean isStop=false;
		
		while (!isStop) {
			menu();
			String key = sc.nextLine();
			switch (key) {
			case "1":
				System.out.print("예금액>");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
			case "2":
				System.out.print("출금액>");
				amount = Integer.parseInt(sc.nextLine());
				if (amount > balance) {
					System.out.println("잔고부족. 출금불가");
					break;
				}
				System.out.println(amount + " - 정상출금됨");
				balance -= amount;
				break;
			case "3":
				System.out.println("잔고는 " + balance);
				break;
			case "4":
				System.out.println("===END===");
				isStop = true; // flag를 이용하기 
			default:
				break; // switch빠지기
			}

		}
		sc.close();
		System.out.println("=====프로그램종료======");

		// . while 문과 Scanner의 nextLine() 메소드를 이용해서 다음 실행 결과와 같이 키보드로부터
		// 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해보세요.

	}

	private static void call7() {

		Scanner sc = new Scanner(System.in);
		int amount = 0, balance = 0;

		aa: while (true) {
			menu();
			String key = sc.nextLine();
			switch (key) {
			case "1":
				System.out.print("예금액>");
				amount = Integer.parseInt(sc.nextLine());
				balance += amount;
				break;
			case "2":
				System.out.print("출금액>");
				amount = Integer.parseInt(sc.nextLine());
				if (amount > balance) {
					System.out.println("잔고부족. 출금불가");
					break;
				}
				System.out.println(amount + " - 정상출금됨");
				balance -= amount;
				break;
			case "3":
				System.out.println("잔고는 " + balance);
				break;
			case "4":
				System.out.println("===END===");
				break aa; // label빠지기 (while빠지기)
			default:
				break; // switch빠지기
			}

		}
		sc.close();
		System.out.println("=====프로그램종료======");

		// . while 문과 Scanner의 nextLine() 메소드를 이용해서 다음 실행 결과와 같이 키보드로부터
		// 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해보세요.

	}

	private static void menu() {
		System.out.println("----------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("----------------------------------");
		System.out.print("선택>");

	}

	private static void call6(int count) {
		// 6. for 문을 이용해서 다음과 같은 실행 결과가 나오는 코드를 작성해보세요.
		for (int row = 1; row <= count; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}

	}

	private static void call5() {
		// 5. 중첩 for 문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력하는 코드
		// 를 작성해보세요. 단, x와 y는 10 이하의 자연수입니다

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}

	}

	private static void call4(int want) {
		// 4. while 문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1,
		// 눈2) 형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추
		// 는 코드를 작성해보세요. 눈의 합이 5가 되는 경우는 (1, 4), (4, 1), (2, 3), (3, 2)입니다

		// 무한loop
		while (true) {
			int su1 = (int) (Math.random() * 6) + 1; // 1<= <=6
			int su2 = (int) (Math.random() * 6) + 1; // 1<= <=6
			if (su1 + su2 == want) {
				System.out.printf("(%d, %d)", su1, su2);
				break;
			}
		}
		System.out.println("=====end=====");

	}

	private static void call3() {
		// 3. for 문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력하는 코드를 작성해보세요.
		int total = 0;
		for (int su = 0; su <= 100; su += 3) {
			total += su;
		}
		System.out.println(total);
	}

	// switch expression
	private static void call2() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A" -> {
			score1 = 100;
		}
		case "B" -> {
			int result = 100 - 20;
			score1 = result;
		}
		default -> {
			score1 = 60;
		}
		}
		System.out.println(score1);
	}

	// switch statement
	private static void call() {
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A":
			score1 = 100;
			break;
		case "B":
			int result = 100 - 20;
			score1 = result;
			break;
		default:
			score1 = 60;
		}
		System.out.println(score1);
	}

}
