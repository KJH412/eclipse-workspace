package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URL;

public class ObjectTest4 {
	
	public static void main(String[] args) throws IOException /*FileNotFoundException*/ {
		//f1();
		f2();
	}

	private static void f2() throws IOException {
//		new FileReader("src/com/shinhan/day09/ComputerVO.java");	
		Class<?> cls = ObjectTest4.class;
		URL url = cls.getResource("java.png"); //getResource
		
		System.out.println(url.getPath()); //파일의 경로가 출력. (한글이면 인코딩된용어?가 나타남.)
		
//		InputStream fis = cls.getResourceAsStream("java.png");
//		InputStream fis = cls.getResourceAsStream("aa.xml");
		InputStream fis = cls.getResourceAsStream("oracleInfo.properties");
		InputStreamReader isr = new InputStreamReader(fis);
		int i;
		while((i = fis.read()) != -1) {
			System.out.print((char)i);
		} 
	}

	private static void f1() {
		//리플렉션
		Class<ComputerVO> cls = ComputerVO.class; //타입 제한이 있다.
		Constructor<?>[] cons = cls.getDeclaredConstructors(); //생성자 여러개 얻기. 여러개 이므로 배열[]
		
		for(Constructor<?> cc:cons) {
			System.out.println(cc.getName()); //이름얻기 
			System.out.println(cc.getParameterCount()); //파라미터 개수 
			
			for(Parameter param:cc.getParameters()) {
				System.out.println(param.getName());
			}
			
			System.out.println("---------------------");
		}
		
		
	}
	
	
}
