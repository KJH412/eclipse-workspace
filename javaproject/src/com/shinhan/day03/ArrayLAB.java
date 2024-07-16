package com.shinhan.day03;

import java.util.Arrays;

 

public class ArrayLAB {

	public static void main(String[] args) {
		method3();

	}
 

	private static void method3() {
		int[][] a = {{30, 30, 30, 30},{40, 40, 40, 40},{50,50,50,50}};
		int[][] b = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] c = new int[a.length][a[0].length];
		int[][] result = sub(a,b,c);		 
        prn(a);prn(b);prn(c); prn(result);		
	}
	public static int[][] sub(int[][] a, int[][] b, int[][] c){
		for(int row=0;row<a.length;row++) {
			for(int col=0;col<a[row].length;col++) {
				c[row][col] = a[row][col]-b[row][col];
			}
		}
		return c;
	}
	public static void prn(int[][] arr) {
		System.out.println("---------------");
		for(int[] datas:arr) {
			for(int su:datas) {
				System.out.printf("%2d ",su);
			}
			System.out.println();
		}
	}

	private static void method2() {
		int[] arr= {3,24,1,55,17,43,5};
		System.out.println("orinal!!:" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("asc sort!!:" + Arrays.toString(arr));
		
	}

	private static void method1() {
		//int[] arr= new int[] {3,24,1,55,17,43,5};
		int[] arr= {3,24,1,55,17,43,5};
		//selection sort, Ascending(오름차순) 작->크
		System.out.println("orinal:" + Arrays.toString(arr));
		//i는 다음값과 비교하여 결정할 값
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					//자리이동(바꾸기)
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("asc sort:" + Arrays.toString(arr));
	}

}






