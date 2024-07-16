package day04;

import java.util.Scanner;

//문제풀이

public class Review {

	public static void main(String[] args) {
		method9();
	}

	private static void method9() {
		int count = 0;
		int[] scores = null;
		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		// 종료가 아닌동안 반복문을 돌게
		while (!isStop) { // true인 동안 돌도록
			menuPrint();
			System.out.println("선택>");

			int job = sc.nextInt();

			switch (job) {
			case 1 -> {
				System.out.println("학생수>");
				count = sc.nextInt();
				scores = new int[count];
			}
			case 2 -> {
				if (scores == null) {
					System.out.println("아직 학생수가 입력되지 않았다.(점수입력불가)");
					break; // switch 빠지기
				}
				for (int i = 0; i < count; i++) {
					System.out.printf("scores[0]>", i);
					scores[i] = sc.nextInt();
				}
			}
			case 3 -> {
				int i = 0;
				for (int score : scores) {
					System.out.printf("scores[%d]: %d", i++, score);
				}
			}
			case 4 -> {
				int max = Integer.MIN_VALUE;
				int total = 0;
				for (int score : scores) {
					if (score > max)
						max = score;
					total += score;
				}
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + (double) total / count);
			}
			case 5 -> {
				isStop = true;
			}
			}

		}
	}

	private static void menuPrint() {
		System.out.println("----------------");
		System.out.println(" ");
		System.out.println("----------------");
	}

	private static void method8() {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int total = 0, count = 0;
		for (int[] datas : array) {
			for (int data : datas) {
				total += data; // total에 data를 누적
			}
			System.out.println(total);
			System.out.println(count);
			System.out.println(total / count);
		}
	}

	private static void method7() {
		int[] array = { 1, 5, 3, 8, 2 };
		int max = Integer.MIN_VALUE; // 제일작은값을 미리준다. 내 값이 제일 커야하니까
		for (int data : array) {
			if (data > max)
				max = data;
		}
	}

	private static void method6() {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78,83,93,87,88} 
		};
		
		for(int i=0; i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===확장for===");
		for(int[] datas:array) {
//			Systme.out.println(Arrays.toString(datas));
			for(int data:datas) {
				System.out.println();
			}
		}
	}

	private static void method() {
		boolean[] arr = new boolean[3]; // false
		Scanner[] arr2 = new Scanner[3]; // null(기본형아니면 객체는 다 null로 값이 들어감.)
	}

	private static void method4() {
		// 지역번수
		int a = 0; // 기본형은 null로 초기화 불가능.
		Integer b = null; // 오토boxing이됨.
		System.out.println(a);
		System.out.println(b);
		// String은 고정문자열

		String s = "자바";
		s = s + "프로그램"; // StringBuffer .append
	}

	private static void method3() {
		//아래 네개의 배열 형태는 다 같음.
		int[][] arr = new int[3][4];
		int[][] arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][];
		
		for(int i=0; i<arr4.length; i++) {
			arr4[i] = new int[i+2]; //i=0일때 2, i=1일때3, i=2일때 4
			for(int j=0; j<arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}
			
	}

	private static void method2() {
		//배열선언 +생성 +자동초기화
		int[] arr = new int[3];
		//배열선언 +생성+ 초기화
		int[] arr2 = new int[] {1,10,100,1000};
		int[] arr3 = {1,10,100,1000};
		//1.배열선언
		int[] arr4;
		//2.생성+초기화
		arr4 = new int[]{1,10,100,1000};
		
		for(int index=0; index<arr4.length; index++) {
			System.out.println(arr4[index]);
		}
		}

	private static void method1() {
		// 1.배열선언
		int a;
		int[] arr = null; // 정의된것이없으면null
		// 2.배열생성
		arr = new int[3]; // 자동으로 초기화된다. 정수->0
		// 3.배열사용
		arr[0] = 100;
		System.out.println(arr[0]);

		// 배열:같은타입의 여러개의 값을 저장하기 위한 자료구조,
		// heap영역에 연속공간을 만든다.
		// 개수를 알아야 생성가능

	}

}
