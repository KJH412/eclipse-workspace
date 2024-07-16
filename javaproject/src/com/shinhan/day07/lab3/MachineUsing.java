package com.shinhan.day07.lab3;

//출력x
public class MachineUsing {

	//1.field
	Machine v1 = new Machine() {
		@Override
		public void powerOn(String title) {
			System.out.println("2.익명구현class만들기");
		}
	};
	
	
	public static void main(String[] args) {
		
		//**구현class 사용
		Machine v3 = new MachineImpl();
		call(v3);
		
		//2.local 변수(메소드안 있음)
		Machine v2 = new Machine() {
			@Override
			public void powerOn(String title) {
				System.out.println("2.익명구현class만들기");
			}
		};
		call(v2);
		
		call((s)-> System.out.println(s+"람다표현식"));
		
		//3.함수의 매개변수 이용
		call(new Machine() {
			@Override
			public void powerOn(String title) {
				System.out.println("2.익명구현class만들기");
			}
		});
	}

	private static void call(Machine machine) {
		machine.powerOn("전원 ON");
		
	}
	

}
