package com.shinhan.day08;

public class ScoreException extends Exception {/* RuntimeException 이었다면 ExceptionTest2에서 사용할 때 method2 에러가 남*/
	String message;
	ScoreException(String message){
		//this.message = message;
		super(message); //부모(Exception)의 message를 받아라
	}
	void print() {
		System.out.println("score는 70이상이어야 한다.");
		
	}

}
