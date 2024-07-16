package com.shinhan.day03;

import java.util.ArrayList;

public class Spliting {
	public static void main(String[] args) {
		
	 		
		Spliting p = new Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for (int i = 0; i < addrArr.length; i++) {
			System.out.print(addrArr[i] + "!!! ");
		}
		System.out.println("=====API이용하기====================");
		String[] arr = addr.split(",");
		for(String s:arr) {
			System.out.println(s);
		}
	}

	public String[] split(String str, char separator) {
		String[] result=null;
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==separator) count++;
		}
		result = new String[count+1];
		int index=0;
		String word="";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==separator) {
				result[index] = word; word="";index++;
			}else {
				word +=str.charAt(i);
			}
		}
		result[index] = word; //마지막단어는 ,를 못만남 		
		return result;
	}

}





