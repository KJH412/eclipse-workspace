package com.shinhan.day05;

import java.util.Arrays;import javax.print.attribute.standard.RequestingUserName;

public class 놀이공원티켓판매 {
	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = {  //3차원배열
				{ { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } },
				{ { 1, 9 }, { 3, 6 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };
		for (int testcast = 0; testcast < tickets.length; testcast++) {

			System.out.println("-------------------testcast[" + testcast + "]");
			
			//방법
			//1.selectionSort(requests[testcast]); //selectionSort (복습하기)
			//2.bubbleSort(); //bubbleSort 배열을 비교해서 뒷부분 부터 결정?  {3,2,7,5}-->순서대로 앞에서부터 3과2비교/3과7비교/7과5비교-->{2,3,5,7} 뒷부분7이 결정됨. 
			//3.javaSort 더 간단
			javaSort(requests[testcast]);
			
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println("판매개수: " + result);

			for (int[] arr : requests[testcast]) { //arr1차원배열 : requests[]2차원배열
				System.out.println(Arrays.toString(arr)); //1차원배열
			}
		}

	}

	//javaSort
	private static void javaSort(int[][] requests) {

		Arrays.sort(requests, (a,b)->{
			if(a[0] == b[0]) return b[1] - a[1]; //descending
			return a[0]	- b[0]; //ascending
		});
		
	}
		
//		System.out.println("========");
//		Integer[] score = {10, 100, 88, 44, 77, 33}; //Integer 
//		//int[] score = {10,100,88,44,77,33};
//		System.out.println("before " + Arrays.toString(score));
//		Arrays.sort(score, (a,b)->b-a); // 작다< 같다= 크다> : 기본 작은것(음수)-같은것(0)-큰것(양수),어센딩(a-b.작은게앞에있음),디센딩(b-a.큰것-작은것)
//		// sort하고 싶은 기능을 람다표현식으로 넣을 수 있다. 기본형x. 객체만 가능하다.
//		System.out.println("after " + Arrays.toString(score));

	
	//bubbleSort
	private static void bubbleSort(int[][] requests) {
		for(int i=0; i<requests.length; i++) { 
			for(int j=0; j<requests.length-i-1; j++) {
				if(requests[j][0]<requests[j+1][0]) { 
					
					swap(requests,j,j+1); 
					
				}else if(requests[i][0] == requests[j][0] &&
						requests[j][1] == requests[j+1][1]) {
					swap(requests,j,j+1); 
				}
			}
		}
		
	}

	//selectionSort 사용. 앞에서부터결정?
	private static void selectionSort(int[][] requests) {
		for(int i=0; i<requests.length; i++) { //i번째는1차배열 j번째는2차배열
			for(int j=i+1; j<requests.length; j++) {
				if(requests[i][0]<requests[j][0]) {  //예) {2,3} 2가i번째0, {1,9} 1이j번째0 
//					int[] temp = requests[i];
//					request[i] = requests[i];
//					request[j] = temp;
					
					swap(requests,i,j); //자리 바꾸란 뜻.
				}else if(requests[i][0] == requests[j][0] &&
						requests[i][1] == requests[j][1]) {
						
				}
			}
		}
	}

	//swap
	private static void swap(int[][] requests, int i, int j) {
		int[] temp = requests[i];
		requests[i] = requests[j];
		requests[j] = temp;		
	}

	// tickets: 티켓 수
	// requests: 회원 등급, 티켓 구매 수량
	public static int solution(int tickets, int[][] requests) {
        //이부분 구현 
		int result = 0;
		
		for(int[] order:requests) {
			if(tickets >= order[1]) { //1차원배열의 첫번째
				tickets -=order[1];
				result += order[1];
			}
		}
		return result;

	}

}
