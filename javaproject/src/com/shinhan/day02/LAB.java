package com.shinhan.day02;

import java.util.Scanner;

public class LAB {

	public static void main(String[] args) {
		method5();

	}

	private static void method5() {
		//직각 역삼각형을 출력할 줄 수: 10
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("직각 역삼각형을 출력할 줄 수:");
		int su = sc.nextInt();
		for(int row=1;row<=su;row++) {
			for(int col=1;col<=su+1-row;col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
		
	}

	private static void method4() {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 :");
		int end = sc.nextInt();
		int total = 0;
		int start;
		if(end%2==0) {
			start = 0; 
		}else {
			start = 1;
		}
		for(int i=start;i<=end;i+=2) {
			total +=i;
		}
		System.out.println("결과값:" + total);
		sc.close();
		/*문제3. 숫자를 입력 받아서 아래와 같은 실행결과가 나타나도록 SumTest 클래스의 main 메쏘드를 완성하십시오. 
		a. 입력 받은 숫자가 홀수인 경우에는, 0 부터 입력 값까지 홀수의 합을 출력합니다.
		- 예제 : 입력이 7 이면 16을 출력 ( 1 + 3 + 5 + 7 = 16 ) 
		 */
		
		
	}

	private static void method3() {
		System.out.println((int)'A'); //65
		System.out.println((int)'a'); //97
		System.out.println('a' - 'A');
		
	}

	private static void method2() {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. :");
		String strLine = sc.nextLine().toUpperCase();
		 
		for(int i=1;i<=strLine.length();i++) {
			System.out.println(strLine.substring(0, i));
		}
		sc.close();
		
		
		/*
		 * 문제2. 문자열을 입력 받아서 아래와 같은 실행결과가 나타나도록 
		 * ForTest클래스의 main 메쏘드를 완성하십시오. 
		 * 입력 받은 문자열을 한 글자씩 증가시키며 출력하는 프로그램입니다. 
		 * (단, 대문자로 출력해야 합니다.)
		 * 
		 */
		
	}

	private static void method1() {
		//java.lang패키지 아래에 있는 class들은 import없이 사용가능 
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("초기값을 정수로 입력하세요. :");
		int start = sc.nextInt();
		System.out.print("마지막 값을 정수로 입력하세요 :");
		int end = sc.nextInt();
		System.out.print("증가분을 정수로 입력하세요 :");
		int step = sc.nextInt();
		int total = 0;
		for(int i=start;i<=end;i+=step) {
			total += i;
		}
		if(total>1000) total += 2000;
		System.out.printf("총합은 %d 입니다.",total );
		sc.close();
		/*
		 * 문제1. 초기 값, 마지막 값, 증가분을 입력 받아서, 
		 * 초기값부터 마지막 값까지, 증가분씩 값을 증가시키면서 
		 * 각 값들의 총합을 구하는 프로그램을 작성하세요. 
		 * 단, 합을 구한 결과가 1000을 넘으면, 
		 * 결과에 2000을 한번 더 더하여 출력합니다. 
		 *   초기값을 정수로 입력하세요. : 1
			마지막 값을 정수로 입력하세요. : 10
			증가분을 정수로 입력하세요. : 1
			총합은 55 입니다.

		 */
		
	}

}
