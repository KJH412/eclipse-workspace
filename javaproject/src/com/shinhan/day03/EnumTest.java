package com.shinhan.day03;
public class EnumTest {
	//상수:변하지않는 값  final static
	final static int SUCCESS=1;
	final static int FAIL=0;
	final static int BOOK=2;	
	public static void main(String[] args) {
		 f3(Week.FRIDAY);
		 f3(Week.MONDAY);	 
		 //무작위로 뽑아보기 
		 int su = (int)(Math.random()*7);
		 f4(su);
		 
	}
	private static void f4(int su) {
		for(Week we :Week.values()) {
			if(su == we.ordinal()) {
				System.out.println(we);break;
			}
		}
	}

	private static void f3(Week aa) {
		/*
		for(Week we :Week.values()) {
			System.out.println(we + "--" + we.name() + "--" + we.ordinal());
		}*/
		String message="";
		switch (aa) {
			case FRIDAY->{message="금";}
			case MONDAY->{message="월";}
			case SATURDAY->{message="토";}
			case SUNDAY->{message="일";}
			case THURSDAY->{message="목";}
			case TUESDAY->{message="화";}
			case WENESDATY->{message="수";}
		} 
		System.out.println(aa + "=>" +  message);
		
	}

	private static void f2(int score) {
		Work result;
		if(score>=90) {
			result = Work.SUCCESS;
		}else {
			result=Work.FAIL;
		}
		System.out.println(result);
		
	}
	
	private static void f1(int score) {
		int result;
		if(score>=90) {
			result = SUCCESS;
		}else {
			result=BOOK;
		}
		System.out.println(result);
		
	}
	 
	 

}




