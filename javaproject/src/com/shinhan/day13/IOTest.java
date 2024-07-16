package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOTest {
	public static void main(String[] args) throws IOException {
		f7();
	}

	private static void f7() throws IOException {
		//파일 읽기 (가장쉬운방법)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileReader fis;
		BufferedReader br;

		String i;
		fis = new FileReader(filename); //파일 열기...2byte씩 처리한다.
		br = new BufferedReader(fis); //reader을 넣는다. 
		while((i=br.readLine()) != null){ //BufferedReader 한 라인으로 읽음.
			System.out.println(i);
		}
		fis.close();
		
	}

	private static void f6() throws IOException {
		//보조스트림 : DataOutputStream, DataInputStream
		String fileName = "aa.txt";
		FileOutputStream fos = new FileOutputStream(fileName); //String을읽는다.
		DataOutputStream dos = new DataOutputStream(fos); //보조연결(여러타입출력할 수 있도록) int,double..기본타입 읽기.
		dos.write(10);
		dos.write(20);
		dos.writeDouble(10.5);
		dos.writeDouble(20.5);
		dos.writeUTF("문자");
		fos.flush();
		fos.close(); 
		
		FileInputStream fis = new FileInputStream(fileName);
		DataInputStream dis = new DataInputStream(fis);
		int a = fis.read();
		int b = fis.read();
		double c = dis.readDouble();
		double d = dis.readDouble();
		String s = dis.readUTF();
		System.out.println(s);
		System.out.println(a+b);
		fis.close();
	}

	private static void f5() throws IOException {
		//파일출력
		String fileName = "aa.txt";
		FileWriter fw = new FileWriter(fileName); //경로안줘서 javaproject파일안에 있음.
		fw.write("java\n");
		fw.write("자바끝");
		//자원을 반납하지 않으면 다른곳에서 이 파일을 사용할 수 없다.
		fw.close(); 
	}

	private static void f4() {
		//모니터 출력
		PrintStream moniter = System.out;
		moniter.println("모니터출력");
		
	}

	private static void f3() throws IOException {
		//파일입력(읽기)
		String filename = "./src/com/shinhan/day13/Review2.java";
		FileReader fis;

		int i;
		fis = new FileReader(filename); //파일 열기  FileReader:2바이트씩 읽기.
		
		//파일을 int타입으로 읽는다. -1:마지막
		while((i = fis.read()) != -1){
			System.out.println((char)i);
		}
		fis.close(); //파일 닫기
	}
	private static void f1() throws IOException {
		//키보드 입력 
		//read는 한바이트씩 처리한다.
		InputStream is = System.in;
		//int i = is.read(); //예외던짐(한바이트씩만 읽음 abc입력->a만) 다 읽고싶다면 반복돌려야한다.
		
		InputStreamReader isr = new InputStreamReader(is);
		int i;
		while(( i = isr.read()) != 13) { //13 :enter키 ASCII값
			System.out.println((char)i);
		}; 
	}
}
