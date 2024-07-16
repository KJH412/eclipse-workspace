package com.shinhan.day07;

public class InnerInterfaceTest {

	public static void main(String[] args) {
		OkButtonListener ok1 = new OkButtonListener(); 
		OkButtonListener2 ok2 = new OkButtonListener2();
		
		Button button = new Button();
		button.setListener(ok1); //구현클래스를 new해서 집어넣은것.set
		button.click();
		
		//익명 구현class만들기
		Button.ClickListener ok3 = new Button.ClickListener(){
			
			@Override
			public void onClick() {
				System.out.println("익명 구현class만들기");
			}
		};
		
		//익명 구현class만들기2
		button.setListener(new Button.ClickListener(){
			
			@Override
			public void onClick() {
				System.out.println("익명 구현class만들기2");
			}
		});
		
//		button.click();
		
		//람다식 (interface에 메서드가 1개 있을때만 가능)
		button.setListener(()->System.out.println("익명 구현class만들기3"));
		button.click();
	}

}
