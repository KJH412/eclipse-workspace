package com.shinhan.day02;

public class StringUtil {

	public static void main(String[] args) {
		hokeyGraphics('*', 10, false);
	}

	private static void hokeyGraphics(char cell, int size, boolean isRect) {
		
		if(isRect) {
			//사각형 모양을 출력
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=size;col++) {
					System.out.print(cell);
				}
				System.out.println();//줄바꾸기 
			}
		}else {
			//삼각형을 출력
			//1row->1col까지 2row->1~2col까지  3row->1~3col까지
			for(int row=1;row<=size;row++) {
				for(int col=1;col<=row;col++) {
					System.out.print(cell);
				}
				System.out.println();//줄바꾸기 
			}
		}
		/*문제4. 아래와 같은 출력이 나오도록 
		 * StringUtil 클래스의 hokeyGraphics(char cell, int size, boolean isRect) 메소드를 완성한다. 
		 * hokeyGraphics 메소드는 cell 문자와 size 값을 이용하여 특정 모양을 출력한다. 
		 * isRect 값이 true 이면 사각형 모양을 출력하고, 
		 * false 이면 삼각형을 출력한다. 
		 * 
		 */
		
	}
}
