package com.shinhan.day06;
//day06 lab3문제(객체지향_duck)

//교육생 답안
public class Sparrow { //public 모든 패키지에서 사용가능. //Duck을 복사해서 사용하고 싶다.
	private String name;
	private int legs;
	private int length;
	
	public Sparrow(int legs, int length) { //다른패키지에서 new로 객체생성 가능
		this.legs = legs;				
		this.length = length;
	}

	public void fly() {//return 없어서 void. getClass().getSimpleName()얻어오기. 오리 또는 참새
		System.out.println(getClass().getSimpleName()+"(" + name + ")는 날지 않습니다.");
	}

	public void sing() {  
		System.out.println(getClass().getSimpleName()+"(" + name + ")가 소리 내어 웁니다.");
	}

	public void setName(String name) { //다른패키지에서 사용할 수 있게 public
		this.name = name; //초기화를 setName에서 한것.
	}
	
	
	//재정의: 함수이름, 매개변수, returnType이 같아야한다.
	//		Modifier 는 같거나 더 넓어져야 한다.
	
	@Override
	public String toString() {
		return "오리의 이름은 " + name + " 입니다. 다리는 " + legs + "개이고 길이는 " + length + "입니다.";
	}
	
	
	
}
