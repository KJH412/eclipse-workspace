package com.shinhan.day07;

class Window {
	
	static interface Listener{
		void alert();
	}
	
	Listener listener;
	void setListener(Listener listener) {
		this.listener = listener;
	}
	void execute() {
		listener.alert();
	}
}
//내부 interface를 구현한 class를 만들어야한다. 
class MyListener1 implements Window.Listener{
	public void alert() {
		System.out.println("1.구현클래스에서 메서드를 재정의한다.");
	}
}
class MyListener2 implements Window.Listener{
	public void alert() {
		System.out.println("구현클래스에서 메서드를 재정의한다.2");
	}
}
//낭비 -> 익명클래스 사용

public class InnerInterfaceTest2 {

	public static void main(String[] args) {
		Window win = new Window();
		
		//1.구현class이용(비슷한 구현class를 계속 만들어야하는 단점이있다)
		MyListener1 my1 = new MyListener1();
		win.setListener(my1);
		win.execute();
		//2.익명구현class를 만든다.
		Window.Listener my2 = new Window.Listener() {
			public void alert() {
				System.out.println("2.익명구현class를 만든다.");
			}
		};
		win.setListener(my2);
		win.execute();
		//3.람다표현식을 사용(메서드가1개인 경우만 가능)
		win.setListener(()->System.out.println("3.람다표현식을 사용(메서드가1개인 경우만 가능)"));
		win.execute();

	}

}
