package com.shinhan.day12.exam;

class Button {
	// 정적 멤버 인터페이스(함수형 인터페이스)
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}

	private ClickListener clickListener;

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}

public class Example2 {
	public static void main(String[] args) {

		Button btnOk = new Button();
		btnOk.setClickListener(()->{
			System.out.println("OK 버튼을 클릭했습니다.");
		});
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(()->{
			System.out.println("Cancel 버튼을 클릭했습니다.");
		});
		btnCancel.click();
	}
}







