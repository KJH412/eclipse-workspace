package com.shinhan.day08.practice;

//인덱스초과
public class Example06 {

	public static void main(String[] args) {
		String[] strArray = { "10", "2a" }; // [0](O) [1](O) [2](X) 인덱스초과
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]); 
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println("value " + value);
			}
			
			//value = Integer.parseInt(strArray[i]); //예외발생. NumberFormatException: For input string: "2a"
			

		}
	}

}
