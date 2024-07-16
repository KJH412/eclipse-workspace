package com.shinhan.lab.lab6;

class Duck{
	public String name;
	public int legs;
	public int length;
	
	
	public Duck(String name, int legs, int length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("오리("+name+")는 날지 않습니다.");
	}
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("오리("+name+")는 소리내어 웁니다.");
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "오리의 이름은 " + name  +" 입니다. 다리는 " + legs + "개 이고 길이는 " + length + " 입니다.";
	}
	
}

class Sparrow{
	public String name;
	public int legs;
	public int length;
	
	public Sparrow(String name, int legs, int length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("참새("+name+")가 날아다닙니다.");
	}
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("참새("+name+")가 소리내어 웁니다.");
	}
	
	@Override
	public String toString() {
		return "참새의 이름은 " + name  +" 입니다. 다리는 " + legs + "개 이고 길이는 " + length + " 입니다.";
	}
	
}

public class lab3 {

	public static void main(String[] args) {
		
		Duck duck = new Duck("꽥꽥이", 2, 15);
		duck.fly();
		duck.sing();
		System.out.println(duck);
		
		Sparrow sparrow = new Sparrow("쨱짹", 2, 10);
		sparrow.fly();
		sparrow.sing();
		System.out.println(sparrow);
	
	}

}
