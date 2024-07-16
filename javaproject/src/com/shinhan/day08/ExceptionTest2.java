package com.shinhan.day08;

public class ExceptionTest2 {

	public static void main(String[] args) {
		method2(70);
	}
	
	private static void method2(int score) {
		
		try {
			if(score <= 70) throw new ScoreException("70초과만 가능"); //Exception을 상속받았기 때문에 예외처리해줘야한다.
			double avg = score/3;
		}catch (ScoreException e) {
			System.out.print(e.getMessage());
		}
	}

	public static void f(String[] args) /*throws Exception*/ { 
		
		//트라이캐치로 직접 예외 처리
		try {
			method1(70);
		}catch (Exception e) {
			e.printStackTrace();
		}
		//---> 위처럼 직접 처리 안하고 예외 던지려면?
		//method1(70); //메소드 호출하고, throws Exception 함.

	}

	private static void method1(int score) throws Exception {//throws Exception (예외던짐) 

		
		//조건에 맞지않으면 강제로 예외를 발생하고자 한다.(araise)
		
		// 예외 강제 발생 : throw new Exception();  new로 꼭 생성해야한다.
		
		//70보다 작으면 에러처리하고싶다.
		if(score < 70) throw new RuntimeException(); //throw(예외가 일어난다.)랑 throws(떠넘긴다)랑 다름.
		
		//RuntimeException : 무조건 던짐
		
		//try-catch로 예외를 잡아서 오류안남.
		try {
			//Exception이면 런타임이 아니라서 컴파일때 확인하므로 반드시 예외처리해야한다.
			if(score <= 70) throw new Exception("오류!!!"); // 예외를 담아서 처리한다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//throw : 일으키다. 발생시킴. (araise)
		if(score <= 70) throw new Exception("오류!!!"); //이거는 그냥 예외를 일으킨거라 오류가나기 때문에 try-catch를하던지 throws를 해야 된다.
		System.out.println("-------------------");
		
		
	}

}
