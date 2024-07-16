package com.shinhan.day13;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		try {
			InetAddress a = InetAddress.getLocalHost();
			System.out.println(a.getHostName());
			System.out.println(a.getHostAddress());
			
			InetAddress[] arr = InetAddress.getAllByName("www.naver.com"); //도메인이름만 알아도 id주소를 알아낼 수 있다.
			for(InetAddress addr:arr) {
				System.out.println(addr.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
