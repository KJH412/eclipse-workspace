package com.shinhan.day09.lab;

import java.util.StringTokenizer;

public class StringBuilderExample {
	
	public static void main(String[] args) {
		String str = "아이디, 이름, 패스워드";
		StringTokenizer st = new StringTokenizer(str, ",| "); //str을 ",| "로 나눈다,
		while(st.hasMoreTokens()) {
			System.out.println(st.countTokens());
		}
	}
	
	//권장
	public static void f2(String[] args) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= 100; i++) {
			str.append(String.valueOf(i));
			System.out.println(System.identityHashCode(str));
		}
		System.out.println(str);
	}
	
	//좋지않음.
	public static void f(String[] args) {
		String str = "";
		for (int i = 1; i <= 100; i++) {
			str += i;
			//System.out.println(System.identityHashCode(str)); 
			//주소가 계속 더해져서 바뀌기 때문에 이렇게는 X.
		}
		System.out.println(str);
	}
}