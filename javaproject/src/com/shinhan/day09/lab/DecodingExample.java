package com.shinhan.day09.lab;

public class DecodingExample {
	public static void main(String[] args) throws Exception {
		byte[] bytes = { -20, -107, -120, -21, -123, -107 };
		String str = new String(bytes, "utf-8"); //새?3?바이트 처리되어있어서 utf-8로
		System.out.println("str: " + str);
	}

}
