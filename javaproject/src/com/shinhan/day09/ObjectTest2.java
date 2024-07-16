package com.shinhan.day09;

//문자열 클래스

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectTest2 {
	public static void main(String[] args) {
		//System.out.println("1.main시작");
		
		//f1(0);
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		//f7();
		f8();
		
		//System.out.println("4.main끝");
	}

	private static void f8() {
		//이메일
		String regExp = "(\\w+)@(\\w+\\.\\w+)";  //()@(): 그룹0번,그룹1번 
		String data = "aaa wed0406@daum.net bbb afaf@naver.com";
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		Pattern patt = Pattern.compile(regExp);
		Matcher mat = patt.matcher(data); //data에서 regExp의 패턴에 해당하는 걸 가져옴. 
		while(mat.find()) {
			System.out.println(mat.group()); //전체
			System.out.println(mat.group(0)); //전체
			System.out.println(mat.group(1)); //첫번째()
			System.out.println(mat.group(2)); //두번쨰()
			System.out.println("-----------------");
		}
	}
	//.은 임의의 문자 1자
	//\w: [0-9A-Za-z]와 같은 의미 (문자 여러자)
	//+ : 1개이상
	//*: 0개이상
	//[]: 선택
	//[-]: 범위
	//{3}: 횟수
	//\\d : [0-9]

	private static void f7() {
		//제어문자는 정해져있음 :  \t \n \" ...... \\->\개를 의미	   //[0-9]{3,4} : 0부터9까지 3,4자리
		
		//패턴
		String regExp = "[01]{3}-[0-9]{3,4}-\\d{4}"; //전화번호  //[01]{3} : 0하고1중에 3자리 라는뜻
		String data = "010-1234-5678";						   //\\d{4} : [0-9]
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		//패턴에 맞은 것들을 골라옴.
		String data2 = "짜장면집 111-124-5678" +  "스시집 010-7894-9969"
				+ "012-7777-8888 nnnnnnnn 010-895-7895";
		Pattern patt = Pattern.compile(regExp);
		Matcher mat = patt.matcher(data2);
		while (mat.find()) {
			System.out.println(mat.group());
		};
		
	}

	private static void f6() {
		/* split은 빈값도 사용, StringTokenizer은 빈(empty)토큰은 무시 */
		//예시1
		String str = "컴퓨터 커피@지갑,  마이크"; 
		String[] arr = str.split("@|,| "); //주어진값으로분리
		System.out.println("배열개수: " + arr.length); //지갑,  마이크 -> split은 비어있는 부분도 취급함.
		for(String s:arr) {
			System.out.println(s);
		}
		System.out.println("-------------------------");
		//예시2
		//토큰 : 하나씩 나눈다는 의미
		StringTokenizer st = new StringTokenizer(str, "@|,| "); 
		System.out.println("토큰개수: " + st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f5() {
		//StringBuilder,StringBuffer 직접 문자열 할당 불가
		//StringBuilder s1 = "이것이자바다";
		StringBuilder s1 = new StringBuilder("이것이 자바다");
		StringBuffer s2 = new StringBuffer("이것이 자바다");
		System.out.println(System.identityHashCode(s1));
		s1.append("!!!!");
		s1.insert(0, "####");
		System.out.println(s1); //값은 바꼈음.
		System.out.println(System.identityHashCode(s1)); //s1이 바꼈는데 주소는 그대로다.
		
		//메모리 
		
	}

	private static void f4() {
		/* String : 고정문자열이다. */
		String s1 = "이것이 자바다";
		String s2 =  new String("이것이 자바다");
		
		//다양한 방법으로 String 만들기 (byte배열, Char배열 ...)
		byte[] arr = {65,66,67,97,98,99}; //ABCabac
		String s3 =  new String(arr);
		
		char[] arr2 = {'가','나','다'};
		String s4 = new String(arr2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(System.identityHashCode(s4));
		s4 += "!!!!";
		System.out.println(System.identityHashCode(s4)); 
		//--> 모바일 프로젝트를 짤 때 이렇게 사용하면 안된다. 잦은 문자열 변경은 String보다 StringBuilder클래스로!
	}

	private static void f3() {
		//Properties는 Map을 구현함(key, value)
		//Properties는 키는 Set만들어짐
		//Set<Object>
		//key가 String이었음 -> Properties(key가 Object)
		//				  <-(강제형변환)	      				
		
		Properties ps = System.getProperties(); //getProperties타입은 마우스대면 나옴. getProperties(key)
		for(Object key :ps.keySet()) { //keySet은 Object타입.   ///ps.keySet():key들을 얻어라.
			String value = System.getProperty((String)key); //문자로 받기
			System.out.println(key + "-->" + value);
		}
	}

	private static void f2() {
//		long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime(); //더 세밀하게 나타남.
		int total = 0 ;
		for(int i=1; i<1000000000; i++) {
			total += i;
		}
//		long endTime = System.currentTimeMillis();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime + "ms");
		
	}

	private static void f1(int j) {  //f1(0)-> 0이 j로 들어옴
		System.out.println("2.f1시작"); 
		
		//int i = 10/j; //오류가 난다. 여기서 멈춤.
		
		//if(j==0) return; //함수 빠지기 (예1)
		//if(j==0) System.exit(0); //일반적(관례적)으로 0은 정상종료, -1은 오류를 의미함. (예2)
		
		//정상적으로 흘러가도록 Exeption처리를 하면 좋다.(예3)
		try {
			int i = 10/j;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("3.f1끝");
	}
}
