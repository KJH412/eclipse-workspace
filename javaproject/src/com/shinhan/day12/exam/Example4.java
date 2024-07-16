package com.shinhan.day12.exam;

import java.util.Collection;

@FunctionalInterface
interface Operator {
	public int apply(int x, int y);
}

public class Example4 {
	
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
//최대값 얻기
		int max = maxOrMin((x,y)->	Math.max(x, y));
		System.out.println("최대값: " + max);
		
//최소값 얻기
		int min = maxOrMin((x,y)->	Math.min(x, y));
		System.out.println("최소값: " + min);
	}
}
