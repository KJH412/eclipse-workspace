package com.shinhan.day09;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.shinhan.util.DateUtil;

public class ObjectTest3 {

	public static void main(String[] args) {
//		f1(); //박싱과언박싱
//		f2()  //parse+기본타입 : 문자열을 기본타입값으로 변환
//		f3(); //Math클래스
//		f4(); //Date클래스
//		f5(); //Calendar클래스	
//		f6(); //LocalDateTime클래스
//		f7(); //DecimalFormat : 숫자를 형식화된 문자열로 변환
		f8(); //SimpleDateFormat 날짜를 형식화된 문자열로 변환
	}

	private static void f8() {
		java.util.Date d = new java.util.Date();
		//내가원하는 포맷으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd/hh:mm:ss");
		System.out.println(sdf.format(d));
		
		//문자->일자 (parse사용) Exception발생할 수 있음
		//String s = "2024/03/22"; //포맷과 같은 형태
		String s = "2024-03-22"; //포맷에 맞지 않으면 에러 발생
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-mm-dd");
		try {
			java.util.Date d2 = sdf2.parse(s); 
			java.sql.Date d3 = new java.sql.Date(d2.getTime());  //sql데이트 형태
			
			System.out.println(d2);
			System.out.println(d3);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(DateUtil.getUtilDate(s)+" util");
		System.out.println(DateUtil.getSQLDate(s)+" sql");
		
 	}

	private static void f7() {
		int a = 1234567890;
		
		System.out.println(a);
		DecimalFormat format = new DecimalFormat("###,###,###");
		
		System.out.println(format.format(a)); //format이 decimal을 나타낸다.
		
	}

	private static void f6() {
		LocalDateTime d = LocalDateTime.now(); //LocalDateTime으로 편하게 쓸 수 음.
		LocalDate d2 = LocalDate.now();
		System.out.println(d);
		System.out.println(d2);
		
		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDayOfMonth());
		System.out.println(d.getHour());
		System.out.println(d.getDayOfWeek());
	}

	private static void f5() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)); //상수중에 있는 것들 찾으면 됨.
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.HOUR));
	}

	private static void f4() {
		Date d1 = new Date();
		java.util.Date d2 = new java.util.Date(); 
		System.out.println(d2); //문자형태로 출력됨. 특정값을 원하면 d2.get값()으로 뽑아냄
		//System.out.println(d2.getYear()); 124뜸. 
		System.out.println(1900 + d2.getYear());
		System.out.println(d2.getTime());
		
		//보통 DB는 sql Date 쓴다.
		java.sql.Date d3 = new java.sql.Date(d2.getTime()); //(권장)
		java.sql.Date d4 = new java.sql.Date(2024-1900,3,22); //(초기데이터) 글자에 선 그어졌으면 더 나은 방법을 찾기..
		System.out.println(d3);
		System.out.println(d4); //3924년 뜸.. 
		
	}

	private static void f3() {
		double a = 5.1;
		
		System.out.println(Math.ceil(a)); //올림
		System.out.println(Math.floor(a)); //버림		
	}

	private static void f2() {
		String s ="100";
		String s2 ="100.456";
		int b = Integer.parseInt(s); //parse + 기본타입
		double d = Double.parseDouble(s2); //캐스팅아님.		
	}

	private static void f1() {
		Integer a = 100; //Auto Boxing (박싱)
		//Integer a = new Integer(100); //deprecated
		
		int b = a.intValue() + 200; //unBoxing (언박싱 후 연산)
		
		
		
	}

}
