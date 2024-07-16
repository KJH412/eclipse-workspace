package com.shinhan.day07;

//구현클래스
public class OkButtonListener implements Button.ClickListener{
								//Button의 내부에 있는 ClickListener를 구현한다.
	@Override
	public void onClick() {
		 System.out.println("===================================");
		 System.out.println("OK버튼을 눌렀을 때 이런 동작을 합니다(1).....");
		 System.out.println("===================================");
	} 
	
}
