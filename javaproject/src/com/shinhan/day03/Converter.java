package com.shinhan.day03;

import java.util.Arrays;

public class Converter {
	public static void main(String[] args) {
		System.out.println("문자열에 특정문자 변경하는 테스");
		System.out.println("-------------Sample 1 --------------");
		String str1 = myReplace("hello world", 'l', '*');
		System.out.println(str1);

		System.out.println("-------------Sample 2 --------------");
		String str2 = myReplace("hello world", ' ', '-');
		System.out.println(str2);

		System.out.println("-------------Sample 3 --------------");
		String str3 = myReplace("hello world", 'a', '*');
		System.out.println(str3);

		byte[] arr2 = {97,98,99,100};
		char[] arr = {'A','B','C'};
		String s1 = new String(arr);
		String s2 = new String(arr2);
		System.out.println(s1);
		System.out.println(s2);
		String s3 = "Hello";
		char[] arr3 = s3.toCharArray();
		System.out.println(Arrays.toString(arr3));
	}

	public static String myReplace(String str, char oldChar, char newChar) {
		// 이 부분을 구현하시오.		 
		char[] arr = str.toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==oldChar) arr[i] = newChar;
		}
		return new String(arr) ;
	}
	
	public static String myReplace2(String str, char oldChar, char newChar) {
		// 이 부분을 구현하시오.
		String result="";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==oldChar) {
				result+=newChar;
			}else {
				result+=str.charAt(i);  
			}
		}
		return result;
	}

}
/*<<수행결과>>
-------------Sample 1 --------------
he**o wor*d
-------------Sample 2 --------------
hello-world
-------------Sample 3 --------------
hello world
*/