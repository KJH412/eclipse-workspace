package com.shinhan.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; //java.io
import java.io.InputStream;

public class ExceptionTeest {
	public static void main(String[] args) { //throws로 예외 넘겨받음
		//method1(0);
		//method1(10);
		//method2();
		//method3();
		//method4();
		//method5();
		//method6(); //오류
		
		//method7(); //메인으로 던짐. throws FileNotFoundException
		//메소드7 트라이캐치문으로 할경우
		try {
			method7();
		} 
		//catch (FileNotFoundException | ClassNotFoundException e) {...} //두가지 한번에 쓰는 경우.
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //method7()빨간줄>마우스>트라이캐치add
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("~~~~~~~~~~~~~~~Main end~~~~~~~~~~~~~~~");
	}

	private static void method7() throws IOException, ClassNotFoundException {//관계없는?예외는 같이 적을 수 있다.?
//	private static void method7() throws FileNotFoundException {
		FileReader fi = new FileReader("src/com/shinhan/day08/Book.java");//("")빨간줄남. => 마우스로 throw 클릭.
		int i;
		while((i = fi.read()) != -1) {
			System.out.println((char)i);
		}
		fi.close();
	}

	private static void method6() {
		try(FileReader fi = new FileReader("src/com/shinhan/day08/Book.java")) {
			
			//비지니스 로직은 여기만 있다.
			int i;
			while((i = fi.read()) != -1) {
				System.out.println((char)i);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	private static void method5() {
		//파일열기
//		FileInputStream fi = null;
		//파일읽기
		FileReader fi = null;
		int i ;
		try {
			//fi = new FileInputStream("src/com/shinhan/day08/Book.java"); //("")빨간줄남. => 마우스대면 throw , try-catch 중에 Add가 뜬다.
			//fi = new FileReader("src/com/shinhan/day08/Book.javaaaaaaaaaa"); //에러확인
			fi = new FileReader("src/com/shinhan/day08/Book.java"); 
			while((i = fi.read())!= -1) { // 마우스 대서 try-catch 두번째 선택.
				System.out.print((char)i); //1013...엔터 returnEnter의 ASCII code값 //그냥 i로 출력하면 엔터도 숫자로나와서 구분X. char로 형변환해준다.
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음. "+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) { //IOException가 더 상위라서 뒤로온다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
//				if(fi != null) fi.close(); //오류. 마우스대면try~catch클릭 자동완성
				fi.close();	//자원반납	(파일열기후 닫기, DB연결후 해제)		
			} catch (IOException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				System.out.println("파일 open불가");
			}
		}
	}

	private static void method4() {
//		com.shinhan.day09.Book a = new com.shinhan.day09.Book();
		
		//하나의 메소드 혹은 class에서 같은 이름의 class를 이용하는 경우
		//같은 패키지를 먼저 검색
		//다른패키지의 class는 반드시 패키지이름까지 사용한다.
		Book a = new Book();
		com.shinhan.day09.Book b = new com.shinhan.day09.Book(); 
		System.out.println(a);
		System.out.println(b);
		
		try {
			Class mybook = Class.forName("com.shinhan.day09.Book"); //클래스를 메모리에 올리라는 것. 클래스를 로드.
			System.out.println(mybook.getName());
			System.out.println(mybook.getPackageName());
			System.out.println(mybook.getSimpleName());
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("*******************");
	}

	private static void method3() throws IOException{
		//일반Exception(RuntimeException이 아닌 Exception) : 컴파일시에 check
		//반드시 Exception처리를 해야한다.
		
		//1)내가한다 2)떠넘긴다.(나를부른곳으로떠넘긴다)
		InputStream input = System.in; //마우스대면 InputStream타입이라 뜸

			int data = input.read();
//			System.out.println((Char)data);

	}
	
	private static void method2() {
		//일단Exception(RuntimeException이 아닌 Exception) : 컴파일시에 check
		//반드시 Exception처리를 해야한다.
		//1)내가한다 2)떠넘긴다.(나를부른곳으로떠넘긴다)
		InputStream input = System.in; //마우스대면 InputStream타입이라 뜸
		try {
			int data = input.read();
			System.out.println(data);
//			System.out.println((Char)data);
		}catch(IOException e) { //IOException은 import가 필요함. 왜? java.io이기 때문이다. java.lang만 import안해도 됨.
			System.out.println("IO오류");
		}
	}
	//오류발생 자동으로 JVM이 Exception 객체를 생성해서 Exception 발생한 곳으로 준다.
	
	private static void method1(int count) {
		//예외:1)RuntimeException...실행시 오류발생, 2)일반Exceoption
		int score = 100;
		//int[] arr = null;  NullPointerException
		int[] arr = new int[10]; //0~9
		//String s = "100";
		String s = "백"; //NumberFormatException
		
		//if(count == 0) return;//<----오류처리로직과 비지니스로직 처리가 섞인다. 권장하지 않음. 
		//if문나가=return
		
		//try~catch : 오류처리로직과 비지니스로직 처리 로직을 분리할 수 있다.
		try {
			System.out.println("평균은 : " + score/count);
			arr[0] = 99;
			System.out.println(arr[9]);
			System.out.println(Integer.parseInt(s)+200);
			
		}catch(ArithmeticException ex) {//상위인 Exception ex로 써도 됨.
			//Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("연산오류...." + ex.getMessage());
		}catch(NullPointerException ex){
			//Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("NullPointerExcoption...." + ex.getMessage());
		}catch(ArrayIndexOutOfBoundsException ex){
			//Exception 처리함...그러므로 프로그램 중단없이 계속 진행된다.
			System.out.println("ArrayIndexOutOfBoundsException...." + ex.getMessage());
		}
		/*
		 catch (NumberFormatException ex) {
			System.out.println("NumberFormatException...." + ex.getMessage());
		}
		*/
		catch (Exception ex) { //맨 상위에 있는 것(Exception)은 마지막에 작성해야함!***
			ex.printStackTrace(); //에러가 난 과정을 보여준다.
			System.out.println("Exception..."+ ex.getMessage());
		}
		finally {
			System.out.println("오류가 있거나 없거나 무조건 수행하는 업무이다.(finally)");
		}
		System.out.println("-----------------");
		
	}
	

}
