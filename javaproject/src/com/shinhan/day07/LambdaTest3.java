package com.shinhan.day07;

public class LambdaTest3 {

	public static void main(String[] args) {
		Person person = new Person(10, 20);
		person.action(new ComputeInterface() { //new만 치고 자동완성키 눌러보면 ComputeInterface({})만들라고 뜸.
			@Override
			public double calc(double x, double y) {
				System.out.println("---1.익명구현class(-)---");
				return x-y;
			}
		});
		person.action((a,b)->a+b);//내가 식을 준것.
		person.action((a,b)->{
			System.out.println("---2.람다표현식 구현---");
			return a+b;
		});
		//이미 만들어진 static메서드를 사용 //(double x, double y)가 똑같이 생겨서 이렇게 줄 수 있음.
		person.action(Computer::staticMethod); //::메소드이름

		//이미 만들어진 instance메서드를 사용
		Computer com = new Computer();
		person.action(com::instanceMethod); //::인스턴스이름
		
	}

}
