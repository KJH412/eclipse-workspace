package com.shinhan.day07.lab3;

interface Action {
	public void work();
}

public class ActionExample{
	public static void main(String[] args) {
		// 익명 구현 객체
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("익명구현객체");
			};
		};
		Action action2 = ()-> System.out.println("람다표현식");
		action.work();
		action2.work();
	}
	
}
